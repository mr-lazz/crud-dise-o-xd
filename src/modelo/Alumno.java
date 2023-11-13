/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.Persona;
import java.util.Date;

/**
 *
 * @author profe
 */
public class Alumno extends Persona {
    private String carrera;

    
    public Alumno(String carrera, String rut, String nombre, Date fechaNac) throws Exception {
        super(rut, nombre, fechaNac);
        setCarrera(carrera);
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) throws Exception {
        if( carrera.equals("Programador") || carrera.equals("Contador") || carrera.equals("Secretariado")){
           this.carrera = carrera; 
        }else{
           throw new Exception("Error, no es una carrera válida, solo acepta: Programador, Contador,Secretariado");
        }
    }

    @Override
    public String toString() {
        return  super.toString()+", "+carrera;
    }
    
    
    
    
    
}
