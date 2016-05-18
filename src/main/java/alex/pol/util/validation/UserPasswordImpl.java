package alex.pol.util.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserPasswordImpl implements ConstraintValidator<UserPassword,String> {
    private String message;
    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9]+$";
    @Override
    public void initialize(UserPassword userPassword) {
        this.message = userPassword.message();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        if(chekPassword(password)){
            return true;
        }else
            return false;
    }
    public static boolean chekPassword(String password){
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
