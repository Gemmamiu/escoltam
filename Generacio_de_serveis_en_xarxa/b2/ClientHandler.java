/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EAC2_2.Generacio_de_serveis_en_xarxa.b2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ClientHandler extends Thread  
{ 
    DateFormat fordate = new SimpleDateFormat("dd/MM/yyyy"); 
    DateFormat fortime = new SimpleDateFormat("hh:mm:ss");
    DateFormat forday = new SimpleDateFormat("EEEEE:MMMMM:yyyy");
    
    final DataInputStream dis; 
    final DataOutputStream dos; 
    final Socket s; 
      
  
    // Constructor 
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos)  
    { 
        this.s = s; 
        this.dis = dis; 
        this.dos = dos; 
    } 
  
    @Override
    public void run()  
    { 
        String rebut; 
        String toreturn; 
        while (true)  
        { 
            try { 
  
                // Pregunta a l'usuari que vol?
                dos.writeUTF("Que vols? [Date | Time | Day].."+ 
                            "Escriu Exit per acabar la connexió"); 
                  
               
                //rebem la resposta del client
                rebut = dis.readUTF(); 
                  
                if(rebut.equals("Exit")) 
                {  
                    System.out.println("Client " + this.s + " envia exit..."); 
                    System.out.println("Tanca aquesta connexió."); 
                    this.s.close(); 
                    System.out.println("Connexió tancada"); 
                    break; 
                } 
                  
               
                //Creant Objecte Data
                Date date = new Date(); 
                
                // escriure al flux de sortida basat en resposta del client
               
                  
                switch (rebut) { 
                  
                    case "Date" : 
                        toreturn = fordate.format(date);
                        dos.writeUTF(toreturn); 
                        break; 
                          
                    case "Time" : 
                        toreturn = fortime.format(date);
                        dos.writeUTF(toreturn); 
                        break;
                        
                    case "Day":
                        toreturn = forday.format(date);
                        dos.writeUTF(toreturn); 
                        break; 
                          
                    default:
                        System.out.println("Input invalid");
                        break; 
                } 
            } catch (IOException e) { 
                e.printStackTrace(); 
            } 
        } 
          
        try
        { 
            // Tancant recursos
            this.dis.close(); 
            this.dos.close(); 
              
        }catch(IOException e){ 
            e.printStackTrace(); 
        } 
    } 
} 