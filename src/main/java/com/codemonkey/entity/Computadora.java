package com.codemonkey.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import java.util.List;

@Entity(name="Computadora")
@Table(name = "computadora")
public class Computadora  implements java.io.Serializable {

        private static final long serialVersionUID = 7526472295622776147L;

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        //@GenericGenerator(name = "native", strategy = "native")
        @Column(name="idcomputadora")
        public long idcomputadora;
        @Column(name="bien")
        private String bien;
        @Column(name="arrendado")
        private String arrendado;
        @Column(name="asignado")
        private String asignado;
        @Column(name="ip")
        private String ip;
        @Column(name="dns")
        private String dns;
        @Column(name="red")
        private String red;
        @Column(name="operativo")
        private String operativo;
        @Column(name="maquina")
        private String maquina;
        @Column(name="tipo")
        private String tipo;
        @Column(name="modelo")
        private String modelo;
        @Column(name="dominio")
        private String dominio;
        @Column(name="administrador")
        private String administrador;
        @Column(name="ubicacion")
        private String ubicacion;
        @Column(name="actualizada")
        private boolean actualizada;

        //@OneToMany
        //@JoinColumn(name="idusuario")
        //private List<Usuario> usuarios;

        //@ManyToOne
        //@JoinColumn(name="iddepartamento")
        public Departamento departamento;


        public Computadora(){}
        
        public void setIdComputadora(long idcomputadora){
                this.idcomputadora=idcomputadora;
        }
        
        public long getIdComputadora(){
                return idcomputadora;
        }

        public Departamento getDepartamento(){
                return departamento;
        }

        public void setDepartamento(Departamento departamento){
                this.departamento=departamento;
        }

        /*
        public List<Usuario> getUsuarios(){
                return usuarios;
        }
        
        public void setUsuarios(List<Usuario> usuarios){
                this.usuarios=usuarios;
        }*/


        public void setBien(String bien){
                this.bien=bien;
        }
        
        public String getBien(){
                return bien;
        }

        public void setArrendado(String arrendado){
                this.arrendado=arrendado;
        }
        
        public String getArrendado(){
                return arrendado;
        }

        public void setAsignado(String asignado){
                this.asignado=asignado;
        }

        
        public String getAsignado(){
                return asignado;
        }

        public void setIp(String ip){
                this.ip=ip;
        }
        
        public String getIp(){
                return ip;
        }

        public void setDns(String dns){
                this.dns=dns;
        }
        
        public String getDns(){
                return dns;
        }

        public void setRed(String red){
                this.red=red;
        }
        
        public String getRed(){
                return red;
        }

        public void setOperativo(String operativo){
                this.operativo=operativo;
        }
        
        public String getOperativo(){
                return operativo;
        }

        public void setMaquina(String maquina){
                this.maquina=maquina;
        }
        
        public String getMaquina(){
                return maquina;
        }

        public void setTipo(String tipo){
                this.tipo=tipo;
        }
        
        public String getTipo(){
                return tipo;
        }

        public void setModelo(String modelo){
                this.modelo=modelo;
        }
        
        public String getModelo(){
                return modelo;
        }


        public void setDominio(String dominio){
                this.dominio=dominio;
        }
        
        public String getDominio(){
                return dominio;
        }



        public void setAdministrador(String administrador){
                this.administrador=administrador;
        }
        
        public String getAdministrador(){
                return administrador;
        }


        public boolean isActualizada(){
                return actualizada;
        }

        public void setActualizada(boolean actualizada) {
                this.actualizada = actualizada;
        }

        public String getUbicacion(){
                return ubicacion;
        }

        public void setUbicacion(String ubicacion){
                this.ubicacion=ubicacion;
        }


        @Override
        public String toString(){
                return "Computadora{ idcomputadora: "+idcomputadora+" , bien: "+bien+ " , arrendado: "+arrendado
                +", asignado: "+asignado+" , ip: "+ip+" , dns: "+dns+", red: "+red + ", dominio: "+dominio
                +" , operativo: "+operativo+" , tipo: "+tipo+" , máquina: "+maquina+" , modelo: "+modelo
                +", administrador: "+administrador+",ubicacion:"+ubicacion+
                ", actualizada:"+actualizada+ " }";
        }
        
}
