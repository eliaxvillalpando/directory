package com.iudc.personas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.iudc.entidades.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonaController {

    @Autowired
    ServicioPersona serviceRepo;

    @GetMapping("/")
    private String paginaPrincipal(Model model) {

        listarClientes(model);
        return "directorio-clientes";

    }

    @GetMapping("/administrar/nuevo-impresor")
    private String formularioImpresor(Model model) {

        model.addAttribute("impresores", new Persona());
        model.addAttribute("tituloPagina", "Crear nuevo usuario");

        return "personas/ModificarPersonas";

    }

    @PostMapping("/administrar/persona/guardar")
    public String saveCliente(Persona Personaimpresor, RedirectAttributes ra, Model model) {

        serviceRepo.guardar(Personaimpresor);
        ra.addFlashAttribute("mensaje", "El usuario ha sido guardado con exito.");
        listarClientes(model);

        return "redirect:/administrar";
    }

    public void listarClientes(Model model) {

        Iterable<Persona> iterablePersona = serviceRepo.listarTodos();
        model.addAttribute("impresores", iterablePersona);

    }

    @GetMapping("/administrar/editar/{id}")
    public String editarCliente(@PathVariable(name = "id") Integer id, Model model,
            RedirectAttributes ra) {
        try {
            Persona impresor = serviceRepo.getId(id);

            model.addAttribute("impresores", impresor);
            model.addAttribute("tituloPagina", "Edtiar impresor (ID: " + id + ")");

            return "personas/ModificarPersonas";

        } catch (Exception ex) {
            ra.addFlashAttribute("mensaje", "No fue posible encontrar un cliente con ese ID");
            return "index";
        }

    }

    @RequestMapping("/administrar/eliminar/{id}")
    public String eliminarImpresor(@PathVariable(name = "id") Integer id, Model model,
            RedirectAttributes ra) {

        try {

            ra.addFlashAttribute("mensaje", "Impresor eliminado");
            serviceRepo.eliminar(id);

            return "redirect:/administrar";

        } catch (Exception ex) {
            ra.addFlashAttribute("mensaje", "No fue posible encontrar un cliente con ese ID");
            return "index";
        }
    }

    @GetMapping("/administrar")
    private String paginaAdministrador(Model model) {

        listarClientes(model);
        return "index";

    }

}
