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

import com.ipartek.formacion.dao.persistence.Ejemplar;
import com.ipartek.formacion.dao.persistence.Libro;
import com.ipartek.formacion.service.EjemplarServiceImp;
import com.ipartek.formacion.service.LibroServiceImp;

@Controller
@RequestMapping(value="/ejemplares")
public class EjemplarController {
	
	private static final Logger logger = LoggerFactory.getLogger(EjemplarController.class);
	
	@Autowired
	private EjemplarServiceImp es = null;
	@Autowired
	private LibroServiceImp is = null;
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("ejemplarValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(validator);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll(){
		mav = new ModelAndView("/ejemplares/listado");
		List<Ejemplar> ejemplares = es.getAll();
		mav.addObject("listado-ejemplares", ejemplares);
		logger.info("Cargado el listado completo de ejemplares.");
		return mav;
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id){
		mav = new ModelAndView("/ejemplares/ejemplar");
		
		Ejemplar ejemplar = es.getById(id);
		mav.addObject("ejemplar", ejemplar);
		
		List<Libro> libros = is.getAll();
		mav.addObject("listado-libros", libros);
		
		logger.info("Datos del ejemplar cargados para edicion.");
		return mav;
	}
	
	@RequestMapping(value="/addEjemplar", method=RequestMethod.GET)
	public String addEjemplar(Model model){
		model.addAttribute("ejemplar", new Ejemplar());
		
		List<Libro> libros = is.getAll();
		model.addAttribute("listado-libros", libros);
		
		logger.info("Cargado formulario para creacion de nuevo ejemplar.");
		return "ejemplares/ejemplar";
	}
	
	@RequestMapping(value="/delete/{id}", method = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") int id){
		es.delete(id);
		return "redirect:/ejemplares";
	}
	
	@RequestMapping(value="/cancel")
	public String cancel(){
		logger.info("Creacion/Edicion del ejemplar cancelada.");
		return "redirect:/ejemplares";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveLibro(@ModelAttribute("ejemplar") @Validated Ejemplar ejemplar, BindingResult bindingResult, Model model){
		
		String destino = "";
		if(bindingResult.hasErrors()){
			logger.info("El ejemplar tiene errores.");
			logger.info(bindingResult.toString());
			destino = "ejemplares/ejemplar";
		} else{
			destino = "redirect:/ejemplares";
			
			if(ejemplar.getCodigo()>0){
				es.update(ejemplar);
			} else{
				es.create(ejemplar);
			}
		}
		return destino;
	}
	
	@RequestMapping(value="/restclients", method=RequestMethod.GET)
	public String sendToRestGetAll(){
		return "ejemplares/listado_rest";
	}
}
