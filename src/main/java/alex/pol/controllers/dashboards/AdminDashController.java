package alex.pol.controllers.dashboards;

import alex.pol.domain.*;
import alex.pol.service.*;
import alex.pol.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Abashkin Aleksandr on 18.06.2016.
 */

@Controller
public class AdminDashController {

    @Autowired
    UserService userService;
    @Autowired
    UserDataService userDataService;
    @Autowired
    StreetService streetService;
    @Autowired
    CountryService countryService;
    @Autowired
    CityService cityService;

    @RequestMapping(value = "/adminDash", method = RequestMethod.GET)
    public ModelAndView showAdminDashboard(@ModelAttribute("myUserData") UserData myUserData,
                                           @RequestParam(required = false) String firstName,
                                           @RequestParam(required = false) String secondName,
                                           HttpServletRequest request) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.ADMIN_DASHBOARD);
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("admin");
        myUserData = userDataService.findByUser(sessionUser);
        List<Street> streetList = this.streetService.getAll();
        List<Country> countryList = this.countryService.getAll();
        List<City> cityList = this.cityService.getAll();
        modelAndView.addObject("myUserData", myUserData);
        modelAndView.addObject("streetList", streetList);
        modelAndView.addObject("cityList", cityList);
        modelAndView.addObject("countryList", countryList);
        return modelAndView;
    }

    @RequestMapping(value = "/adminEdit", method = RequestMethod.POST)
    public String updateAdminData(@ModelAttribute("myUserData") UserData myUserData,
                                       @RequestParam(required = false) String firstName,
                                       @RequestParam(required = false) String secondName,
                                       @RequestParam(required = false) Integer countryId,
                                       @RequestParam(required = false) Integer cityId,
                                       @RequestParam(required = false) Integer streetId,
                                       @RequestParam(required = false) String house,
                                       @RequestParam(required = false) String apartment,
                                       HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("admin");
        myUserData = userDataService.findByUser(sessionUser);
        myUserData.setFirstName(firstName);
        myUserData.setSecondName(secondName);
        if (countryId != null){
            myUserData.setCountry(this.countryService.getById(countryId));
        }
        if (cityId != null){
            myUserData.setCity(this.cityService.getById(cityId));
        }
        if (streetId != null){
            myUserData.setStreet(this.streetService.getById(streetId));
        }
        myUserData.setHouse(house);
        myUserData.setApartment(apartment);
        userDataService.update(myUserData);
        return "redirect:/adminDash";
    }


    @RequestMapping(value = "/listOfUsers", method = RequestMethod.GET)
    public ModelAndView showUsersTable(@ModelAttribute("myUserData") UserData myUserData,
                                       HttpServletRequest request) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.ADMIN_DASHBOARD_TABLE);
        List<UserData> userList = userDataService.getAll();
        modelAndView.addObject("userList", userList);
        return modelAndView;
    }

    @RequestMapping(value = "/showMap", method = RequestMethod.GET)
    public ModelAndView showMap(@ModelAttribute("myUserData") UserData myUserData,
                                HttpServletRequest request) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.ADMIN_DASHBOARD_MAP);
        return modelAndView;
    }

//
//    @RequestMapping(value = "/addNewUser", method = RequestMethod.GET)
//    public ModelAndView addNewUser(@ModelAttribute("myUserData") UserData myUserData,
//                                HttpServletRequest request) throws SQLException {
//        ModelAndView modelAndView = new ModelAndView(JspPath.ADMIN_DASHBOARD_REGISTRATION);
//        return modelAndView;
//    }


    /**
     * This method will provide the medium to add a new user.
     */
    @RequestMapping(value = { "/addNewUser" }, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        UserData user = new UserData();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        return "registration";
    }
}