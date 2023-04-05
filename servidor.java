/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            ServerSocket servidor; // declarando el servidor
            Socket sc; // declarando el socket
            int puerto = 5000; 
            DataInputStream input; 
            DataOutputStream output;
            ArrayList<Socket> listaHilo= new ArrayList();
        try {
            // TODO code application logic here
            servidor = new ServerSocket(puerto); // creando el servidor 
            System.out.println("SERVIDOR INICIADO");
          
            while(true){
                System.out.println("lista de clientes : "+listaHilo);
                System.out.println("");
                sc = servidor.accept(); 
                input = new DataInputStream(sc.getInputStream());
                output = new DataOutputStream(sc.getOutputStream()); 
                listaHilo.add(sc); 
                HiloCliente hc= new HiloCliente(sc,input,output); 
                Thread hilo = new Thread(hc);     
                hilo.start();
               
              
                
                System.out.println("______________________________________________________________________");
                
            }
        } catch (IOException ex) {
            Logger.getLogger(servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
