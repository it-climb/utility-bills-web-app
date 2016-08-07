package alex.pol.social.linkedin;

import alex.pol.domain.User;
import alex.pol.service.UserDataService;
import alex.pol.service.UserService;
import alex.pol.domain.UserData;
import alex.pol.util.PostgreJsonHibernate.MyJson;
import alex.pol.util.validation.UserValid;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.social.linkedin.api.impl.LinkedInTemplate;
import org.springframework.social.linkedin.connect.LinkedInConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@Controller
public class LinkidinController {

    @Autowired
    UserValid userValid;

    @Autowired
    UserService userService;

    @Autowired
    UserDataService userDataService;

    @Value("${spring.social.linkedin.app-id}")
    private String APP_ID;

    @Value("${spring.social.linkedin.app-secret}")
    private String APP_SECRET;

    private static final String REDIRECT_URL = "http://utilitybillswebapp.unnt7pfuqq.eu-central-1.elasticbeanstalk.com/linkedincallback";
    //"http://localhost:8080/linkedincallback";

    @RequestMapping(value="/linkedinLogin",method = RequestMethod.GET)
    public String loginWithLinkedin(HttpServletRequest request){
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        String returnValue =
            "https://www.linkedin.com/oauth/v2/authorization?"
            + "response_type=code&client_id="
            + APP_ID + "&redirect_uri=" + REDIRECT_URL + "&state="
            + sessionId + "&scope=r_basicprofile+r_emailaddress";
        return "redirect:" + returnValue;
    }

    @RequestMapping(value = "/linkedincallback", method = RequestMethod.GET)
    public String getToken(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {
        HttpSession httpSession = request.getSession();
        String faceCode = request.getParameter("code");
        String accessToken = getLinkedinAccessToken(faceCode);
        AccessGrant accessGrant = new AccessGrant(accessToken);
        LinkedInConnectionFactory connectionFactory =
                new LinkedInConnectionFactory(APP_ID, APP_SECRET);
        Connection<LinkedIn> connection = connectionFactory.createConnection(accessGrant);
        String linkedinUserEmail = connection.fetchUserProfile().getEmail();
        User linkedinUser = userService.getByEmail(linkedinUserEmail);
        //addUserAndUserData(linkedinUser,connection);
        if (linkedinUser == null) {
            linkedinUser = User.newBuilder().setEmail(linkedinUserEmail)
                    .setPassword(RandomStringUtils.randomAlphanumeric(16)).build();//"Google"
            userService.insert(linkedinUser);
            MyJson myJson = new MyJson();
            ConnectionData connectionData = connection.createData();
            myJson.put("provider", connectionData.getProviderId());
            myJson.put("displayName", connectionData.getDisplayName());
            myJson.put("imageUrl", connectionData.getImageUrl());
            myJson.put("providerUserId", connectionData.getProviderUserId());
            myJson.put("secret", connectionData.getSecret());
            myJson.put("accessToken", connectionData.getAccessToken());
            myJson.put("expireTime", connectionData.getExpireTime());
            myJson.put("refreshToken", connectionData.getRefreshToken());
            UserData googleUserData = UserData.newBuilder().setUser(linkedinUser)
                    .setSocialData(myJson).build();
            userDataService.insert(googleUserData);
        }
        UserData linkedinUserData = userDataService.findByUser(linkedinUser);
        if(linkedinUser != null && !linkedinUserData.getSocialData()
                .get("provider").equals("linkedin")){
            linkedinUser = null;
        }
        httpSession.setAttribute("user", linkedinUser);
        return "redirect:/";
    }

    /*private void addUserAndUserData(User user, Connection connection) throws SQLException {
        if (user == null) {
            user = User.newBuilder().setEmail(connection.fetchUserProfile().getEmail())
                    .setPassword(RandomStringUtils.randomAlphanumeric(16)).build();//"Google"
            userService.insert(user);
            ConnectionData connectionData = connection.createData();
            MyJson myJson = new MyJson();
            myJson.put("provider", connectionData.getProviderId());
            myJson.put("displayName", connectionData.getDisplayName());
            myJson.put("imageUrl", connectionData.getImageUrl());
            myJson.put("providerUserId", connectionData.getProviderUserId());
            myJson.put("secret", connectionData.getSecret());
            myJson.put("accessToken", connectionData.getAccessToken());
            myJson.put("expireTime", connectionData.getExpireTime());
            myJson.put("refreshToken", connectionData.getRefreshToken());
            UserData googleUserData = UserData.newBuilder().setUser(user)
                    .setSocialData(myJson).build();
            userDataService.insert(googleUserData);
        }
    }*/

    private String getLinkedinAccessToken(String faceCode){
        String token = null;
        if (faceCode != null && ! "".equals(faceCode)) {
            String newUrl = "https://www.linkedin.com/oauth/v2/accessToken?"
                + "grant_type=authorization_code&code=" + faceCode
                + "&redirect_uri=" + REDIRECT_URL
                + "&client_id=" + APP_ID + "&client_secret=" + APP_SECRET;
            HttpClient httpclient = new DefaultHttpClient();
            try {
                HttpGet httpget = new HttpGet(newUrl);
                ResponseHandler<String> responseHandler = new BasicResponseHandler();
                String responseBody = httpclient.execute(httpget, responseHandler);
                JSONObject json = (JSONObject)JSONSerializer.toJSON(responseBody);
                token = json.get("access_token").toString();

            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                httpclient.getConnectionManager().shutdown();
            }
        }
        return token;
    }
}

