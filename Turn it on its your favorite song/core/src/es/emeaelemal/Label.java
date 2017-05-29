package es.emeaelemal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Daniel on 5/16/2017.
 */
public class Label {
    public Rectangle jeje;
    protected int x;
    protected int y;
    protected Texture skin;
    protected int alto;
    protected int ancho;
    protected int indice;

    public Label(int x,int y,String name,int b,int h,int indice)
    {
        this.indice=indice;
        jeje=new Rectangle(x,y,b,h);
        this.x=x;
        this.y=y;
        this.alto=h;
        this.ancho=b;
        skin = new Texture(Gdx.files.internal(name));
    }

    public boolean isClicked()
    {
        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){


            if(Gdx.graphics.getHeight()-Gdx.input.getY()>y && Gdx.graphics.getHeight()-Gdx.input.getY()<y+alto && Gdx.input.getX()<x+ancho && Gdx.input.getX()>x)
            {
                return true;
            }
        }
        return false;
    }

    public void render(final SpriteBatch b,boolean grab[],boolean dibujar)
    {
        if(dibujar==true)
            b.draw(skin,x,y);
        else {
            int pls = 0;
            for (int i = 0; i < grab.length; i++) {
                if (grab[i] == false || grab[indice] == grab[i]) {
                } else
                    pls = 1;
            }
            if (pls == 0)
                grab[indice] = check();
        }
    }
    public boolean check(){
        boolean ret=this.isClicked();
        if (ret) {
            this.x = Gdx.input.getX()-ancho/2;
            this.y = (Gdx.graphics.getHeight() - Gdx.input.getY())-alto/2;
            jeje.setPosition(this.x,this.y);
        }
        return ret;
    }
}
