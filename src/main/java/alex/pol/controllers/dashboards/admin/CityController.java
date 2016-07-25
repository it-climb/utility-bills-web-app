package alex.pol.controllers.dashboards.admin;

import alex.pol.domain.City;
import alex.pol.domain.Country;
import alex.pol.domain.UserData;
import alex.pol.service.CityService;
import alex.pol.service.CountryService;
import alex.pol.service.UserDataService;
import alex.pol.service.UserService;
import alex.pol.util.ClassNameUtil;
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
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Abashkin Aleksandr on 18.06.2016.
 */

@Controller
public class CityController {
    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    @Autowired
    UserService userService;
    @Autowired
    UserDataService userDataService;
    @Autowired
    CountryService countryService;
    @Autowired
    CityService cityService;




    @RequestMapping(value = "/listOfCity", method = RequestMethod.GET)
    public ModelAndView showCityTable(@ModelAttribute("myUserData") UserData myUserData,
                                        HttpServletRequest request) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.ADMIN_DASHBOARD_CITY_TABLE);
        List<City> cityList = cityService.getAll();
        modelAndView.addObject("cityList", cityList);
        return modelAndView;
    }



    /**
     * Update(save new updated name of city) or save new city
     *
     * @param cityId
     * @param cityName
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/addNewCity", method = RequestMethod.POST)
    public String addNewCity(@RequestParam(required = false) Integer cityId,
                             @RequestParam(required = true) String cityName,
                             @RequestParam(required = true) Integer countryId) throws SQLException {

        if (cityId == null) {
            City city = new City();
            if (cityName == null || countryId == null) {
                return "redirect:/except";
            }
            List<City> cityList = cityService.getAll();
            for (City city1 : cityList) {
                if (cityName.equals(city1.getName())) {
                    return "redirect:/except";
                }
            }
            city.setName(cityName);
            city.setCountry(this.countryService.getById(countryId));

            log.info("admin adding new city with name " + cityName + " and  id" + cityId);
            cityService.insert(city);
        } else {

            try {
                City city = cityService.getById(cityId);
                city.setName(cityName);
                city.setCountry(this.countryService.getById(countryId));
//                Street street = Street.newBuilder().setName(streetName).setId(streetId).build();
                log.info("admin update the name of city on " + cityName + " and  id" + cityId);
                cityService.update(city);
            } catch (Exception e) {
                e.printStackTrace();
                return "redirect:/except";
            }
        }
        return "redirect:/listOfCity";
    }


    /**
     * Show the page where you can update current name of street without adding new one
     *
     * @param cityId
     * @return
     * @throws SQLException
     */

    @RequestMapping(value = "/cityEdit", method = RequestMethod.POST)
    public ModelAndView saveOrUpdateCity(@RequestParam(required = false) Integer cityId) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.ADMIN_DASHBOARD_CITY_EDIT);
        if (cityId != null) {
            City city = cityService.getById(cityId);
            Country country = cityService.getById(cityId).getCountry();
            modelAndView.addObject("city", city);
            modelAndView.addObject("currentCountry", country);
        }

        List<Country> countryList = this.countryService.getAll();
        modelAndView.addObject("countryList", countryList);
        return modelAndView;
    }

    /**
     * Delete city
     *
     * @param cityId
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/deleteCity", method = RequestMethod.POST)
    public String deleteOne(@RequestParam(required = true) Integer cityId) throws SQLException {
        cityService.delete(cityService.getById(cityId));
        return "redirect:/listOfCity";
    }

}