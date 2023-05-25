package com.iudc.entidades;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 20)
    private String apellido;

    @Column(name = "celular", nullable = false, length = 10)
    private String celular;

    @Column(name = "telefonoArea", nullable = false, length = 10)
    private String telefonoArea;

    @Column(name = "correo", nullable = false, length = 30)
    private String correo;

    @Column(name = "extension", nullable = false, length = 3)
    private int extension;

    @Column(name = "area", nullable = false, length = 25)
    private String area;

}
