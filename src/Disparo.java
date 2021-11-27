import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
/**
 * Esta clase es la que genera el ataque a distancia, es activado por el personaje.
 */
public class Disparo extends BaseActor{
private LevelScreen nivel;
private LevelScreen2 nivel2;
private LevelScreen3 nivel3;
private float tiempoBala;
private float velocidadBala;
private float cuentaBala;
private int direccion;
private boolean explosion;
private boolean enabled;
private Explosion e;
	public Disparo(float x, float y, Stage s, LevelScreen nivel) {
		super(x, y, s);
		e = new Explosion(0,0,s);
		this.nivel=nivel;
		tiempoBala=100;
		velocidadBala=4;
		
		this.loadAnimationFromSheet("assets/platform_metroidvania asset pack v1.01/miscellaneous sprites/orb_anim_strip_6.png",1, 6, 0.1f, true);	
	}
	public Disparo(float x, float y, Stage s, LevelScreen2 nivel) {
		super(x, y, s);
		e = new Explosion(0,0,s);
		this.nivel2=nivel;
		tiempoBala=100;
		velocidadBala=4;
		
		this.loadAnimationFromSheet("assets/platform_metroidvania asset pack v1.01/miscellaneous sprites/orb_anim_strip_6.png",1, 6, 0.1f, true);	
	}
	public Disparo(float x, float y, Stage s, LevelScreen3 nivel) {
		super(x, y, s);
		e = new Explosion(0,0,s);
		this.nivel3=nivel;
		tiempoBala=100;
		velocidadBala=4;
		
		this.loadAnimationFromSheet("assets/platform_metroidvania asset pack v1.01/miscellaneous sprites/orb_anim_strip_6.png",1, 6, 0.1f, true);	
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
				this.enabled=false;
				if(explosion) {
					e.drop(this.getX(), this.getY());
				}
			}
		}
		}else if (nivel2!=null){
			for(Enemigo enemigo: nivel2.enemigos) {
				if(enemigo.vivo && this.enabled && this.overlaps(enemigo)) {
					enemigo.dano();
					this.enabled=false;
					if(explosion) {
						e.drop(this.getX(), this.getY());
					}
				}
			}
		}else {
			for(Enemigo enemigo: nivel3.enemigos) {
				if(enemigo.vivo && this.enabled && this.overlaps(enemigo)) {
					enemigo.dano();
					this.enabled=false;
					if(explosion) {
						e.drop(this.getX(), this.getY());
					}
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
	 * @param direccionY para saber si tiene que ir hacia la arriba o abajo
	 * @param explosion para saber si esta activo el potenciador que genera la explosion
	 */
	public void disparar(int direccionX,int direccionY,boolean explosion) {
		this.velocityVec.set(velocidadBala*direccionX,velocidadBala*direccionY);

		if(direccionX>0 &&direccionY>0)
		setRotation(45);
		else if(direccionX<0 &&direccionY>0)
		setRotation(135);
		else if(direccionX<0 &&direccionY==0) {
			direccionY+=5;
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
		direccionX-=5;
			setRotation(-90);}
		else if(direccionX==0 &&direccionY>0) {
			setRotation(90);
			direccionX+=5;
		}
		
		this.explosion=explosion;
		this.enabled=true;
		if(nivel!=null)
			this.setPosition(nivel.jugador.getX(), nivel.jugador.getY());
			else if(nivel2!=null)
				this.setPosition(nivel2.jugador.getX(), nivel2.jugador.getY());
		else
			this.setPosition(nivel3.jugador.getX(), nivel3.jugador.getY());
		cuentaBala=tiempoBala;
		
	}
	
}
