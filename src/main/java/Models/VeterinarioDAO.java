/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

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
public class VeterinarioDAO extends DAO{
    private static VeterinarioDAO instance;

    private VeterinarioDAO() {
        getConnection();
        createTable();
    }

    public static VeterinarioDAO getInstance() {
        return (instance == null ? (instance = new VeterinarioDAO()) : instance);
    }

    public Veterinario create(int id, String nome, String telefone, String endereço) {
        try {
            PreparedStatement pstm;
            pstm = DAO.getConnection().prepareStatement("INSERT INTO vet"
                    + " (id,nome,telefone) VALUES (?,?,?,?)");
            pstm.setInt(1,id);
            pstm.setString(2, nome);
            pstm.setString(3, telefone);
            pstm.setString(4, endereço);
            executeUpdate(pstm);

        } catch (SQLException e) {
            Logger.getLogger(VeterinarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return this.retrieveById(lastId("veterinario", "id"));
    }

    private Veterinario buildObject(ResultSet rs) {
        Veterinario veterinario = null;
        try {
            veterinario = new Veterinario(rs.getInt("id"), 
                    rs.getString("nome"),
                    rs.getString("telefone"),
                    rs.getString("endereço)"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return veterinario;
    }

    public List retrieve(String sql) {
        List<Veterinario> veterinarios = new ArrayList();
        ResultSet rs = getResultSet(sql);

        try {
            while (rs.next()) {
                veterinarios.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return veterinarios;
    }

    public Veterinario retrieveById(int id) {
        List<Veterinario> veterinarios = this.retrieve("SELECT * FROM "
                + "vet WHERE id = " + id);
        return (veterinarios.isEmpty() ? null : veterinarios.get(0));
    }

    public List retrieveBySimilarName(String nome) {
        return this.retrieve("SELECT * FROM vet WHERE nome LIKE '%" + nome + "%'");
    }

    public List retrieveAll() {
        return this.retrieve("SELECT * FROM vet");
    }

    public void update(Veterinario veterinario) {
        PreparedStatement pstm;

        try {
            pstm = VeterinarioDAO.getConnection().prepareStatement("UPDATE vet "
                    + "SET id=?, nome=?, telefone = ? WHERE id=?");
            pstm.setInt(1, veterinario.getId());
            pstm.setString(2, veterinario.getNome());
            pstm.setString(3, veterinario.getTelefone());
            pstm.setString(4, veterinario.getEndereço());
            executeUpdate(pstm);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public void delete(Veterinario veterinario) {
        PreparedStatement pstm;
        try {
            pstm = VeterinarioDAO.getConnection().prepareStatement("DELETE FROM vet WHERE id = ?");
            pstm.setInt(1, veterinario.getId());
            executeUpdate(pstm);

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
