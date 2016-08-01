package alex.pol.controllers.dashboards;

import alex.pol.domain.Role;
import alex.pol.domain.User;
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
        System.out.println("method selectDashboard!!");
        HttpSession session = request.getSession();
        User user = userService.getByEmail((String) session.getAttribute("email"));
        System.out.println("СМОТРИ СЮДА = " + user);
//        if (userDataService.findByUser(user).getRole().equals(Role.USER)) {
        if (userService.getByEmail(user.getEmail()).getRole().equals(Role.USER)) {
            System.out.println("USER want to open dashboard!!");
            session.setAttribute("user", user);
            return "redirect:/userDash";
//        } else if (userDataService.findByUser(user).getRole().equals(Role.MODERATOR)) {
        } else if (userService.getByEmail(user.getEmail()).getRole().equals(Role.MODERATOR)) {
            System.out.println("Moderator want to open dashboard!!");
            session.setAttribute("moderator", user);
            return "redirect:/moderatorDash";
//        } else if (userDataService.findByUser(user).getRole().equals(Role.ADMIN)) {
        } else if (userService.getByEmail(user.getEmail()).getRole().equals(Role.ADMIN)) {
            System.out.println("ADMIN want to open dashboard!!");
            session.setAttribute("admin", user);
            return "redirect:/adminDash";
        } else {
            System.out.println("LAST ELSE IS WORKING");
            return "redirect:/home";
        }

    }

}