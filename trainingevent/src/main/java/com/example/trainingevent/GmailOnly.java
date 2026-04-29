package com.example.trainingevent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = GmailValidator.class)
@Target( { ElementType.FIELD } ) 
@Retention(RetentionPolicy.RUNTIME) 
public @interface GmailOnly {
     
    public String message() default "Email must be a Gmail address"; 
    public Class<?>[] groups() default {}; 
    public Class<? extends Payload>[] payload() default {}; 
} 