package com.josueobregon.backendTienda.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String Login() {return "Pages/login";}

    @GetMapping("/Index")
    public String Index() {return "Pages/Index";}
}
