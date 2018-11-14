
package proyectojarra;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import vistas.JarraView;

public class LlenarJarras implements Runnable{
    
    private JLabel lblCantidadAgua1;
    private JLabel lblCantidadAgua2;
    private JLabel lblCantidadAgua3;
    private JLabel lblJarra1;
    private JLabel lblJarra2;
    private JLabel lblJarra3;
    
    ImageIcon jarraVacia = new ImageIcon(getClass().getResource("/imagenes/jarravacia.jpeg"));
    ImageIcon jarraLlena = new ImageIcon(getClass().getResource("/imagenes/jarraLLena.jpeg"));

    private ArrayList<Proceso> listaProceso;
    
    public LlenarJarras(JLabel lblCantidadAgua1,
                        JLabel lblCantidadAgua2,
                        JLabel lblCantidadAgua3,
                        JLabel lblJarra1,
                        JLabel lblJarra2,
                        JLabel lblJarra3,
                        ArrayList<Proceso> listaProceso) {
        this.lblCantidadAgua1 = lblCantidadAgua1;
        this.lblCantidadAgua2 = lblCantidadAgua2;
        this.lblCantidadAgua3 = lblCantidadAgua3;
        this.lblJarra1 = lblJarra1;
        this.lblJarra2 = lblJarra2;
        this.lblJarra3 = lblJarra3;
        this.listaProceso = listaProceso;

    }
    @Override
    public void run() {
        try {
            for (Proceso proceso : listaProceso) {
                this.lblCantidadAgua1.setText(proceso.getValor1());
                this.lblCantidadAgua2.setText(proceso.getValor2());
                this.lblCantidadAgua3.setText(proceso.getValor3());
                
                this.lblJarra1.setIcon(proceso.getValor1().equals("0") ? jarraVacia : jarraLlena);
                this.lblJarra2.setIcon(proceso.getValor2().equals("0") ? jarraVacia : jarraLlena);
                this.lblJarra3.setIcon(proceso.getValor3().equals("0") ? jarraVacia : jarraLlena);
                
                Thread.sleep(3000);
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(LlenarJarras.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
