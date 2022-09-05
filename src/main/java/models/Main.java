/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Scanner;

/**
 *
 * @author lfrma
 */
public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
         
        System.out.println("==========================================================");
        System.out.println("");
        System.out.println("Bem vindo à Clinica Veterinária");
        System.out.println("");
        System.out.println("Insira o id do cliente ou deixe vazio para mostrar todos");
        int idCliente = myObj.nextInt();
        if(idCliente == 0) {
            System.out.println(ClienteDAO.getInstance().retrieveAll());
        }
        else {
            Cliente c1 = ClienteDAO.getInstance().retrieveById(idCliente);
        }
    }
}
