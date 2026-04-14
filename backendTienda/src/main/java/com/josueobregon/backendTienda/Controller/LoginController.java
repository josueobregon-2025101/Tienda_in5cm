package com.josueobregon.backendTienda.Controller;

import com.josueobregon.backendTienda.Entity.Usuarios;
import com.josueobregon.backendTienda.Service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private UsuariosService usuariosService;
    @Autowired
    private ClientesService clientesService;
    @Autowired
    private ProductosService productosService;
    @Autowired
    private VentasService ventasService;
    @Autowired
    private DetalleVentaService detalleVentaService;


    @GetMapping("/")
    public String Login() {return "Pages/login";}

    @GetMapping("/Index")
    public String index(Model model) {
        model.addAttribute("usuarios", usuariosService.findAll());
        model.addAttribute("clientes", clientesService.findAll());
        model.addAttribute("productos", productosService.findAll());
        model.addAttribute("ventas", ventasService.findAll());
        model.addAttribute("detalle",detalleVentaService.obtenerDetalle());
        return "Pages/Index";
    }

    @PostMapping("/login")
    public String login(@RequestParam String usuario, @RequestParam String password,
                        HttpSession session, Model model) {
        String userCorrecto = "user";
        String passCorrecto = "4321";

        if (usuario.equals(userCorrecto) && password.equals(passCorrecto)) {
            session.setAttribute("usuarioLogueado", usuario);
            return "redirect:/Index";
        } else {
            model.addAttribute("error", "Usuario y contraseña incorrecta");
            return "login";
        }
    }
}

