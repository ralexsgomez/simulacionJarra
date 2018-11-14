
package proyectojarra;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import vistas.JarraView;

public class LlenarJarras implements Runnable{
    
    private JLabel lblCantidadAgua1;
    private JLabel lblCantidadAgua2;
    private JLabel lblCantidadAgua3;
    private ArrayList<Proceso> listaProceso;
    
    public LlenarJarras(JLabel lblCantidadAgua1,
                        JLabel lblCantidadAgua2,
                        JLabel lblCantidadAgua3,
                        ArrayList<Proceso> listaProceso) {
        this.lblCantidadAgua1 = lblCantidadAgua1;
        this.lblCantidadAgua2 = lblCantidadAgua2;
        this.lblCantidadAgua3 = lblCantidadAgua3;
        this.listaProceso = listaProceso;

    }
    @Override
    public void run() {
        try {
            for (Proceso proceso : listaProceso) {
                this.lblCantidadAgua1.setText(proceso.getValor1());
                this.lblCantidadAgua2.setText(proceso.getValor2());
                this.lblCantidadAgua3.setText(proceso.getValor3());
                Thread.sleep(3000);
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(LlenarJarras.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
