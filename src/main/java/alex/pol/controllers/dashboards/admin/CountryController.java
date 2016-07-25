package alex.pol.controllers.dashboards.admin;

import alex.pol.domain.Country;
import alex.pol.domain.UserData;
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
public class CountryController {
    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    @Autowired
    UserService userService;
    @Autowired
    UserDataService userDataService;
    @Autowired
    CountryService countryService;

    @RequestMapping(value = "/listOfCountry", method = RequestMethod.GET)
    public ModelAndView showCountryTable(@ModelAttribute("myUserData") UserData myUserData,
                                         HttpServletRequest request) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.ADMIN_DASHBOARD_COUNTRY_TABLE);
        List<Country> countryList = countryService.getAll();
        modelAndView.addObject("countryList", countryList);
        return modelAndView;
    }

     /**
     * Update(save new updated name of country) or save new country
     *
     * @param countryId
     * @param countryName
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/addNewCountry", method = RequestMethod.POST)
    public String addNewCountry(@RequestParam(required = false) Integer countryId, @RequestParam(required = true) String countryName) throws SQLException {

        if (countryId == null) {
            Country country = new Country();
            if (countryName == null) {
                return "redirect:/except";
            }
            List<Country> countryList = countryService.getAll();
            for (Country myCountry : countryList) {
                if (countryName.equals(myCountry.getName())) {
                    return "redirect:/except";
                }
            }
            country.setName(countryName);
            log.info("admin adding new country with name " + countryName + " and  id" + countryId);
            countryService.insert(country);
        } else {

            try {
                Country country = countryService.getById(countryId);
                country.setName(countryName);
                log.info("admin update the name of country on " + countryName + " and  id" + countryId);
                countryService.update(country);
            } catch (Exception e) {
                e.printStackTrace();
                return "redirect:/except";
            }
        }
        return "redirect:/listOfCountry";
    }


    /**
     * Show the page where you can update current name of country without adding new one
     *
     * @param countryId
     * @return
     * @throws SQLException
     */

    @RequestMapping(value = "/countryEdit", method = RequestMethod.POST)
    public ModelAndView saveOrUpdateCountry(@RequestParam(required = false) Integer countryId) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.ADMIN_DASHBOARD_COUNTRY_EDIT);
        if (countryId != null) {
            Country country = countryService.getById(countryId);
            modelAndView.addObject("country", country);
        }

        return modelAndView;
    }

    /**
     * Delete country
     *
     * @param countryId
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/deleteCountry", method = RequestMethod.POST)
    public String deleteOne(@RequestParam(required = true) Integer countryId) throws SQLException {
        countryService.delete(countryService.getById(countryId));
        return "redirect:/listOfCountry";
    }

}