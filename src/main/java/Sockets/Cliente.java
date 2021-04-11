/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author Maxangel
 */
public class Cliente extends JFrame {
    private JLabel etiqueta, dni;
    private final int PUERTO=5000;
    private final String IP ="localhost";
    private DataInputStream entrada;
    private Socket so;
    
    public Cliente(){
        super("Cliente");
        setBounds(100,200,200,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        etiqueta=new JLabel("Su numero de DNI es: ");
        dni= new JLabel("");
        
        etiqueta.setBounds(25,15,200,50);
        dni.setBounds(50,40,100,50);
        
        crearConexion();
        
        add(etiqueta);
        add(dni);
        setVisible(true);
        
    }    
    
    public void crearConexion() {
        try{
            so= new Socket(IP,PUERTO);
                try{
            entrada= new DataInputStream(so.getInputStream());
            dni.setText(entrada.readUTF());
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
        so.close();
    }catch (IOException ioe){
    System.out.println (ioe.getMessage());
}
    
}

public static void main  (String [] args){
    Cliente sv=new Cliente();
    
        }
}