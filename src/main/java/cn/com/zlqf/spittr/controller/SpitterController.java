package cn.com.zlqf.spittr.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.com.zlqf.spittr.entity.Spitter;
import cn.com.zlqf.spittr.exception.SpitterNotFoundException;
import cn.com.zlqf.spittr.service.SpitterService;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	
	@Autowired
	private SpitterService spitterService;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String showRegistForm(Model model) {
		Spitter spitter = new Spitter();
		model.addAttribute("spitter", spitter);
		return "registForm";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String regist(@Valid Spitter spitter,Errors errors,MultipartFile profilePicture,HttpServletRequest request,RedirectAttributes model) throws Exception {
		spitter.setId(UUID.randomUUID().toString());
		if(errors.hasErrors()) {
			return "registForm";
		}
		String path = request.getSession().getServletContext().getRealPath("uploads");  
		File file = new File(path,profilePicture.getOriginalFilename());
		profilePicture.transferTo(file);
		
		spitterService.addSpitter(spitter);
		
		model.addAttribute("username", spitter.getUsername());
		model.addFlashAttribute("spitter", spitter);
		return "redirect:/spitter/{username}";
	}
	
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	public String showProfile(@PathVariable String username,Model model) {
		model.addAttribute("username", username);
		return "profile";
	}
	@RequestMapping("/userPage")
	public String userPage() {
		return "userPage";
	}
	
	@RequiresRoles({"admin"})
	@RequestMapping("/adminPage")
	public String adminPage() {
		return "adminPage";
	}
	
	
	@RequestMapping("/testException")
	public String testException() {
		throw new SpitterNotFoundException();
	}
	
	@RequestMapping("/testException2")
	public String testException2() {
		int x = 1/0;
		return "";
	}
}
