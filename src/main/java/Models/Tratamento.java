/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author lfrma
 */
public class Tratamento {
    private int id;
    private String dataInicio;
    private String dataFinal;

    public Tratamento(int id, String dataInicio, String dataFinal) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
    }

    public int getId() {
        return id;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }
    
    
}
