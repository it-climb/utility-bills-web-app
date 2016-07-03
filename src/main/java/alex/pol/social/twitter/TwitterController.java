package alex.pol.social.twitter;

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
import org.springframework.social.oauth1.*;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class TwitterController {


    @Autowired
    UserValid userValid;

    @Autowired
    UserService userService;

    @Autowired
    UserDataService userDataService;

    private static final String APP_ID = "PKCZbhANQr8j2crAhjg2mpHBe";

    private static final String APP_SECRET = "LjdLyDgRqWjHLk2WbWUd2p0kia2Vivmv25L3LmG0jKf37Eny1l";

    //private static final String ACCESS_TOKEN="742722266186797056-ha3zCmesK3pLZ5geHlEbXcr0zm6taM7";

    //private static final String ACEESS_TOKEN_SECRET = "4jYZeRuUMkim8UfxLgBmT6bQtYQnvXEp3YUH6i0WZchZW";

    private static final String REDIRECT_URL =
    "http://utilitybillswebapp.unnt7pfuqq.eu-central-1.elasticbeanstalk.com/twitterCallback";
    //"http://127.0.0.1:8080/twitterCallback";

    private static TwitterConnectionFactory twitterConnectionFactory;

    private static OAuth1Operations oauthOperations;

    private static OAuthToken requestToken;

    private static Connection<Twitter> connection;



    @RequestMapping(value = "/twitterLogin", method = RequestMethod.GET)
    public void loginWithTwitter(HttpServletRequest request,
                                   HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        String sessionId = session.getId();

        twitterConnectionFactory =
                new TwitterConnectionFactory(APP_ID, APP_SECRET);
        oauthOperations = twitterConnectionFactory.getOAuthOperations();
        requestToken = oauthOperations.fetchRequestToken(REDIRECT_URL, null);
        String authorizeUrl = oauthOperations.buildAuthorizeUrl(requestToken.getValue(), OAuth1Parameters.NONE);
        response.sendRedirect(authorizeUrl);
    }

    @RequestMapping(value = "/twitterCallback", method = RequestMethod.GET)
    public ModelAndView getToken(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession httpSession = request.getSession();
        String oauthToken = request.getParameter("oauth_token");
        String authVerifier = request.getParameter("oauth_verifier");
        OAuthToken accessToken = oauthOperations.exchangeForAccessToken(
                new AuthorizedRequestToken(requestToken, authVerifier), null);
        connection = twitterConnectionFactory.createConnection(accessToken);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("connection",connection);
        modelAndView.addObject("email","");
        return modelAndView;
    }

    @RequestMapping(value = "/addTwitterUser", method = RequestMethod.GET)
    public String addTwitterUser(@RequestParam(required = false) String email,
                                 HttpServletRequest request) throws SQLException {
        HttpSession httpSession = request.getSession();
        User twitterUser = userService.getByEmail(email);
        //addUserAndUserData(twitterUser, connection, email);
        if (twitterUser == null) {
            twitterUser = User.newBuilder().setEmail(email)
                    .setPassword(RandomStringUtils.randomAlphanumeric(16)).build();
            userService.insert(twitterUser);
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
            UserData googleUserData = UserData.newBuilder().setUser(twitterUser)
                    .setSocialData(myJson).build();
            userDataService.insert(googleUserData);
        }
        UserData twitterUserData = userDataService.findByUser(twitterUser);
        if(twitterUser != null && !twitterUserData.getSocialData()
                .get("provider").equals("twitter")){
            twitterUser = null;
        }
        httpSession.setAttribute("user", twitterUser);
        return "redirect:/";

    }

    /*private void addUserAndUserData(User user, Connection connection,String email) throws SQLException {
        if (user == null) {
            user = User.newBuilder().setEmail(email)
                    .setPassword(RandomStringUtils.randomAlphanumeric(16)).build();//"Google"
            userService.insert(user);
            JSONObject jsonObject = new JSONObject();
            ConnectionData connectionData = connection.createData();
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
    }

    private boolean checkListForUser(List<User> userList, User user) {
        if (userList == null) return false;
        if (userList.size() == 0) return true;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getEmail().equals(user.getEmail())
                    //&& userList.get(i).getPassword().equals(user.getPassword())
                    ) {
                user = userList.get(i);
                return false;
            }
        }
        return true;
    }*/
}