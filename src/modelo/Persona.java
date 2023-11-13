/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author profe
 */
// Estructura de una clase
public abstract class Persona {
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    //atributos
    private String rut;
    private String nombre;
    private Date fechaNac;

   
    //constructor (varios)
    public Persona(String rut, String nombre, Date fechaNac) throws Exception {
        setRut(rut);
        setNombre(nombre);
        setFechaNac(fechaNac);
    }

    //getter - accesadores
    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    //setter - mutadores
    public void setRut(String rut) throws Exception {
        if (rut.equals("")) {
            throw new Exception("Error, el rut no debe estar vacío");
        } else if (rut.length() != 3) {
            throw new Exception("Error, el largo del rut debe ser 3 dígitos");
        } else {
            this.rut = rut;
        }
    }

    public void setNombre(String nombre) throws Exception {
        if (nombre.length() >= 3 && nombre.length() <= 20) {
            this.nombre = nombre;
        } else {
            throw new Exception("Error, el largo del nombre debe tener entre 3 y 20 caracteres");
        }
    }

    
    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;        
    }

    @Override
    public String toString() {
        return rut + ", " + nombre + ", " +formato.format(fechaNac);
    }


}
