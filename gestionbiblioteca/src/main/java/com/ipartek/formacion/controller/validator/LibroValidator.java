package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistence.Libro;

public class LibroValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Libro.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Libro libro = (Libro) obj;
		
		if(libro.getCodigo()<-1){
			errors.rejectValue("codigo", "errorCodigo", 
					new Object[]{"'codigo'"}, "Error: Codigo incorrecto");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titulo", "errorTitulo", "Error: Titulo requerido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "autor", "errorAutor" ,"Error: Autor requerido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbn", "errorIsbn" ,"Error: ISBN requerido");
	}

}
