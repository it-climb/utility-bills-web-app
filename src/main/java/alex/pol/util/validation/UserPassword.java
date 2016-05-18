package alex.pol.util.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserPasswordImpl.class)
@Documented
public @interface UserPassword {
    String message() default "{UserPassword}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List{
        Unique[] value();
    }
}
