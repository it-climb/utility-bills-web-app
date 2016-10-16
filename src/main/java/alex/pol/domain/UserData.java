package alex.pol.domain;

import javax.persistence.*;
import java.util.List;


import alex.pol.util.PostgreJsonHibernate.MyJson;
import alex.pol.util.PostgreJsonHibernate.MyJsonType;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.google.gson.Gson;
import net.sf.json.JSONObject;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Entity(name = "UserData")
@TypeDef(name = "MyJsonType",typeClass = MyJsonType.class)
public class UserData extends BaseModel {

    private String firstName;

    private String secondName;

    private Integer age;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "street_id")
    private Street street;

    private String house;

    private String apartment;

    private int pinCode;

    @Column
    @Type(type = "MyJsonType")
    private MyJson socialData;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public MyJson getSocialData(){return socialData;}

    public void setSocialData(MyJson socialData){this.socialData = socialData;}

    public static Builder newBuilder() {
        return new UserData().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setId(Integer id) {
            UserData.this.id = id;
            return this;
        }

        public Builder setFirstName(String name) {
            UserData.this.firstName = name;
            return this;
        }

        public Builder setSecondName(String name) {
            UserData.this.secondName = name;
            return this;
        }

        public Builder setAge(Integer age) {
            UserData.this.age = age;
            return this;
        }

        public Builder setCountry(Country country) {
            UserData.this.country = country;
            return this;
        }

        public Builder setCity(City city) {
            UserData.this.city = city;
            return this;
        }

        public Builder setStreet(Street street) {
            UserData.this.street = street;
            return this;
        }

        public Builder setHouse(String house) {
            UserData.this.house = house;
            return this;
        }

        public Builder setApartment(String apartment) {
            UserData.this.apartment = apartment;
            return this;
        }

        public Builder setPinCode(int pinCode) {
            UserData.this.pinCode = pinCode;
            return this;
        }

        public Builder setUser(User user) {
            UserData.this.user = user;
            return this;
        }

        public Builder setSocialData(MyJson socialData) {
            UserData.this.socialData = socialData;
            return this;
        }


        public UserData build() {
            return UserData.this;
        }
    }

    @Override
    public String toString() {
        return "UserData{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", country=" + country +
                ", city=" + city +
                ", street=" + street +
                ", house='" + house + '\'' +
                ", apartment='" + apartment + '\'' +
                ", pinCode=" + pinCode +
                ", socialData=" + socialData +
                ", user=" + user +
                '}';
    }
}

