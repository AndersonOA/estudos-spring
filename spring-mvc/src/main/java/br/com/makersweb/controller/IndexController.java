package br.com.makersweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.makersweb.enums.PagesEnum;

@Controller
public class IndexController {
	
	@RequestMapping(value = "home")
	public ModelAndView index() {
		System.out.println(PagesEnum.Home.getPage());
		return new ModelAndView(PagesEnum.Home.getPage());
	}

}
