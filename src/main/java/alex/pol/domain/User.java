package alex.pol.domain;

import alex.pol.util.validation.Unique;
import alex.pol.util.validation.UserEmail;
import alex.pol.util.validation.UserPassword;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

/**
 * Create model of user with fields: name and password
 */
@Entity(name = "users")

/**
 * Create blueprint of model user, describe mistakes you can make when create new one
 * BaseModel give all the users id and version in DB
 */
public class User extends BaseModel {

//    @Unique(message = "This email already exists")
//    @UserEmail(message = "Invalid email")
    private String email;

    @UserPassword(message = "Pleas use latin characters")
    @NotEmpty(message = "Please enter your password")
    @Size(min = 6, max = 16, message = "Your password must between 6 and 16 characters")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Builder newBuilder(){return new User().new Builder();}

    public class Builder {

        private Builder() {
        }

        public Builder setId(Integer id) {
            User.this.setId(id);
            return this;
        }

        public Builder setVersion(Long version){
            User.this.setVersion(version);
            return this;
        }

        public Builder setEmail(String email) {
            User.this.email = email;
            return this;
        }

        public Builder setPassword(String password){
            User.this.password = password;
            //User.this.confirmPassword = password;
            return this;
        }


        public User build() {
            return User.this;
        }
    }
}
