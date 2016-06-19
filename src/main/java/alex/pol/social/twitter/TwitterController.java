package alex.pol.social.twitter;

import alex.pol.domain.User;
import alex.pol.repository.UserDataService;
import alex.pol.repository.UserService;
import alex.pol.util.validation.UserValid;
import org.glassfish.jersey.server.oauth1.OAuth1Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth1.*;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
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
    //"http://utilitybillswebapp.unnt7pfuqq.eu-central-1.elasticbeanstalk.com/twitterCallback";
    //"http://localhost:8080/twitterCallback";
    "http://127.0.0.1:8080/twitterCallback";

    private static TwitterConnectionFactory twitterConnectionFactory;

    private static OAuth1Operations oauthOperations;

    private static OAuthToken requestToken;

    /*private Twitter twitter;

    private ConnectionRepository connectionRepository;

    @Inject
    public TwitterController(Twitter twitter, ConnectionRepository connectionRepository) {
        this.twitter = twitter;
        this.connectionRepository = connectionRepository;
    }

    @RequestMapping(value = "/twitterLogin1", method=RequestMethod.POST)
    public String helloTwitter(Model model) {
        if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
            return "redirect:/connect/twitter";
        }

        twitter.userOperations().getUserProfile().getName();

        model.addAttribute("connection", twitter.userOperations().getUserProfile().getName());
        model.addAttribute("code", twitter.userOperations().getUserProfile().getProfileImageUrl());
        model.addAttribute("token",twitter.userOperations().getUserProfile().getId());
        //CursoredList<TwitterProfile> friends = twitter.friendOperations().getFriends();
        //model.addAttribute("friends", friends);
        return "test";
    }
*/


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
        response.sendRedirect(authorizeUrl);/**/

// upon receiving the callback from the provider:
        /*OAuthToken accessToken = oauthOperations.exchangeForAccessToken(
                new AuthorizedRequestToken(requestToken, oauthVerifier), null);*/

        /*OAuthToken accessToken = new OAuthToken(ACCESS_TOKEN,ACEESS_TOKEN_SECRET);
        Connection<Twitter> connection = twitterConnectionFactory.createConnection(accessToken);*/

        /*twitter = new TwitterTemplate(APP_ID, APP_SECRET, ACCESS_TOKEN, ACEESS_TOKEN_SECRET);
        modelAndView.addObject("connection",twitter.userOperations().getUserProfile().getName());
        OAuth2Template oauth2 = new OAuth2Template(APP_ID, APP_SECRET, "", "https://api.twitter.com/oauth2/token");
        String accesstoken= oauth2.authenticateClient().getAccessToken();
        modelAndView.addObject("token",accesstoken);
        modelAndView.addObject("code",ACCESS_TOKEN);*/
       // modelAndView.addObject("connection",connection);
        //return modelAndView;

        /*twitterConnectionFactory =
                new TwitterConnectionFactory(APP_ID, APP_SECRET);
        oauthOperations = twitterConnectionFactory.getOAuthOperations();
        OAuthToken requestToken = oauthOperations.fetchRequestToken(REDIRECT_URL, null);
        String authorizeUrl = oauthOperations.buildAuthorizeUrl(requestToken.getValue(),
                OAuth1Parameters.NONE);
        response.sendRedirect(authorizeUrl);*/


        /*String returnValue =
                "https://accounts.google.com/o/oauth2/v2/auth?scope=email+profile&"//email,profile&"//%20
                        + "redirect_uri=" + REDIRECT_URL//"state=%2Fprofile&"
                        + "&response_type=code&client_id=" + APP_ID;
        return "redirect:" + returnValue;*/
    }

    @RequestMapping(value = "/twitterCallback", method = RequestMethod.GET)
    public ModelAndView getToken(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession httpSession = request.getSession();
        String oauthToken = request.getParameter("oauth_token");
        String authVerifier = request.getParameter("oauth_verifier");
        /*twitterConnectionFactory = new TwitterConnectionFactory(APP_ID, APP_SECRET);
        GoogleConnectionFactory googleConnectionFactory =
                new GoogleConnectionFactory(APP_ID, APP_SECRET);
        OAuth2Operations auth2Operations = googleConnectionFactory.getOAuthOperations();
        AccessGrant accessGrant = auth2Operations.exchangeForAccess(
                authorizationCode, REDIRECT_URL, null);
        Connection<Google> connection = googleConnectionFactory.createConnection(accessGrant);
        String googleUserEmail = connection.fetchUserProfile().getEmail();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("connection",connection);
        modelAndView.addObject("email",googleUserEmail);
        List<User> userList = userService.getAll();
        User googleUser = User.newBuilder().setEmail(googleUserEmail)
                .setPassword("Google").build();
        if (checkListForUser(userList,googleUser)){
            userService.insert(googleUser);
        }
        httpSession.setAttribute("user", googleUser);*/
        OAuthToken accessToken = oauthOperations.exchangeForAccessToken(
                new AuthorizedRequestToken(requestToken, authVerifier), null);
        Connection<Twitter> connection = twitterConnectionFactory.createConnection(accessToken);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("connection",connection);
        //modelAndView.addObject("token",oauthToken);
        //modelAndView.addObject("code",authVerifier);
        return modelAndView;
    }

    private boolean checkListForUser(List<User> userList, User user) {
        if (userList == null) return false;
        if (userList.size() == 0) return true;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getEmail().equals(user.getEmail())
                    && userList.get(i).getPassword().equals(user.getPassword())) {
                return false;
            }
        }
        return true;
    }
}/**/