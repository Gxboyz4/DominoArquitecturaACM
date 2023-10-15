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
    private final int falso = 0;
    private final int primerCaso = 1;
    private final int segundoCaso = 2;
    private final int tercerCaso = 3;
    private final int cuartoCaso = 4;
    private final int quintoCaso = 5;
    private final int sextoCaso = 6;
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
    public void colocarPosicionFichaDer(int desplazamientoX,int desplazamientoY,Ficha ficha,int grados)
    {
        ficha.setPanelFichas(lienzo);
        int x = fichas.getLast().getPosicionX();
        int y = fichas.getLast().getPosicionY();
        ficha.setPosicionX(x+desplazamientoX);
        ficha.setPosicionY(y+desplazamientoY);
        fichas.addLast(ficha);
        fichas.getLast().dibujarEnPanelRotada(grados);
        
    }

    public void agregarFichaDerecha(Ficha ficha){
        int distancia = 15;
        
        if(!fichas.isEmpty()){
            switch (validarColocacionDerecha(ficha)) {
                case 1 -> {
                    colocarPosicionFichaDer(34,0,ficha,-90);
                    this.numeroDerecha = ficha.getNumeroInferior();
                    break;
                }
                case 2 -> {
                    colocarPosicionFichaDer(43,0,ficha,-90);
                    this.numeroDerecha = ficha.getNumeroInferior();
                    break;
                }
                case 3 -> {
                    colocarPosicionFichaDer(34,0,ficha,90);
                    this.numeroDerecha = ficha.getNumeroSuperior();
                    break;
                }
                case 4 -> {
                    colocarPosicionFichaDer(43,0,ficha,90);
                    this.numeroDerecha = ficha.getNumeroSuperior();
                    break;
                }
                case 5 -> {
                    colocarPosicionFichaDer(34,0,ficha,0);
                    this.numeroDerecha = ficha.getNumeroSuperior();
                    break;
                }
                case 6 -> {
                    colocarPosicionFichaDer(34,0,ficha,0);
                    this.numeroDerecha = ficha.getNumeroSuperior();
                    break;
                }
                
                default -> {
                    //Declaraciones ejecutadas cuando ninguno de los valores coincide con el valor de la expresión
                    break;
                }
              }
            
        }else 
        if(fichas.isEmpty()){
            this.numeroDerecha = ficha.getNumeroSuperior();
            this.numeroIzquierda = ficha.getNumeroInferior();
            ficha.setPanelFichas(lienzo);
            ficha.setPosicionX(171-22);
            ficha.setPosicionY(120-22);
            fichas.addLast(ficha);
            fichas.getLast().dibujarEnPanel();
            
            
        }
        System.out.println(numeroDerecha);
        
     }
        public void colocarPosicionFichaIzq(int desplazamientoX,int desplazamientoY,Ficha ficha,int grados)
    {
        ficha.setPanelFichas(lienzo);
        int x = fichas.getFirst().getPosicionX();
        int y = fichas.getFirst().getPosicionY();
        ficha.setPosicionX(x+desplazamientoX);
        ficha.setPosicionY(y+desplazamientoY);
        fichas.addFirst(ficha);
        fichas.getFirst().dibujarEnPanelRotada(grados);
    }
 
    public void agregarFichaIzquierda(Ficha ficha){

        int distancia = 15;
        if(!fichas.isEmpty()){
            switch (validarColocacionIzquierda(ficha)) {
                case 1 -> {
                    ficha.setPanelFichas(lienzo);
                    colocarPosicionFichaIzq(-34,0,ficha,90);
                    this.numeroIzquierda = ficha.getNumeroInferior();
                    break;
                }
                case 2 -> {
                    colocarPosicionFichaIzq(-43,0,ficha,90);
                    this.numeroIzquierda = ficha.getNumeroInferior();
                    break;
                }
                case 3 -> {
                    ficha.setPanelFichas(lienzo);
                    colocarPosicionFichaIzq(-34,0,ficha,-90);
                    this.numeroIzquierda = ficha.getNumeroSuperior();
                    break;
                }
                case 4 -> {
                    colocarPosicionFichaIzq(-43,0,ficha,-90);
                    this.numeroIzquierda = ficha.getNumeroSuperior();
                    break;
                }
                case 5 -> {
                    colocarPosicionFichaIzq(-34,0,ficha,0);
                    this.numeroIzquierda = ficha.getNumeroSuperior();
                    break;
                }
                case 6 -> {
                    colocarPosicionFichaIzq(-34,0,ficha,0);
                    this.numeroIzquierda = ficha.getNumeroSuperior();
                    break;
                }
                
                default -> {
                    //Declaraciones ejecutadas cuando ninguno de los valores coincide con el valor de la expresión
                    break;
                }
              }
            
        }else 
        if(fichas.isEmpty()){
            this.numeroDerecha = ficha.getNumeroSuperior();
            this.numeroIzquierda = ficha.getNumeroInferior();
            ficha.setPanelFichas(lienzo);
            ficha.setPosicionX(171-22);
            ficha.setPosicionY(120-22);
            fichas.addLast(ficha);
            fichas.getLast().dibujarEnPanel();
            
            //No pongan nada aqui 😎
        }
        
                System.out.println(numeroIzquierda+"IZQUIERDAAAAAAA");
               System.out.println(fichas);
     }
    public int validarColocacionDerecha(Ficha ficha)
    {
        if(fichas.size() == 0)
        {
            return sextoCaso;
        }
        if(fichas.getLast().equals(ficha))
        {
            return falso;
        }
        if(fichas.size() == 1)
        {
            if(this.numeroDerecha == ficha.getNumeroInferior())
            {
                if( fichas.getLast().getNumeroSuperior() == fichas.getLast().getNumeroInferior())
                    {
                        if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                        {
                            return quintoCaso;
                        }
                        return tercerCaso;
                    }
                    if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                    {
                        return sextoCaso;
                    }
                    return cuartoCaso;
            }
            if(this.numeroDerecha == ficha.getNumeroSuperior())
            {
                if( fichas.getLast().getNumeroSuperior() == fichas.getLast().getNumeroInferior())
                    {
                        if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                        {
                            return quintoCaso;
                        }
                        return primerCaso;

                    }

                    if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                    {
                        return sextoCaso;
                    }
                    return segundoCaso;
            }
            if(this.numeroIzquierda == ficha.getNumeroInferior())
            {
                if( fichas.getLast().getNumeroSuperior() == fichas.getLast().getNumeroInferior())
                    {
                        if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                        {
                            return quintoCaso;
                        }
                        return tercerCaso;
                    }
                    if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                    {
                        return sextoCaso;
                    }
                    return cuartoCaso;
            }
            if(this.numeroIzquierda == ficha.getNumeroSuperior())
            {
                if( fichas.getLast().getNumeroSuperior() == fichas.getLast().getNumeroInferior())
                    {
                        if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                        {
                            return quintoCaso;
                        }
                        return primerCaso;

                    }

                    if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                    {
                        return sextoCaso;
                    }
                    return segundoCaso;
            }
        }
        if(this.numeroDerecha == ficha.getNumeroInferior())
        {
            if( fichas.getLast().getNumeroSuperior() == fichas.getLast().getNumeroInferior())
                {
                    if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                    {
                        return quintoCaso;
                    }
                    return tercerCaso;
                }
                if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                {
                    return sextoCaso;
                }
                return cuartoCaso;
        }
        if(this.numeroDerecha == ficha.getNumeroSuperior())
        {
            if( fichas.getLast().getNumeroSuperior() == fichas.getLast().getNumeroInferior())
                {
                    if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                    {
                        return quintoCaso;
                    }
                    return segundoCaso;
                    
                }
                
                if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                {
                    return sextoCaso;
                }
                return segundoCaso;
        }
        System.out.println("cago"+fichas.get(fichas.size()-1).getNumeroSuperior()+fichas.getLast().getNumeroSuperior());
        return falso;
    }
    public int validarColocacionIzquierda(Ficha ficha)
    {
        if(fichas.size() == 0)
        {
            return sextoCaso;
        }
        if(fichas.getFirst().equals(ficha))
        {
            return falso;
        }
        if(fichas.size() == 1)
        {
            if(this.numeroDerecha == ficha.getNumeroInferior())
            {
                if( fichas.getFirst().getNumeroSuperior() == fichas.getFirst().getNumeroInferior())
                    {
                        if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                        {
                            return quintoCaso;
                        }
                        return tercerCaso;
                    }
                    if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                    {
                        return sextoCaso;
                    }
                    return cuartoCaso;
            }
            if(this.numeroDerecha == ficha.getNumeroSuperior())
            {
                if( fichas.getFirst().getNumeroSuperior() == fichas.getFirst().getNumeroInferior())
                    {
                        if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                        {
                            return quintoCaso;
                        }
                        return primerCaso;

                    }

                    if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                    {
                        return sextoCaso;
                    }
                    return segundoCaso;
            }
            if(this.numeroIzquierda == ficha.getNumeroInferior())
            {
                if( fichas.getFirst().getNumeroSuperior() == fichas.getFirst().getNumeroInferior())
                    {
                        if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                        {
                            return quintoCaso;
                        }
                        return tercerCaso;
                    }
                    if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                    {
                        return sextoCaso;
                    }
                    return cuartoCaso;
            }
            if(this.numeroIzquierda == ficha.getNumeroSuperior())
            {
                if( fichas.getFirst().getNumeroSuperior() == fichas.getFirst().getNumeroInferior())
                    {
                        if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                        {
                            return quintoCaso;
                        }
                        return primerCaso;

                    }

                    if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                    {
                        return sextoCaso;
                    }
                    return segundoCaso;
            }
        }
        if(this.numeroIzquierda == ficha.getNumeroInferior())
        {
            if( fichas.getFirst().getNumeroSuperior() == fichas.getFirst().getNumeroInferior())
                {
                    if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                    {
                        return quintoCaso;
                    }
                    return tercerCaso;
                }
                if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                {
                    return sextoCaso;
                }
                return cuartoCaso;
        }
        if(this.numeroIzquierda == ficha.getNumeroSuperior())
        {
            if( fichas.getFirst().getNumeroSuperior() == fichas.getFirst().getNumeroInferior())
                {
                    if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                    {
                        return quintoCaso;
                    }
                    return primerCaso;
                    
                }
                
                if( ficha.getNumeroSuperior() == ficha.getNumeroInferior())
                {
                    return sextoCaso;
                }
                return segundoCaso;
        }
        System.out.println("cago"+fichas.get(fichas.size()-1).getNumeroSuperior()+fichas.getLast().getNumeroSuperior());
        return falso;
    }

}
