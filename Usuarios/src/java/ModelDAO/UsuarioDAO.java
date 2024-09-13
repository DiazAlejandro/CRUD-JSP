/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelDAO;

import Config.ConnectionBD;
import Interface.CrudUsuario;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements CrudUsuario{
    ConnectionBD conexion = new ConnectionBD();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Usuario usuario = new Usuario();
    
    @Override
    public List listar() {
        ArrayList<Usuario> listaUsarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try {
            conn = conexion.getConnectionBD();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()){
                Usuario usuario = new Usuario();
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setCelular(rs.getString("celular"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setFecha_nac(rs.getDate("fecha_nac"));
                usuario.setMatricula(rs.getString("matricula"));
                usuario.setNombre(rs.getString("nombre"));
                
                listaUsarios.add(usuario);
            }
        } catch (Exception e) {
            System.err.println("ERROR DE CARGA DE DATOS: "+e);
        }
        
        return listaUsarios;
    }

    @Override
    public Usuario mostrarUsuario(String matricula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean agregarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (apellidos, celular, correo, "+
                "fecha_nac, matricula, nombre) VALUES ('"+usuario.getApellidos()+"','"+
                usuario.getCelular()+"','"+usuario.getCorreo()+"','"+
                usuario.getFecha_nac()+"','"+usuario.getMatricula()+"','"+
                usuario.getNombre()+"')";
        
        try {
            conn = conexion.getConnectionBD();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();           
        } catch (Exception e) {
            System.out.println("ERROR AL INSERTAR: "+e);
        }
        return false;
    }

    @Override
    public Boolean editarUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean borrarUsuario(String matricula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
