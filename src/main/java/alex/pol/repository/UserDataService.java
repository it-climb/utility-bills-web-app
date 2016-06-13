package alex.pol.repository;

import alex.pol.domain.User;
import alex.pol.domain.UserData;

import java.sql.SQLException;

public interface UserDataService extends Service<UserData>{
    UserData findByUser(User user);

    @Override
    UserData insert(UserData o) throws SQLException;
}
