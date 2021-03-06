package com.ipartek.formacion.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dao.persistence.Usuario;
import com.ipartek.formacion.service.UsuarioServiceImp;

@Controller
@RequestMapping(value="/usuarios")
public class UsuariosController {
	
	private static final Logger logger = LoggerFactory.getLogger(UsuariosController.class);
	
	@Autowired
	private UsuarioServiceImp us = null;
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("usuarioValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(validator);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll(){
		mav = new ModelAndView("/usuarios/listado");
		List<Usuario> usuarios = us.getAll();
		mav.addObject("listado-usuarios", usuarios);
		logger.info("Cargado el listado completo de usuarios.");
		return mav;
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id){
		mav = new ModelAndView("/usuarios/usuario");
		Usuario usuario = us.getById(id);
		mav.addObject("usuario", usuario);
		logger.info("Datos del usuario cargados para edicion.");
		return mav;
	}
	
	@RequestMapping(value="/addUsuario", method=RequestMethod.GET)
	public String addUsuario(Model model){
		model.addAttribute("usuario", new Usuario());
		logger.info("Cargado formulario para creacion de nuevo usuario.");
		return "usuarios/usuario";
	}
	
	@RequestMapping(value="/delete/{id}", method = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") int id){
		//mav = new ModelAndView("/usuarios/listado");
		us.delete(id);
		return "redirect:/usuarios";
	}
	
	@RequestMapping(value="/cancel")
	public String cancel(){
		logger.info("Creacion/Edicion del usuario cancelada.");
		return "redirect:/usuarios";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveUsuario(@ModelAttribute("usuario") @Validated Usuario usuario, BindingResult bindingResult, Model model){
		
		String destino = "";
		if(bindingResult.hasErrors()){
			logger.info("El usuario tiene errores.");
			logger.info(bindingResult.toString());
			destino = "usuarios/usuario";
		} else{
			destino = "redirect:/usuarios";
			
			if(usuario.getCodigo()>0){
				us.update(usuario);
			} else{
				us.create(usuario);
			}
		}
		return destino;
	}
	
	@RequestMapping(value="/restclients", method=RequestMethod.GET)
	public String sendToRestGetAll(){
		return "usuarios/listado_rest";
	}
}
