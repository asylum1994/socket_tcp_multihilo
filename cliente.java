/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          String host = "127.0.0.1";
          int puerto=5000;
          
           DataInputStream input; 
           DataOutputStream output; 
        try {
            // TODO code application logic here   
             Socket sc= new Socket(host, puerto);
             input = new DataInputStream(sc.getInputStream()); 
             output = new DataOutputStream(sc.getOutputStream()); 
             
             output.writeUTF("hola soy el cliente "+sc);
             String mensaje = input.readUTF();
             
             System.out.println(mensaje);
             sc.close();
             
        } catch (IOException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
