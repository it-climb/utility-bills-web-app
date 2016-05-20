package alex.pol.controllers;

import alex.pol.util.ClassNameUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showAll(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView =new ModelAndView("home");
        modelAndView.addObject("name","hello");
        return modelAndView;
    }

    @RequestMapping(value = "/except", method = RequestMethod.GET)
    public ModelAndView showExcept() {
        ModelAndView modelAndView = new ModelAndView("/exceptions/except");

        log.fatal("fatal message");
        log.error("error message");
        log.warn("warning message");
        log.info("info message");
        log.trace("trace message");
        log.debug("debug message");

        return modelAndView;
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public ModelAndView showSuccess() {
        ModelAndView modelAndView = new ModelAndView("/utils/success");
        return modelAndView;
    }


}
