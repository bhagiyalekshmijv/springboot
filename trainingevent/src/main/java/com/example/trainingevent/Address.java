package com.example.trainingevent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = AddressValidator.class)
@Target( { ElementType.FIELD } ) 
@Retention(RetentionPolicy.RUNTIME) 
public @interface Address {
     
    public String message() default "Your address must contains India"; 
    public Class<?>[] groups() default {}; 
    public Class<? extends Payload>[] payload() default {}; 
} 