package alex.pol.domain;
import alex.pol.util.validation.Unique;
import javax.persistence.*;
import java.util.*;

@Entity(name = "streets")
public class Street extends BaseModel {

    @Unique(message = "This street already exists")
    private String name;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "street", fetch = FetchType.LAZY)
    private Set<UserData> userData;


    public Set<UserData> getUserData() {
        return userData;
    }

    public void setUserData(Set<UserData> userData) {
        this.userData = userData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}





