package com.josueobregon.backendTienda.Controller;

import com.josueobregon.backendTienda.Entity.Usuarios;
import com.josueobregon.backendTienda.Service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Base64;

@Controller
public class GeneralController {
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

    //Index

    @GetMapping("/Index")
    public String index(HttpSession session,Model model) {
            Usuarios usuario = (Usuarios) session.getAttribute("usuarioLogueado");
            if (usuario == null){
                return "redirect:/log";
            }

            if (usuario.getFoto() != null) {
                // Convertir bytes a Base64
                String fotoBase64 = Base64.getEncoder().encodeToString(usuario.getFoto());
                model.addAttribute("fotoBase64", fotoBase64);
            }
            model.addAttribute("usuario", usuario);

            model.addAttribute("usuarios", usuariosService.findAll());
            model.addAttribute("clientes", clientesService.findAll());
            model.addAttribute("productos", productosService.findAll());
            model.addAttribute("ventas", ventasService.findAll());
            model.addAttribute("detalle",detalleVentaService.obtenerDetalle());
            return "Pages/Index";

    }
    @GetMapping("/eliminar/usuarios/{id}")
    public String eliminarU(@PathVariable int id) {
        usuariosService.DeleteUsuario(id);
        return "redirect:/Index";
    }

    @GetMapping("/eliminar/ventas/{id}")
    public String eliminarV(@PathVariable int id) {
        ventasService.DeleteVenta(id);
        return "redirect:/Index";
    }

    @GetMapping("/eliminar/clientes/{id}")
    public String eliminarC(@PathVariable int id) {
        clientesService.DeleteCliente(id);
        return "redirect:/Index";
    }

    @GetMapping("/eliminar/productos/{id}")
    public String eliminarP(@PathVariable int id) {
        productosService.DeleteProducto(id);
        return "redirect:/Index";
    }
    @GetMapping("/eliminar/detalle/{id}")
    public String eliminarD(@PathVariable int id) {
        detalleVentaService.deleteDetalle(id);
        return "redirect:/Index";
    }

    //login
    @GetMapping("/log")
    public String Login() {return "Pages/login";}

    @PostMapping("/login")
    public String validar(@RequestParam String usuario, @RequestParam String password,
                        HttpSession session,Model model) {
        Usuarios u = usuariosService.login(usuario,password);

        if (u != null) {
            session.setAttribute("usuarioLogueado", u);
            return "redirect:/Index";
        } else {
            model.addAttribute("error", "Usuario y contraseña incorrecta");
            return "Pages/login";
        }
    }
}

