package alex.pol.domain;

import alex.pol.util.validation.Unique;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "cities")
public class City extends BaseModel {

    @Unique(message = "This City already exists")
    private String name;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "city", fetch = FetchType.LAZY)
    private Set<UserData> userData;

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
