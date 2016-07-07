package alex.pol.controllers.dashboards;

import alex.pol.service.UserDataService;
import alex.pol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Abashkin Aleksandr on 18.06.2016.
 */

@Controller
public class DashboardsConroller {
    private String sessionAdminName = "admin";
    private String sessionModeratorName = "moderator";
    private String sessionUserName = "user";

    @Autowired
    UserService userService;
    @Autowired
    UserDataService userDataService;

    /**
     * This method show user login page(with fields asking you to enter your email and password)
     * or enter the page with user registration/
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/dashboards", method = RequestMethod.GET)
    public String selectDashboard(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute(sessionAdminName));
        System.out.println(session.getAttribute(sessionModeratorName));
        System.out.println(session.getAttribute(sessionUserName));

        if (session.getAttribute(sessionAdminName) != null) {
//            User admin = (User) session.getAttribute(sessionAdminName);
//            request.setAttribute("admin", admin);
            return "redirect:/adminDash";
        }
        if (session.getAttribute(sessionModeratorName) != null) {
//            User moderator = (User) session.getAttribute(sessionModeratorName);
//            request.setAttribute(sessionModeratorName, moderator);
            return "redirect:/moderatorDash";
        }
        if (session.getAttribute(sessionUserName) != null) {
//            User user = (User) session.getAttribute(sessionUserName);
//            request.setAttribute(sessionUserName, user);
            return "redirect:/userDash";
        } else {
            return "redirect:/home";
        }
    }

}