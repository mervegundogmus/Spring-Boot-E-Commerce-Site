package com.shopping.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Bu bir Spring MVC denetleyici sınıfıdır, bu nedenle bu açıklamayı @Controller burada kullanıyoruz
//Ve bu uygulamanın ana sayfasına yapılan HTTP GET isteğini işleyecek olan işleyici yöntemidir

@Controller
public class MainController {

	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}

}
