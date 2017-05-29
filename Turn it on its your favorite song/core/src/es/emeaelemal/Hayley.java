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
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

public class Hayley {
    private Rectangle rect;
    private Animation animacion[];
    private float clock;
    private TextureRegion [][] movimiento;
    private Texture imagen;
    private TextureRegion activo;
    private int speed;
    int x,y,oldx,oldy,nivelactual,estado,direccion;


    public Hayley(int x, int y,int nivel)
    {
        direccion=3;
        estado=0;
        nivelactual=nivel;
        rect = new Rectangle(x+15,y,60,32);
        imagen = new Texture(Gdx.files.internal("HW.png"));
        this.speed=7;
        this.x=x;
        this.y=y;
        this.oldx=x;
        this.oldy=y;
        this.animaciones();
    }

    public int render(final SpriteBatch b,ArrayList<Rectangle> r,Pared meta,Pared ins,int estado,boolean camind[],Pared exit)
    {
        this.estado=estado;
        this.oldx=this.x;
        this.oldy=this.y;
        moverLados(b);
        checarColision(r,meta,camind,ins,exit);
        return nivelactual;
    }
    public void moverDir(final SpriteBatch b,int dir){
        clock+= Gdx.graphics.getDeltaTime();
        activo = (TextureRegion) animacion[dir].getKeyFrame(clock,true);
        b.draw(activo,x,y,100,100);
        rect.setPosition(x+15,y);
    }
    public void moverLados(final SpriteBatch b){
        int i=-1;
        int inc=speed;
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)||estado==1){
            i=3;
            x-=inc;
            direccion=1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)||estado==3){
            i=1;
            x+=inc;
            direccion=3;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)||estado==2){
            i=0;
            y+=inc;
            direccion=2;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)||estado==4){
            i=2;
            y-=inc;
            direccion=4;
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

    public void checarColision(ArrayList<Rectangle> r,Pared meta,boolean camind[],Pared ins,Pared exit)
    {
        if(this.rect.overlaps(meta.rect))
        {
            nivelactual++;
        }
        if(nivelactual==10) {
            if(this.rect.overlaps(meta.rect))
            {
                nivelactual++;
            }
         else
            if (this.rect.overlaps(ins.rect)) {
                nivelactual = 8;
            } else if (this.rect.overlaps(exit.rect)) {
                nivelactual = 15;
            }
        }
        for(Rectangle f:r) {
                if (this.rect.overlaps(f)) {
                    this.x = this.oldx;
                    this.y = this.oldy;
                    rect.setPosition(oldx+15, oldy);
                    camind[0]=false;
                    break;
                }
                else
                {
                    camind[0]=true;
                }
        }
    }

}
