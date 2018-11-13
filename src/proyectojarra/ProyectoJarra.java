
package proyectojarra;

import java.util.ArrayList;
import java.util.Arrays;
import vistas.JarraView;

public class ProyectoJarra {

    public static void main(String[] args) {
        new JarraView().setVisible(true);
//        ProyectoJarra pj = new ProyectoJarra();
//        pj.iniciarJArras(32, 20, 12);
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
            } else {
            }
            
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
