/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author lfrma
 */
public class Exame {
    private int id;
    private String desc;
    private String data;
    private int idAnimal;
    private int idVet;
    private int idCliente;

    public Exame(int id, String desc, int idAnimal, int idVet, int idCliente, String data) {
        this.id = id;
        this.desc = desc;
        this.idAnimal = idAnimal;
        this.idVet = idVet;
        this.idCliente = idCliente;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
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
    
    public String getData() {
        return data;
    }
    
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setData(String data) {
        this.data = data;
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
    
}
