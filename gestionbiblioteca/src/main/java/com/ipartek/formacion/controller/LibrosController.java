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

import com.ipartek.formacion.dao.persistence.Libro;
import com.ipartek.formacion.service.LibroServiceImp;

@Controller
@RequestMapping(value="/libros")
public class LibrosController {
	
	private static final Logger logger = LoggerFactory.getLogger(LibrosController.class);
	
	@Autowired
	private LibroServiceImp is = null;
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("libroValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(validator);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll(){
		mav = new ModelAndView("/libros/listado");
		List<Libro> libros = is.getAll();
		mav.addObject("listado-libros", libros);
		logger.info("Cargado el listado completo de libros.");
		return mav;
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id){
		mav = new ModelAndView("/libros/libro");
		Libro libro = is.getById(id);
		mav.addObject("libro", libro);
		logger.info("Datos del libro cargados para edicion.");
		return mav;
	}
	
	@RequestMapping(value="/addLibro", method=RequestMethod.GET)
	public String addLibro(Model model){
		model.addAttribute("libro", new Libro());
		logger.info("Cargado formulario para creacion de nuevo libro.");
		return "libros/libro";
	}
	
	@RequestMapping(value="/delete/{id}", method = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") int id){
		is.delete(id);
		return "redirect:/libros";
	}
	
	@RequestMapping(value="/cancel")
	public String cancel(){
		logger.info("Creacion/Edicion del libro cancelada.");
		return "redirect:/libros";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveLibro(@ModelAttribute("libro") @Validated Libro libro, BindingResult bindingResult, Model model){
		
		String destino = "";
		if(bindingResult.hasErrors()){
			logger.info("El libro tiene errores.");
			logger.info(bindingResult.toString());
			destino = "libros/libro";
		} else{
			destino = "redirect:/libros";
			
			if(libro.getCodigo()>0){
				is.update(libro);
			} else{
				is.create(libro);
			}
		}
		return destino;
	}
	
	@RequestMapping(value="/restclients", method=RequestMethod.GET)
	public String sendToRestGetAll(){
		return "libros/listado_rest";
	}
}
