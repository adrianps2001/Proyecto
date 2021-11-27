import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Explosion extends BaseActor
{
	Animation animacion;
	boolean enabled = false;
	float time;
    public Explosion(float x, float y, Stage s)
    { 
       super(x,y,s);
       animacion =loadAnimationFromSheet("assets/platform_metroidvania asset pack v1.01/miscellaneous sprites/orb_collected_anim_strip_5.png", 1, 5, 0.1f, true);
       setScaleX(3);
       setScaleY(3);
    }    
    
    

	@Override
	public void act(float dt) {
		// TODO Auto-generated method stub
		this.setAnimation(animacion);
		
		if(enabled) {
		time+=dt;
		if(time>0.5) {
			enabled=false;
			this.setVisible(false);
			time = 0;
		}}
		
	}

	
	public void update(float dt) {
		// TODO Auto-generated method stub
	}
    
    @Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
    	
    	if(enabled)
		super.draw(batch, parentAlpha);
	}
    
    public void drop (float posicionX,float posicionY) {
		this.enabled=true;
		this.setVisible(true);
		this.setPosition(posicionX,posicionY);
		
    }



	public float getTime() {
		return time;
	}



	public void setTime(float time) {
		this.time = time;
	}
    
}