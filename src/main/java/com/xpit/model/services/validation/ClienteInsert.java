package com.xpit.model.services.validation;

/* Back End - API REST 
 * Service Validation - Valicação Camada de Servicos do Controlador Rest 
 * Interface para criação de Anotação customizada 
 * ClienteInsertValidator é  a classe que implementa o ClienteInsert
 * Java + Spring Framework
 * Renato Sanches - XP IT Tecnologia 
 */


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

// ClienteInsertValidator é  a classe que implementa o ClienteInsert
@Constraint(validatedBy = ClienteInsertValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)

public @interface ClienteInsert {
	
	String message() default "Erro de validação";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
