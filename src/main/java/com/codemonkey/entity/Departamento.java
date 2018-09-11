package com.codemonkey.entity;


import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import java.util.List;



@Entity(name="Departamento")
@Table(name = "departamento")
public class Departamento implements java.io.Serializable{

    private static final long serialVersionUID = 7526472295622776147L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    //@GenericGenerator(name = "native", strategy = "native")
    @Column(name="iddepartamento")
    public long iddepartamento;
    @Column(name="nombre")
    public String nombre;
    @Column(name="responsable")
    private String responsable;

    /*@OneToMany
    @JoinColumn(name="idusuario")
    private List<Usuario> usuarios;
    */

   /* @OneToMany
    @JoinColumn(name="idcomputadora")
    private List<Computadora> computadoras;
    */

    public Departamento(){}

    public long getIdDepartamento(){
        return iddepartamento;
    }

    public void setIdDepartamento(long iddepartamento){
        this.iddepartamento=iddepartamento;
    }

    /*
    public List<Computadora> getComputadoras(){
        return computadoras;
    }

    public void setComputadoras(List<Computadora> computadoras){
        this.computadoras=computadoras;
    }*/

    /*public List<Usuario> getUsuarios(){
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios){
        this.usuarios=usuarios;
    }*/

    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public String getNombre(){
        return nombre;
    }


    public void setResponsable(String responsable){
        this.responsable=responsable;
    }
    
    public String getResponsable(){
        return responsable;
    }

    @Override
    public String toString(){
        return "Departamento{ id: "+iddepartamento+", nombre: "+nombre 
        +", responsable: "+responsable+"}";
        //+", usuarios: "+usuarios+ ", computadoras:"+computadoras+"}";
    }
}
