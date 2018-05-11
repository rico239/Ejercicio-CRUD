/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;

import java.sql.Date;

/**
 *
 * @author Usuario 1 DAM
 */
public class Empleado {

    /*Estos seran las variables de empleado*/
    int emp_no;
    String apellido;
    String oficio;
    int director;
    Date fechaalta;
    float salario;
    float comision;
    int dep_nom;

    /*getters y setters de empleados*/
    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public int getDirector() {
        return director;
    }

    public void setDirector(int director) {
        this.director = director;
    }

    public Date getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public int getDep_nom() {
        return dep_nom;
    }

    public void setDep_nom(int dep_nom) {
        this.dep_nom = dep_nom;
    }

    /*constructor vacio*/
    public Empleado() {
    }

    /*constructor con las variables de empleado */
    public Empleado(int emp_no, String apellido, String oficio, int director, Date fechaalta, float salario, float comision, int dep_nom) {
        this.emp_no = emp_no;
        this.apellido = apellido;
        this.oficio = oficio;
        this.director = director;
        this.fechaalta = fechaalta;
        this.salario = salario;
        this.comision = comision;
        this.dep_nom = dep_nom;
    }

}
