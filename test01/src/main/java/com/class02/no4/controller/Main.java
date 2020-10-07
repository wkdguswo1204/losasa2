package com.class02.no4.controller;

import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller

public class Main {

	@RequestMapping("/main.no4")
	public ModelAndView main(HttpServletRequest req, ModelAndView mv) {
		System.out.println("?????????????????");
		return mv;
	}
}
