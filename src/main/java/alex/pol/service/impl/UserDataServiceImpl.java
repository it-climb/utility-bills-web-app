package alex.pol.service.impl;


import alex.pol.service.UserDataService;
import alex.pol.dao.UserDataDao;
import alex.pol.domain.User;
import alex.pol.domain.UserData;
import org.springframework.stereotype.Service;

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
