/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.servidordominoacmp;

import java.util.ArrayList;
import java.util.List;
import org.itson.libreriatiposdominoacmp.FichaDTO;

/**
 *
 * @author Gabriel Mancinas
 */
public class PozoServidor {

    List<FichaDTO> fichas;

    public PozoServidor() {
        this.reiniciarPozo();
    }

    public void reiniciarPozo() {
        this.fichas = new ArrayList();
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                String rutaImagen = String.format("/imgFrmPartidaFichas/ficha%d_%d.png", i, j);
                FichaDTO ficha = new FichaDTO(i, j, rutaImagen);
                fichas.add(ficha);
            }
        }
    }

    public List<FichaDTO> getFichas() {
        return fichas;
    }

    public FichaDTO devolverFicha() {
        int numeroRandom = (int) (Math.random() * getFichas().size() + 0);
        return fichas.get(numeroRandom);
    }

    public Boolean verificarNumFichas() {
        return fichas.isEmpty();
    }

    public void eliminarFicha(FichaDTO ficha) {
        fichas.remove(ficha);
    }

    public List<FichaDTO> repartirFichas(int numFichas) {
        List<FichaDTO> fichasRepartidas = new ArrayList();
        for (int j = 0; j < numFichas; j++) {
            FichaDTO ficha;
            ficha = devolverFicha();
            eliminarFicha(ficha);
            fichasRepartidas.add(ficha);
        }
        return fichasRepartidas;
    }

    public void agregarFichas(List<FichaDTO> fichas) {
        this.fichas.addAll(fichas);
    }
}
