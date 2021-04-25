/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloestudiante;

import java.io.Serializable;

/**
 *
 * @author Hp
 */
public class estudiantes implements Serializable {
    private String codrg = "";
    private String nombre = "";
    private String apeliido = "";
    private String fechanaci = "";
    private String ced = "";
    private int tlf = 0;
    private String nacionalidad = "";
    private String tipo = "";
    private String carrera = "";
    private String fechareg = "";

    public estudiantes(String codrg, String nombre, String apeliido, String fechanaci, String ced, int tlf, String nacionalidad, String tipo, String carrera, String fechareg) {
        this.codrg = codrg;
        this.nombre = nombre;
        this.apeliido = apeliido;
        this.fechanaci = fechanaci;
        this.ced = ced;
        this.tlf = tlf;
        this.nacionalidad = nacionalidad;
        this.tipo = tipo;
        this.carrera = carrera;
        this.fechareg = fechareg;
    }

    public String getCodrg() {
        if(codrg == null){
            return "";
        }
        return codrg;
    }

    public void setCodrg(String codrg) {
        
        this.codrg = codrg;
    }

    public String getNombre() {
        if(nombre == null){
            return "";
        }
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApeliido() {
        if(apeliido == null){
            return "";
        }
        return apeliido;
    }

    public void setApeliido(String apeliido) {
        this.apeliido = apeliido;
    }

    public String getFechanaci() {
       if(fechanaci == null){
            return "";
        }
        return fechanaci;
    }

    public void setFechanaci(String fechanaci) {
        this.fechanaci = fechanaci;
    }

    public String getCed() {
        if(ced == null){
            return "";
        }
        return ced;
    }

    public void setCed(String ced) {
        this.ced = ced;
    }

    public int getTlf() {
        return tlf;
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }

    public String getNacionalidad() {
        if(nacionalidad == null){
            return "";
        }
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTipo() {
        if(tipo == null){
            return "";
        }
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCarrera() {
        if(carrera == null){
            return "";
        }
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getFechareg() {
        if(fechareg == null){
            return "";
        }
        return fechareg;
    }

    public void setFechareg(String fechareg) {
        this.fechareg = fechareg;
    }

}