package alex.pol.domain;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "city", fetch = FetchType.LAZY)
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
