package alex.pol.repository;

import alex.pol.domain.User;
import alex.pol.domain.UserData;

public interface UserDataService extends Service<UserData>{
    UserData findByUser(User user);
}
