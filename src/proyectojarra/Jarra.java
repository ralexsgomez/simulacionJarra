
package proyectojarra;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Jarra {
    private ArrayList<Integer> litro;
    // 0 es vacio
    // 1 es lleno

    public Jarra(int capacidadLitro, boolean llenar) {
        if (llenar) {
            this.litro = new ArrayList<Integer>(Collections.nCopies(capacidadLitro, 1));
        } else {
           this.litro = new ArrayList<Integer>(Collections.nCopies(capacidadLitro, 0));
        }
    }

    public boolean tieneCapcidad() {
        return this.litro.contains(0);
    }
    
     public boolean tieneAgua() {
        return this.litro.contains(1);
    }

    public void agregarAgua(){
        this.eliminar(0);
        this.litro.add(1);
    }
    
    public void quitarAgua(){
        this.eliminar(1);
        this.litro.add(0);
    }

    public ArrayList getLitro() {
        return litro;
    }
    
    public int cantidadAgua() {
        int count = 0;
        if (!this.litro.contains(1)) return 0;
        for (int i = 0; i < this.litro.size(); i++) {
            if (this.litro.get(i) == 1) count ++;
        }
        return count;
    }
    
    public void eliminar(int number){
        for (int i = 0; i < this.litro.size(); i++) {
            if (this.litro.get(i) == number) {
                this.litro.remove(i);
                break;
            }
        }
    }
    
}
