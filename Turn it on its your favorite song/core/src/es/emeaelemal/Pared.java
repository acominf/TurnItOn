package es.emeaelemal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Daniel on 5/25/2017.
 */
public class Pared {
    public Rectangle rect;
    private int x;
    private int y;
    private Texture skin;
    private int alto;
    private int ancho;

    public Pared(int x, int y, int b, int h,String name)
    {
        rect=new Rectangle(x,y,b,h);
        this.x=x;
        this.y=y;
        this.alto=h;
        this.ancho=b;
        skin = new Texture(Gdx.files.internal(name));
    }

    public void render(final SpriteBatch b)
    {
        b.draw(skin,x,y,alto,ancho);
    }
}
