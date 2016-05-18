package alex.pol.repository;

import alex.pol.domain.User;

import java.sql.SQLException;

public interface UserService extends Service<User> {

    User getByEmail(String email);

    @Override
    User insert(User o) throws SQLException;
}
