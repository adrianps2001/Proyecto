import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
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
/**Primera pantalla del juego que permite jugar, deshabilitar la musica y salir*/
public class Final extends BaseScreen
{
  
 
    
    Label title ;
    Label options ;
    Label exit ;
    Label play ;
    int elegir;
    Table keyTable;
    LabelStyle elegido; 
    boolean sonido = true;
    public void initialize() {
    	
    	TilemapActor tma = new TilemapActor("assets/Menu.tmx", mainStage);
    	 FreeTypeFontGenerator fontGenerator = 
    	            new FreeTypeFontGenerator(Gdx.files.internal("assets/OpenSans.ttf"));
    	 ((OrthographicCamera)this.mainStage.getCamera()).setToOrtho(false, 400, 320);
    	 FreeTypeFontParameter fontParameters = new FreeTypeFontParameter();
         fontParameters.size = 50;
         fontParameters.color = Color.WHITE;

         fontParameters.borderWidth = 2;
         fontParameters.borderColor = Color.BLACK;
         fontParameters.borderStraight = true;
         fontParameters.minFilter = TextureFilter.Linear;
         fontParameters.magFilter = TextureFilter.Linear;
         
         BitmapFont customFont = fontGenerator.generateFont(fontParameters);

         elegido = new LabelStyle();
         elegido.font = customFont;
    	
         

        		 
    	 title = new Label("\n\n\n                        ¡Enorabuena!",elegido);
    	elegir=0;
    	 
    	 play = new Label("                Has completado el juego",elegido);
            title.setVisible(true); 
            uiTable.row().colspan(3).expandX().fillX();
    	uiTable.add(title).expandX();
    	 uiTable.row().colspan(2).expandY().fillX();
    	uiTable.add(play).expandX();
    
    	
    }
   
    

    public boolean keyDown(int keyCode) {
  
    	
        		 BaseGame.setActiveScreen( new Inicio());
     		
        return false;
    }



	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
	}
}