/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccalle.modelo;
import java.awt.GridBagLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.*;

/**
 *
 * @author Casa
 */
public class DialogAñadeAristas extends JDialog {
    
    private JButton bAceptar = new JButton("Aceptar");
    private JButton bOtroPto = new JButton("Otro Punto");
    
    private LinkedList<JTextField> camposTexto = new LinkedList<JTextField>();
    private LinkedList<JLabel> etiquetas = new LinkedList<JLabel>();
    
    private int[] puntos = null;
    
    public DialogAñadeAristas(JFrame owner) {
        super(owner, "Introduce Aristas", true);
        
        setLayout(new GridLayout(0,2));
        
        camposTexto.add(new JTextField());
        etiquetas.add(new JLabel("Punto 0"));
        camposTexto.add(new JTextField());
        etiquetas.add(new JLabel("Punto 1"));
        
        add(bAceptar);
        add(bOtroPto);
        add(etiquetas.get(0));
        add(camposTexto.get(0));
        add(etiquetas.get(1));
        add(camposTexto.get(1));
        
        bAceptar.addActionListener(new ManejadorBotonAceptar());
        bOtroPto.addActionListener(new ManejadorBotonOtroPunto());
        
        pack();
        setResizable(false);
        
    }
    
    public int[] muestra(){
        puntos = null;
        setVisible(true);
        
        while (camposTexto.size() > 2) {
            remove(camposTexto.removeLast());
            remove(etiquetas.removeLast());
        }
        pack();
        return puntos;
    }
    
    private class ManejadorBotonAceptar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            puntos = new int[camposTexto.size()];
            int i=0;
            try {
                for ( i = 0; i < camposTexto.size(); i++)
                    puntos[i] = Integer.parseInt(camposTexto.get(i).getText());
                             
            } catch (NumberFormatException except) {
                puntos = null;
                JOptionPane.showMessageDialog(null, "Error en punto" +i,
                        "Error en los datos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            setVisible(false);
        }
            
    }
    private class ManejadorBotonOtroPunto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JLabel l = new JLabel("Punto" +camposTexto.size());
            etiquetas.add(l);
            add(l);
            JTextField tf = new JTextField();
            camposTexto.add(tf);
            add(tf);
            pack();
        }
        
    }
}
