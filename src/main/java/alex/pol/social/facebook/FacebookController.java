package alex.pol.social.facebook;

import alex.pol.domain.User;
import alex.pol.repository.UserDataService;
import alex.pol.repository.UserService;
import alex.pol.social.model.SocialUserData;
import alex.pol.util.validation.UserValid;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.facebook.api.Facebook;

import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
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
public class FacebookController {


    @Autowired
    UserValid userValid;

    @Autowired
    UserService userService;

    @Autowired
    UserDataService userDataService;

    @RequestMapping(value="/facebookLogin",method = RequestMethod.GET)
    public String loginWithFacebook(HttpServletRequest request){

        HttpSession session = request.getSession();
        String sessionId = session.getId();
        String appId = "1554105688224570";
        String redirectUrl = "http://localhost:8080/callback";//localhost
        String returnValue = "https://www.facebook.com/dialog/oauth?client_id="
                + appId + "&redirect_uri=" + redirectUrl
                + "&scope=email,user_birthday&state=" + sessionId;
        return "redirect:"+returnValue;
    }

    @RequestMapping(value = "/callback", method = RequestMethod.GET)
    public ModelAndView getToken(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {
        HttpSession httpSession = request.getSession();
        String faceCode = request.getParameter("code");
        //String state = request.getParameter("state");
        String accessToken = getFacebookAccessToken(faceCode);
        //JSONObject jsonObject = getUserJSONObjectFromJsonResponse(accessToken, httpSession);
        //String sessionID = httpSession.getId();
        AccessGrant accessGrant = new AccessGrant(accessToken);
        FacebookConnectionFactory connectionFactory =
                new FacebookConnectionFactory("1554105688224570", "b9c76b95fefb25983b0d45d9ba3d8364");
        Connection<Facebook> connection = connectionFactory.createConnection(accessGrant);
        String facebookUserEmail = connection.fetchUserProfile().getEmail();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("connection",connection);
        modelAndView.addObject("email",facebookUserEmail);


        List<User> userList = userService.getAll();
        User facebookUser = User.newBuilder().setEmail(facebookUserEmail).setPassword("Facebook").build();

        if (checkListForUser(userList,facebookUser)){
            userService.insert(facebookUser);
        }

        httpSession.setAttribute("user", facebookUser);


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

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    private String logoutUser(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.invalidate();
        return "redirect:http://localhost:8080/login";
    }

    private String getFacebookAccessToken(String faceCode){
        String token = null;
        if (faceCode != null && ! "".equals(faceCode)) {
            String appId = "1554105688224570";
            String redirectUrl = "http://localhost:8080/callback";
            String faceAppSecret = "b9c76b95fefb25983b0d45d9ba3d8364";
            String newUrl = "https://graph.facebook.com/oauth/access_token?client_id="
                    + appId + "&redirect_uri=" + redirectUrl + "&client_secret="
                    + faceAppSecret + "&code=" + faceCode;
            HttpClient httpclient = new DefaultHttpClient();
            try {
                HttpGet httpget = new HttpGet(newUrl);
                ResponseHandler<String> responseHandler = new BasicResponseHandler();
                String responseBody = httpclient.execute(httpget, responseHandler);

                if(responseBody.contains("access_token")) {
                    //success
                    String[] mainResponseArray = responseBody.split("&");
                    for (String string : mainResponseArray) {
                        if (string.contains("access_token")) {
                            token = string.replace("access_token=", "").trim();
                        }
                    }
                }

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

    private JSONObject getUserJSONObjectFromJsonResponse(String accessToken,
                                                      HttpSession httpSession) {
        JSONObject json = null;
        HttpClient httpclient = new DefaultHttpClient();
        try {
            if (accessToken != null && ! "".equals(accessToken)) {
                String newUrl = "https://graph.facebook.com/me?access_token=" + accessToken;
                httpclient = new DefaultHttpClient();
                HttpGet httpget = new HttpGet(newUrl);
                System.out.println("Get info from face --> executing request: "
                        + httpget.getURI());
                ResponseHandler<String> responseHandler = new BasicResponseHandler();
                String responseBody = httpclient.execute(httpget, responseHandler);
                json = (JSONObject) JSONSerializer.toJSON(responseBody);

            } else {
                System.err.println("Token for facebook is null");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpclient.getConnectionManager().shutdown();
        }
        return json;
    }
}
