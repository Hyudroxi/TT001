/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lfrma
 */
public class Animal {
    private int id;
    private int idade;
    private String nome;
    private String sexo;
    private int idCliente;
    private int idEspecie;

    public Animal(int id, int idade, String nome, String sexo, int idCliente, int idEspecie) {
        this.id = id;
        this.idade = idade;
        this.nome = nome;
        this.sexo = sexo;
        this.idCliente = idCliente;
        this.idEspecie = idEspecie;
    }

    public int getId() {
        return id;
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdEspecie() {
        return idEspecie;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdEspecie(int idEspecie) {
        this.idEspecie = idEspecie;
    }
    
    @Override
    public String toString(){
        return "\nnome: "+this.nome;
    }
}
