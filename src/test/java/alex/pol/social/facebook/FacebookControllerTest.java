package alex.pol.social.facebook;

import alex.pol.service.UserDataService;
import alex.pol.service.UserService;
import alex.pol.util.validation.UserValid;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.OAuth2Operations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;

public class FacebookControllerTest {

    FacebookController facebookController;

    @Autowired
    UserValid userValid;

    @Autowired
    UserService userService;

    @Autowired
    UserDataService userDataService;

    @Value("${spring.social.facebook.app-id}")
    private String APP_ID;

    @Value("${spring.social.facebook.app-secret}")
    private String APP_SECRETE;

    private static final String REDIRECT_URL =
            //"http://utilitybillswebapp.unnt7pfuqq.eu-central-1.elasticbeanstalk.com/callback";
            "http://localhost:8080/callback";

    private static FacebookConnectionFactory facebookConnectionFactory;

    private static OAuth2Operations oauthOperations;

    @Before
    public void setUp() throws Exception {
        facebookController= new FacebookController();
    }
/*
    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testReturnError() throws Exception {

    }

@Test
    public void testGetConnection() throws Exception {

    }
*/
    @Test
    public void testLoginWithFacebook() throws Exception {
        /*HttpServletRequest request;
        HttpServletResponse response;
        facebookController.loginWithFacebook(request, response);
        FacebookController h;*/
        assertEquals("","");
    }


}