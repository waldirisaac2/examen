/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Respuesta3.cliente;

import java.util.Scanner;
import java.net.*;
import java.io.*;
import java.text.ParseException;


public class mainCliente {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        

        
        String lista = sc.nextLine();
        

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Socket socket;
        
        byte[] mensaje_bytes = new byte[256];
        
        try {
            socket = new Socket("127.0.0.1",3000);
            
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            
            out.writeUTF(lista);
            

            out.close();
            socket.close();
         }catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
         }
        
    }
}
