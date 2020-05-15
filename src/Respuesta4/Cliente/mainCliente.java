/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Respuesta4.Cliente;


import java.net.*;  
import java.io.*;  
/**
 *
 * @author Daniel-PC
 */
public class mainCliente {
    public static void main(String args[])throws Exception{  
        Socket s=new Socket("localhost",1620);  
        DataInputStream in=new DataInputStream(s.getInputStream());  
        DataOutputStream out=new DataOutputStream(s.getOutputStream());  
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  

        String mensaje1="",mensaje2="";  
        while(!mensaje1.equals("Fin")){  
            mensaje1=br.readLine();  
            out.writeUTF(mensaje1);  
            out.flush();  
            mensaje2=in.readUTF();  
            System.out.println("Servidor: "+mensaje2); 

        }  
    out.close(); 
    s.close();  
    } 
}