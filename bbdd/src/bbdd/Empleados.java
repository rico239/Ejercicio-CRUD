/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario 1 DAM
 */
public class Empleados {

    private Connection conexion;
    private ArrayList<Empleado> empleados;

    /*Este sera la conexion que hara a la base de datos*/
    public Empleados() throws SQLException {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
        } catch (SQLException ex) {
            Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    /*Este sera el metodo con todas las variables para crear el empleado */
    public int CreaE(Empleado emp) throws SQLException {
        int filas;
        String sql = "INSERT INTO empleados VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, emp.getEmp_no());
        sentencia.setString(2, emp.getApellido());
        sentencia.setString(3, emp.getOficio());
        sentencia.setInt(4, emp.getDirector());
        sentencia.setDate(5, emp.getFechaalta());
        sentencia.setFloat(6, emp.getSalario());
        sentencia.setFloat(7, emp.getComision());
        sentencia.setInt(8, emp.getDep_nom());
        filas = sentencia.executeUpdate();
        return filas;
    }

    /*Este sera el metodo con todas las variables para actualizar el empleado */
    public int Update(int emp_no, Empleado emp) throws SQLException {
        String sql = "UPDATE Empleados SET  emp_no= ?, apellido= ?, oficio=?, Director=?, Fechaalta=?,Salario=?,Comision=?,Dep_nom=? WHERE dep_nomb=?;";
        int filas;
        PreparedStatement sentencia = conexion.prepareCall(sql);
        sentencia.setInt(1, emp_no);
        sentencia.setString(2, emp.apellido);
        sentencia.setString(3, emp.oficio);
        sentencia.setInt(4, emp.director);
        sentencia.setDate(5, emp.fechaalta);
        sentencia.setFloat(6, emp.salario);
        sentencia.setFloat(7, emp.comision);
        sentencia.setInt(8, emp_no);
        filas = sentencia.executeUpdate();
        return filas;
    }

    /*Este sera el metodo para listar un empleado con las variables*/
    public Empleado ListUno(int emp_no) throws SQLException {
        Empleado emp = new Empleado();
        String sql = "SELECT * FROM Empleados WHERE emp_no=?;";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, emp_no);
        ResultSet rs = sentencia.executeQuery();
        rs.first();
        emp.setEmp_no(rs.getInt(1));
        emp.setApellido(rs.getString(2));
        emp.setOficio(rs.getString(3));
        emp.setDirector(rs.getInt(4));
        emp.setFechaalta(rs.getDate(5));
        emp.setSalario(rs.getFloat(6));
        emp.setComision(rs.getFloat(7));
        emp.setDep_nom(rs.getInt(8));
        return emp;
    }

    /*Este sera el metodo para buscar un empleado en concreto*/
    public Empleado BuscUno(String Apellido) throws SQLException {
        Empleado emp = new Empleado();
        String sql = "SELECT * FROM Empleados WHERE Apellido=?;";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, Apellido);
        ResultSet rs = sentencia.executeQuery();
        rs.first();
        emp.setEmp_no(rs.getInt(1));
        emp.setApellido(rs.getString(2));
        emp.setOficio(rs.getString(3));
        emp.setDirector(rs.getInt(4));
        emp.setFechaalta(rs.getDate(5));
        emp.setSalario(rs.getFloat(6));
        emp.setComision(rs.getFloat(7));
        emp.setDep_nom(rs.getInt(8));
        return emp;
    }

    /*Este sera el metodo par listar todos los empleados con las variables*/
    public ArrayList<Empleado> ListTodos() throws SQLException {
        Empleado emp;
        ArrayList<Empleado> emps = new ArrayList<>();
        String sql = "SELECT * FROM Empleados ;";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            emp = new Empleado();
            emp.setEmp_no(rs.getInt(1));
            emp.setApellido(rs.getString(2));
            emp.setOficio(rs.getString(3));
            emp.setDirector(rs.getInt(4));
            emp.setFechaalta(rs.getDate(5));
            emp.setSalario(rs.getFloat(6));
            emp.setComision(rs.getFloat(7));
            emp.setDep_nom(rs.getInt(8));
            emps.add(emp);
        }
        return emps;
    }

    /*Este sera el metodo para borrar todos los empleados que selecciones*/
    public int BorraE(int emp) throws SQLException {
        String sql = "DELETE FROM Empleados WHERE dep_nomb=?;";
        int filas;
        PreparedStatement sentencia = conexion.prepareCall(sql);
        sentencia.setInt(1, emp);
        filas = sentencia.executeUpdate();
        return filas;
    }

    /*Este es el metodo para cerrar la conexion*/
    public void Close() throws SQLException {
        conexion.close();
    }
}
