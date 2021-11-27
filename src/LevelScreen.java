import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class LevelScreen extends BaseScreen {
	
	public boolean powerup1;
    public boolean powerup2;
    public int vidas ;
    public int coins ;
	Knight jugador;
	boolean gameOver;
	boolean abierto;
	Image coinImage;
	Image lifesImage;
	int muertes;
	float time;
	private ArrayList<SpawnGob> spawnsGob;
	private ArrayList<SpawnSeta> spawnsSeta;
	Label coinLabel;
	Label vidasLabel;
	Label muertesLabel;
	Label gameOverLabel;
	Table keyTable;
	public ArrayList<Enemigo> enemigos;
	ArrayList<Color> keyList;
	TilemapActor tma;
	boolean sonido = true;
	boolean musica =false;
 public LevelScreen(int vidas,int coins,boolean powerup1,boolean powerup2,boolean sonido) {
	 this.coins = coins;
	 this.vidas = vidas;
	 this.powerup1 = powerup1;
	 this.powerup2 = powerup2;
	 this.sonido = sonido;
 }
	public void initialize() {
		tma = new TilemapActor("assets/map.tmx", mainStage);
		((OrthographicCamera)this.mainStage.getCamera()).setToOrtho(false, 400, 320);
		MapProperties props1;
		coinImage=new Image(new Texture(Gdx.files.internal("assets/platform_metroidvania asset pack v1.01/miscellaneous sprites/coin.png")));
		coinImage.setScale(3,3);
		lifesImage = new Image(new Texture(Gdx.files.internal("assets/platform_metroidvania asset pack v1.01/hud elements/lifes_icon.png")));
		lifesImage.setScale(2,2);
		for (MapObject obj : tma.getRectangleList("Solid")) {
			props1 = obj.getProperties();
			new Solid((float) props1.get("x"), (float) props1.get("y"), (float) props1.get("width"),
					(float) props1.get("height"), mainStage);
		}
		
		MapObject startPoint = tma.getRectangleList("start").get(0);
		MapProperties startProps = startPoint.getProperties();
		jugador = new Knight((float) startProps.get("x"), (float) startProps.get("y"), mainStage, this,powerup1,powerup2);
		enemigos = new ArrayList<Enemigo>();
		spawnsGob = new ArrayList<SpawnGob>();
		spawnsSeta = new ArrayList<SpawnSeta>();
		Enemigo enemigo;
		SpawnGob spawngob;
		SpawnSeta spawnseta;
		for (MapObject obj : tma.getRectangleList("mosca")) {

			props1 = obj.getProperties();
			enemigo = new Goblin((float) props1.get("x"), (float) props1.get("y"), mainStage, this);
			enemigos.add(enemigo);
		}
		
		
		for (MapObject obj : tma.getTileList("Flag")) {
			MapProperties props = obj.getProperties();
			new Potion((float) props.get("x"), (float) props.get("y"), mainStage);
		}

		for (MapObject obj : tma.getTileList("Coin")) {
			MapProperties props = obj.getProperties();
			new Coin((float) props.get("x"), (float) props.get("y"), mainStage);
		}
		
		for (MapObject obj : tma.getRectangleList("Door")) {
			MapProperties props = obj.getProperties();
			new Puerta((float) props.get("x"), (float) props.get("y"), mainStage);
		}

		

		
		

		for (MapObject obj : tma.getRectangleList("spawnGob")) {
			MapProperties props = obj.getProperties();
			spawngob= new SpawnGob((float) props.get("x"), (float) props.get("y"), mainStage, this);
			spawnsGob.add(spawngob);
		}
		for (MapObject obj : tma.getRectangleList("spawnSeta")) {
			MapProperties props = obj.getProperties();
			spawnseta= new SpawnSeta((float) props.get("x"), (float) props.get("y"), mainStage, this);
			spawnsSeta.add(spawnseta);
		}

	

		jugador.toFront();

		gameOver = false;
		time = 0;

        coinLabel = new Label("  " + coins , BaseGame.labelStyle);
        coinLabel.setColor(Color.GOLD);
        keyTable = new Table();
        vidasLabel = new Label("  " + vidas, BaseGame.labelStyle);
         vidasLabel.setColor(Color.LIGHT_GRAY);
         gameOverLabel =new Label("",BaseGame.labelStyle);
		muertesLabel = new Label("   0/40", BaseGame.labelStyle);
		  muertesLabel.setColor(Color.LIGHT_GRAY);
		  
			gameOverLabel.setText("You died");
			gameOverLabel.setColor(Color.RED);
			gameOverLabel.setVisible(false);
		uiTable.pad(20);
		uiTable.add(coinImage);
		uiTable.add(coinLabel);
		uiTable.add(muertesLabel).expandX().fillY();
		uiTable.add(gameOverLabel);
		uiTable.add(lifesImage);
		uiTable.add(vidasLabel);
		uiTable.row();
		uiTable.add().colspan(3).expandY();
		
		keyList = new ArrayList<Color>();
	}

	public void update(float dt) {
		if (gameOver)
			return;
		time -= dt;
		if (time <= 0) {
			
			muertesLabel.setVisible(true);
			coinLabel.setVisible(true);
		}
		if(sonido &&!musica) {
			musica=true;
			try {
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("assets/platform_metroidvania asset pack v1.01/OST.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.loop(1);
			} catch (Exception e) {
				e.printStackTrace();
			}}
		for (BaseActor potion : BaseActor.getList(mainStage, "Potion")) {
			if (jugador.overlaps(potion)) {
				if(jugador.getNumDisparos()==0) {
				jugador.setNumDisparos(1);
				
				potion.remove();
			
				}}
		}
		for (BaseActor door : BaseActor.getList(mainStage, "Puerta")) {
			if (jugador.overlaps(door) &&abierto) {
				
				BaseGame.setActiveScreen(new Tienda(vidas,coins,powerup1,powerup2,false,sonido));
				
			
			}
			if(abierto) {
				door.setVisible(false);
			}
		}
		coinLabel.setText("  " + coins );
		vidasLabel.setText("  " + vidas );
		for (BaseActor coin : BaseActor.getList(mainStage, "Coin")) {
			if (jugador.overlaps(coin)) {
				coins++;
				coinLabel.setText("  " + coins );
				coin.remove();		
				if(sonido) {
				try {
					AudioInputStream audioInputStream = AudioSystem
							.getAudioInputStream(new File("assets/Sonidos/street-fighter-coin.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				} catch (Exception e) {
					e.printStackTrace();
				}}

			}
		}
		
		
		if(muertes<=30) {
		muertesLabel.setText( "     "+muertes + "/30");
		}
		if(muertes>29&&!abierto){
			muertesLabel.setText( "     "+"30" + "/30");
			abierto=true;
			if(sonido) {
				try {
					AudioInputStream audioInputStream = AudioSystem
							.getAudioInputStream(new File("assets/platform_metroidvania asset pack v1.01/puerta.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				} catch (Exception e) {
					e.printStackTrace();
				}}
		}

		for (BaseActor actor : BaseActor.getList(mainStage, "Solid")) {
			Solid solid = (Solid) actor;

			if (jugador.overlaps(solid) && solid.isEnabled()) {
				Vector2 offset = jugador.preventOverlap(solid);

				if (offset != null) {
					// collided in X direction
					if (Math.abs(offset.x) > Math.abs(offset.y))
						jugador.velocityVec.x = 0;
					else // collided in Y direction
						jugador.velocityVec.y = 0;
				}
			}
		
		}

		for (SpawnGob spawnGob : spawnsGob) {
			spawnGob.spawn();				

		}
		for (SpawnSeta spawnSeta : spawnsSeta) {
			
			spawnSeta.spawn();				

		}
		for (Enemigo enemigo : enemigos) {
			for (BaseActor explosion : BaseActor.getList(mainStage, "Explosion")) {
				if(enemigo.overlaps(explosion) && explosion.isVisible()) {
					enemigo.dano();
					
				}
				
				
			}
			
			
			for (BaseActor actor : BaseActor.getList(mainStage, "Solid")) {
			Solid solid = (Solid) actor;
			if(enemigo.time>100) {
			if (enemigo.overlaps(solid) && solid.overlaps(enemigo)) {
				
				 enemigo.isWithinDistance(10,solid);
				 Vector2 offset = enemigo.preventOverlapDistance(solid);
				
				if (offset !=null) {
					// collided in X direction
					if (Math.abs(offset.x) > Math.abs(offset.y))
						enemigo.velocityVec.x = 0;
						else  // collided in Y direction
						enemigo.velocityVec.y = 0;
				
				}
			}}}
					
			enemigo.setTime(dt + enemigo.getTime());
			if (enemigo.vivo && jugador.overlaps(enemigo)) {
				Vector2 offset = jugador.preventOverlap(enemigo);
				
					if (vidas == 0) {
						
						uiTable.add(gameOverLabel);
						gameOverLabel.setVisible(true);
						gameOverLabel.setY(300);
						gameOverLabel.setX(300);
						gameOver=true;

						jugador.remove();
					} else {
						vidas--;
						jugador.setPosition(400, 50);
						vidasLabel.setText("  " + vidas);
						
						for (Enemigo enemigos : enemigos) {
							enemigos.setVivo(false);
							enemigos.remove();
							

						}
					
					}

				
			} 
		}
	}

	public boolean keyDown(int keyCode) {
		if (gameOver)
			BaseGame.setActiveScreen( new Inicio());
		
		return false;
	}
}