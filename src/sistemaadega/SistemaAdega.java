/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaadega;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;


/**
 *
 * @author Diego
 */
public class SistemaAdega {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Telas.TelaSplash splash = new Telas.TelaSplash();
        splash.setVisible(true);
    }
    
    public static class MetodosGerais{
        public static void limparCampos(JFrame jframe)
        {
            for (int i=0; i < jframe.getContentPane().getComponentCount(); i++) {   
                Component c = jframe.getContentPane().getComponent(i);   
                if (c instanceof JTextField) {   
                    JTextField field = (JTextField) c;   
                    field.setText("");  
                }
                if(c instanceof JComboBox){
                    JComboBox field = (JComboBox) c;
                    field.setSelectedIndex(0);
                }
                 
        
            }
        }
    }
    
}
