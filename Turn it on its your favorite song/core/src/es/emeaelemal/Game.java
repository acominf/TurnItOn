package es.emeaelemal;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private OrthographicCamera lakitu;
	private Hayley p1;
	private Label l[];
	//boolean grab=false;
	@Override
	public void create () {
		l = new Label [20];
		batch = new SpriteBatch();
		lakitu = new OrthographicCamera();
		lakitu.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		lakitu.update();
		p1 = new Hayley(400,300);
		l[0]= new Label(100,030,"hurt.png",175,45);
		l[1]= new Label(100,130,"Rabajo.png",175,45);
		l[2]= new Label(100,230,"Rarriba.png",175,45);
		l[3]= new Label(100,330,"Rderecha.png",175,45);
		l[4]= new Label(100,430,"Rizquierda.png",175,45);
		l[5]= new Label(100,430,"while.png",215,116);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		lakitu.update();
		batch.setProjectionMatrix(lakitu.combined);
		batch.begin();
		boolean grab=false;
		grab=l[0].render(batch,grab);
		grab=l[1].render(batch,grab);
		grab=l[2].render(batch,grab);
		grab=l[3].render(batch,grab);
		grab=l[4].render(batch,grab);
		grab=l[5].render(batch,grab);
		p1.render(batch);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
