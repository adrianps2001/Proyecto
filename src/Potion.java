import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
/**Clase de la pocion que otorga el ataque a distancia al personaje*/
public class Potion extends BaseActor
{
	
	private boolean enabled;
    public Potion(float x, float y, Stage s)
    { 
       super(x,y,s);
       loadAnimationFromSheet("assets/platform_metroidvania asset pack v1.01/miscellaneous sprites/antidote_potion.png", 1, 1, 0.1f, true);
    }    
    @Override
   	public void draw(Batch batch, float parentAlpha) {
   		// TODO Auto-generated method stub
       	if(enabled)
   		super.draw(batch, parentAlpha);
   	}
      /**Metodo para que el enemigo lo spawnee al morir*/
       public void drop (float posicionX,float posicionY) {
   		this.enabled=true;
   		this.setPosition(posicionX,posicionY);
   		
       }
}