package es.emeaelemal;

/**
 * Created by Daniel on 5/28/2017.
 */
public class Accion extends Label {
    private int num;
    public Accion(int x, int y, String name, int b, int h, int indice,int num) {
        super(x, y, name, b, h, indice);
        this.num=num;
    }

    public int ejecutar(){
     return num;
    }
}
