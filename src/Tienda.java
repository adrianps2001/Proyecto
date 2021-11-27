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
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Align;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;
/**Tienda en la que se compran vidas y mejoras*/
public class Tienda extends BaseScreen
{	
	public boolean powerup1;
    public boolean powerup2;
    public int vidas ;
    public int coins ;
    boolean lvl2;
	boolean continuar;
    Label title ;
    Label espada ;
    Label orbe ;
    Image coinImage;
    Image coinImageVida;
    Image coinImageEspada;
    Image coinImageOrbe;
    Label vida ;
    Label explicacion ;
    Label continuarLbl ;
    Label coinsLbl;
    
    Label precioVida;
    Label precioEspada;
    Label precioOrbe;
    
    int elegir;
    Table keyTable;
    LabelStyle elegido; 
    LabelStyle opcion;
    boolean sonido;
    public Tienda(int vidas,int coins,boolean powerup1,boolean powerup2,boolean lvl2,boolean sonido) {
   	 this.coins = coins;
   	 this.vidas = vidas;
   	 this.powerup1 = powerup1;
   	 this.powerup2 = powerup2;
   	 this.lvl2=lvl2;
   	 this.sonido=sonido;
    }
    
    public void initialize() {
    	
    	TilemapActor tma = new TilemapActor("assets/Menu.tmx", mainStage);
    	 FreeTypeFontGenerator fontGenerator = 
    	            new FreeTypeFontGenerator(Gdx.files.internal("assets/OpenSans.ttf"));
    	 ((OrthographicCamera)this.mainStage.getCamera()).setToOrtho(false, 400, 320);

    	 FreeTypeFontParameter fontParameters = new FreeTypeFontParameter();
         fontParameters.size = 15;
         fontParameters.color = Color.RED;

         fontParameters.borderWidth = 2;
         fontParameters.borderColor = Color.BLACK;
         fontParameters.borderStraight = true;
         fontParameters.minFilter = TextureFilter.Linear;
         fontParameters.magFilter = TextureFilter.Linear;

         BitmapFont customFont = fontGenerator.generateFont(fontParameters);

         elegido = new LabelStyle();
         opcion = new LabelStyle();
         
         elegido.font = customFont;
         fontParameters.size = 15;
         fontParameters.color = Color.WHITE;
          customFont = fontGenerator.generateFont(fontParameters);
          opcion.font = customFont;
          continuarLbl= new Label("Continuar",opcion);
          coinImage=new Image(new Texture(Gdx.files.internal("assets/platform_metroidvania asset pack v1.01/hud elements/coins_hud.png")));
          coinImageVida=new Image(new Texture(Gdx.files.internal("assets/platform_metroidvania asset pack v1.01/hud elements/coins_hud.png")));
          coinImageEspada=new Image(new Texture(Gdx.files.internal("assets/platform_metroidvania asset pack v1.01/hud elements/coins_hud.png")));
          coinImageOrbe=new Image(new Texture(Gdx.files.internal("assets/platform_metroidvania asset pack v1.01/hud elements/coins_hud.png")));
          
    	title = new Label("Tienda", BaseGame.labelStyle);
    	elegir=0;
    	continuar=false;
    	espada = new Label("Espada", opcion);
    	explicacion = new Label("              Te quedan:"+vidas+" vidas",opcion);
    	precioVida = new Label("10",opcion);
    	precioEspada = new Label("20", opcion);
    	precioOrbe = new Label("20", opcion);
    	
    	coinsLbl = new Label(coins+"",opcion);
    	orbe = new Label("Orbe", opcion);
    	vida = new Label("Vida",elegido);
        title.setVisible(true); 
    	title.setX(150);
    	title.setY(250);
    	this.mainStage.addActor(title);
    	vida.setX(50);
    	vida.setY(150);
    	
    	this.mainStage.addActor(vida);
    	espada.setX(175);
    	espada.setY(150);
    	this.mainStage.addActor(espada);
    	orbe.setX(300);
    	orbe.setY(150);
    	this.mainStage.addActor(orbe);
    	explicacion.setX(25);
    	explicacion.setY(100);
    	this.mainStage.addActor(explicacion);
    	continuarLbl.setX(170);
    	continuarLbl.setY(50);
    	this.mainStage.addActor(continuarLbl);
    	coinImage.setX(5);
    	coinImage.setY(300);
    	this.mainStage.addActor(coinImage);
    	coinsLbl.setX(25);
    	coinsLbl.setY(300);
    	this.mainStage.addActor(coinsLbl);
    	precioVida.setX(55);
    	precioVida.setY(135);
    	this.mainStage.addActor(precioVida);
    	precioEspada.setX(190);
    	precioEspada.setY(135);
    	this.mainStage.addActor(precioEspada);
    	precioOrbe.setX(305);
    	precioOrbe.setY(135);
    	this.mainStage.addActor(precioOrbe);
    	coinImageVida.setX(75);
    	coinImageVida.setY(135);
    	this.mainStage.addActor(coinImageVida);
    	coinImageEspada.setX(210);
    	coinImageEspada.setY(135);
    	this.mainStage.addActor(coinImageEspada);
    	coinImageOrbe.setX(325);
    	coinImageOrbe.setY(135);
    	this.mainStage.addActor(coinImageOrbe);
    	
    }
   
    

    public boolean keyDown(int keyCode) {
    	if (keyCode == Keys.DOWN ) {
    		continuar=true;
    		vida.setStyle(opcion);
			espada.setStyle(opcion);
			orbe.setStyle(opcion);
			explicacion.setText("         Pasar al siguiente nivel");
			continuarLbl.setStyle(elegido);
    	}
    	if (keyCode == Keys.UP &&continuar) {
    		continuar=false;
    		elegir=0;
    		vida.setStyle(elegido);
			espada.setStyle(opcion);
			orbe.setStyle(opcion);
			explicacion.setText("              Te quedan: "+vidas+" vidas");

			continuarLbl.setStyle(opcion);
    	}
    	if(!continuar) {
    	if (keyCode == Keys.RIGHT &&elegir <2) {
    		elegir++;
    	}
    	if (keyCode == Keys.LEFT &&elegir >0) {
    		elegir--;
    	}
    	if(keyCode == Keys.LEFT||keyCode == Keys.RIGHT) {
    		
    		if (elegir ==0) {
    			vida.setStyle(elegido);
    			espada.setStyle(opcion);
    			orbe.setStyle(opcion);
    			explicacion.setText("              Te quedan: "+vidas+" vidas");
    		}
    		if (elegir ==1) {
    			espada.setStyle(elegido);
    			vida.setStyle(opcion);
    			orbe.setStyle(opcion);
    			explicacion.setText("            Tu ataque principal ahora\n               recorrera unos metros");

    		}
    		if (elegir ==2) {
    			orbe.setStyle(elegido);
    			espada.setStyle(opcion);
    			vida.setStyle(opcion);
    			explicacion.setText("Tu ataque secundario ahora explota al \nimpactar pero puede dañarte a ti tambien");

    		}
    	}
    	}
        if (keyCode == Keys.SPACE)
        {
        	if(!continuar) {
        	 
        	 if (elegir ==0) {
        		 if(coins>=10&&vidas!=3) {
        		 vidas++;
        		 coins=coins-10;
        		 coinsLbl.setText(coins+"");
        		 explicacion.setText("              Te quedan: "+vidas+" vidas");
        		 }else if(vidas==3) {
        			 explicacion.setText("     Ya tienes 3 vidas no puedes comprar más");
        		 }
     		}
     		if (elegir ==1) {
     			if(coins>=20&&!powerup1) {
           		 powerup1=true;
           		 coins=coins-20;
        		 coinsLbl.setText(coins+"");

           		 }else if(powerup1) {
           			explicacion.setText("            Ya has comprado esta mejora");
           			 
           		 }
     			 

     		}
     		if (elegir ==2) {
     			if(coins>=20&&!powerup2) {
              		 powerup2=true;
              		 coins=coins-20;
            		 coinsLbl.setText(coins+"");

              		 }else if(powerup2) {
                			explicacion.setText("            Ya has comprado esta mejora");
                  			 
               		 }
     		}
        }else {
        	if(!lvl2) {
   		 BaseGame.setActiveScreen( new LevelScreen2(vidas,coins,powerup1,powerup2,sonido));
        	}else {
          		 BaseGame.setActiveScreen( new LevelScreen3(vidas,coins,powerup1,powerup2,sonido));

        		
        	}
        	
        }
        	}
        return false;
    }



	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		coinsLbl.setText(coins+"");
	}
}