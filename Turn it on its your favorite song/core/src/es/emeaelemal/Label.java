package es.emeaelemal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Daniel on 5/16/2017.
 */
public class Label {
    private int x;
    private int y;
    private Texture skin;
    private int alto;
    private int ancho;
    private boolean grab;

    public Label(int x,int y,String name,int b,int h)
    {
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
                grab=true;
                return true;
            }
        }
        grab=false;
        return false;
    }

    public boolean render(final SpriteBatch b,boolean grab)
    {
        if (grab==false)
            check();
      b.draw(skin,x,y);
      return this.grab;

    }
    public void check(){

        if (this.isClicked()) {
            this.x = Gdx.input.getX()-ancho/2;
            this.y = (Gdx.graphics.getHeight() - Gdx.input.getY())-alto/2;
        }
    }
}
