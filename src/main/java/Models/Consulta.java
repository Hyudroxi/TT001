/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author lfrma
 */
public class Consulta {
    private int id;
    private String data;
    private String historico;
    private int idAnimal;
    private int idVet;
    private int idCliente;
    private int idTratamento;

    public Consulta(int id, String data, String historico, int idAnimal, int idVet, int idCliente, int idTratamento) {
        this.id = id;
        this.data = data;
        this.historico = historico;
        this.idAnimal = idAnimal;
        this.idVet = idVet;
        this.idCliente = idCliente;
        this.idTratamento = idTratamento;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public String getHistorico() {
        return historico;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public int getIdVet() {
        return idVet;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdTratamento() {
        return idTratamento;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public void setIdVet(int idVet) {
        this.idVet = idVet;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdTratamento(int idTratamento) {
        this.idTratamento = idTratamento;
    }
    
}
