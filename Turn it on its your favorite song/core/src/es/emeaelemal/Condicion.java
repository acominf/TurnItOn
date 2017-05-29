package es.emeaelemal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Daniel on 5/28/2017.
 */
public class Condicion extends Label {

    private int num;
    public boolean unicef;

    public Condicion(int x, int y, String name, int b, int h, int indice,int num) {
        super(x, y, name, b, h, indice);
        this.num=num;
    }

    public void render(final SpriteBatch b, boolean grab[], boolean dibujar,boolean condusef[])
    {
        super.render(b,grab,dibujar);
        unicef=condusef[num];

    }

    public boolean checarCondicion()
    {
            return unicef;
    }
}
