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
public class AnimalDAO extends DAO {
    private static AnimalDAO instance;
    
    private AnimalDAO(){
        getConnection();
        createTable();
    }
    
    //Singleton
    public static AnimalDAO getInstance(){
        return (instance == null ? (instance = new AnimalDAO()) : instance);
    }
    
    public Animal create(int id, String nome, int idade, String sexo, int idCliente, int idEspecie) {
        try{
            PreparedStatement pstm;
            pstm = DAO.getConnection().prepareStatement("INSERT INTO animal"
            +" (id, nome, idade, sexo, id Cliente, idEspecie)"
            + "VALUES (?,?,?,?,?,?)");
            pstm.setInt(1,id);
            pstm.setString(2,nome);
            pstm.setInt(3,idade);
            pstm.setString(4,sexo);
            pstm.setInt(5,idCliente);
            pstm.setInt(6,idEspecie);
            executeUpdate(pstm);
                    
        }catch (SQLException e){
           Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, e);
        }
     return this.retrieveById(lastId("animal", "id"));   
    }
    
    private Animal buildObject(ResultSet rs){
        Animal animal = null;
        try{
            animal = new Animal(rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("idade"),
                    rs.getString("sexo"),
                    rs.getInt("idCliente"),
                    rs.getInt("idEspecie"));
            
        }catch (SQLException e){
           System.err.println("Exception: " + e.getMessage());
        }
        return animal;
    }
    
    public List retrieve(String query) {
        List<Animal> animais = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                animais.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return animais;
    }
    
    public List retrieveAll() {
        return this.retrieve("SELECT * FROM animal");
    }

   public Animal retrieveById(int id) {
        List<Animal> animais = this.retrieve("SELECT * FROM animal WHERE id = " + id);
        return (animais.isEmpty() ? null : animais.get(0));
    }

    public List<Animal> retrieveByClientId(int idCliente) {
        List<Animal> animais = this.retrieve("SELECT * FROM animal where id_cliente = " + idCliente);

        return (animais.isEmpty() ? null : animais);
    }
    public List retrieveBySimilarName(String nome,int id) {
        return this.retrieve("SELECT * FROM animal WHERE nome LIKE '%" + nome + "%' AND id_especie = "+id);
    }
    
    public void update(Animal animal) {
        PreparedStatement pstm;
        try {
            pstm = DAO.getConnection().prepareStatement("UPDATE animal SET id=?, nome=?, idade=?,"
                    + "sexo=?, idCliente=?, idEspecie=? WHERE id=?");
            pstm.setInt(1, animal.getId());
            pstm.setString(2, animal.getNome());
            pstm.setInt(3, animal.getIdade());
            pstm.setString(4, animal.getSexo());
            pstm.setInt(5, animal.getIdCliente());
            pstm.setInt(6, animal.getIdEspecie());
            
            executeUpdate(pstm);

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    
    public void delete(Animal animal) {
        PreparedStatement pstm;

        try {
            pstm = DAO.getConnection().prepareStatement("DELETE FROM animal WHERE id = ?");
            pstm.setInt(1, animal.getId());
            executeUpdate(pstm);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
