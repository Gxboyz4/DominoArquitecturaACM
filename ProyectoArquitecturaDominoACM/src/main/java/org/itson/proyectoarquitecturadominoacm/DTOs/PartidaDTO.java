/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectoarquitecturadominoacm.DTOs;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Gabriel Mancinas
 */
public class PartidaDTO implements Serializable{
    

    List<JugadorDTO> jugadores;
    
    public PartidaDTO(List<JugadorDTO> jugadores){
        this.jugadores=jugadores;
    }  
}
