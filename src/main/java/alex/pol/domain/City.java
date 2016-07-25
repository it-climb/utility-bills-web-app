package alex.pol.domain;

import alex.pol.util.validation.Unique;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "cities")
public class City extends BaseModel {

    @Unique(message = "This City already exists")
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "city", fetch = FetchType.LAZY)
    private Set<UserData> userData;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "city", fetch = FetchType.LAZY)
    private Set<Street> street;

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Street> getStreet() {
        return street;
    }

    public void setStreet(Set<Street> street) {
        this.street = street;
    }
}
