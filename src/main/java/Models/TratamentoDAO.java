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
public class TratamentoDAO extends DAO {
    private static TratamentoDAO instance;

    private TratamentoDAO() {
        getConnection();
        createTable();
    }

    public static TratamentoDAO getInstance() {
        return (instance == null ? (instance = new TratamentoDAO()) : instance);
    }

    public Tratamento create(int id, String sintomas, String dataInicio,
            String dataFinal, int idAnimal, int idCliente) {
        try {
            PreparedStatement pstm;
            pstm = DAO.getConnection().prepareStatement("INSERT INTO tratamento"
                    + " (id,sintomas,dataInicio,dataFinal,idAnimal,idCLiente) VALUES (?,?,?,?,?,?)");
            pstm.setInt(1, id);
            pstm.setString(2, sintomas);
            pstm.setString(3, dataInicio);
            pstm.setString(4, dataFinal);
            pstm.setInt(5, idAnimal);
            pstm.setInt(6, idCliente);
            executeUpdate(pstm);

        } catch (SQLException e) {
            Logger.getLogger(TratamentoDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return this.retrieveById(lastId("tratamento", "id"));
    }

    private Tratamento buildObject(ResultSet rs) {
        Tratamento tratamento = null;
        try {
            tratamento = new Tratamento(rs.getInt("id"), 
                    rs.getString("sintomas"),
                    rs.getString("dataInicio"),
                    rs.getString("dataFinal"),
                    rs.getInt("idAnimal"),
                    rs.getInt("idCliente"));

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }

        return tratamento;
    }

    public List retrieve(String sql) {
        List<Tratamento> tratamentos = new ArrayList();
        ResultSet rs = getResultSet(sql);

        try {
            while (rs.next()) {
                tratamentos.add(buildObject(rs));
            }

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }

        return tratamentos;
    }

    public Tratamento retrieveById(int id) {
        List<Tratamento> tratamentos = this.retrieve("SELECT * FROM "
                + "tratamento WHERE id = " + id);
        return (tratamentos.isEmpty() ? null : tratamentos.get(0));
    }

    public Tratamento retrieveFirstByAnimalId(int idAnimal) {
        List<Tratamento> tratamentos = this.retrieve("SELECT * FROM "
                + "tratamento WHERE idAnimal = " + idAnimal);
        return (tratamentos.isEmpty() ? null : tratamentos.get(0));
    }

    public List retrieveAllByAnimalId(int idAnimal) {
        return this.retrieve("SELECT * FROM tratamento where idAnimal = " + idAnimal);
    }

    public List retrieveAll() {
        return this.retrieve("SELECT * FROM tratamento");
    }

    public void update(Tratamento tratamento) {
        PreparedStatement pstm;

        try {
            pstm = TratamentoDAO.getConnection().prepareStatement("UPDATE tratamento "
                    + "SET id=?, sintomas = ?, dataInicio = ?, "
                    + "dataFinal = ?, IdAnimal = ?, IdVet=?, IdCliente=? WHERE id = ?");
            pstm.setInt(1, tratamento.getId());
            pstm.setString(2, tratamento.getSintomas());
            pstm.setString(3, tratamento.getDataInicio());
            pstm.setString(4, tratamento.getDataFinal());
            pstm.setInt(5, tratamento.getIdAnimal());
            pstm.setInt(6, tratamento.getIdCliente());
            executeUpdate(pstm);

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public void delete(Tratamento tratamento) {
        PreparedStatement pstm;
        try {
            pstm = TratamentoDAO.getConnection().prepareStatement("DELETE FROM tratamento WHERE id = ?");
            pstm.setInt(1, tratamento.getId());
            executeUpdate(pstm);

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
