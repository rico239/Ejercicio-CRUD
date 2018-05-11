/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Usuario 1 DAM
 */
public class Bbdd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        /* conexiones a las clases que muestran cada clase*/
        DepConsola depCone = new DepConsola();
        EmpConsola emConex = new EmpConsola();

        /*Menu principal para elegir la opcion que queramos*/
        System.out.println(
                "------------------------------------------------------------------------------------------\n"
                + "1.Listar Departamentos. Aquí debe dar la opción de listar un solo departamento o todos.  |\n"
                + "2.Listar Empleados. Aquí debe dar la opción de listar un solo empleado o todos.          |\n"
                + "3.Buscar empleado por nombre.                                                            |\n"
                + "4.Buscar departamento por nombre.                                                        |\n"
                + "5.Crear empleado.                                                                        |\n"
                + "6.Crear departamento.                                                                    |\n"
                + "7.Borrar empleado.                                                                       |\n"
                + "8.Borrar departamento.                                                                   |\n "
                + "-----------------------------------------------------------------------------------------");

        /*SWITCH para que nos detecte el numero que introduzcamos y vaya a los distintos metodos*/
        Scanner sc = new Scanner(System.in);
        int menu = sc.nextInt();

        switch (menu) {

            case 1:
                depCone.listado();
                break;

            case 2:
                emConex.Listado();
                break;
            case 3:
                emConex.Buscar();
                break;

            case 4:
                depCone.BuscarDep();
                break;

            case 5:
                emConex.CrearE();
                break;

            case 6:
                depCone.CrearD();
                break;

            case 7:
                emConex.EliminarE();
                break;

            case 8:
                depCone.EliminarD();
                break;
        }

    }
}
