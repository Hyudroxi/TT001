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

    public Consulta(int id, String data, String historico) {
        this.id = id;
        this.data = data;
        this.historico = historico;
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

    public void setData(String data) {
        this.data = data;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }
    
    
}
