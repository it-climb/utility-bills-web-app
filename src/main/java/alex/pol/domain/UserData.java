package alex.pol.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity(name = "UserData")
public class UserData extends BaseModel {

    private String firstName;

    private String secondName;

    private Integer age;

    private String country;

    private String city;

    private String street;

    private String house;

    private String apartment;

    private int pinCode;

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
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

        public Builder setCountry(String country) {
            UserData.this.country = country;
            return this;
        }

        public Builder setCity(String city) {
            UserData.this.city = city;
            return this;
        }

        public Builder setStreet(String street) {
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


        public UserData build() {
            return UserData.this;
        }
    }
}
