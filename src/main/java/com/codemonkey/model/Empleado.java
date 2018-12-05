package com.codemonkey.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.Data;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data 
@ToString @EqualsAndHashCode
@Table(name="empleado")
@Entity(name="Empleado")
public class Empleado implements java.io.Serializable{
    
    private static final long serialVersionUID = 8799656278674706638L;
     
    @Id
    @Column(name="idempleado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long idempleado;

    @OneToMany(mappedBy="empleado" ) //(fetch = FetchType.LAZY, mappedBy="empleado" )
    @ElementCollection(targetClass=Equipo.class)
    private java.util.List<Equipo> equipos;

    @Column(name="nombre")
    @Getter @Setter private String nombre;
    @Column(name="apellidos")
    @Getter @Setter private String apellidos;

    @ManyToOne
    @JoinColumn(name="area_nombre")
    @Getter @Setter private Area area;

  
}
