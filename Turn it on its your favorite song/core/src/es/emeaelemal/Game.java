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
	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("Hayley.jpg");
		lakitu = new OrthographicCamera();
		lakitu.setToOrtho(false,800,600);
		lakitu.update();
		p1 = new Hayley(400,300);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		lakitu.update();
		batch.setProjectionMatrix(lakitu.combined);
		batch.begin();
		p1.render(batch);
		//batch.draw(img, 0, 0);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
