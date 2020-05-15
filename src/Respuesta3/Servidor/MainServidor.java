    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Respuesta3.Servidor;


import java.net.*; 
import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Daniel-PC
 */
public class MainServidor {
    public static void main(String argv[]) {
        
     ServerSocket socket;
     
     boolean fin = false;
     try {
         
        socket = new ServerSocket(3000);
        
        Socket socket_cli = socket.accept();

        DataInputStream in =new DataInputStream(socket_cli.getInputStream());

        String mensaje ="";
            
        mensaje = in.readUTF();
        
        String[] parts = mensaje.split("\\|");
        
        String nombre = parts[0];
        String apellido = parts[1];
        String edad = parts[2];
 
         
         
        String date = edad;
 
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(date, fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);
        
        int año = periodo.getYears();
        
        System.out.println(" El señor(a) "+ nombre +" " + apellido + " tiene " +  año+ " años");
        //
        socket.close();
     }

     catch (Exception e) {
        System.err.println(e.getMessage());
        System.exit(1);
     }
  }
    
 
}
