package alex.pol.util.validation;


import alex.pol.domain.User;
import alex.pol.repository.UserService;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValid implements Validator {

    @Autowired
    UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        User userValid = userService.getByEmail(user.getEmail());

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email", "Email is required.");
        if(userValid != null){
            errors.rejectValue("email", "This email already exists");
        }
        if(!EmailValidator.getInstance().isValid( user.getEmail())){
            errors.rejectValue("email", "email.notValid", "Email address is not valid.");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password", "Password is empty");



    }
}
