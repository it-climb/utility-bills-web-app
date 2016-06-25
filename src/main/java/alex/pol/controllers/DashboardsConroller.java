package alex.pol.controllers;

import alex.pol.domain.User;
import alex.pol.domain.UserData;
import alex.pol.dto.RegAndLogDto;
import alex.pol.repository.UserDataService;
import alex.pol.repository.UserService;
import alex.pol.repository.impl.UserDataServiceImpl;
import alex.pol.util.JspPath;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

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
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if (sessionUser == null) {
            return "redirect:/userDash";
        } else
            return "redirect:/userDash";
    }

    @RequestMapping(value = "/userDash", method = RequestMethod.GET)
    public ModelAndView showUserDashboard(@ModelAttribute("myUserData") UserData myUserData,
                                          @RequestParam(required = false) String firstName,
                                          @RequestParam(required = false) String secondName,
                                          HttpServletRequest request) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.USER_DASHBOARD);
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        myUserData = userDataService.findByUser(sessionUser);
        modelAndView.addObject("myUserData", myUserData);
        return modelAndView;
    }

    @RequestMapping(value = "/userEdit", method = RequestMethod.POST)
    public ModelAndView updateUserData(@ModelAttribute("myUserData") UserData myUserData,
                                       @RequestParam(required = false) String firstName,
                                       @RequestParam(required = false) String secondName,
                                       @RequestParam(required = false) String country,
                                       @RequestParam(required = false) String city,
                                       @RequestParam(required = false) String street,
                                       @RequestParam(required = false) String house,
                                       @RequestParam(required = false) String apartment,
                                       HttpServletRequest request) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.USER_DASHBOARD);
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        myUserData = userDataService.findByUser(sessionUser);
        myUserData.setFirstName(firstName);
        myUserData.setSecondName(secondName);
        myUserData.setCountry(country);
        myUserData.setCity(city);
        myUserData.setStreet(street);
        myUserData.setHouse(house);
        myUserData.setApartment(apartment);
        userDataService.update(myUserData);
        modelAndView.addObject("myUserData", myUserData);
        return modelAndView;
    }


    @RequestMapping(value = "/showTable", method = RequestMethod.GET)
    public ModelAndView showTable(@ModelAttribute("myUserData") UserData myUserData,
                                       HttpServletRequest request) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.USER_DASHBOARD_TABLE);
        return modelAndView;
    }

    @RequestMapping(value = "/showMap", method = RequestMethod.GET)
    public ModelAndView showMap(@ModelAttribute("myUserData") UserData myUserData,
                                  HttpServletRequest request) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.USER_DASHBOARD_MAP);
        return modelAndView;
    }

    @RequestMapping(value = "/sendPinCode", method = RequestMethod.GET)
    public String sendPinCode(@ModelAttribute("myUserData") UserData myUserData,
                                    @RequestParam(required = true) int pinCode,
                                    HttpServletRequest request) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.USER_DASHBOARD_SENDPIN);
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        myUserData = userDataService.findByUser(sessionUser);
        modelAndView.addObject("myUserData", myUserData);
        return "redirect:/userDash";
    }
}