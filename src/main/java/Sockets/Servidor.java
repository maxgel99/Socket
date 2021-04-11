/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets;

/**
 *
 * @author Maxangel
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import javax.swing.JButton;
import javax.swing.JFrame;
public class Servidor extends JFrame {
    private JButton enviar;
    private final int PUERTO=5000;
    private ServerSocket sc;
    private DataOutputStream salida;
    private Socket so;
    /**
     * @param args the command line arguments
     */
    public Servidor() {
        super ("Servidor");
        setBounds(600,200,200,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
       enviar =new JButton("Enviar");
        enviar.setBounds(50,50,100,50);
        enviar.addActionListener(new ActionListener(){
        
        @Override
        public void actionPerformed(ActionEvent e){
            crearConexion();
        }
    });
        add(enviar);
        setVisible(true);
        
        // TODO code application logic here
    }
    public void crearConexion(){
        try {
            sc= new ServerSocket(PUERTO);
           
        }catch (IOException ioe){
            System.out.println (ioe.getMessage());
        }
        so = null;
        try{
            so=sc.accept();
            
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
        try{
            salida=new DataOutputStream(so.getOutputStream());
            salida.writeUTF("85124158");
            so.close();
            sc.close();
        } catch (IOException ioe ){
            System.out.println(ioe.getMessage());
        }
    }
    public static void main (String [] args){
        Servidor sv=new Servidor();
    }
    
}
