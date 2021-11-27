import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
/**Clase de la que heredan todos los enemigos*/
public class Enemigo extends BaseActor{
	public boolean vivo;
	protected LevelScreen nivel;
	protected LevelScreen2 nivel2;
	protected LevelScreen3 nivel3;
	private Coin coins;
	private Potion potions;
	int vida;
	float x;
	float y;
	float acc;
	float time;
	boolean retroceso;
	public Enemigo(float x, float y, Stage s, LevelScreen nivel) {
		super(x, y, s);
		// TODO Auto-generated constructor stub
		this.nivel=nivel;
		vivo=true;
		coins = new Coin(0,0,s);
		potions = new Potion(0,0,s);
	}
	public Enemigo(float x, float y, Stage s, LevelScreen2 nivel) {
		super(x, y, s);
		// TODO Auto-generated constructor stub
		this.nivel2=nivel;
		vivo=true;
		coins = new Coin(0,0,s);
		potions = new Potion(0,0,s);
	}
	public Enemigo(float x, float y, Stage s, LevelScreen3 nivel) {
		super(x, y, s);
		// TODO Auto-generated constructor stub
		this.nivel3=nivel;
		vivo=true;
		coins = new Coin(0,0,s);
		potions = new Potion(0,0,s);
	}
 /**Metodo utilizado cuando un enemigo es eliminado para que dropee un objeto*/
	public void dead() {
		
		if(Math.random()*8<3) {
			coins.drop(this.getX(),this.getY());
			}else {
				if(Math.random()*8<3) {
					potions.drop(this.getX(),this.getY());
				}
			}
		if(nivel!=null) {
		nivel.muertes++;
		nivel.enemigos.remove(this);
		}
		else if(nivel2!=null) {
			nivel2.muertes++;
		nivel2.enemigos.remove(this);
		}
		else {
			nivel3.muertes++;
		nivel3.enemigos.remove(this);
		}
		this.vivo=false;
		this.remove();
	}
	/**Metodo utilizado cuando un enemigo recibe daño*/
	public void dano() {
		this.retroceso=true;
		this.x = this.getX();
		this.y = this.getY();
		
		

	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		if(vivo)super.draw(batch, parentAlpha);
	}

	public float getAcc() {
		return acc;
	}

	public void setAcc(float acc) {
		this.acc = acc;
	}

	public boolean getVivo() {
		return vivo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

	public float getTime() {
		return time;
	}



	public void setTime(float time) {
		this.time = time;
	}
	
	
}
