package com.codemonkey.entity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import org.hibernate.annotations.GenericGenerator;
import javax.persistence.GenerationType;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;
import lombok.Data;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity(name="Usuario")
@Table(name = "usuario")
public class Usuario implements java.io.Serializable {
        private static final long serialVersionUID = 7526472295622776147L;

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        //@GenericGenerator(name = "native", strategy = "native")
        @Column(name="idusuario")
        public long idusuario;
        @Column(name="nombre")
        @Getter @Setter private String nombre;
        @Column(name="apellidos")
        @Getter @Setter private String apellidos;
        @Column(name="usuario")
        @Getter @Setter private String usuario;
        @Column(name="password")
        @Getter @Setter private String password;
        @Column(name="cargo")
        @Getter @Setter public String cargo;

        @ManyToOne
        @JoinColumn(name="idcomputadora")
        @Getter @Setter private Computadora computadora;

        @ManyToOne
        @JoinColumn(name="iddepartamento")
        @Getter @Setter private Departamento departamento;
        
        
        public void setIdUsuario(long idusuario){
                this.idusuario=idusuario;
        }
        
        public long getIdUsuario(){
                return idusuario;
        }

        /*public Usuario(){}
        public void setComputadora(Computadora computadora){
                this.computadora=computadora;
        }

        public Computadora getComputadora(){
                return computadora;
        }
        
        public void setNombre(String nombre){
                this.nombre=nombre;
        }
        
        public String getNombre(){
                return nombre;
        }

        public void setApellidos(String apellidos){
                this.apellidos=apellidos;
        }
        
        public String getApellidos(){
                return apellidos;
        }

        public void setUsuario(String usuario){
                this.usuario=usuario;
        }
        
        public String getUsuario(){
                return usuario;
        }
        
        public void setPassword(String password){
                this.password=password;
        }
        
        public String getPassword(){
                return password;
        }
        
        public void setCargo(String cargo){
                this.cargo=cargo;
        }
        
        public String getCargo(){
                return cargo;
        }

        

        public Departamento getDepartamento(){
                return departamento;
        }
        
        public void setDepartamento(Departamento departamento){
                this.departamento = departamento;
        }
        
        @Override
        public String toString(){
                return "Usuario{ id: "+idusuario+", nombre: "+nombre +", apellidos: "+apellidos
                +", usuario: "+usuario+" , password: "+password+",cargo: "+cargo+"}";
                //" , departamento: "+departamento+", computadora: "+computadora+"}";
        }
             */ 
}
