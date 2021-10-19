/*
Realitzem un petit client FTP, aquest es connecta a un servidor instal·lat en el localhost, o la IP
que dessitgis, un cop conectat intentarem passar un document de l'origen a la carpeta del servidor FTP. 
 */
package EAC2_2.Generacio_de_serveis_en_xarxa.b1;

/**
 *
 * @author Usuari
 */
import java.io.BufferedInputStream;
import java.io.FileInputStream; 
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTP;  
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FtpClient 
{
    static Boolean connexio=true;
    static Scanner lector=new Scanner(System.in);

    
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException
    {
        try
        {
            Scanner lector=new Scanner(System.in);
            // Creant el nostre objecte ftpClient 
            FTPClient ftpClient = new FTPClient();
            
            do {
                String ftp = "localhost"; // També podrieu ficar una ip
                System.out.println("Introdueix usuari");
                String user = lector.next();
                System.out.println("Introdueix password");
                String password = lector.next();

                // Conectant al servidor
                ftpClient.connect(InetAddress.getByName(ftp));
                ftpClient.login(user, password);

                //Verificar connexió amb el servidor.
                int reply = ftpClient.getReplyCode();

                System.out.println("Resposta rebuda de connexió FTP:" + reply);

                if (FTPReply.isPositiveCompletion(reply)) {
                    System.out.println("Ens hem conectat satisfactoriament");
                    connexio = false;
                } else {
                    System.out.println("Tenim problemes de connexió!!!");
                    System.out.println("Probablement tens el password o user incorrecte");

                }
            } while (connexio);
            //Verificar si fa el canvi de directori de treball
            
            
            
            ftpClient.changeWorkingDirectory("/"); //Canvi de directori de treball
            System.out.println("S'ha fet el canvi satisfactoriament");
            
            //Fer una activació per enviar qualsevol tipus d'arxiu            
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            
            //Anem al menu per mirar les diverses opcions
            
            menu(ftpClient);
                
                
            ftpClient.logout(); //Tancaar sessió 
            ftpClient.disconnect();//Ens desconectem del server
        }
        catch(Exception e)
                {
                    System.out.println(e.getMessage());
                    System.out.println("Error!!!!");
                }
    }
    
    
    
    public static void menu(FTPClient ftpClient) throws IOException{
        boolean sortir = false;
            System.out.println("----MENU----");
            System.out.println("");
            System.out.println("Premeu 1 si voleu copiar un fitxer");
            System.out.println("Premeu 2 si voleu borrar un fitxer");
            System.out.println("Premeu 3 per sortir");
            System.out.println("");
        int opcio=lector.nextInt();
        switch (opcio){
            case 1: 
                
                copiarFitxerFTP(ftpClient);
                    
            break;
            case 2: esborrarFitxerFTP( ftpClient);
                    
            break;
            case 3: 
                
                break;
                
            default: System.out.println("Opcio incorrecta, torneu a entrar el número");
            
        }
    
    
    
    } 
    public static void copiarFitxerFTP(FTPClient ftpClient) throws IOException{
        Boolean transferencia = false;
        Scanner lector = new Scanner(System.in);
        BufferedInputStream buffIn = null;
        System.out.println("Introdueix la ruta del fitxer a transferir");
        String arxiu = "";
        while (!transferencia) {
            arxiu = lector.next();

            try {
                buffIn = new BufferedInputStream(new FileInputStream(arxiu));
                transferencia = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("La ruta no existeix, torna-la a introduir");
                transferencia = false;
            }

        }

        ftpClient.enterLocalPassiveMode();

        //Guardant l'arxiu al server
        ftpClient.storeFile("Nuevo.txt", buffIn);//Ruta complerta de l'allotjament en el FTP
        System.out.println("Transferencia realitzada!!!");
        menu(ftpClient);
        try {
            buffIn.close(); //Tancar l'enviament d'arxius
        } catch (IOException ex) {
            Logger.getLogger(FtpClient.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Problema en el tancament d'arxius");
        }
        lector.close();
    }
    

    public static void esborrarFitxerFTP(FTPClient ftpClient) throws IOException{
        
        Boolean transferencia=false;
        Scanner lector=new Scanner(System.in);
        BufferedInputStream buffIn = null;
        String arxiu="";
            System.out.println("Introdueix la ruta del fitxer a borrar");
            arxiu=lector.next();
            //Guardant l'arxiu al server
            transferencia=ftpClient.deleteFile(arxiu);//Ruta complerta de l'allotjament en el FTP
            if (transferencia)
                System.out.println("Arxiu borrat!!!");
            else
                System.out.println("No hem pogut borrar el fitxer, ruta incorrecta");
            menu(ftpClient);
        try {
            buffIn.close(); //Tancar l'enviament d'arxius
        } catch (IOException ex) {
            Logger.getLogger(FtpClient.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Problema en el tancament d'arxius");
        }
        lector.close();
    }
    
        
    }
