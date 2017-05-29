package es.emeaelemal;

import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

/**
 * Created by Daniel on 5/28/2017.
 */
public class Condicional extends Label {

    private Rectangle cond;
    private Rectangle acc;

    public Condicional(int x, int y, String name, int b, int h, int indice) {
        super(x, y, name, b, h, indice);
        cond= new Rectangle(x+23,y+181-81,175,45);
        acc=  new Rectangle(x+16,y+181-159,187,49);
    }

    public int ejecutar(ArrayList<Condicion> conde, ArrayList<Accion> acc)
    {
        this.cond.setPosition(x+23,y+181-81);
        this.acc.setPosition(x+16,y+181-159);
        int estado=0;
        Boolean aux = false;
        for(Condicion cc:conde)
        {
            //System.out.println(cc.x+"   "+cc.y);
            if(cond.overlaps(cc.jeje))
            {
                //System.out.println(cond.x+"   "+cond.y);

                aux=cc.checarCondicion();
            }
        }
        for(Accion ac:acc)
        {
            if(this.acc.overlaps(ac.jeje))
            {


                if(aux==true)
                {
                    //System.out.println(this.acc.x+" lala  "+this.acc.y);
                    estado=ac.ejecutar();
                }
            }
        }
        return estado;
    }

}
