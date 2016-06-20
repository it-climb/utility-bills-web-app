package alex.pol.repository.impl;


import alex.pol.repository.UserDataService;
import alex.pol.dao.UserDataDao;
import alex.pol.domain.User;
import alex.pol.domain.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserDataServiceImpl extends BaseService<UserData, UserDataDao> implements UserDataService {

    public UserData findByUser(User user) {
        UserData userData = dao.findByUser(user);
        if (userData != null) {
            return userData;
        } else {
            userData = new UserData();
            userData.setUser(user);
            dao.save(userData);
            return userData;
        }
    }

}
