package com.bc.test.controller;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bc.frame.logger.Log4jManager;

@Controller
@RequestMapping("/ts")
public class TsController {

	private static final Logger log = Log4jManager.get();
	
	@RequestMapping("/index")
	public String index() {
		log.debug("Ts index controller.");
		return "/ts/index.html";
	}

}