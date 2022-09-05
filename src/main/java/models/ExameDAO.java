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
public class ExameDAO extends DAO{
    private static ExameDAO instance;

    private ExameDAO() {
        getConnection();
        createTable();
    }

    public static ExameDAO getInstance() {
        return (instance == null ? (instance = new ExameDAO()) : instance);
    }
    
    
    public Exame create(int id, String desc, String data, int idAnimal, int idVet, int idCliente) {
        try {
            PreparedStatement pstm;
            pstm = DAO.getConnection().prepareStatement("INSERT INTO exame"
            + " (id,desc,data,idAnimal,idVet,idCliente) "
            + "VALUES (?,?,?,?,?,?)");
            pstm.setInt(1, id);
            pstm.setString(2,desc);
            pstm.setString(3,data);
            pstm.setInt(4, idAnimal);
            pstm.setInt(5, idVet);
            pstm.setInt(6, idCliente);
            executeUpdate(pstm);

        } catch (SQLException e) {
            Logger.getLogger(ExameDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return this.retrieveById(lastId("exame","id"));
    }

    private Exame buildObject(ResultSet rs) {
        Exame exame = null;
        try {
            exame = new Exame(rs.getInt("id"), 
                    rs.getString("desc"), 
                    rs.getString("data"), 
                    rs.getInt("idAnimal"), 
                    rs.getInt("idVet"), 
                    rs.getInt("idCliente"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return exame;
    }

    public List retrieve(String sql) {
        List<Exame> exames = new ArrayList();
        ResultSet rs = getResultSet(sql);

        try {
            while (rs.next()) {
                exames.add(buildObject(rs));
            }

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }

        return exames;
    }

    public Exame retrieveById(int id) {
        List<Exame> exames = this.retrieve("SELECT * FROM exame WHERE id = " + id);
        return (exames.isEmpty() ? null : exames.get(0));
    }
    
    public List retrieveAll(){
        return this.retrieve("SELECT * FROM exame");
    }
    
    
    public void update(Exame exame){
        PreparedStatement pstm;
        
        try {
            pstm = ExameDAO.getConnection().prepareStatement("UPDATE exame SET id=?, desc=?, data=?, idAnimal = ?, idVet=?, idCliente=? WHERE id=?");
            pstm.setInt(1,exame.getId());
            pstm.setString(2,exame.getDesc());
            pstm.setString(3,exame.getData());
            pstm.setInt(4,exame.getIdAnimal());
            pstm.setInt(5,exame.getIdVet());
            pstm.setInt(6,exame.getIdCliente());
            executeUpdate(pstm); 
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    public void delete(Exame exame){
        PreparedStatement pstm;
         try {
             pstm = ExameDAO.getConnection().prepareStatement("DELETE FROM exame WHERE id = ?");
             pstm.setInt(1,exame.getId());
             executeUpdate(pstm);
             
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
