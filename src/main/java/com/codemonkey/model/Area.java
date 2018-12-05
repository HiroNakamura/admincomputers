package com.codemonkey.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data 
@ToString @EqualsAndHashCode
@Table(name="area")
@Entity(name="Area")
public class Area implements java.io.Serializable{

    private static final long serialVersionUID = 8099656478674706638L;
     
    @Id
    @Column(name="idarea")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long idarea;
    @Column(name="nombre")
    @Getter @Setter private String nombre;

    @OneToMany(mappedBy="area")
    @Getter @Setter private List<Empleado> empleados;

}
