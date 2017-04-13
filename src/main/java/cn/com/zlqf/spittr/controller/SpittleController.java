package cn.com.zlqf.spittr.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.zlqf.spittr.entity.Spittle;

@Controller
public class SpittleController {
	
	@RequestMapping("/spittles")
	public String spittles(Model model) {
		List<Spittle> spittleList = new ArrayList<>();
		for(int i=1 ; i<=20 ; ++i) {
			spittleList.add(new Spittle("Spittle " + i, new Date()));
		}
		model.addAttribute("spittleList", spittleList);
		return "spittles";
	}
}
