import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
/**Esta clase es la de la moneda con la que interactua el jugador en los niveles, y es dropeada por los enemigos*/
public class Coin extends BaseActor
{
	boolean enabled = false;
    public Coin(float x, float y, Stage s)
    { 
       super(x,y,s);
       loadAnimationFromSheet("assets/platform_metroidvania asset pack v1.01/miscellaneous sprites/coin_anim_strip_6.png", 1, 6, 0.1f, true);
    }    
    
    @Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
    	if(enabled)
		super.draw(batch, parentAlpha);
	}
    /**Este metodo sirve para spawnear la moneda en la posicion en la que se encuentra el enemigo
     * @param posiconX para saber la posicion X del enemigo
     * @param posiconY para saber la posicion Y del enemigo*/
    public void drop (float posicionX,float posicionY) {
		this.enabled=true;
		this.setPosition(posicionX,posicionY);
		
    }
}