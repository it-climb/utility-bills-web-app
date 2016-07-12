package alex.pol.controllers.dashboards;

import alex.pol.domain.*;
import alex.pol.service.*;
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
import java.util.List;

@Controller
public class UserDashController {

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
    @Autowired
    AvatarService avatarService;



    @RequestMapping(value = "/userDash", method = RequestMethod.GET)
    public ModelAndView showUserDashboard(@ModelAttribute("myUserData") UserData myUserData,
                                          @RequestParam(required = false) String firstName,
                                          @RequestParam(required = false) String secondName,
                                          HttpServletRequest request) throws SQLException, InstantiationException, IllegalAccessException {
        ModelAndView modelAndView = new ModelAndView(JspPath.USER_DASHBOARD);
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        myUserData = userDataService.findByUser(sessionUser);
        List<Street> streetList = this.streetService.getAll();
        List<Country> countryList = this.countryService.getAll();
        List<City> cityList = this.cityService.getAll();
        List<Avatar> avatarList = this.avatarService.getAll();
        modelAndView.addObject("myUserData", myUserData);
        modelAndView.addObject("streetList", streetList);
        modelAndView.addObject("cityList", cityList);
        modelAndView.addObject("countryList", countryList);
        modelAndView.addObject("avatarList", avatarList);
        System.out.println(avatarList.toString());
        return modelAndView;
    }

    @RequestMapping(value = "/userEdit", method = RequestMethod.POST)
    public String updateUserData(@ModelAttribute("myUserData") UserData myUserData,
                                       @RequestParam(required = false) String firstName,
                                       @RequestParam(required = false) String secondName,
                                       @RequestParam(required = false) Integer countryId,
                                       @RequestParam(required = false) Integer cityId,
                                       @RequestParam(required = false) Integer streetId,
                                       @RequestParam(required = false) String house,
                                       @RequestParam(required = false) String apartment,
                                       HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
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
        return "redirect:/userDash";

    }


    @RequestMapping(value = "/showTable", method = RequestMethod.GET)
    public ModelAndView showTable(@ModelAttribute("myUserData") UserData myUserData,
                                  HttpServletRequest request) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.USER_DASHBOARD_TABLE);
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