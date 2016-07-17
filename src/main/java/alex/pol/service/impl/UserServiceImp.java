package alex.pol.service.impl;

import alex.pol.service.UserService;
import alex.pol.dao.UserDao;
import alex.pol.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import java.sql.SQLException;

@Service
public class UserServiceImp extends BaseService<User, UserDao> implements UserService {


    @Autowired
    NotificationService notificationService;


    @Override
    public User getByEmail(String email) {
       return dao.findByEmail(email);
    }

    @Override
    public User insert(User o) throws SQLException {

            notificationService.sendNotification(o);
        dao.save(o);
        return o;
    }
}
