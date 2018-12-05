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
@Table(name="equipo")
@Entity(name="Equipo")
public class Equipo implements java.io.Serializable{

    private static final long serialVersionUID = 8799656478674706638L;
     
    @Id
    @Column(name="idequipo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long idequipo;
    @Column(name="modelo")
    @Getter @Setter private String modelo;
    @Column(name="bien")
    @Getter @Setter private String bien;
    

    @ManyToOne
    @JoinColumn(name="empleado_nombre")
    @Getter @Setter private Empleado empleado;
}
