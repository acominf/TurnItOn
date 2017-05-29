package es.emeaelemal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

/**
 * Created by Daniel on 5/27/2017.
 */
public class Panel {

    protected int x;
    protected int y;
    protected int letoca;
    protected Texture skin;
    protected int alto;
    protected int ancho;
    private Rectangle play,pause,cond1,cond2,cond3,cond4;
    private boolean go;

    public Panel(int x,int y,int b,int h)
    {
        letoca=1;
        go=false;
        play = new Rectangle(x+432,y+557-65,70,65);
        pause = new Rectangle(x+332,y+557-65,70,65);
        cond1= new Rectangle(x+23,y+557-309,269,238);
        cond2= new Rectangle(x+23+269,y+557-309,269,238);
        cond3= new Rectangle(x+23,y+557-545,269,238);
        cond4= new Rectangle(x+23+269,y+557-545,269,238);
        this.x=x;
        this.y=y;
        this.alto=h;
        this.ancho=b;
        skin = new Texture(Gdx.files.internal("Panel.png"));
    }

    public int render(final SpriteBatch b, ArrayList<Condicional> k, ArrayList<Condicion> conde, ArrayList<Accion> acc,boolean condusef[]) {
        int estado = 0;
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {

            //System.out.println(Gdx.input.getX());

            if (play.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())) {
                this.go = true;
            }
            if (pause.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())) {
                this.go = false;
                letoca=1;
            }
        }
        for (Condicional k1 : k)
        {
            if  (cond1.contains(k1.jeje) && letoca == 1){
                if (go == true) {
                    estado = k1.ejecutar(conde, acc);
                    if (estado == 0) {
                        letoca++;
                        for(Condicion f:conde)
                        {
                            f.unicef=true;
                        }
                        for(int i=0;i<condusef.length;i++)
                        {
                            condusef[i]=true;
                        }
                    }
                }
                else
                    letoca=1;
            }
           if (cond2.contains(k1.jeje) && letoca == 2) {
               if (go == true) {
                   estado = k1.ejecutar(conde, acc);
                   if (estado == 0) {
                       letoca++;
                       for(Condicion f:conde)
                       {
                           f.unicef=true;
                       }
                      for(int i=0;i<condusef.length;i++)
                       {
                           condusef[i]=true;
                       }
                   }
               }
               else
                   letoca=1;
           }
                    if  (cond3.contains(k1.jeje) && letoca == 3){
                        if (go == true) {
                            estado = k1.ejecutar(conde, acc);
                            System.out.println(estado);
                            if (estado == 0) {
                                letoca++;
                                for(Condicion f:conde)
                                {
                                    f.unicef=true;
                                }
                                for(int i=0;i<condusef.length;i++)
                                {
                                    condusef[i]=true;
                                }
                            }
                        }
                        else
                            letoca=1;
                    }
                    if (cond4.contains(k1.jeje) && letoca == 4) {
                        if (go == true) {
                            estado = k1.ejecutar(conde, acc);
                            if (estado == 0) {
                                letoca = 1;
                                go = false;
                                for(Condicion f:conde)
                                {
                                    f.unicef=true;
                                }
                                for(int i=0;i<condusef.length;i++)
                                {
                                    condusef[i]=true;
                                }
                            }
                        }
                        else
                            letoca=1;
                    }
        }
                b.draw(skin, x, y, ancho, alto);
                return estado;
    }
}
