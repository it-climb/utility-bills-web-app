package alex.pol.domain;

import alex.pol.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.*;

@Entity(name = "streets")
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "street", fetch = FetchType.LAZY)
    private Set<UserData> userData;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserData> getUserData() {
        return userData;
    }

    public void setUserData(Set<UserData> userData) {
        this.userData = userData;
    }

}
