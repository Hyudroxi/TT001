/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lfrma
 */
public class Cliente {
    private int id;
    private String nome;
    private String telefone;
    private String endereço;
    private String email;
    private String cep;
    private List<Animal> animais;
    
    public Cliente(int id, String nome, String telefone, String endereço, String email, String cep) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereço = endereço;
        this.email = email;
        this.cep = cep;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereço() {
        return endereço;
    }

    public String getEmail() {
        return email;
    }

    public String getCep() {
        return cep;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public void addAnimal (Animal animal) {
        if(!animal.getNome().isBlank()) {
            animais.add(animal);
        }
    }
    
    public List<Animal> getAnimais() {
        List<Animal> copia = new ArrayList<Animal>(animais);
        
        return copia;
    }
    
    @Override
    public String toString() {
        String desc = "Cliente{" + "nome= " + nome + ",telefone " + telefone + ",endereço "+ endereço+ ", CEP " + cep + "email " + email+"}";
        return desc + "\nAnimais{" + animais.toString()+"\n}";
    }   
}
