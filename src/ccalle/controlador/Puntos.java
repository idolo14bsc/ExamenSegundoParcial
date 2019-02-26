/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccalle.controlador;

import java.util.ArrayList;

/**
 *
 * @author Casa
 */
public class Puntos {
    private ArrayList<Punto> puntos = new ArrayList<Punto>();

    public Puntos() {
    }
    
    public Punto punto(int i) {
        if (i<0 || i>=puntos.size())
            return null;
        return puntos.get(i);
    }
}
