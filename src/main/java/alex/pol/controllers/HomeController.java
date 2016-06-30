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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
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

    private StringBuilder add = null;

    @RequestMapping(value= {"/","/home"}, method = RequestMethod.GET)
    public ModelAndView showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException {


        HttpSession session = request.getSession();
        User userReg = new User();
        UserData userData = new UserData();
        User userLog = (User) session.getAttribute("user");
        if (add != null && add.toString().equals("logout")){
            userLog = null;
            session.invalidate();
        }
        RegAndLogDto dto = new RegAndLogDto();
        ModelAndView modelAndView =new ModelAndView("home");
        modelAndView.addObject("dto", dto);
        modelAndView.addObject("add", add);
        add = null;
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

    /**
     * Add new user in DB if you entered write information in fields of adding user(enter first name, last name, email and password)
     * in not, write about your mistakes
     * If all is clear send you to congratulation modal window
     * @param dto
     * @param request
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String addNewUser(@ModelAttribute("dto") RegAndLogDto dto,
                             HttpServletRequest request)throws SQLException {

        HttpSession session = request.getSession();
        User user = User.newBuilder().setEmail(dto.getEmail()).setPassword(dto.getPassword()).build();
        session.setAttribute("user", user);
        userService.insert(user);
        UserData userData = UserData.newBuilder().setUser(user).build();
        userDataService.insert(userData);
        add = new StringBuilder("add");
        return "redirect:/";
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public ModelAndView showSuccess() {
        ModelAndView modelAndView = new ModelAndView("/utils/success");
        return modelAndView;
    }

    @RequestMapping(value = "/accountLogout", method = RequestMethod.GET)
    public String logOut(){
        add = new StringBuilder("logout");
        return "redirect:/";
    }

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/msg")
    public String msg(@RequestHeader("Accept-Language") Locale locale){
        return messageSource.getMessage("msg",null,locale);
    }

    /**
     *Method act when you entered your email and password
     * @param email
     * @param password
     * @param request
     * @return all is write - page success (Success)
     * something is wrong - page loginProblems ("Incorrect email ! Try again")
     * @throws SQLException
     */

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public String updateOne(@RequestParam(required = true) String email, @RequestParam(required = true) String password, HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        User user = userService.getByEmail(email);
        if(user!=null && user.getPassword().equals(password/*Integer.toString(password.hashCode())*/)) {
            session.setAttribute("user", user);
            return "redirect:/";
        }else {
            add = new StringBuilder("errorLogin");
            return "redirect:/";
        }
    }
}

