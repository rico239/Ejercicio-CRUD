/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario 1 DAM
 */
public class EmpConsola {

    /*Este sera el metodo para listar todos o un solo empleado */
    public void Listado() throws SQLException {
        Empleados emp = new Empleados();
        Empleado emp1;

        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Pulsa 1 para listar todos los empleados o 2 para listar un solo empleado|");
        System.out.println("-------------------------------------------------------------------------");

        switch (Integer.parseInt(sc.nextLine())) {
            case 1:
                emp.ListTodos();

                for (int i = 0; i < emp.ListTodos().size(); i++) {
                    emp1 = new Empleado();
                    emp1 = emp.ListTodos().get(i);
                    System.out.println(emp1.getEmp_no() + "|" + emp1.getApellido() + "|" + emp1.getOficio() + "|" + emp1.getDirector() + "|" + emp1.getFechaalta() + "|" + emp1.getSalario() + "|" + emp1.getComision() + "|" + emp1.getDep_nom());
                }
                break;
            case 2:
                emp1 = emp.ListUno(Integer.parseInt(sc.nextLine()));
                System.out.println(emp1.getEmp_no() + "|" + emp1.getApellido() + "|" + emp1.getOficio() + "|" + emp1.getDirector() + "|" + emp1.getFechaalta() + "|" + emp1.getSalario() + "|" + emp1.getComision() + "|" + emp1.getDep_nom() + "|");
                break;
        }
    }

    /*Este sera el metodo para buscar un empleado en concreto*/
    public void Buscar() throws SQLException {

        Empleados emp = new Empleados();
        Empleado emp1;
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------------");
        System.out.println("Dime el apellido del empleado y te lo busco|");
        System.out.println("--------------------------------------------");
        emp1 = emp.BuscUno(sc.nextLine());
        System.out.println("");
        System.out.println(emp1.getEmp_no() + "|" + emp1.getApellido() + "|" + emp1.getOficio() + "|" + emp1.getDirector() + "|" + emp1.getFechaalta() + "|" + emp1.getSalario() + "|" + emp1.getComision() + "|" + emp1.getDep_nom() + "|");

    }

    /*Este sera el metodo para crear un empleado nuevo*/
    public void CrearE() throws SQLException {
        Empleados emp = new Empleados();
        Empleado emp1 = new Empleado();
        Scanner sc = new Scanner(System.in);

        System.out.println("*******************************************");
        System.out.println("Crea el numero de empleado que va a tener *");
        System.out.println("*******************************************");
        emp1.setEmp_no(Integer.parseInt(sc.nextLine()));
        System.out.println("*******************************************");
        System.out.println("Dime el apellido:                         *");
        System.out.println("*******************************************");
        emp1.setApellido(sc.nextLine());
        System.out.println("*******************************************");
        System.out.println("Dime el oficio que tendra el empleado:    *");
        System.out.println("*******************************************");
        emp1.setOficio(sc.nextLine());
        System.out.println("************************************************");
        System.out.println("Dime el codigo del director que tendra a cargo:*");
        System.out.println("************************************************");
        emp1.setDirector(Integer.parseInt(sc.nextLine()));
        System.out.println("*************************************************");
        System.out.println("Dime la fecha de alta que ha tenido el empleado:*");
        System.out.println("*************************************************");
        java.sql.Date jsqlD = java.sql.Date.valueOf(sc.nextLine());
        emp1.setFechaalta(jsqlD);
        System.out.println("***********************************************");
        System.out.println("Dime el salario que tendra el trabajador:******");
        System.out.println("***********************************************");
        emp1.setSalario(Float.parseFloat(sc.nextLine()));
        System.out.println("***********************************************");
        System.out.println("Dime la comision que tendra el trabajador:    *");
        System.out.println("***********************************************");
        emp1.setComision(Float.parseFloat(sc.nextLine()));
        System.out.println("*************************************************************");
        System.out.println("Dime el numero del departamento en que estara el trabajador:*");
        System.out.println("*************************************************************");
        emp1.setDep_nom(Integer.parseInt(sc.nextLine()));

        emp.CreaE(emp1);
    }

    /*Este es el metodo que eliminara el empleado seleccionado*/
    public void EliminarE() throws SQLException {
        Empleados emp = new Empleados();

        Scanner sc = new Scanner(System.in);
        System.out.println("**************************************************");
        System.out.println("Elimina el empleado que quieras diciendome su id:*");
        System.out.println("**************************************************");

        emp.BorraE(Integer.parseInt(sc.nextLine()));
    }
}
