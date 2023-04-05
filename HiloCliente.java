/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class HiloCliente implements Runnable {
    Socket cliente; 
    DataInputStream input; 
    DataOutputStream output; 
     
    public HiloCliente(Socket cliente,DataInputStream input,DataOutputStream output) {
        this.cliente = cliente;
        this.input=input; 
        this.output=output; 
    }
    
    @Override
    public void run(){
   
       
        try {
            //Aqui creas los buffers de entrada salida y aqui los finalizas cuando dejes de usarlos.
            //y cada hilo ejecutara su run() para cada cliente que se conecte.
            
 
            String mensaje = input.readUTF();
            System.out.println(mensaje);
            output.writeUTF("HOLA CLIENTE : "+ cliente +" SOY EL SERVIDOR");
        } catch (IOException ex) {
            Logger.getLogger(HiloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
            
      
    }
}
