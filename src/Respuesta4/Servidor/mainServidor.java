/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Respuesta4.Servidor;


import java.net.*;  
import java.io.*;  

import java.io.PrintWriter;
/**
 *
 * @author Daniel-PC
 */
public class mainServidor {
    public static void main(String args[])throws Exception{  
            ServerSocket ss=new ServerSocket(1620);  
            Socket s=ss.accept();  
            DataInputStream in=new DataInputStream(s.getInputStream());  
            DataOutputStream out=new DataOutputStream(s.getOutputStream());  
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  

            String mensaje1="",mensaje2="";  
            
            String Final = null;
            
            while(!mensaje1.equals("Fin")){  
                mensaje1=in.readUTF();  
                System.out.println("Cliente: "+mensaje1);  
                mensaje2=br.readLine();  
                out.writeUTF(mensaje2);  
                out.flush();  
                
                
                
                if(Final == null){
                    Final = "Cliente: "+mensaje1+"\n"+"Servidor: "+mensaje2+"\n";
                }else{
                    Final = Final +"Cliente: "+mensaje1+"\n"+"Servidor: "+mensaje2+"\n";
                  
                }
            }
        
        in.close();  
        s.close();  
        ss.close();
        int i = 1;
        String ruta = "D:/chat_"+ i +".txt";
        File archivo = new File(ruta); 
        
        
        
        
        do{
            ++i;
            ruta = "D:/chat_"+ i +".txt";
            archivo = new File(ruta);
        }while (archivo.exists());

        
        PrintWriter writer = new PrintWriter("D:/chat_"+ i +".txt", "UTF-8");
        writer.println(Final);
        writer.close();
        
        

            
    
    }
}
