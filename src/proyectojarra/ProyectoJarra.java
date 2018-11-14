
package proyectojarra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import vistas.JarraView;

public class ProyectoJarra {
    
    private JLabel lblCantidadAgua1;
    private JLabel lblCantidadAgua2;
    private JLabel lblCantidadAgua3;
    private JarraView jarraView;
    private ArrayList<Proceso> listaProcesos = new ArrayList<>();
            

    public ProyectoJarra(JLabel lblCantidadAgua1, JLabel lblCantidadAgua2, JLabel lblCantidadAgua3, JarraView jarraView) {
        this.lblCantidadAgua1 = lblCantidadAgua1;
        this.lblCantidadAgua2 = lblCantidadAgua2;
        this.lblCantidadAgua3 = lblCantidadAgua3;
        this.jarraView = jarraView;
    }
    

    public void iniciarJArras(int capacidad1, int capacidad2, int capacidad3) {
        Jarra jarraA = new Jarra(capacidad1, true);
        Jarra jarraB = new Jarra(capacidad2, false);
        Jarra jarraC = new Jarra(capacidad3, false);
        
        Jarra [] jarras = {jarraA, jarraB, jarraC};
        
        ArrayList<Jarra> listaJarras = new ArrayList(Arrays.asList(jarras));
        this.vaciarJarras(listaJarras);
        //si las jarras aun no estan iguales renviar a vaciar
        if (listaJarras.get(0).cantidadAgua() != listaJarras.get(1).cantidadAgua()) {
            this.moverAgua(listaJarras.get(1), listaJarras.get(2));
            this.vaciarJarras(listaJarras);
        }
        
        
        LlenarJarras llenarJarras = new LlenarJarras(lblCantidadAgua1,
                        lblCantidadAgua2,
                        lblCantidadAgua3,
                        listaProcesos);
        
        //iniciar pintando en la vista
        Thread thread = new Thread(llenarJarras);
        thread.start();
    }

    //mover el valor menor de las jarras a la jarra Menor
    public void vaciarJarras(ArrayList<Jarra> listaJarras){
        for (int i = 0; i < listaJarras.size(); i++) {
            Jarra jarraSiguiente;
            //verificar que la jarra siguiente tenga capacidad
            if (i  == listaJarras.size() - 1) {
               //si estamos en la ultima jarra agregar la siguiente a la primera
               jarraSiguiente = listaJarras.get(0);
            } else {
               jarraSiguiente = listaJarras.get(i + 1);
            }
            if (jarraSiguiente.tieneCapcidad()){
                this.moverAgua(listaJarras.get(i), jarraSiguiente);
            }
            Proceso proceso = new Proceso(String.valueOf(listaJarras.get(0).cantidadAgua()),
                    String.valueOf(listaJarras.get(1).cantidadAgua()),
                    String.valueOf(listaJarras.get(2).cantidadAgua())
            );
            listaProcesos.add(proceso);
            System.out.println(" " + listaJarras.get(0).cantidadAgua() + "  " + listaJarras.get(1).cantidadAgua()  + "  " + listaJarras.get(2).cantidadAgua());
            //salir del sistema cuando encuentre el resultado
            if (listaJarras.get(0).cantidadAgua() == listaJarras.get(1).cantidadAgua()) break;
        }
    }

    public void moverAgua(Jarra jarra1, Jarra jarra2 ){
        //pasar agua de una jarra a otra
        while(jarra2.tieneCapcidad() && jarra1.tieneAgua()) {
            jarra1.quitarAgua();
            jarra2.agregarAgua();
        }
    }
    
}
