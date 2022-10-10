/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lfrma
 */
public class ClienteDAO extends DAO {
    private static ClienteDAO instance;
    
    private ClienteDAO(){
        getConnection();
        createTable();
    }
    
    //Singleton
    public static ClienteDAO getInstance(){
        return(instance == null ? (instance = new ClienteDAO()) : instance);
    }
    
    public Cliente create(int id, String nome, String telefone, String endereço, String cep, String email){
        try{
            PreparedStatement pstm;
            pstm = DAO.getConnection().prepareStatement("INSERT INTO cliente"
            +"(id, nome, telefone, endereco, cep, email)"
            + "VALUES (?,?,?,?,?,?)");
            pstm.setInt(1,id);
            pstm.setString(2,nome);
            pstm.setString(3,telefone);
            pstm.setString(4,endereço);
            pstm.setString(5,cep);
            pstm.setString(6,email);
            executeUpdate(pstm);
        }catch(SQLException e){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
       return this.retrieveById(lastId("cliente", "id"));
    }
    
    private Cliente buildObject (ResultSet rs){
        Cliente cliente = null;
        try{
            cliente = new Cliente (rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("telefone"),
                    rs.getString("endereço"),
                    rs.getString("cep"),
                    rs.getString("email"));
        }catch (SQLException e){
            System.err.println("Exception: "+ e.getMessage());
        }
        return cliente;
    }
    
     public List retrieve(String query) {
        List<Cliente> clientes = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                clientes.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return clientes;
    }
     
    public List retrieveAll(){
        return this.retrieve("SELECT * FROM cliente ");
    }
    
    public Cliente retrieveById(int id) {
        List<Cliente> clientes = this.retrieve("SELECT * FROM cliente WHERE id = " + id);
        return (clientes.isEmpty() ? null : clientes.get(0));
    }

    public List retrieveBySimilarName(String name) {
        return this.retrieve("SELECT * FROM cliente WHERE nome LIKE '%" + name + "%'");
    }

    public void update(Cliente cliente) {
        PreparedStatement pstm;
        try {
            pstm = DAO.getConnection().prepareStatement("UPDATE cliente SET id=?, nome=?, telefone=?,"
                    + "endereco=?, cep=?, email=? WHERE id=?");
            pstm.setInt(1, cliente.getId());
            pstm.setString(2, cliente.getNome());
            pstm.setString(3, cliente.getTelefone());
            pstm.setString(4, cliente.getEndereço());
            pstm.setString(5, cliente.getCep());
            pstm.setString(6, cliente.getEmail());
            executeUpdate(pstm);

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public void delete(Cliente cliente) {
        PreparedStatement pstm;

        try {
            pstm = DAO.getConnection().prepareStatement("DELETE FROM cliente WHERE id = ?");
            pstm.setInt(1, cliente.getId());
            executeUpdate(pstm);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    
    
}
