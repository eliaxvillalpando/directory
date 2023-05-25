package com.iudc.personas;

import com.iudc.entidades.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.ui.Model;

@Service
@Transactional
public class ServicioPersona {

    @Autowired
    RepositorioPersonas repo;

    public List<Persona> listarTodos() {
        return repo.findAll();
    }

    public void guardar(Persona persona) {
        repo.save(persona);
    }

    public Persona getId(Integer id) {
        return repo.findById(id).get();
    }

    public void eliminar(int id) {
        repo.deleteById(id);
    } 
    
    
      
    
    

}
