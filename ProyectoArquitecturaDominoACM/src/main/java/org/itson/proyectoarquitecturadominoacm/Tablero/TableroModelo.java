/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.Tablero;

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
//    private List<Ficha> fichasDibujadas;
    
    public TableroModelo(JPanel lienzo){
        this.lienzo = lienzo;
        fichas = new LinkedList<Ficha>();
    }
    
    
    
    public void agregarFichaDerecha(Ficha ficha){
        int distancia = 15;
        if(!fichas.isEmpty()&& validarColocacionDerecha(ficha)){
            
            int x = fichas.getLast().getPosicionX();
            int y = fichas.getLast().getPosicionY();
            ficha.setPosicionX(x+20);
            ficha.setPosicionY(y);
            fichas.addLast(ficha);
            fichas.getLast().dibujarEnPanelUsuario();
        }else if(fichas.isEmpty()){
            ficha.setPosicionX(171-35);
            ficha.setPosicionY(120-35);
            fichas.addLast(ficha);
            fichas.getLast().dibujarEnPanelUsuario();
        }
        
        
     }
    public boolean validarColocacionDerecha(Ficha ficha)
    {
        
        if(fichas.get(fichas.size()-1).getNumeroInferior() == fichas.getLast().getNumeroInferior()||fichas.get(fichas.size()-1).getNumeroSuperior()== fichas.getLast().getNumeroInferior())
        {
            //No se puede utilizar el numero inferior de la ultima ficha
            if( fichas.getLast().getNumeroSuperior() == ficha.getNumeroSuperior() ||  fichas.getLast().getNumeroSuperior() == ficha.getNumeroInferior())
            {
                return true;
            }
        }else if( fichas.get(fichas.size()-1).getNumeroInferior() == fichas.getLast().getNumeroSuperior()||fichas.get(fichas.size()-1).getNumeroSuperior()== fichas.getLast().getNumeroSuperior())
            {
                return true;
            }
        
        return false;
    }
    public void agregarFichaIzquierda(Ficha ficha){
         
    }
}
