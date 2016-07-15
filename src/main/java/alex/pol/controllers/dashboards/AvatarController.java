//package alex.pol.controllers.dashboards;
//import alex.pol.domain.*;
//import alex.pol.service.*;
//import alex.pol.util.ClassNameUtil;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//
//import java.io.File;
//import java.io.BufferedOutputStream;
//import java.io.FileOutputStream;
//
//import java.io.IOException;
//import java.nio.file.Paths;
//import java.sql.SQLException;
//import java.util.List;
//
//@Controller
//public class AvatarController {
//
//    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());
//
//    @Autowired
//    UserService userService;
//    @Autowired
//    UserDataService userDataService;
//    @Autowired
//    StreetService streetService;
//    @Autowired
//    CountryService countryService;
//    @Autowired
//    CityService cityService;
//    @Autowired
//    AvatarService avatarService;
//
//    @RequestMapping(value = "/uploadAvatar", method = RequestMethod.POST)
//    public String updateAvatar(@ModelAttribute("myUserData") UserData myUserData,
//                               @RequestParam("avatarFile") MultipartFile avatarFile,
//                               @RequestParam(required = false) Integer avatarId,
//                               HttpServletRequest request) throws SQLException, IOException {
//        HttpSession session = request.getSession();
//        User sessionUser = (User) session.getAttribute("user");
//        myUserData = userDataService.findByUser(sessionUser);
//        if (avatarFile != null) {
//            if (!avatarFile.isEmpty()) {
//             try {
//
//                 String fileName = avatarFile.getOriginalFilename();
//
////                 ~~~~~~~~~~~~~~~~~Create new Directory for user avatars~~~~~~~~~~~~~~~~~~~~
//
//                 String[] test1 = sessionUser.getEmail().split("@");
//                 String nameDir = test1[0] + sessionUser.getId();
//                 String directory = "/home/agios/JavaProjects/utility-bills-web-app6/src/main/webapp/resources/dashboards/assets/img/avatars/".concat(nameDir);
//                 File dir = new File(directory);
//                 if(!(dir.exists())){
//                     dir.mkdirs();
//                 }
//                 String filePath = Paths.get(directory, fileName).toString();
//
//                 BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
//                 stream.write(avatarFile.getBytes());
//                 stream.close();
//
////
////                 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
////                 ~~~~~~~~~~~~~~~Save new user avatars on the local Drive~~~~~~~~~~~~~~
//
////                 String directory = "/home/agios/JavaProjects/utility-bills-web-app6/src/main/webapp/resources/dashboards/assets/img/avatars/";
////                 String filePath = Paths.get(directory, fileName).toString();
////
////                 BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
////                 stream.write(avatarFile.getBytes());
////                 stream.close();
//
////                 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
////                 ~~~~~~~~~~~~~~~Create new user avatars~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//                 Avatar avatar = new Avatar();
//                 List<Avatar> avatarList = avatarService.getAll();
//
//                 String[] test = filePath.split("webapp");
//                 String avatarPath = test[1];
//
//                 for (Avatar myAvatar : avatarList) {
//                     if (avatarPath.equals(myAvatar.getPath())) {
//                         myUserData.setAvatar(this.avatarService.getByPath(avatarPath));
//                         log.info("user changed avatar with Path " + avatarPath + " and  id " + avatar.getId());
//                         userDataService.update(myUserData);
//                         return "redirect:/userDash";
//                     }
//                 }
//
//                 avatar.setPath(avatarPath);
//                 avatarService.insert(avatar);
//                 if (avatar.getId()!= null){
//                     myUserData.setAvatar(this.avatarService.getById(avatar.getId()));
//                 }
//                 log.info("user adding new avatar with Path " + avatarPath + " and  id " + avatar.getId());
//             } catch (Exception e) {
//                 System.out.print(e.getMessage());
//             }
//            }
//
////                 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//        }
//        userDataService.update(myUserData);
//        return "redirect:/userDash";
//    }
//}
