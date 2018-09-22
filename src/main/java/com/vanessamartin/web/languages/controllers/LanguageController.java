package com.vanessamartin.web.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vanessamartin.web.languages.models.Language;
import com.vanessamartin.web.languages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService langService;
	public LanguageController(LanguageService langService) {
		this.langService = langService;
	}
	
	@RequestMapping("/languages")
	public String index(@ModelAttribute("Lang") Language lan, Model model) {
		List<Language> languages = langService.allLanguages();
		model.addAttribute("languages", languages);
		return "/languages.jsp";
	}
	
	 @RequestMapping(value="/languages", method=RequestMethod.POST)
	    public String create(@Valid @ModelAttribute("Lang") Language lan, BindingResult result) {
	        if (result.hasErrors()) {
	            return "/languages.jsp";
	        } else {
	            langService.create(lan);
	            return "redirect:/languages";
	        }
	    }
	 @RequestMapping("/languages/{id}")
	 public String show(@PathVariable("id") Long id, Model model) {
		 Language lang = langService.findLan(id);
		 model.addAttribute("lang", lang);
		 return "show.jsp";
	 }
	 @RequestMapping("/languages/{id}/edit")
	    public String edit(@ModelAttribute("preLang") Language preLang, @PathVariable("id") Long id, Model model) {
	        Language lang = langService.findLan(id);
	        System.out.println("!!!!!!!!!!!!!!!!! PRE LANG ID CHECK 111: " + preLang.getId());
	        model.addAttribute("lang", lang);
	        return "/edit.jsp";
	    }
	 
	 @RequestMapping(value="/languages", method=RequestMethod.PUT)
	 public String update(@Valid @ModelAttribute("preLang") Language preLang, BindingResult result) {
		 if(result.hasErrors()) {
			 return "/edit.jsp";
		 } else {
			 
			 System.out.println(" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! controller edit1");
			 System.out.println("!!!!!!!!!!!!!!!!! PRE LANG ID CHECK 222: " + preLang.getId());
			 //getting the name works but getting the ID doesn't??????
			 //very annoying
			 System.out.println("!!!!!!!!!!!!!!!!! PRE LANG NAME CHECK: " + preLang.getName());
			 langService.updateLan(preLang);
			 System.out.println(" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! controller edit2");
			 return "redirect:/languages";
		 }
	 }
	 
	 @RequestMapping("/languages/{id}/delete")
	 public String delete(@PathVariable("id") Long id, Model model) {
		 langService.deleteLan(id);
		 return "redirect:/languages";
	 }
}
