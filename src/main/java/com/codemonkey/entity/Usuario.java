package com.codemonkey.entity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.GenerationType;
import javax.persistence.Table;

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
        private String nombre;
        @Column(name="apellidos")
        private String apellidos;
        @Column(name="usuario")
        private String usuario;
        @Column(name="password")
        private String password;
        @Column(name="cargo")
        public String cargo;

        @ManyToOne
        @JoinColumn(name="idcomputadora")
        private Computadora computadora;

        @ManyToOne
        @JoinColumn(name="iddepartamento")
        private Departamento departamento;
        
        
        public Usuario(){}

        
        public void setIdUsuario(long idusuario){
                this.idusuario=idusuario;
        }
        
        public long getIdUsuario(){
                return idusuario;
        }

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
              
}
