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
public class DepConsola {

    /*Este sera el metodo para listar todos o solo un departamento*/
    public void listado() throws SQLException {
        Departamentos dep = new Departamentos();
        Departamento dep1 = new Departamento();
        ArrayList<Departamento> deps = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("*********************************************************************************");
        System.out.println("Pulsa 1 para listar todos los departamentos o 2 para listar un solo departamento*");
        System.out.println("*********************************************************************************");
        switch (Integer.parseInt(sc.nextLine())) {
            case 1:
                dep.ListarTodos();
                deps = dep.ListarTodos();
                for (int i = 0; i < deps.size(); i++) {
                    System.out.println(deps.get(i).getDep_nomb() + "|" + deps.get(i).getDnombre() + "|" + deps.get(i).getLocalidad() + "|");
                }
                break;
            case 2:
                dep1 = dep.Listaruno(Integer.parseInt(sc.nextLine()));
                System.out.println(dep1.getDep_nomb() + "|" + dep1.getDnombre() + "|" + dep1.getLocalidad() + "|");
                break;
        }
    }

    /*Este sera el metodo para buscar el departamento que queramos*/
    public void BuscarDep() throws SQLException {
        Departamentos dep = new Departamentos();
        Departamento dep1 = new Departamento();
        Scanner sc = new Scanner(System.in);
        System.out.println("**********************************************");
        System.out.println("Dime el nombre del departamento y te lo busco*");
        System.out.println("**********************************************");
        dep1 = dep.BuscarUno(sc.nextLine());
        System.out.println("");
        System.out.println(dep1.getDep_nomb() + "|" + dep1.getDnombre() + "|" + dep1.getLocalidad());
    }

    /*Este sera el metodo para crear un nuevo departamento*/
    public void CrearD() throws SQLException {
        Departamentos dep = new Departamentos();
        Departamento dep1 = new Departamento();
        Scanner sc = new Scanner(System.in);

        System.out.println("*******************************************");
        System.out.println("Crea el id del departamento que va a tener*");
        System.out.println("*******************************************");
        dep1.setDep_nomb(Integer.parseInt(sc.nextLine()));
        System.out.println("*********************************");
        System.out.println("Dime el Nombre del Departamento:*");
        System.out.println("*********************************");
        dep1.setDnombre(sc.nextLine());
        System.out.println("******************************************************");
        System.out.println("Dime en que localidad estara situado el departamento:*");
        System.out.println("******************************************************");
        dep1.setLocalidad(sc.nextLine());
        dep.CreaD(dep1);
    }

    /*Este sera el metodo para eliminar el departamento seleccionado */
    public void EliminarD() throws SQLException {
        Departamentos dep = new Departamentos();

        Scanner sc = new Scanner(System.in);
        System.out.println("*************************************");
        System.out.println("Elimina el departamento que quieras:*");
        System.out.println("*************************************");

        dep.BorraD(Integer.parseInt(sc.nextLine()));
    }

}
