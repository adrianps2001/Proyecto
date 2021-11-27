import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
/**
 * Esta clase es la que genera el ataque potenciado, es activado por el personaje.
 */
public class AtaqueUp extends BaseActor{
private LevelScreen nivel;
private LevelScreen2 nivel2;
private LevelScreen3 nivel3;
private double tiempoBala;
private float velocidadBala;
private double cuentaBala;
private int direccion;

private boolean enabled;
	public AtaqueUp(float x, float y, Stage s, LevelScreen nivel) {
		super(x, y, s);
		
		this.nivel=nivel;
		tiempoBala=0.39*3/2;
		velocidadBala=3;
		
		this.loadAnimationFromSheet("assets/herochar sprites(new)/sword_effect_strip_4(new).png" ,1, 4, 0.1f*3/2, true);	
	}
	public AtaqueUp(float x, float y, Stage s, LevelScreen2 nivel) {
		super(x, y, s);
		
		this.nivel2=nivel;
		tiempoBala=0.39*3/2;
		velocidadBala=3;
		
		this.loadAnimationFromSheet("assets/herochar sprites(new)/sword_effect_strip_4(new).png" ,1, 4, 0.1f*3/2, true);	
	}
	public AtaqueUp(float x, float y, Stage s, LevelScreen3 nivel) {
		super(x, y, s);
		
		this.nivel3=nivel;
		tiempoBala=0.39*3/2;
		velocidadBala=3;
		
		this.loadAnimationFromSheet("assets/herochar sprites(new)/sword_effect_strip_4(new).png" ,1, 4, 0.1f*3/2, true);	
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
		}else if(nivel2!=null){
			for(Enemigo enemigo: nivel2.enemigos) {
				if(enemigo.vivo && this.enabled && this.overlaps(enemigo)) {
					enemigo.dano();
				}
			}
		}
		else {
			for(Enemigo enemigo: nivel3.enemigos) {
				if(enemigo.vivo && this.enabled && this.overlaps(enemigo)) {
					enemigo.dano();
				}
			}
		}
		if(cuentaBala<=0) {
			enabled=false;
		}
		}
	}
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		if(enabled)
		super.draw(batch, parentAlpha);
	}
	/**
	 * Este es el metodo que se utiliza para generar el ataque , posicionarlo, rotarlo y saber hacia donde se tiene que mover
	 * @param direccionX para saber si tiene que ir hacia la derecha o izquierda
	 * @param direccionY para saber si tiene que ir hacia la arriba o obajo
	 */
	public void disparar(int direccionX,int direccionY) {
		this.velocityVec.set(velocidadBala*direccionX,velocidadBala*direccionY);

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
		else if(nivel2!=null)
			this.setPosition(nivel2.jugador.getX()+direccionX, nivel2.jugador.getY()+ direccionY);
		else
			this.setPosition(nivel3.jugador.getX()+direccionX, nivel3.jugador.getY()+ direccionY);
		cuentaBala=tiempoBala;
		
	}
	
}
