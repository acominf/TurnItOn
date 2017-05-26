package es.emeaelemal;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private OrthographicCamera lakitu;
	private Hayley p1;
	private Label l[];
	private ArrayList<Pared> pars;
	private ArrayList<Rectangle> r;
	private Pared meta;
	private int nivel;
	//boolean grab=false;
	@Override
	public void create () {
		nivel=1;
		Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
		//l = new Label [20];
		batch = new SpriteBatch();
		lakitu = new OrthographicCamera();
		lakitu.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		lakitu.update();
		/*pars=new ArrayList<Pared>();
		pars.add(new Pared(500,400,64,64));
		p1 = new Hayley(400,300);
		/*l[0]= new Label(100,030,"hurt.png",175,45);
		l[1]= new Label(100,130,"Rabajo.png",175,45);
		l[2]= new Label(100,230,"Rarriba.png",175,45);
		l[3]= new Label(100,330,"Rderecha.png",175,45);
		l[4]= new Label(100,430,"Rizquierda.png",175,45);
		l[5]= new Label(100,430,"while.png",215,116);
		img=new Texture(Gdx.files.internal("Ground.jpg"));*/
		r = new ArrayList<Rectangle>();
		createnivel1();
		/*for(int i=0;i<6;i++)
		{
	//		r.add(l[i].jeje);
		}*/
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		lakitu.update();
		batch.setProjectionMatrix(lakitu.combined);
		batch.begin();
		batch.draw(img,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		//boolean grab=false;
		/*grab=l[0].render(batch,grab);
		grab=l[1].render(batch,grab);
		grab=l[2].render(batch,grab);
		grab=l[3].render(batch,grab);
		grab=l[4].render(batch,grab);
		grab=l[5].render(batch,grab);*/
		//p1.render(batch,r);
		if(nivel==1) {
			rendernivel1();
		}
		else
		{
			rendernivel2();
		}
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	public void createnivel1()
	{
		meta = new Pared(+64*17,200+64,64,64,"meta.png");
		r.add(meta.rect);
		pars=new ArrayList<Pared>();
		p1 = new Hayley(64+15,200+64,nivel);
		hacerlinea(0,200+64,1,0);
		hacerlinea(0,200,18,0);
		hacerlinea(0,200+2*64,18,0);
		pars.add(meta);
		img=new Texture(Gdx.files.internal("Ground.jpg"));
		for(Pared p:pars){
			r.add(p.rect);
		}
		borderlands();
	}
	public void createnivel2()
	{
		pars.clear();
		r.clear();

		int d=0,xact=100,yact=100,la=64,delay=15;
		p1 = new Hayley(0,100+la,nivel);
		hacerlinea(0, 100-delay, 2, 0);
		for(int i=0;i<5;i++) {
			hacerlinea(xact+delay, yact-delay, 3, d);
			if(d==0){
				xact+=la*3;
			}
			else{
				yact+=la*3;
			}
			d=(d+1)%2;
		}
		hacerlinea(xact, yact-delay, 1, 0);
		xact=100-2*la;
		yact=100+2*la;
		d=0;
		for(int i=0;i<5;i++) {
			hacerlinea(xact, yact, 3, d);
			if(d==0){
				xact+=la*3;
			}
			else{
				yact+=la*3;
			}
			d=(d+1)%2;
		}
		hacerlinea(xact, yact, 3, 0);
		meta = new Pared(xact+la,yact-la,64,64,"meta.png");


		pars.add(meta);
		img=new Texture(Gdx.files.internal("Ground.jpg"));
		for(Pared p:pars){
			r.add(p.rect);
		}
		borderlands();
	}
	public void rendernivel1()
	{
		for(Pared p:pars){
			p.render(batch);
		}
		nivel=p1.render(batch,r,meta);
		if(nivel ==2)
		{
			System.out.println(nivel);
			createnivel2();
		}
	}

	public void rendernivel2()
	{
		for(Pared p:pars){
			p.render(batch);
		}
		nivel=p1.render(batch,r,meta);
	}

	public void borderlands()
	{
		r.add(new Rectangle(0,0,0,Gdx.graphics.getHeight()));
		r.add(new Rectangle(0,0,Gdx.graphics.getWidth(),0));
		r.add(new Rectangle(Gdx.graphics.getWidth(),0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
		r.add(new Rectangle(0,Gdx.graphics.getHeight(),Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
	}
	public void hacerlinea(int x, int y, int largo, int dir){
		//der=0, arr=1
		int la=64;
		for(int i=0;i<largo;i++){
			if(dir==0){
				pars.add(new Pared(x+i*la,y,la,la,"pared.png"));

			}
			else{
				pars.add(new Pared(x,y+i*la,la,la,"pared.png"));
			}
		}
	}
}