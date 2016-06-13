package alex.pol.controllers;

import alex.pol.domain.User;
import alex.pol.domain.UserData;
import alex.pol.dto.RegAndLogDto;
import alex.pol.repository.UserDataService;
import alex.pol.repository.UserService;
import alex.pol.util.ClassNameUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Locale;

@Controller
public class HomeController {
    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    @Autowired
    UserService userService;

    @Autowired
    UserDataService userDataService;

    @RequestMapping(value= {"/","/home"}, method = RequestMethod.GET)
    public ModelAndView showAll(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        User userReg = new User();
        UserData userData = new UserData();
        User userLog = (User) session.getAttribute("user");

        ModelAndView modelAndView =new ModelAndView("home");
        RegAndLogDto dto = new RegAndLogDto();
        modelAndView.addObject("dto", dto);
        if (userLog != null){
            modelAndView.addObject("email", userLog.getEmail());
        }

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

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String addNewUser(@ModelAttribute("dto") RegAndLogDto dto,
                             HttpServletRequest request)throws SQLException {
        //userValid.validate(user, result);
//        if(result.hasErrors()){
//            return "users/registration";
//        }else{
        HttpSession session = request.getSession();
        User user = User.newBuilder().setEmail(dto.getEmail()).setPassword(dto.getPassword()).build();
        session.setAttribute("user", user);
        userService.insert(user);
        UserData userData = UserData.newBuilder().setUser(user).setFirstName(dto.getFirstName()).setSecondName(dto.getSecondName()).build();
        userDataService.insert(userData);
//        }
        return "redirect:/";
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public ModelAndView showSuccess() {
        ModelAndView modelAndView = new ModelAndView("/utils/success");
        return modelAndView;
    }

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/msg")
    public String msg(@RequestHeader("Accept-Language") Locale locale){
        return messageSource.getMessage("msg",null,locale);
    }
}

