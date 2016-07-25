package alex.pol.controllers.dashboards.admin;

import alex.pol.domain.City;
import alex.pol.domain.Country;
import alex.pol.domain.Street;
import alex.pol.domain.UserData;
import alex.pol.service.*;
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
public class StreetController {
    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

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




    @RequestMapping(value = "/listOfStreet", method = RequestMethod.GET)
    public ModelAndView showStreetTable(@ModelAttribute("myUserData") UserData myUserData,
                                        HttpServletRequest request) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.ADMIN_DASHBOARD_STREET_TABLE);
        List<Street> streetList = streetService.getAll();
        modelAndView.addObject("streetList", streetList);
        return modelAndView;
    }



    /**
     * Update(save new updated name of street) or save new street
     *
     * @param streetId
     * @param streetName
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/addNewStreet", method = RequestMethod.POST)
    public String addNewStreet(@RequestParam(required = false) Integer streetId,
                               @RequestParam(required = true) String streetName,
                               @RequestParam(required = true) Integer cityId,
                               @RequestParam(required = true) Integer countryId) throws SQLException {

        if (streetId == null) {
            Street street = new Street();
            if (streetName == null || cityId == null || countryId == null) {
                return "redirect:/except";
            }
            List<Street> streetList = streetService.getAll();
            for (Street street1 : streetList) {
                if (streetName.equals(street1.getName())) {
                    return "redirect:/except";
                }
            }
            street.setName(streetName);
            City city = this.cityService.getById(cityId);
            street.setCity(city);
            log.info("admin adding new street with name " + streetName + " and  id" + streetId);
            streetService.insert(street);
        } else {
            try {
                Street street = streetService.getById(streetId);
                street.setName(streetName);
                City city = this.cityService.getById(cityId);
                city.setCountry(this.countryService.getById(countryId));
                street.setCity(city);
                log.info("admin update the name of street on " + streetName + " and  id" + streetId);
                streetService.update(street);
            } catch (Exception e) {
                e.printStackTrace();
                return "redirect:/except";
            }
        }
        return "redirect:/listOfStreet";
    }


    /**
     * Show the page where you can update current name of street without adding new one
     *
     * @param streetId
     * @return
     * @throws SQLException
     */

    @RequestMapping(value = "/streetEdit", method = RequestMethod.POST)
    public ModelAndView saveOrUpdateStreet(@RequestParam(required = false) Integer streetId) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.ADMIN_DASHBOARD_STREET_EDIT);
        if (streetId != null) {
            Street street = streetService.getById(streetId);
            City city = streetService.getById(streetId).getCity();
            modelAndView.addObject("street", street);
            modelAndView.addObject("currentCity", city);

        }

        List<Country> countryList = this.countryService.getAll();
        List<City> cityList = this.cityService.getAll();
        modelAndView.addObject("cityList", cityList);
        modelAndView.addObject("countryList", countryList);
        return modelAndView;
    }

    /**
     * Delete street
     *
     * @param streetId
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/deleteStreet", method = RequestMethod.POST)
    public String deleteOne(@RequestParam(required = true) Integer streetId) throws SQLException {
        streetService.delete(streetService.getById(streetId));
        return "redirect:/listOfStreet";
    }

}