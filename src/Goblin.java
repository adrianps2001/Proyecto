import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
/**El enemigo Goblin*/
public class Goblin extends Enemigo{
	private boolean enabled;
	private boolean persiguiendo;
	private Animation andando;
	private Animation golpeado;
	private float aceleracion;
	private float velocidadMaxima;
	public Goblin(float x, float y, Stage s, LevelScreen nivel) {
		super(x, y, s, nivel);
		// TODO Auto-generated constructor stub
		persiguiendo=true;
		andando=loadAnimationFromSheet("assets/platform_metroidvania asset pack v1.01/enemies sprites/goblin/goblin_run_anim_strip_6.png", 1, 6, 0.1f, true);
		golpeado=loadAnimationFromSheet("assets/platform_metroidvania asset pack v1.01/enemies sprites/goblin/goblin_hit_anim_strip_3.png", 1, 3, 0.1f, true);
		velocidadMaxima=35;
		aceleracion=30000;
		vida = 2;
	}
	public Goblin(float x, float y, Stage s, LevelScreen2 nivel) {
		super(x, y, s, nivel);
		// TODO Auto-generated constructor stub
		persiguiendo=true;
		andando=loadAnimationFromSheet("assets/platform_metroidvania asset pack v1.01/enemies sprites/goblin/goblin_run_anim_strip_6.png", 1, 6, 0.1f, true);
		golpeado=loadAnimationFromSheet("assets/platform_metroidvania asset pack v1.01/enemies sprites/goblin/goblin_hit_anim_strip_3.png", 1, 3, 0.1f, true);
		velocidadMaxima=35;
		aceleracion=30000;
		vida = 2;
	}
	public Goblin(float x, float y, Stage s, LevelScreen3 nivel) {
		super(x, y, s, nivel);
		// TODO Auto-generated constructor stub
		persiguiendo=true;
		andando=loadAnimationFromSheet("assets/platform_metroidvania asset pack v1.01/enemies sprites/goblin/goblin_run_anim_strip_6.png", 1, 6, 0.1f, true);
		golpeado=loadAnimationFromSheet("assets/platform_metroidvania asset pack v1.01/enemies sprites/goblin/goblin_hit_anim_strip_3.png", 1, 3, 0.1f, true);
		velocidadMaxima=35;
		aceleracion=30000;
		vida = 2;
	}
	
	

	@Override
	public void act(float dt) {
		// TODO Auto-generated method stub
		super.act(dt);
		
		
		if(vivo) {
			time+=dt;
			if(retroceso) {
				if(nivel!=null) {
				this.setAnimation(golpeado);
				this.velocidadMaxima=100;
				if(nivel.jugador.getX()<this.getX()) {
					this.accelerationVec.add(300000,0);
					setScaleX(-1);
					
				}else if(nivel.jugador.getX()>this.getX()) {
					this.accelerationVec.add(-300000,0);
					setScaleX(1);
			}
				if(nivel.jugador.getY()<this.getY()) {
					this.accelerationVec.add(0,300000);
				
			}else if(nivel.jugador.getY()>this.getY()) {
				this.accelerationVec.add(0,-300000);
		}
				if(Math.abs(this.getX()-x)>20 ||Math.abs(this.getY()-y)>20) {
					this.retroceso=false;
					this.velocidadMaxima=35;
					this.setAnimation(andando);
					this.vida--;
					if(vida==0) {
						
						
						this.dead();
					
				}
				}}else if(nivel2!=null){

					this.setAnimation(golpeado);
					this.velocidadMaxima=100;
					if(nivel2.jugador.getX()<this.getX()) {
						this.accelerationVec.add(300000,0);
						setScaleX(-1);
						
					}else if(nivel2.jugador.getX()>this.getX()) {
						this.accelerationVec.add(-300000,0);
						setScaleX(1);
				}
					if(nivel2.jugador.getY()<this.getY()) {
						this.accelerationVec.add(0,300000);
					
				}else if(nivel2.jugador.getY()>this.getY()) {
					this.accelerationVec.add(0,-300000);
			}
					if(Math.abs(this.getX()-x)>20 ||Math.abs(this.getY()-y)>20) {
						this.retroceso=false;
						this.velocidadMaxima=35;
						this.setAnimation(andando);
						this.vida--;
						if(vida==0) {
							
							
							this.dead();
						
					}
					}
					
				}else {

					this.setAnimation(golpeado);
					this.velocidadMaxima=100;
					if(nivel3.jugador.getX()<this.getX()) {
						this.accelerationVec.add(300000,0);
						setScaleX(-1);
						
					}else if(nivel3.jugador.getX()>this.getX()) {
						this.accelerationVec.add(-300000,0);
						setScaleX(1);
				}
					if(nivel3.jugador.getY()<this.getY()) {
						this.accelerationVec.add(0,300000);
					
				}else if(nivel3.jugador.getY()>this.getY()) {
					this.accelerationVec.add(0,-300000);
			}
					if(Math.abs(this.getX()-x)>20 ||Math.abs(this.getY()-y)>20) {
						this.retroceso=false;
						this.velocidadMaxima=35;
						this.setAnimation(andando);
						this.vida--;
						if(vida==0) {
							
							
							this.dead();
						
					}
					}
					
				}
			}
			
			if(persiguiendo) {
				
				if(nivel!=null) {
				if(nivel.jugador.getX()<this.getX()) {
					accelerationVec.add(-aceleracion,0);
					if(nivel.jugador.getX()+1<this.getX()) {
					setScaleX(-1);
					}
				}else if(nivel.jugador.getX()>this.getX()) {
					accelerationVec.add(aceleracion,0);
					setScaleX(1);
			} 
				if(nivel.jugador.getY()<this.getY()) {
				accelerationVec.add(0,-aceleracion);
				
			}else if(nivel.jugador.getY()>this.getY()) {
				accelerationVec.add(0,aceleracion);
		}
			
				
			}else if(nivel2!=null){

				if(nivel2.jugador.getX()<this.getX()) {
					accelerationVec.add(-aceleracion,0);
					if(nivel2.jugador.getX()+1<this.getX()) {
					setScaleX(-1);
					}
				}else if(nivel2.jugador.getX()>this.getX()) {
					accelerationVec.add(aceleracion,0);
					setScaleX(1);
			} 
				if(nivel2.jugador.getY()<this.getY()) {
				accelerationVec.add(0,-aceleracion);
				
			}else if(nivel2.jugador.getY()>this.getY()) {
				accelerationVec.add(0,aceleracion);
		}
//			
			}else {

				if(nivel3.jugador.getX()<this.getX()) {
					accelerationVec.add(-aceleracion,0);
					if(nivel3.jugador.getX()+1<this.getX()) {
					setScaleX(-1);
					}
				}else if(nivel3.jugador.getX()>this.getX()) {
					accelerationVec.add(aceleracion,0);
					setScaleX(1);
			} 
				if(nivel3.jugador.getY()<this.getY()) {
				accelerationVec.add(0,-aceleracion);
				
			}else if(nivel3.jugador.getY()>this.getY()) {
				accelerationVec.add(0,aceleracion);
		}
//			
			}
				
			}
				
			else {
				if(nivel2!=null) {
					
				if(Math.sqrt(Math.pow(nivel2.jugador.getX()-this.getX(),2)+Math.pow(nivel2.jugador.getY()-this.getY(),2))<300&&time>2) {
					persiguiendo=true;
				}
				
				}else if(nivel!=null){
					
					if(Math.sqrt(Math.pow(nivel.jugador.getX()-this.getX(),2)+Math.pow(nivel.jugador.getY()-this.getY(),2))<300&&time>2) {
						persiguiendo=true;
					}
				}else {
					if(Math.sqrt(Math.pow(nivel.jugador.getX()-this.getX(),2)+Math.pow(nivel.jugador.getY()-this.getY(),2))<300&&time>2) {
						persiguiendo=true;
					}
				}
			}
			velocityVec.add(accelerationVec.x*dt, accelerationVec.y*dt);
			velocityVec.x=MathUtils.clamp(velocityVec.x, -velocidadMaxima, velocidadMaxima);
			velocityVec.y=MathUtils.clamp(velocityVec.y, -velocidadMaxima, velocidadMaxima);
			moveBy(velocityVec.x*dt, velocityVec.y*dt);
			accelerationVec.set(0,0);
			
			
			
		}
		
	}
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
    	if(enabled) {
		super.draw(batch, parentAlpha);
		if(nivel!=null)
    	nivel.enemigos.add(this);
		else if (nivel2!=null)
	    nivel2.enemigos.add(this);
		else
			nivel3.enemigos.add(this);
    	}
	}
	/**metodo utilizado para ser spawneado por SpawnGob
	 * @param posicionX para saber la posición X del spawn
	 * @param posicionY para saber la posición Y del spawn*/
	public void spawn (float posicionX,float posicionY) {
		this.enabled=true;
		this.setPosition(posicionX,posicionY);
		
    }
}
	
	

