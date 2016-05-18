package alex.pol.dao;


import alex.pol.domain.User;
import alex.pol.domain.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataDao extends JpaRepository<UserData, Integer> {
    UserData findByUser(User user);
}
