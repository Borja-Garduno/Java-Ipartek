package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistence.Usuario;

public class UsuarioValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Usuario.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Usuario usu = (Usuario) obj;
		
		if(usu.getCodigo()<-1){
			errors.rejectValue("codigo", "errorCodigo", 
					new Object[]{"'codigo'"}, "Error: Codigo incorrecto");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "errorNombre", "Error: Nombre requerido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidos", "errorApellidos" ,"Error: Apellidos requeridos");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fNacimiento", "errorFNacimiento" ,"Error: Fecha de nacimiento requerida");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "errorEmail" ,"Error: Email requerido");
	}

}
