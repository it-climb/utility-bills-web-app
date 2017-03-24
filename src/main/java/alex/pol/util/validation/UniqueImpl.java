package alex.pol.util.validation;

import alex.pol.domain.User;
import alex.pol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UniqueImpl implements ConstraintValidator<Unique, String> {

    @Autowired
    UserService userService;

    private String message;

    @Override
    public void initialize(Unique unique) {
        this.message = unique.message();
    }

    @Override
    public boolean isValid(String target, ConstraintValidatorContext context) {
        try {
            User user = userService.getByEmail(target);
            if(user != null) return false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
}
