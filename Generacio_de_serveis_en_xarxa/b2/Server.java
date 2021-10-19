/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EAC2_2.Generacio_de_serveis_en_xarxa.b2;


//Implementació Java del servidor
// Conté dues classes: Server i ClientHandler
  
import java.io.*; 
import java.text.*; 
import java.util.*; 
import java.net.*; 
  
// Server class 
public class Server  
{ 
    public static void main(String[] args) throws IOException  
    { 
        //el servidor escolta al port 7777
        ServerSocket ss = new ServerSocket(7777); 
        int i=1;  
  
        // executant un bucle infinit per obtenir
         // sol·licitud del client
         System.out.println("Esperant Clients!!!");
        
        while (true)  
        { 
            Socket s = null; 
              
            try 
            { 
                // socket object to receive incoming client requests 
                //socket object per rebre sol·licituds de clients entrants
                s = ss.accept(); 
                System.out.println("Un nou client s'ha connectat : " + s + " Client "+i); 
                i++;  
                //obtenir fluxos d’entrada i sortida
                DataInputStream dis = new DataInputStream(s.getInputStream()); 
                DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
                  
                System.out.println("Assignant un nou fil per aquest client"); 
  
                // creeu un nou objecte de fil
                Thread t = new ClientHandler(s, dis, dos); 
  
                // Invocant el mètode start ()
                t.start(); 
                  
            } 
            catch (Exception e){ 
                s.close(); 
                e.printStackTrace(); 
            } 
        } 
    } 
} 