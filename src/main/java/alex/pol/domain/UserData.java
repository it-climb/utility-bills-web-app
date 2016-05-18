package alex.pol.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity(name = "UserData")
public class UserData extends BaseModel{

    private String firstName;

    private String secondName;

    private Integer age;

    @OneToOne(cascade = CascadeType.MERGE )
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

        public Builder setUser(User user) {
            UserData.this.user = user;
            return this;
        }


        public UserData build() {
            return UserData.this;
        }
    }
}
