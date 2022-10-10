/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author lfrma
 */
public class Tratamento {
    private int id;
    private String sintomas;
    private String dataInicio;
    private String dataFinal;
    private int idAnimal;
    private int idCliente;

    public Tratamento(int id, String sintomas, String dataInicio, String dataFinal, int idAnimal, int idCliente) {
        this.id = id;
        this.sintomas = sintomas;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.idAnimal = idAnimal;
        this.idCliente = idCliente;
    }

    public int getId() {
        return id;
    }

    public String getSintomas() {
        return sintomas;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
}
