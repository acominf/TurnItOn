package es.emeaelemal;

/**
 * Created by Der on 5/16/2017.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Hayley {
    private Sprite skin;
    int x,y;

    public Hayley(int x, int y)
    {
        this.x=x;
        this.y=y;
        skin = new Sprite(new Texture(Gdx.files.internal("HW.png")),25,34);
    }

    public void render(final SpriteBatch b)
    {
        b.draw(skin,x,y);
    }
}
