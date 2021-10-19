/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EAC2_2.Generacio_de_serveis_en_xarxa.b2;

// Java implementation for a client 
// Save file as Client.java 
  
import java.io.*; 
import java.net.*; 
import java.util.Scanner; 
  
// Client class 
public class Client  
{ 
    public static void main(String[] args) throws IOException  
    { 
        try
        { 
            Scanner lector = new Scanner(System.in); 
              
            //obtenint localhost ip
            InetAddress ip = InetAddress.getByName("localhost"); 
      
          
            //establir la connexió amb el port de servidor 7777
            Socket s = new Socket(ip, 7777); 
      
      
            //obtenir fluxos d’entrada i sortida
            DataInputStream dis = new DataInputStream(s.getInputStream()); 
            DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
      
           
            // el següent bucle realitza l'intercanvi de
             // informació entre client i gestor de clients
            
            
            while (true)  
            { 
                System.out.println(dis.readUTF()); 
                String perEnviar = lector.nextLine(); 
                dos.writeUTF(perEnviar); 
                  
                
                // Si el client envia "EXIT", tanqueu aquesta connexió i sortiu del bucle
                
  
                if(perEnviar.equals("Exit")) 
                { 
                    System.out.println("Tancant aquesta connexió : " + s); 
                    s.close(); 
                    System.out.println("Connexió tancada"); 
                    break; 
                } 
                  
                //data o hora d'impressió segons el sol·licitud del client 
                String rebut = dis.readUTF(); 
                System.out.println(rebut); 
            } 
              
            // Tancant recursos 
            lector.close(); 
            dis.close(); 
            dos.close(); 
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
    } 
} 
