package pl.coderslab.Spring01Hibernate.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = YearOfBirthValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface YearOfBirth {

    String message() default "{pl.coderslab.Spring01Hibernate.validator.yearOfBirth}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
