/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario 1 DAM
 */
public class Departamentos {

    private Connection conexion;
    private ArrayList<Departamento> departamentos;

    public Departamentos() throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
        } catch (SQLException ex) {
            Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    /*Este es el metodo para actualizar los datos de los departamentos*/
    public int Update(int dep_no, Departamento dep) throws SQLException {
        String sql = "UPDATE Departamentos SET Dnombre= ?, Locadidad= ? WHERE dep_nomb;";
        int filas;
        PreparedStatement sentencia = conexion.prepareCall(sql);
        sentencia.setString(1, dep.dnombre);
        sentencia.setString(2, dep.localidad);
        sentencia.setInt(3, dep_no);
        filas = sentencia.executeUpdate();
        return filas;

    }

    /* Este es el metodo para listar un departamento */
    public Departamento Listaruno(int dep_nomb) throws SQLException {
        Departamento dep = new Departamento();
        String sql = "SELECT * FROM departamentos WHERE dept_no = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, dep_nomb);
        ResultSet rs = sentencia.executeQuery();
        rs.first();
        dep.setDep_nomb(rs.getInt(1));
        dep.setDnombre(rs.getString(2));
        dep.setLocalidad(rs.getString(3));
        return dep;
    }

    /*Este es el departamento para buscar el departamento  */
    public Departamento BuscarUno(String dnombre) throws SQLException {
        Departamento dep = new Departamento();
        String sql = "SELECT * FROM departamentos WHERE dnombre = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, dnombre);
        ResultSet rs = sentencia.executeQuery();
        rs.first();
        dep.setDep_nomb(rs.getInt(1));
        dep.setDnombre(rs.getString(2));
        dep.setLocalidad(rs.getString(3));
        return dep;
    }

    public void Delete(int dep) throws SQLException {
        String sql = "DELETE FROM Departamentos WHERE Dep_nomb=?;";
        int filas;
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, dep);
        filas = sentencia.executeUpdate();
    }

    /*metodo para cerrar la coneñion*/
    public void Close() throws SQLException {
        conexion.close();
    }

    /*metodo para listar todos los departamentos*/
    public ArrayList<Departamento> ListarTodos() throws SQLException {
        Departamento dep;
        ArrayList<Departamento> deps = new ArrayList<>();
        String sql = "SELECT * FROM departamentos";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet rs = sentencia.executeQuery();

        while (rs.next()) {
            dep = new Departamento();
            dep.setDep_nomb(rs.getInt(1));
            dep.setDnombre(rs.getString(2));
            dep.setLocalidad(rs.getString(3));
            deps.add(dep);
        }
        return deps;
    }

    /*metodo para crear los departamentos */
    public int CreaD(Departamento dep) throws SQLException {
        int filas;
        String sql = "INSERT INTO Departamentos VALUES (?,?,?)";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, dep.getDep_nomb());
        sentencia.setString(2, dep.getDnombre());
        sentencia.setString(3, dep.getLocalidad());
        filas = sentencia.executeUpdate();
        return filas;
    }

    /*metodo para borrar el departamento seleccionado*/
    public int BorraD(int dep) throws SQLException {
        String sql = "DELETE FROM Departamentos WHERE Emp_no=?;";
        int filas;
        PreparedStatement sentencia = conexion.prepareCall(sql);
        sentencia.setInt(1, dep);
        filas = sentencia.executeUpdate();
        return filas;
    }
}
