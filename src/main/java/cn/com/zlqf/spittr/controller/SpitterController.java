package cn.com.zlqf.spittr.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.zlqf.spittr.entity.Spitter;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String showRegistForm(Model model) {
		Spitter spitter = new Spitter();
		model.addAttribute("spitter", spitter);
		return "registForm";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String regist(@Valid Spitter spitter,Errors errors) {
		spitter.setId(UUID.randomUUID().toString());
		if(errors.hasErrors()) {
			return "registForm";
		}
		System.out.println(spitter);
		return "redirect:/spitter/" + spitter.getUsername();
	}
	
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	public String showProfile(@PathVariable String username,Model model) {
		model.addAttribute("username", username);
		return "profile";
	}
}
