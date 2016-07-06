package alex.pol.social.google;

import alex.pol.domain.User;
import alex.pol.service.UserDataService;
import alex.pol.service.UserService;
import alex.pol.util.validation.UserValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

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
            httpSession.setAttribute("user", googleUser);
        //return modelAndView;
        return "redirect:/";
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
}