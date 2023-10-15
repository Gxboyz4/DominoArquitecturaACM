/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Tablero;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.itson.proyectoarquitecturadominoacm.Fichas.Ficha;

/**
 *
 * @author Gabriel Mancinas
 */
public class TableroModelo {
   private JPanel lienzo;
    private LinkedList<Ficha> fichas;
    private int numeroDerecha;
    private int numeroIzquierda;
//    private List<Ficha> fichasDibujadas;

    public int getNumeroDerecha() {
        return numeroDerecha;
    }

    public void setNumeroDerecha(int numeroDerecha) {
        this.numeroDerecha = numeroDerecha;
    }

    public int getNumeroIzquierda() {
        return numeroIzquierda;
    }

    public void setNumeroIzquierda(int numeroIzquierda) {
        this.numeroIzquierda = numeroIzquierda;
    }
    
    public TableroModelo(JPanel lienzo){
        this.lienzo = lienzo;
        fichas = new LinkedList<Ficha>();
    }
    public void colocarPosicionFichaDer(int desplazamientoX,int desplazamientoY,Ficha ficha)
    {
        int x = fichas.getLast().getPosicionX();
        int y = fichas.getLast().getPosicionY();

        ficha.setPosicionX(x+desplazamientoX);
        ficha.setPosicionY(y+desplazamientoY);
    }
    public void colocarPosicionFichaIzq(int desplazamientoX,int desplazamientoY,Ficha ficha)
    {
        int x = fichas.getFirst().getPosicionX();
        int y = fichas.getFirst().getPosicionY();
        ficha.setPosicionX(x+desplazamientoX);
        ficha.setPosicionY(y+desplazamientoY);
    }
 
    public void agregarFichaDerecha(Ficha ficha){
        int distancia = 15;
        if(!fichas.isEmpty()){
            switch (validarColocacionDerecha(ficha)) {
                case 1 -> {
                    ficha.setPanelFichas(lienzo);
                    colocarPosicionFichaDer(34,0,ficha);
                    fichas.addLast(ficha);
                    fichas.getLast().dibujarEnPanelRotada(-90);
                    System.out.println(fichas);
                    break;
                }
                case 2 -> {
                    ficha.setPanelFichas(lienzo);
                    colocarPosicionFichaDer(43,0,ficha);
                    fichas.addLast(ficha);
                    fichas.getLast().dibujarEnPanelRotada(-90);
                    System.out.println(fichas);
                    break;
                }
                case 3 -> {
                    ficha.setPanelFichas(lienzo);
                    colocarPosicionFichaDer(34,0,ficha);
                    fichas.addLast(ficha);
                    fichas.getLast().dibujarEnPanelRotada(90);
                    this.numeroDerecha = ficha.getNumeroSuperior();
                    System.out.println(fichas);
                    break;
                }
                case 4 -> {
                    ficha.setPanelFichas(lienzo);
                    colocarPosicionFichaDer(43,0,ficha);
                    fichas.addLast(ficha);
                    fichas.getLast().dibujarEnPanelRotada(90);
                    this.numeroDerecha = ficha.getNumeroSuperior();
                    System.out.println(fichas);
                    break;
                }
                case 5 -> {
                    ficha.setPanelFichas(lienzo);
                    colocarPosicionFichaDer(34,0,ficha);
                    fichas.addLast(ficha);
                    fichas.getLast().dibujarEnPanel();
                    System.out.println(fichas);
                    this.numeroDerecha = ficha.getNumeroSuperior();
                    break;
                }
                case 6 -> {
                    ficha.setPanelFichas(lienzo);
                    colocarPosicionFichaDer(34,0,ficha);
                    fichas.addLast(ficha);
                    fichas.getLast().dibujarEnPanel();
                    this.numeroDerecha = ficha.getNumeroSuperior();
                    System.out.println(fichas);
                    break;
                }
                
                default -> {
                    //Declaraciones ejecutadas cuando ninguno de los valores coincide con el valor de la expresión
                    break;
                }
              }
            
        }else 
        if(fichas.isEmpty()){
            this.numeroDerecha = ficha.getNumeroInferior();
            this.numeroIzquierda = ficha.getNumeroInferior();
            ficha.setPanelFichas(lienzo);
            ficha.setPosicionX(171-22);
            ficha.setPosicionY(120-22);
            fichas.addLast(ficha);
            fichas.getLast().dibujarEnPanel();
            
            
        }
        
        
     }
    public void agregarFichaIizquierda(Ficha ficha){
        int distancia = 15;
        if(!fichas.isEmpty()){
            switch (validarColocacionIzquierda(ficha)) {
                case 1 -> {
                    ficha.setPanelFichas(lienzo);
                    colocarPosicionFichaIzq(-34,0,ficha);
                    fichas.addFirst(ficha);
                    fichas.getFirst().dibujarEnPanelRotada(90);
                    break;
                }
                case 2 -> {
                    ficha.setPanelFichas(lienzo);
                    colocarPosicionFichaIzq(-43,0,ficha);
                    fichas.addFirst(ficha);
                    fichas.getFirst().dibujarEnPanelRotada(90);
                    break;
                }
                case 3 -> {
                    ficha.setPanelFichas(lienzo);
                    colocarPosicionFichaIzq(-34,0,ficha);
                    fichas.addFirst(ficha);
                    fichas.getFirst().dibujarEnPanelRotada(-90);
                    break;
                }
                case 4 -> {
                    ficha.setPanelFichas(lienzo);
                    colocarPosicionFichaIzq(-43,0,ficha);
                    fichas.addFirst(ficha);
                    fichas.getFirst().dibujarEnPanelRotada(-90);
                    break;
                }
                case 5 -> {
                    ficha.setPanelFichas(lienzo);
                    colocarPosicionFichaIzq(-34,0,ficha);
                    fichas.addFirst(ficha);
                    fichas.getFirst().dibujarEnPanel();
                    break;
                }
                case 6 -> {
                    ficha.setPanelFichas(lienzo);
                    colocarPosicionFichaIzq(-34,0,ficha);
                    fichas.addFirst(ficha);
                    fichas.getFirst().dibujarEnPanel();
                    break;
                }
                
                default -> {
                    //Declaraciones ejecutadas cuando ninguno de los valores coincide con el valor de la expresión
                    break;
                }
              }
            
        }else 
        if(fichas.isEmpty()){
            ficha.setPanelFichas(lienzo);
            ficha.setPosicionX(171-22);
            ficha.setPosicionY(120-22);
            fichas.addFirst(ficha);
            fichas.getFirst().dibujarEnPanel();
        }
        
        
     }
    public int validarColocacionDerecha(Ficha ficha)
    {
        //eesta es para saber si se puede utilizar el numero inferior del ultima ficha
        if(fichas.size() == 1){
            if( fichas.getLast().getNumeroSuperior() == ficha.getNumeroSuperior()  )
            { 
//              
                if( fichas.getLast().getNumeroSuperior() == fichas.getLast().getNumeroInferior())
                {
                    if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                    {
                        return 5;
                    }
                    return 1;
                    
                }
                
                if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                {
                    return 6;
                }
                return 2;
            }
            if( fichas.getLast().getNumeroInferior() == ficha.getNumeroSuperior()  )
            {

                if( fichas.getLast().getNumeroSuperior() == fichas.getLast().getNumeroInferior())
                {
                    return 1;
                }
                return 2;
            }
            if(fichas.getLast().getNumeroInferior() == ficha.getNumeroInferior())
            {
                if( fichas.getLast().getNumeroSuperior() == fichas.getLast().getNumeroInferior())
                {
                    if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                    {
                        return 5;
                    }
                    return 3;
                }
                if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                {
                    return 6;
                }
                return 4;
            }
        }
        else
        if(fichas.get(fichas.size()-2).getNumeroInferior() == fichas.getLast().getNumeroInferior()||fichas.get(fichas.size()-2).getNumeroSuperior()== fichas.getLast().getNumeroInferior())
        {
           //este no entra
            if( fichas.getLast().getNumeroSuperior() == ficha.getNumeroSuperior()  )
            { 
//                if(fichas.getLast().getPosicionX()+90>= lienzo.getWidth()){
//                    System.out.println("sesalio"+ fichas.getLast().getPosicionX());
//                     return 7;
//                }
                //esta es pa la mula
                if( fichas.getLast().getNumeroSuperior() == fichas.getLast().getNumeroInferior())
                {
                    if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                    {
                        return 5;
                    }
                    return 1;
                    
                }
                
                if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                {
                    return 6;
                }
                return 2;
            }
            //este no entra
            if(fichas.getLast().getNumeroSuperior() == ficha.getNumeroInferior())
            {
//                 if(fichas.getLast().getPosicionX()+90>= lienzo.getWidth()){
//                    System.out.println("sesalio"+ fichas.getLast().getPosicionX());
//                    return 7;
//                }
                if( fichas.getLast().getNumeroSuperior() == fichas.getLast().getNumeroInferior())
                {
                    if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                    {
                        return 5;
                    }
                    return 3;
                }
                if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                {
                    return 6;
                }
                return 4;
            }
        }else
        if( fichas.get(fichas.size()-2).getNumeroInferior() == fichas.getLast().getNumeroSuperior()||fichas.get(fichas.size()-2).getNumeroSuperior()== fichas.getLast().getNumeroSuperior())
            {
            if( fichas.getLast().getNumeroInferior() == ficha.getNumeroSuperior()  )
            {
//                 if(fichas.getLast().getPosicionX()+90>= lienzo.getWidth()){
//                    System.out.println("sesalio"+ fichas.getLast().getPosicionX());
//                    return 7;
//                }
                if( fichas.getLast().getNumeroSuperior() == fichas.getLast().getNumeroInferior())
                {
                    return 1;
                }
                return 2;
            }
            if(fichas.getLast().getNumeroInferior() == ficha.getNumeroInferior())
            {
//                 if(fichas.getLast().getPosicionX()+90>= lienzo.getWidth()){
//                    System.out.println("sesalio"+ fichas.getLast().getPosicionX());
//                    return 7;
//                }
                if( fichas.getLast().getNumeroSuperior() == fichas.getLast().getNumeroInferior())
                {
                    if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                    {
                        return 5;
                    }
                    return 3;
                }
                if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                {
                    return 6;
                }
                return 4;
            }
            }
        System.out.println("cago"+fichas.get(fichas.size()-1).getNumeroSuperior()+fichas.getLast().getNumeroSuperior());
        return 0;
    }
    public int validarColocacionIzquierda(Ficha ficha)
    {
        
        if(fichas.get(1).getNumeroInferior() == fichas.getFirst().getNumeroInferior()||fichas.get(1).getNumeroSuperior()== fichas.getFirst().getNumeroInferior())
        {
            System.out.println("entroaaa");
            if( fichas.getFirst().getNumeroSuperior() == ficha.getNumeroSuperior()  )
            { 
//                if(fichas.getLast().getPosicionX()+90>= lienzo.getWidth()){
//                    System.out.println("sesalio"+ fichas.getLast().getPosicionX());
//                     return 7;
//                }
                if( fichas.getFirst().getNumeroSuperior() == fichas.getFirst().getNumeroInferior())
                {
                    if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                    {
                        return 5;
                    }
                    return 1;
                    
                }
                if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                {
                    return 6;
                }
                return 2;
            }
            if(fichas.getFirst().getNumeroSuperior() == ficha.getNumeroInferior())
            {
//                 if(fichas.getLast().getPosicionX()+90>= lienzo.getWidth()){
//                    System.out.println("sesalio"+ fichas.getLast().getPosicionX());
//                    return 7;
//                }
                if( fichas.getFirst().getNumeroSuperior() == fichas.getFirst().getNumeroInferior())
                {
                    if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                    {
                        return 5;
                    }
                    return 3;
                }
                if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                {
                    return 6;
                }
                return 4;
            }
        } 
        if( fichas.get(1).getNumeroInferior() == fichas.getFirst().getNumeroSuperior()||fichas.get(1).getNumeroSuperior()== fichas.getFirst().getNumeroSuperior())
            {
            if( fichas.getLast().getNumeroInferior() == ficha.getNumeroSuperior()  )
            {
//                 if(fichas.getLast().getPosicionX()+90>= lienzo.getWidth()){
//                    System.out.println("sesalio"+ fichas.getLast().getPosicionX());
//                    return 7;
//                }
                if( fichas.getFirst().getNumeroSuperior() == fichas.getFirst().getNumeroInferior())
                {
                    return 1;
                }
                return 2;
            }
            if(fichas.getLast().getNumeroInferior() == ficha.getNumeroInferior())
            {
//                 if(fichas.getLast().getPosicionX()+90>= lienzo.getWidth()){
//                    System.out.println("sesalio"+ fichas.getLast().getPosicionX());
//                    return 7;
//                }
                if( fichas.getFirst().getNumeroSuperior() == fichas.getFirst().getNumeroInferior())
                {
                    if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                    {
                        return 5;
                    }
                    return 3;
                }
                if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                {
                    return 6;
                }
                return 4;
            }
            }
        System.out.println("cago"+fichas.get(fichas.size()-1).getNumeroSuperior()+fichas.getLast().getNumeroSuperior());
        return 0;
    }
    public void agregarFichaIzquierda(Ficha ficha){
         
    }
}
