import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
/**
 * Esta clase es la que genera el ataque, es activado por el personaje.
 */
public class Ataque extends BaseActor{
private LevelScreen nivel;
private LevelScreen2 nivel2;
private LevelScreen3 nivel3;
private double tiempoBala;
private float velocidadBala;
private double cuentaBala;
private Animation ataque;
private int direccion;
private int cuenta;


private boolean enabled;
	public Ataque(float x, float y, Stage s, LevelScreen nivel) {
		super(x, y, s);
		// TODO Auto-generated constructor stub
		this.nivel=nivel;
		tiempoBala=0.39;
		velocidadBala=400;
	ataque=loadAnimationFromSheet("assets/herochar sprites(new)/sword_effect_strip_4(new).png" ,1, 4, 0.1f, true);	
	}
	public Ataque(float x, float y, Stage s, LevelScreen2 nivel) {
		super(x, y, s);
		// TODO Auto-generated constructor stub
		this.nivel2=nivel;
		tiempoBala=0.39;
		velocidadBala=400;
	ataque=loadAnimationFromSheet("assets/herochar sprites(new)/sword_effect_strip_4(new).png" ,1, 4, 0.1f, true);	
	}
	public Ataque(float x, float y, Stage s, LevelScreen3 nivel) {
		super(x, y, s);
		// TODO Auto-generated constructor stub
		this.nivel3=nivel;
		tiempoBala=0.39;
		velocidadBala=400;
	ataque=loadAnimationFromSheet("assets/herochar sprites(new)/sword_effect_strip_4(new).png" ,1, 4, 0.1f, true);	
	}
	
	@Override
	public void act(float dt) {
		// TODO Auto-generated method stub
		if(enabled) {
		super.act(dt);
		moveBy(velocityVec.x*dt,velocityVec.y*dt);
		cuentaBala-=dt;
		if(nivel!=null) {
			for(Enemigo enemigo: nivel.enemigos) {
				if(enemigo.vivo && this.enabled && this.overlaps(enemigo)) {
				enemigo.dano();	
				}
			}
		}else if (nivel2!=null){
			for(Enemigo enemigo: nivel2.enemigos) {
				if(enemigo.vivo && this.enabled && this.overlaps(enemigo)) {
				enemigo.dano();	
				}
			}
		}else{
			for(Enemigo enemigo: nivel3.enemigos) {
				if(enemigo.vivo && this.enabled && this.overlaps(enemigo)) {
				enemigo.dano();	
				}
			}
		}
		if(cuentaBala<=0) {
			enabled=false;
		}
		}}
	
	
	
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		if(enabled)
		super.draw(batch, parentAlpha);
		
	}
	/**
	 * Este es el metodo que se utiliza para generar el ataque , posicionarlo y rotarlo
	 * @param direccionX para saber si tiene que ir hacia la derecha o izquierda
	 * @param direccionY para saber si tiene que ir hacia la arriba o obajo
	 */
	public void atacar(int direccionX,int direccionY) {
		
		if(direccionX>0 &&direccionY>0)
		setRotation(45);
		else if(direccionX<0 &&direccionY>0)
		setRotation(135);
		else if(direccionX<0 &&direccionY==0) {
			direccionY-=5;
			setRotation(180);
		}
		else if(direccionX>0 &&direccionY==0) {
			direccionY+=5;
			setRotation(0);
		}
		else if(direccionX<0 &&direccionY<0)
			setRotation(-135);
		else if(direccionX>0 &&direccionY<0)
			setRotation(-45);
		else if(direccionX==0 &&direccionY<0) {
		direccionX+=5;
			setRotation(-90);}
		else if(direccionX==0 &&direccionY>0)
			setRotation(90);
		
		setScaleY(2);
		
		this.enabled=true;
		if(nivel!=null)
		this.setPosition(nivel.jugador.getX()+direccionX, nivel.jugador.getY()+ direccionY);
		else if (nivel2!=null)
			this.setPosition(nivel2.jugador.getX()+direccionX, nivel2.jugador.getY()+ direccionY);
		else
			this.setPosition(nivel3.jugador.getX()+direccionX, nivel3.jugador.getY()+ direccionY);

		cuentaBala=tiempoBala;
		this.velocityVec.set(0,0);
	}
	
}
