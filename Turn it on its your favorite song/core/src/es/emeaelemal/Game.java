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
	Texture end;
	private OrthographicCamera lakitu;
	private Hayley p1;
	private Label l[];
	private ArrayList<Pared> pars;
	private ArrayList<Rectangle> r;

	private ArrayList<Condicion> cond;
	private ArrayList<Accion> acc;
	private ArrayList<Condicional> k;

	private Pared meta,ins,exit;
	private int nivel,estado;
	private Panel p;
	private boolean grab[];
	private boolean condusef[];
	@Override
	public void create () {
		cond=new ArrayList<Condicion>();
		acc=new ArrayList<Accion>();
		k=new ArrayList<Condicional>();

		estado=0;
		nivel=10;
		Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
		batch = new SpriteBatch();
		lakitu = new OrthographicCamera();
		p = new Panel(795,210,576,557);
		lakitu.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		lakitu.update();
		l = new Label[10];
		grab = new boolean[10];
		condusef= new boolean[5];
		pars=new ArrayList<Pared>();
		for(int i=0;i<l.length;i++) {
			grab[i]=false;
		}
		for(int i=0;i<condusef.length;i++) {
			condusef[i]=true;
		}
		img=new Texture(Gdx.files.internal("Ground.jpg"));
		end=new Texture(Gdx.files.internal("End.png"));
		r = new ArrayList<Rectangle>();
		createnivel0();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		lakitu.update();
		batch.setProjectionMatrix(lakitu.combined);
		batch.begin();
		batch.draw(img,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		if(nivel!=10 && nivel!=8)
			estado=p.render(batch,k,cond,acc,condusef);
		dibujarLabels();
		if(nivel==1) {
			rendernivel1();
		}
		else if(nivel==2)
		{
			rendernivel2();
		}
		else if(nivel==3)
		{
			rendernivel3();
		}
		else if(nivel==4)
		{
			rendernivel4();
		}
		else if(nivel==5)
		{
			rendernivel5();
		}
		else if(nivel==6)
		{
			rendernivel6();
		}
		else if(nivel==7)
		{
				batch.draw(end, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		}
		else if(nivel==8)
		{
			rendernivelins();
		}
		else if(nivel==10)
		{
			rendernivel0();
		}

		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		end.dispose();
	}

	public void createnivel1()
	{
		pars.clear();
		r.clear();
		k.clear();
		cond.clear();
		acc.clear();
		l = new Label[10];
		l[0]=(new Condicional(0,600,"while.png",215,181,5));
		k.add((Condicional) l[0]);
		l[1]=(new Condicion(15,530,"wallnext.png",175,45,0,0));
		cond.add((Condicion) l[1]);
		l[2]=(new Accion(7,420,"Rabajo.png",187,49,1,4));
		acc.add((Accion) l[2]);
		l[3]=(new Accion(450,530,"Rarriba.png",187,49,2,2));
		acc.add((Accion) l[3]);
		l[4]=(new Accion(450,410,"Rderecha.png",187,49,3,3));
		acc.add((Accion) l[4]);
		l[5]=(new Accion(450,470,"Rizquierda.png",187,49,4,1));
		acc.add((Accion) l[5]);
		l[6]=(new Condicional(220,410,"while.png",215,181,6));
		k.add((Condicional) l[6]);
		l[7]=(new Condicion(15,480,"wallnext.png",175,45,7,0));
		cond.add((Condicion) l[7]);
		l[8]=(new Condicional(220,600,"while.png",215,181,8));
		k.add((Condicional) l[8]);
		l[9]=(new Condicional(440,600,"while.png",215,181,9));
		k.add((Condicional) l[9]);
		for(int i=0;i<l.length;i++) {
			r.add(l[i].jeje);
		}
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

		k.clear();
		cond.clear();
		acc.clear();
		l = new Label[10];
		l[0]=(new Condicional(795,15,"while.png",215,181,5));
		k.add((Condicional) l[0]);
		l[1]=(new Condicion(400,215,"wallnext.png",175,45,0,0));
		cond.add((Condicion) l[1]);
		l[2]=(new Accion(150,15,"Rabajo.png",187,49,1,4));
		acc.add((Accion) l[2]);
		l[3]=(new Accion(570,410,"Rarriba.png",187,49,2,2));
		acc.add((Accion) l[3]);
		l[4]=(new Accion(570,350,"Rderecha.png",187,49,3,3));
		acc.add((Accion) l[4]);
		l[5]=(new Accion(570,290,"Rizquierda.png",187,49,4,1));
		acc.add((Accion) l[5]);
		l[6]=(new Condicional(1015,15,"while.png",215,181,6));
		k.add((Condicional) l[6]);
		l[7]=(new Condicion(575,215,"wallnext.png",175,45,7,0));
		cond.add((Condicion) l[7]);
		l[8]=(new Condicional(575,15,"while.png",215,181,8));
		k.add((Condicional) l[8]);
		l[9]=(new Condicional(355,15,"while.png",215,181,9));
		k.add((Condicional) l[9]);
		for(int i=0;i<l.length;i++) {
			r.add(l[i].jeje);
		}
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
	public void createnivel3()
	{
		pars.clear();
		r.clear();

		k.clear();
		cond.clear();
		acc.clear();
		l = new Label[10];
		l[0]=(new Condicional(795,15,"while.png",215,181,5));
		k.add((Condicional) l[0]);
		l[1]=(new Condicion(400,215,"wallnext.png",175,45,0,0));
		cond.add((Condicion) l[1]);
		l[2]=(new Accion(350,15,"Rabajo.png",187,49,1,4));
		acc.add((Accion) l[2]);
		l[3]=(new Accion(550,15,"Rarriba.png",187,49,2,2));
		acc.add((Accion) l[3]);
		l[4]=(new Accion(350,115,"Rderecha.png",187,49,3,3));
		acc.add((Accion) l[4]);
		l[5]=(new Accion(550,115,"Rizquierda.png",187,49,4,1));
		acc.add((Accion) l[5]);
		l[6]=(new Condicional(1015,15,"while.png",215,181,6));
		k.add((Condicional) l[6]);
		l[7]=(new Condicion(575,215,"wallnext.png",175,45,7,0));
		cond.add((Condicion) l[7]);
		l[8]=(new Condicional(575,-300,"while.png",215,181,8));
		k.add((Condicional) l[8]);
		l[9]=(new Condicional(355,-300,"while.png",215,181,9));
		k.add((Condicional) l[9]);
		for(int i=0;i<l.length;i++) {
			r.add(l[i].jeje);
		}
		int d=0,xact=100,yact=100,la=64,delay=15;
		p1 = new Hayley(60,428,nivel);
		hacerlinea(0, 300, 4, 1);
		hacerlinea(0,300,10,0);
		hacerlinea(640, 300, 4, 1);
		hacerlinea(0,492,10,0);
		meta = new Pared(560,428,64,64,"meta.png");
		pars.add(new Pared(64,364,64,64,"Pared.png"));
		pars.add(new Pared(202,428,64,64,"Pared.png"));
		pars.add(new Pared(345,364,64,64,"Pared.png"));
		pars.add(new Pared(485,428,64,64,"Pared.png"));
		pars.add(meta);
		img=new Texture(Gdx.files.internal("Ground.jpg"));
		for(Pared p:pars){
			r.add(p.rect);
		}
		borderlands();
	}

	public void createnivel4()
	{
		pars.clear();
		r.clear();

		k.clear();
		cond.clear();
		acc.clear();
		l = new Label[10];
		l[0]=(new Condicional(795,15,"while.png",215,181,5));
		k.add((Condicional) l[0]);
		l[1]=(new Condicion(400,215,"wallnext.png",175,45,0,0));
		cond.add((Condicion) l[1]);
		l[2]=(new Accion(150,15,"Rabajo.png",187,49,1,4));
		acc.add((Accion) l[2]);
		l[3]=(new Accion(570,410,"Rarriba.png",187,49,2,2));
		acc.add((Accion) l[3]);
		l[4]=(new Accion(570,350,"Rderecha.png",187,49,3,3));
		acc.add((Accion) l[4]);
		l[5]=(new Accion(570,290,"Rizquierda.png",187,49,4,1));
		acc.add((Accion) l[5]);
		l[6]=(new Condicional(1015,15,"while.png",215,181,6));
		k.add((Condicional) l[6]);
		l[7]=(new Condicion(575,215,"wallnext.png",175,45,7,0));
		cond.add((Condicion) l[7]);
		l[8]=(new Condicional(575,15,"while.png",215,181,8));
		k.add((Condicional) l[8]);
		l[9]=(new Condicional(355,15,"while.png",215,181,9));
		k.add((Condicional) l[9]);
		for(int i=0;i<l.length;i++) {
			r.add(l[i].jeje);
		}
		int d=0,xact=100,yact=100,la=64,delay=15;
		p1 = new Hayley(305,575,nivel);
		hacerlinea(0, 300, 6, 1);
		hacerlinea(0,300,7,0);
		hacerlinea(384, 300, 6, 1);
		hacerlinea(0,620,7,0);
		hacerlinea(128,556,3,0);
		hacerlinea(192,492,2,0);
		hacerlinea(192,428,2,0);
		hacerlinea(58,364,2,1);
		meta = new Pared(64,556,64,64,"meta.png");
		pars.add(meta);
		img=new Texture(Gdx.files.internal("Ground.jpg"));
		for(Pared p:pars){
			r.add(p.rect);
		}
		borderlands();
	}

	public void createnivel5()
	{
		pars.clear();
		r.clear();

		k.clear();
		cond.clear();
		acc.clear();
		l = new Label[10];
		l[0]=(new Condicional(845,15,"while.png",215,181,5));
		k.add((Condicional) l[0]);
		l[1]=(new Condicion(0,70,"wallnext.png",175,45,0,0));
		cond.add((Condicion) l[1]);
		l[2]=(new Accion(200,15,"Rabajo.png",187,49,1,4));
		acc.add((Accion) l[2]);
		l[3]=(new Accion(200,125,"Rarriba.png",187,49,2,2));
		acc.add((Accion) l[3]);
		l[4]=(new Accion(0,125,"Rderecha.png",187,49,3,3));
		acc.add((Accion) l[4]);
		l[5]=(new Accion(0,15,"Rizquierda.png",187,49,4,1));
		acc.add((Accion) l[5]);
		l[6]=(new Condicional(1065,15,"while.png",215,181,6));
		k.add((Condicional) l[6]);
		l[7]=(new Condicion(200,70,"wallnext.png",175,45,7,0));
		cond.add((Condicion) l[7]);
		l[8]=(new Condicional(625,15,"while.png",215,181,8));
		k.add((Condicional) l[8]);
		l[9]=(new Condicional(405,15,"while.png",215,181,9));
		k.add((Condicional) l[9]);
		for(int i=0;i<l.length;i++) {
			r.add(l[i].jeje);
		}
		int d=0,xact=100,yact=100,la=64,delay=15;
		p1 = new Hayley(64,264,nivel);
		hacerlinea(0, 200, 8, 1);
		hacerlinea(576, 200, 8, 1);
		hacerlinea(0, 200, 9, 0);
		hacerlinea(0, 648, 9, 0);
		hacerlinea(64, 328, 2, 1);
		hacerlinea(192, 264, 5, 1);
		hacerlinea(448, 328, 4, 1);
		hacerlinea(389, 456, 3, 1);
		hacerlinea(192, 264, 2, 1);
		pars.add(new Pared(128,520,64,64,"Pared.png"));
		meta = new Pared(455,584,64,64,"meta.png");


		pars.add(meta);
		img=new Texture(Gdx.files.internal("Ground.jpg"));
		for(Pared p:pars){
			r.add(p.rect);
		}
		borderlands();
	}

	public void createnivel6()
	{
		pars.clear();
		r.clear();

		k.clear();
		cond.clear();
		acc.clear();
		l = new Label[10];
		l[0]=(new Condicional(795,15,"while.png",215,181,5));
		k.add((Condicional) l[0]);
		l[1]=(new Condicion(400,215,"wallnext.png",175,45,0,0));
		cond.add((Condicion) l[1]);
		l[2]=(new Accion(150,15,"Rabajo.png",187,49,1,4));
		acc.add((Accion) l[2]);
		l[3]=(new Accion(570,410,"Rarriba.png",187,49,2,2));
		acc.add((Accion) l[3]);
		l[4]=(new Accion(570,350,"Rderecha.png",187,49,3,3));
		acc.add((Accion) l[4]);
		l[5]=(new Accion(570,290,"Rizquierda.png",187,49,4,1));
		acc.add((Accion) l[5]);
		l[6]=(new Condicional(1015,15,"while.png",215,181,6));
		k.add((Condicional) l[6]);
		l[7]=(new Condicion(575,215,"wallnext.png",175,45,7,0));
		cond.add((Condicion) l[7]);
		l[8]=(new Condicional(575,15,"while.png",215,181,8));
		k.add((Condicional) l[8]);
		l[9]=(new Condicional(355,15,"while.png",215,181,9));
		k.add((Condicional) l[9]);
		for(int i=0;i<l.length;i++) {
			r.add(l[i].jeje);
		}
		int d=0,xact=100,yact=100,la=64,delay=15;
		p1 = new Hayley(185,556,nivel);
		hacerlinea(0, 300, 6, 1);
		hacerlinea(0, 620, 7, 0);
		hacerlinea(0, 300, 7, 0);
		hacerlinea(448, 300, 6, 1);
		hacerlinea(128, 428, 2, 1);
		hacerlinea(192, 492, 2, 0);
		hacerlinea(256, 364, 3, 0);
		pars.add(new Pared(256,556,64,64,"Pared.png"));
		meta = new Pared(320,556,64,64,"meta.png");


		pars.add(meta);
		img=new Texture(Gdx.files.internal("Ground.jpg"));
		for(Pared p:pars){
			r.add(p.rect);
		}
		borderlands();
	}

	public void createnivel0()
	{
		pars.clear();
		r.clear();
		k.clear();
		cond.clear();
		acc.clear();
		l = new Label[10];
		l[0]=(new Condicional(0,-600,"while.png",215,181,5));
		k.add((Condicional) l[0]);
		l[1]=(new Condicion(15,-530,"wallnext.png",175,45,0,0));
		cond.add((Condicion) l[1]);
		l[2]=(new Accion(7,-420,"Rabajo.png",187,49,1,4));
		acc.add((Accion) l[2]);
		l[3]=(new Accion(450,-530,"Rarriba.png",187,49,2,2));
		acc.add((Accion) l[3]);
		l[4]=(new Accion(450,-410,"Rderecha.png",187,49,3,3));
		acc.add((Accion) l[4]);
		l[5]=(new Accion(450,-470,"Rizquierda.png",187,49,4,1));
		acc.add((Accion) l[5]);
		l[6]=(new Condicional(220,-410,"while.png",215,181,6));
		k.add((Condicional) l[6]);
		l[7]=(new Condicion(15,-480,"wallnext.png",175,45,7,0));
		cond.add((Condicion) l[7]);
		l[8]=(new Condicional(220,-600,"while.png",215,181,8));
		k.add((Condicional) l[8]);
		l[9]=(new Condicional(440,-600,"while.png",215,181,9));
		k.add((Condicional) l[9]);
		for(int i=0;i<l.length;i++) {
			r.add(l[i].jeje);
		}
		meta = new Pared(600,400,64,64,"go.png");
		ins = new Pared(600,300,64,64,"instrucciones.png");
		exit= new Pared(600,200,64,64,"exit.png");
		r.add(meta.rect);
		r.add(ins.rect);
		r.add(exit.rect);
		pars=new ArrayList<Pared>();
		p1 = new Hayley(10,10,nivel);
		pars.add(meta);
		pars.add(ins);
		pars.add(exit);
		img=new Texture(Gdx.files.internal("Groundmenu.png"));
		for(Pared p:pars){
			r.add(p.rect);
		}
		borderlands();
	}

	public void createnivelins()
	{
		pars.clear();
		r.clear();
		k.clear();
		cond.clear();
		acc.clear();
		l = new Label[10];
		l[0]=(new Condicional(0,-600,"while.png",215,181,5));
		k.add((Condicional) l[0]);
		l[1]=(new Condicion(15,-530,"wallnext.png",175,45,0,0));
		cond.add((Condicion) l[1]);
		l[2]=(new Accion(7,-420,"Rabajo.png",187,49,1,4));
		acc.add((Accion) l[2]);
		l[3]=(new Accion(450,-530,"Rarriba.png",187,49,2,2));
		acc.add((Accion) l[3]);
		l[4]=(new Accion(450,-410,"Rderecha.png",187,49,3,3));
		acc.add((Accion) l[4]);
		l[5]=(new Accion(450,-470,"Rizquierda.png",187,49,4,1));
		acc.add((Accion) l[5]);
		l[6]=(new Condicional(220,-410,"while.png",215,181,6));
		k.add((Condicional) l[6]);
		l[7]=(new Condicion(15,-480,"wallnext.png",175,45,7,0));
		cond.add((Condicion) l[7]);
		l[8]=(new Condicional(220,-600,"while.png",215,181,8));
		k.add((Condicional) l[8]);
		l[9]=(new Condicional(440,-600,"while.png",215,181,9));
		k.add((Condicional) l[9]);
		for(int i=0;i<l.length;i++) {
			r.add(l[i].jeje);
		}
		meta = new Pared(0,707,64,64,"back.png");
		r.add(meta.rect);
		pars=new ArrayList<Pared>();
		p1 = new Hayley(10,10,nivel);
		pars.add(meta);
		img=new Texture(Gdx.files.internal("gins.png"));
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
		nivel=p1.render(batch,r,meta,ins,estado,condusef,exit);
		if(nivel ==2)
		{
			createnivel2();
		}
	}

	public void rendernivel2()
	{
		for(Pared p:pars){
			p.render(batch);
		}
		nivel=p1.render(batch,r,meta,ins,estado,condusef,exit);
		if(nivel ==3)
		{
			createnivel3();
		}
	}

	public void rendernivel3()
	{
		for(Pared p:pars){
			p.render(batch);
		}
		nivel=p1.render(batch,r,meta,ins,estado,condusef,exit);
		if(nivel ==4)
		{
			createnivel4();
		}
	}

	public void rendernivel4()
	{
		for(Pared p:pars){
			p.render(batch);
		}
		nivel=p1.render(batch,r,meta,ins,estado,condusef,exit);
		if(nivel ==5)
		{
			createnivel5();
		}
	}

	public void rendernivel5()
	{
		for(Pared p:pars){
			p.render(batch);
		}
		nivel=p1.render(batch,r,meta,ins,estado,condusef,exit);
		if(nivel ==6)
		{
			createnivel6();
		}
	}

	public void rendernivel6()
	{
		for(Pared p:pars){
			p.render(batch);
		}
		nivel=p1.render(batch,r,meta,ins,estado,condusef,exit);
	}

	public void borderlands()
	{
		r.add(new Rectangle(0,0,0,Gdx.graphics.getHeight()));
		r.add(new Rectangle(0,0,Gdx.graphics.getWidth(),0));
		r.add(new Rectangle(Gdx.graphics.getWidth(),0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
		r.add(new Rectangle(0,Gdx.graphics.getHeight(),Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
	}
	public void hacerlinea(int x, int y, int largo, int dir){
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

	public void dibujarLabels()
	{
		l[0].render(batch,grab,true);
		l[6].render(batch,grab,true);
		l[8].render(batch,grab,true);
		l[9].render(batch,grab,true);
		((Condicion)l[1]).render(batch,grab,true,condusef);
		l[2].render(batch,grab,true);
		l[3].render(batch,grab,true);
		l[4].render(batch,grab,true);
		l[5].render(batch,grab,true);
		((Condicion)l[7]).render(batch,grab,true,condusef);
		((Condicion)l[1]).render(batch,grab,false,condusef);
		l[2].render(batch,grab,false);
		l[3].render(batch,grab,false);
		l[4].render(batch,grab,false);
		l[5].render(batch,grab,false);
		((Condicion)l[7]).render(batch,grab,false,condusef);
		l[0].render(batch,grab,false);
		l[6].render(batch,grab,false);
		l[8].render(batch,grab,false);
		l[9].render(batch,grab,false);
	}
	public void rendernivel0()
	{
		for(Pared p:pars){
			p.render(batch);
		}
		nivel=p1.render(batch,r,meta,ins,estado,condusef,exit);
		if(nivel ==11)
		{
			nivel=1;
			createnivel1();
		}
		else
			if(nivel==8)
			{
				createnivelins();
			}
			else
				if(nivel==15)
				{
					System.exit(0);
				}
	}
	public void rendernivelins()
	{
		for(Pared p:pars){
			p.render(batch);
		}
		nivel=p1.render(batch,r,meta,ins,estado,condusef,exit);
		if(nivel ==9)
		{
			nivel=10;
			createnivel0();
		}
	}
}