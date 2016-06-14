package alex.pol.social.linkedin;

import alex.pol.domain.User;
import alex.pol.repository.UserDataService;
import alex.pol.repository.UserService;
import alex.pol.util.validation.UserValid;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
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

    private static final String APP_ID ="773o2rdlcyfr20";

    private static final String APP_SECRETE ="oUGpJndR2jlLvanv";

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
    public ModelAndView getToken(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {
        HttpSession httpSession = request.getSession();
        String faceCode = request.getParameter("code");
        String accessToken = getLinkedinAccessToken(faceCode);
        AccessGrant accessGrant = new AccessGrant(accessToken);
        LinkedInConnectionFactory connectionFactory =
                new LinkedInConnectionFactory(APP_ID, APP_SECRETE);
        Connection<LinkedIn> connection = connectionFactory.createConnection(accessGrant);
        String linkedinUserEmail = connection.fetchUserProfile().getEmail();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("connection",connection);
        modelAndView.addObject("email",linkedinUserEmail);
        List<User> userList = userService.getAll();
        User linkedinUser = User.newBuilder().setEmail(linkedinUserEmail).setPassword("Linkedin").build();
        if (checkListForUser(userList,linkedinUser)){
            userService.insert(linkedinUser);
        }
        httpSession.setAttribute("user", linkedinUser);
        return modelAndView;
    }

    private boolean checkListForUser(List<User> userList, User user){
        if (userList==null) return false;
        if (userList.size()==0)return true;
        for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getEmail().equals(user.getEmail())
                    && userList.get(i).getPassword().equals(user.getPassword())){
                return false;
            }
        }
        return true;
    }

    private String getLinkedinAccessToken(String faceCode){
        String token = null;
        if (faceCode != null && ! "".equals(faceCode)) {
            String newUrl = "https://www.linkedin.com/oauth/v2/accessToken?"
                + "grant_type=authorization_code&code=" + faceCode
                + "&redirect_uri=" + REDIRECT_URL
                + "&client_id=" + APP_ID + "&client_secret=" + APP_SECRETE;
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

