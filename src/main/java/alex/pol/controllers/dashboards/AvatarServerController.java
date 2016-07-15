package alex.pol.controllers.dashboards;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import alex.pol.domain.Avatar;
import alex.pol.domain.User;
import alex.pol.domain.UserData;
import alex.pol.service.*;
import alex.pol.util.ClassNameUtil;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AvatarServerController {

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
    @Autowired
    AvatarService avatarService;

    @RequestMapping(value = "/uploadAvatar", method = RequestMethod.POST)
    public String updateAvatar(@ModelAttribute("myUserData") UserData myUserData,
                               @RequestParam("avatarFile") MultipartFile avatarFile,
                               @RequestParam(required = false) Integer avatarId,
                               HttpServletRequest request) throws SQLException, IOException {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        myUserData = userDataService.findByUser(sessionUser);

        String[] partEmail = sessionUser.getEmail().split("@");
        String bucketName = "test-avatars-test";
        String keyName = partEmail[0] + "/" + avatarFile.getOriginalFilename();

        AWSCredentials credentials = new BasicAWSCredentials(
                "AKIAIIT3A6ZJYYAL7PXQ",
                "d/eRw4LdHCB9JULbTf+Qy10aQu1QE6+jlvshRdND");

        AmazonS3 s3client = new AmazonS3Client(credentials);

        if (!avatarFile.isEmpty()) {

            uploadOnS3(bucketName, keyName, s3client, avatarFile);

            String avatarPath = "http://" + bucketName + ".s3.amazonaws.com/" + keyName;

            Avatar avatar = new Avatar();
            List<Avatar> avatarList = avatarService.getAll();
////
////            String[] test = filePath.split("webapp");
////            String avatarPath = test[1];
////
            for (Avatar myAvatar : avatarList) {
                if (avatarPath.equals(myAvatar.getPath())) {
                    myUserData.setAvatar(this.avatarService.getByPath(avatarPath));
                    log.info("user changed avatar with Path " + avatarPath + " and  id " + avatar.getId());
                    userDataService.update(myUserData);
                    return "redirect:/userDash";
                }
            }

            avatar.setPath(avatarPath);
            avatarService.insert(avatar);
            if (avatar.getId() != null) {
                myUserData.setAvatar(this.avatarService.getById(avatar.getId()));
            }

        log.info("user adding new avatar with Path " + avatarPath + " and  id " + avatar.getId());
        userDataService.update(myUserData);

        }

        return "redirect:/userDash";
    }

    public File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    public void uploadOnS3(String bucketName, String keyName, AmazonS3 s3client,  MultipartFile file) throws IOException {

        try {

            s3client.putObject(
                    new PutObjectRequest(bucketName, keyName, convert(file))
                            .withCannedAcl(CannedAccessControlList.PublicRead));

        } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which " +
                    "means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which " +
                    "means the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

    }
}