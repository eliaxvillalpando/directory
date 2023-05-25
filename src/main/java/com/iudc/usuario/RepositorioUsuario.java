package com.iudc.usuario;

import com.iudc.entidades.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface RepositorioUsuario extends CrudRepository<Usuario, Integer> {

    @Query("SELECT u FROM Usuario u WHERE u.usuario = :usuario")
    public Usuario getUserByAlias(@Param("usuario") String username);
    
    
}
