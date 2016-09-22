package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistence.Ejemplar;

public class EjemplarValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Ejemplar.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Ejemplar ejemplar = (Ejemplar) obj;
		
		if(ejemplar.getCodigo()<-1){
			errors.rejectValue("codigo", "errorCodigo", 
					new Object[]{"'codigo'"}, "Error: Codigo incorrecto");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "editorial", "errorEditorial", "Error: Editorial requerida");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nPaginas", "errornPaginas" ,"Error: Numero de Paginas requeridas");
	}

}
