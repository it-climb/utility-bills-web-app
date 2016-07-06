package alex.pol.service.impl;


import alex.pol.service.UserService;
import alex.pol.dao.UserDao;
import alex.pol.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp extends BaseService<User, UserDao> implements UserService {

//    @Autowired
//    MailMail mailMail;

    @Override
    public User getByEmail(String email) {
       return dao.findByEmail(email);
    }

//    @Override
//    public User insert(User o) throws SQLException{
//
//            dao.save(o);
//            mailMail.sendMail("from@no-spam.com",
//                    o.getEmail(),
//                    "Welcome list",
//                    "Congratulation! \n\n Now you are in EESN team!");
//            return o;
//
//
//    }

}
