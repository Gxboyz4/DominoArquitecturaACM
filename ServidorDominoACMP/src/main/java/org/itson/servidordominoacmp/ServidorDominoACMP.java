/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.itson.servidordominoacmp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel Mancinas
 */
public class ServidorDominoACMP {

    static final int puerto = 9090;
    static ProxyServidor proxyServidor;
   // static List<PaqueteDatos> historialChat = new ArrayList();

    
    public static void main(String[] args) {
    iniciarServidor();
    }
    
    public static void iniciarServidor(){
        try{
         proxyServidor = new ProxyServidor();
         proxyServidor.iniciarSocket();
         proxyServidor.iniciarHilo();
         
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
   
    }

