package alex.pol.domain;

import alex.pol.util.validation.Unique;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "countries")
public class Country extends BaseModel{

    @Unique(message = "This County already exists")
    private String name;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "country", fetch = FetchType.LAZY)
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
