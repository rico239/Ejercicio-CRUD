/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;

/**
 *
 * @author Usuario 1 DAM
 */
public class Departamento {

    /*variables de empleado*/
    int dep_nomb;
    String dnombre;
    String localidad;

    /*setters y getter de la clase empleado */
    public int getDep_nomb() {
        return dep_nomb;
    }

    public void setDep_nomb(int dep_nomb) {
        this.dep_nomb = dep_nomb;
    }

    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    /*constructor vacio*/
    public Departamento() {
    }

    /*constructor con las variables del departamento*/
    public Departamento(int dep_nomb, String dnombre, String localidad) {
        this.dep_nomb = dep_nomb;
        this.dnombre = dnombre;
        this.localidad = localidad;
    }

}
