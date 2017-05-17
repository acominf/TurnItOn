package es.emeaelemal;

/**
 * Created by Daniel on 5/16/2017.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Hayley {
    private Animation animacion[];
    private float clock;
    private TextureRegion [][] movimiento;
    private Texture imagen;
    private TextureRegion activo;
    private int speed;
    int x,y;

    public Hayley(int x, int y)
    {
        imagen = new Texture(Gdx.files.internal("HW.png"));
        this.speed=7;
        this.x=x;
        this.y=y;
        this.animaciones();
    }

    public void render(final SpriteBatch b)
    {
        moverLados(b);
    }
    public void moverDir(final SpriteBatch b,int dir){
        clock+= Gdx.graphics.getDeltaTime();
        activo = (TextureRegion) animacion[dir].getKeyFrame(clock,true);
        b.draw(activo,x,y,100,100);
    }
    public void moverLados(final SpriteBatch b){
        int i=-1;
        int inc=speed;
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            i=3;
            x-=inc;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            i=1;
            x+=inc;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            i=0;
            y+=inc;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            i=2;
            y-=inc;
        }
        if(i==-1){
            b.draw(activo,x,y,100,100);
        }
        else{
            moverDir(b,i);
        }

    }
    public void animaciones()
    {
        animacion= new Animation[4];
        TextureRegion [] [] temp = TextureRegion.split(imagen,24,32);
        movimiento= new TextureRegion[4][3];
        for(int j=0;j<4;j++)
        {
            for (int i = 3; i < 6; i++) {
                movimiento[j][i-3] = temp[j][i];
            }
        }
        animacion[0] = new Animation(.1f,movimiento[0]);
        animacion[1] = new Animation(.1f,movimiento[1]);
        animacion[2] = new Animation(.1f,movimiento[2]);
        animacion[3] = new Animation(.1f,movimiento[3]);
        clock=0f;
        activo=(TextureRegion) animacion[0].getKeyFrame(clock,true);
    }

}
