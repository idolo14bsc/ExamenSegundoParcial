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
public class Aristas {
    private ArrayList<Arista> aristas = new ArrayList<Arista>();
    
    public void añade(Arista a) {
        aristas.add(a);
    }
    
    public Arista arista (int i) {
        if(i<0 || i>aristas.size())
            return null;
        return aristas.get(i);
    }
}
