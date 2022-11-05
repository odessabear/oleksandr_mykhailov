package com.epam.spring.webprovider.service.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
    String message() default "The password length must not be less than 8 characters and must not contain spaces and couldn't be NULL!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
