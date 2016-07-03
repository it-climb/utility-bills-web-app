package alex.pol.social.google;

import alex.pol.domain.User;
import alex.pol.domain.UserData;
import alex.pol.repository.UserDataService;
import alex.pol.repository.UserService;
import alex.pol.util.PostgreJsonHibernate.MyJson;
import alex.pol.util.validation.UserValid;
import net.sf.json.JSONObject;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class GoogleController {


    @Autowired
    UserValid userValid;

    @Autowired
    UserService userService;

    @Autowired
    UserDataService userDataService;

    private static final String APP_ID = "1011007286985-m3j1tdo57usehe66vh7knlpc9rd3en93.apps.googleusercontent.com";

    private static final String APP_SECRETE = "qtBbMeRj02xbdIqoeARnrHI1";

    private static final String REDIRECT_URL = "http://utilitybillswebapp.unnt7pfuqq.eu-central-1.elasticbeanstalk.com/googleCallback";
    //"http://localhost:8080/googleCallback";


    @RequestMapping(value = "/googleLogin", method = RequestMethod.GET)
    public String loginWithGoogle(HttpServletRequest request) {
        //HttpSession session = request.getSession();
        //String sessionId = session.getId();
        String returnValue =
                "https://accounts.google.com/o/oauth2/v2/auth?scope=email+profile&"
                        + "redirect_uri=" + REDIRECT_URL
                        + "&response_type=code&client_id=" + APP_ID;
        return "redirect:" + returnValue;
    }

    @RequestMapping(value = "/googleCallback", method = RequestMethod.GET)
    public String getAccessToken(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession httpSession = request.getSession();
        String authorizationCode = request.getParameter("code");
        GoogleConnectionFactory googleConnectionFactory =
                new GoogleConnectionFactory(APP_ID, APP_SECRETE);
        OAuth2Operations auth2Operations = googleConnectionFactory.getOAuthOperations();
        AccessGrant accessGrant = auth2Operations.exchangeForAccess(
                authorizationCode, REDIRECT_URL, null);
        Connection<Google> connection = googleConnectionFactory.createConnection(accessGrant);
        String googleUserEmail =connection.fetchUserProfile().getEmail();
        User googleUser = userService.getByEmail(googleUserEmail);
        if (googleUser == null) {
            googleUser= User.newBuilder().setEmail(googleUserEmail)
                    .setPassword(RandomStringUtils.randomAlphanumeric(16)).build();//"Google"
            userService.insert(googleUser);
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
            UserData googleUserData = UserData.newBuilder().setUser(googleUser)
                    .setSocialData(myJson).build();
            userDataService.insert(googleUserData);
        }
        httpSession.setAttribute("user", googleUser);
        return "redirect:/";

    }
/*
    private User addUserAndUserData(User user, Connection connection) throws SQLException {
        if (user == null) {
            user = User.newBuilder().setEmail(connection.fetchUserProfile().getEmail())
                    .setPassword(RandomStringUtils.randomAlphanumeric(16)).build();//"Google"
            userService.insert(user);
            ConnectionData connectionData = connection.createData();
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("provider", connectionData.getProviderId());
            jsonObject.put("displayName", connectionData.getDisplayName());
            jsonObject.put("imageUrl", connectionData.getImageUrl());
            jsonObject.put("providerUserId", connectionData.getProviderUserId());
            jsonObject.put("secret", connectionData.getSecret());
            jsonObject.put("accessToken", connectionData.getAccessToken());
            jsonObject.put("expireTime", connectionData.getExpireTime());
            jsonObject.put("refreshToken", connectionData.getRefreshToken());

            MyJson myJson = new MyJson();
            myJson.setSocialData(jsonObject);
            UserData googleUserData = UserData.newBuilder().setUser(user)
                    .setSocialData(myJson).build();
            userDataService.insert(googleUserData);
        }
        return user;
    }*/
}

