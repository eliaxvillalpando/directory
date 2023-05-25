package com.iudc.personas;

import com.iudc.entidades.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class PersonasRepositorioTests {


    @Autowired
    RepositorioPersonas repo;

    @Autowired
    private TestEntityManager entityManager;
    
/*
    @Test
    public void crearPersona() {

        Persona persona1 = new Persona();
        persona1.setNombre("Elias");
        persona1.setApellido("López Villalpando");
        persona1.setArea("Sistemas");
        persona1.setCelular("4491135286");
        persona1.setCorreo("el.sistemas@iudc.com.mx");
        persona1.setExtension(114);
        persona1.setTelefonoArea("4499621028");

        Persona savedPersona = repo.save(persona1);
        Persona existUser = entityManager.find(Persona.class, savedPersona.getId());
        assertThat(persona1.getNombre()).isEqualTo(existUser.getNombre());

    }
*/
    
    
    
}
