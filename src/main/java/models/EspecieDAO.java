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
public class EspecieDAO extends DAO {
    private static EspecieDAO instance;

    private EspecieDAO() {
        createTable();
        getConnection();
    }

    public static EspecieDAO getInstance() {
        return (instance == null ? (instance = new EspecieDAO()) : instance);
    }

    public Especie create(int id, String nome) {
        try {
            PreparedStatement pstm;
            pstm = DAO.getConnection().prepareStatement("INSERT INTO especie (id,nome) VALUES (?,?)");
            pstm.setInt(1, id);
            pstm.setString(2, nome);
            executeUpdate(pstm);

        } catch (SQLException e) {
            Logger.getLogger(EspecieDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return this.retrieveById(lastId("especie", "id"));
    }

    private Especie buildObject(ResultSet rs) {
        Especie especie = null;
        try{
            especie = new Especie(rs.getInt("id"), 
                    rs.getString("nome"));

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }

        return especie;
    }

    public List retrieve(String sql) {
        List<Especie> especies = new ArrayList();
        ResultSet rs = getResultSet(sql);

        try {
            while (rs.next()) {
                especies.add(buildObject(rs));
            }

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }

        return especies;
    }

    public Especie retrieveById(int id) {
        List<Especie> especies = this.retrieve("SELECT * FROM especie WHERE id = " + id);
        return (especies.isEmpty() ? null : especies.get(0));
    }

    public Especie retrieveByName(String nome) {
        List<Especie> especies = this.retrieve("SELECT * FROM especie WHERE nome LIKE '" + nome+"%'");
        return (especies.isEmpty() ? null : especies.get(0));
    }

    public List retrieveBySimilarName(String nome) {
        return this.retrieve("SELECT * FROM especie WHERE nome LIKE '%" + nome + "%'");
    }

    public List retrieveAll() {
        return this.retrieve("SELECT * FROM especie");
    }

    public void update(Especie especie) {
        PreparedStatement pstm;

        try {
            pstm = EspecieDAO.getConnection().prepareStatement("UPDATE especie SET id=? ,nome=? WHERE id=?");
            pstm.setInt(1, especie.getId());
            pstm.setString(2, especie.getNome());
            executeUpdate(pstm);

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public void delete(Especie especie) {
        PreparedStatement pstm;
        try {
            pstm = EspecieDAO.getConnection().prepareStatement("DELETE FROM especie WHERE id = ?");
            pstm.setInt(1, especie.getId());
            executeUpdate(pstm);

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
