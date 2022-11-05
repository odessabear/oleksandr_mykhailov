package com.epam.spring.webprovider.service.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordLengthValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
    String message() default "Password length shouldn't be less than 8 characters!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
