package com.codemonkey.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import org.hibernate.annotations.GenericGenerator;
import javax.persistence.GenerationType;
import javax.persistence.Table;
//import javax.persistence.OneToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;

//import java.util.List;

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
@Entity(name="Computadora")
@Table(name = "computadora")
public class Computadora  implements java.io.Serializable {

        private static final long serialVersionUID = 7526472295622776147L;

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        //@GenericGenerator(name = "native", strategy = "native")
        @Column(name="idcomputadora")
        @Getter @Setter public long idcomputadora;
        @Column(name="bien")
        @Getter @Setter private String bien;
        @Column(name="arrendado")
        @Getter @Setter private String arrendado;
        @Column(name="asignado")
        @Getter @Setter private String asignado;
        @Column(name="ip")
        @Getter @Setter private String ip;
        @Column(name="dns")
        @Getter @Setter private String dns;
        @Column(name="red")
        @Getter @Setter private String red;
        @Column(name="operativo")
        @Getter @Setter private String operativo;
        @Column(name="maquina")
        @Getter @Setter private String maquina;
        @Column(name="tipo")
        @Getter @Setter private String tipo;
        @Column(name="modelo")
        @Getter @Setter private String modelo;
        @Column(name="dominio")
        @Getter @Setter private String dominio;
        @Column(name="administrador")
        @Getter @Setter private String administrador;
        @Column(name="ubicacion")
        @Getter @Setter private String ubicacion;
        @Column(name="actualizada")
        @Getter @Setter private boolean actualizada;
        @Column(name="dispositivo")
        @Getter @Setter private String dispositivo;
        @Column(name="estado")
        @Getter @Setter private boolean estado; 

        //@OneToMany
        //@JoinColumn(name="idusuario")
        //private List<Usuario> usuarios;

        //@ManyToOne
        //@JoinColumn(name="iddepartamento")
        @Getter @Setter public Departamento departamento;


        /*public Computadora(){}
        
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
        }*/

        /*
        public List<Usuario> getUsuarios(){
                return usuarios;
        }
        
        public void setUsuarios(List<Usuario> usuarios){
                this.usuarios=usuarios;
        }*/


        /*public void setBien(String bien){
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

        public String getDispositivo(){
                return dispositivo;
        }

        public void setDispositivo(String dispositivo){
                this.dispositivo=dispositivo;
        }

        public boolean isEstado(){
                return estado;
        }

        public void setEstado(boolean estado){
                this.estado=estado;
        }


        @Override
        public String toString(){
                return "Equipo{ idcomputadora: "+idcomputadora+" , bien: "+bien+ " , arrendado: "+arrendado
                +", asignado: "+asignado+" , ip: "+ip+" , dns: "+dns+", red: "+red + ", dominio: "+dominio
                +" , operativo: "+operativo+" , tipo: "+tipo+", dipositivo:"+dispositivo
                +" , máquina: "+maquina+" , modelo: "+modelo + "estado:"+estado
                +", administrador: "+administrador+",ubicacion:"+ubicacion+
                ", actualizada:"+actualizada+ " }";
        }*/
        
}
