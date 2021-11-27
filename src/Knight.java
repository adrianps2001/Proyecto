import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Color;

public class Knight extends BaseActor  
{
    private Animation stand;
    private Animation walk;
	private ArrayList<Ataque> ataques;
	private ArrayList<AtaqueUp> ataquesUp;
	private ArrayList<Disparo> disparos;
	private int numAtaques;
	private int numDisparos;
	private int direccionY;
	private int direccionX;
	private boolean direccionRX = true;
	private boolean powerup1;
	private boolean powerup2;
	private float coolDownAtaque;
	private float cuentaCoolDownAtaque;
	private float coolDownDisparo;
	private float cuentaCoolDownDisparo;
	private int ataqueActual;
	private int disparoActual;
    private float walkAcceleration;
    private float walkDeceleration;
    private float maxSpeed;
    private float gravity;
    private float maxVerticalSpeed;
   
    private Animation jump;
    private float jumpSpeed;
    private BaseActor belowSensor;

    public Knight(float x, float y, Stage s, LevelScreen nivel,boolean powerup1,boolean powerup2)
    {
        super(x,y,s);

 stand =  loadAnimationFromSheet("assets/herochar sprites(new)/herochar_idle_anim_strip_4.png", 1, 4, 0.1f, true);
        

        walk = loadAnimationFromSheet("assets/herochar sprites(new)/herochar_run_anim_strip_6.png", 1, 6, 0.1f, true);


        maxSpeed = 75;
        walkAcceleration   = 1000000;
        walkDeceleration   = 1000000;
        gravity            = 700;
        maxVerticalSpeed   = 1000;
        
        setBoundaryPolygon(8);
        this.powerup1=powerup1;
        this.powerup2=powerup2;
        jump = walk;
        jumpSpeed = 400;

        // set up the below sensor
        belowSensor = new BaseActor(0,0, s);
     
        belowSensor.setSize( this.getWidth() - 8, 8 );
        belowSensor.setBoundaryRectangle();
       // belowSensor.setVisible(false);
        
        ataqueActual=0;
		numAtaques=1;
		this.coolDownAtaque=1f;
		this.cuentaCoolDownAtaque=0;
		ataques=new ArrayList<Ataque>();
		for(int i=0; i<numAtaques; i++) {
			ataques.add(new Ataque(0,0,s,nivel));
		}
		ataquesUp=new ArrayList<AtaqueUp>();
		for(int i=0; i<numAtaques; i++) {
			ataquesUp.add(new AtaqueUp(0,0,s,nivel));
		}
		disparoActual=0;
		numDisparos=1;
		this.coolDownDisparo=2f;
		this.cuentaCoolDownDisparo=0;
		disparos=new ArrayList<Disparo>();
		for(int i=0; i<numDisparos; i++) {
			disparos.add(new Disparo(0,0,s,nivel));
		}
		
    }
    public Knight(float x, float y, Stage s, LevelScreen2 nivel,boolean powerup1,boolean powerup2)
    {
        super(x,y,s);

 stand =  loadAnimationFromSheet("assets/herochar sprites(new)/herochar_idle_anim_strip_4.png", 1, 4, 0.1f, true);
        

        walk = loadAnimationFromSheet("assets/herochar sprites(new)/herochar_run_anim_strip_6.png", 1, 6, 0.1f, true);


        maxSpeed = 75;
        walkAcceleration   = 1000000;
        walkDeceleration   = 1000000;
        gravity            = 700;
        maxVerticalSpeed   = 1000;
        
        setBoundaryPolygon(8);
        this.powerup1=powerup1;
        this.powerup2=powerup2;
        jump = walk;
        jumpSpeed = 400;

        // set up the below sensor
        belowSensor = new BaseActor(0,0, s);
     
        belowSensor.setSize( this.getWidth() - 8, 8 );
        belowSensor.setBoundaryRectangle();
       // belowSensor.setVisible(false);
        
        ataqueActual=0;
		numAtaques=1;
		this.coolDownAtaque=1f;
		this.cuentaCoolDownAtaque=0;
		ataques=new ArrayList<Ataque>();
		for(int i=0; i<numAtaques; i++) {
			ataques.add(new Ataque(0,0,s,nivel));
		}
		ataquesUp=new ArrayList<AtaqueUp>();
		for(int i=0; i<numAtaques; i++) {
			ataquesUp.add(new AtaqueUp(0,0,s,nivel));
		}
		disparoActual=0;
		numDisparos=1;
		this.coolDownDisparo=2f;
		this.cuentaCoolDownDisparo=0;
		disparos=new ArrayList<Disparo>();
		for(int i=0; i<numDisparos; i++) {
			disparos.add(new Disparo(0,0,s,nivel));
		}
		
    }
    public Knight(float x, float y, Stage s, LevelScreen3 nivel,boolean powerup1,boolean powerup2)
    {
        super(x,y,s);

 stand =  loadAnimationFromSheet("assets/herochar sprites(new)/herochar_idle_anim_strip_4.png", 1, 4, 0.1f, true);
        

        walk = loadAnimationFromSheet("assets/herochar sprites(new)/herochar_run_anim_strip_6.png", 1, 6, 0.1f, true);


        maxSpeed = 75;
        walkAcceleration   = 1000000;
        walkDeceleration   = 1000000;
        gravity            = 700;
        maxVerticalSpeed   = 1000;
        
        setBoundaryPolygon(8);
        this.powerup1=powerup1;
        this.powerup2=powerup2;
        jump = walk;
        jumpSpeed = 400;

        // set up the below sensor
        belowSensor = new BaseActor(0,0, s);
     
        belowSensor.setSize( this.getWidth() - 8, 8 );
        belowSensor.setBoundaryRectangle();
       // belowSensor.setVisible(false);
        
        ataqueActual=0;
		numAtaques=1;
		this.coolDownAtaque=1f;
		this.cuentaCoolDownAtaque=0;
		ataques=new ArrayList<Ataque>();
		for(int i=0; i<numAtaques; i++) {
			ataques.add(new Ataque(0,0,s,nivel));
		}
		ataquesUp=new ArrayList<AtaqueUp>();
		for(int i=0; i<numAtaques; i++) {
			ataquesUp.add(new AtaqueUp(0,0,s,nivel));
		}
		disparoActual=0;
		numDisparos=1;
		this.coolDownDisparo=2f;
		this.cuentaCoolDownDisparo=0;
		disparos=new ArrayList<Disparo>();
		for(int i=0; i<numDisparos; i++) {
			disparos.add(new Disparo(0,0,s,nivel));
		}
		
    }

    public Knight(float x, float y, Stage s, LevelScreen2 nivel)
    {
        super(x,y,s);

        stand =  loadAnimationFromSheet("assets/herochar sprites(new)/herochar_idle_anim_strip_4.png", 1, 4, 0.1f, true);
        

        walk = loadAnimationFromSheet("assets/herochar sprites(new)/herochar_run_anim_strip_6.png", 1, 6, 0.1f, true);

        maxSpeed = 175;
        walkAcceleration   = 1000000;
        walkDeceleration   = 1000000;
        gravity            = 700;
        maxVerticalSpeed   = 1000;

        setBoundaryPolygon(8);

        jump = walk;
        jumpSpeed = 400;

        // set up the below sensor
        belowSensor = new BaseActor(0,0, s);
     
        belowSensor.setSize( this.getWidth() - 8, 8 );
        belowSensor.setBoundaryRectangle();
       // belowSensor.setVisible(false);
        
        ataqueActual=0;
		numAtaques=1;
		this.coolDownAtaque=1f;
		this.cuentaCoolDownAtaque=0;
		ataques=new ArrayList<Ataque>();
		for(int i=0; i<numAtaques; i++) {
			ataques.add(new Ataque(0,0,s,nivel));
		}
    }
    public void act(float dt)
    {
        super.act( dt );

        // get keyboard input
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            accelerationVec.add( -walkAcceleration, 0 );
        direccionX = -30;
        direccionRX = false;
        }

        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            accelerationVec.add( walkAcceleration, 0 );
        direccionX = 30;
        direccionRX = true;

        }
        if (Gdx.input.isKeyPressed(Keys.UP)) {
            accelerationVec.add( 0, walkAcceleration );
        direccionY = 30;
        }
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            accelerationVec.add( 0, -walkAcceleration );
        direccionY = -30;
        }
        if (!Gdx.input.isKeyPressed(Keys.LEFT)&&!Gdx.input.isKeyPressed(Keys.RIGHT))
        	 direccionX = 0;

        if (!Gdx.input.isKeyPressed(Keys.UP)&&!Gdx.input.isKeyPressed(Keys.DOWN))
        direccionY = 0;
        
    	if(cuentaCoolDownAtaque>0) {
			this.cuentaCoolDownAtaque-=dt;
		}
    	if(cuentaCoolDownDisparo>0) {
			this.cuentaCoolDownDisparo-=dt;
		}
        
        
        
        if (Gdx.input.isKeyPressed(Keys.Z) && this.cuentaCoolDownAtaque<=0) {
        	if(!powerup1) {
        	atacar(direccionX,direccionY);
        }
        	if(powerup1) {
        	atacarUp(direccionX,direccionY);
        	}
        }
        if (Gdx.input.isKeyPressed(Keys.X) && this.cuentaCoolDownDisparo<=0 && numDisparos!=0)
        	disparar(direccionX,direccionY);
        if ( !Gdx.input.isKeyPressed(Keys.RIGHT)
        && !Gdx.input.isKeyPressed(Keys.LEFT)  )
        {
            float decelerationAmount = walkDeceleration * dt;

            float walkDirection;
            
            if ( velocityVec.x > 0 )
                walkDirection = 1;
            else
                walkDirection = -1;

            float walkSpeed = Math.abs( velocityVec.x );

            walkSpeed -= decelerationAmount;

            if (walkSpeed < 0)
                walkSpeed = 0;

            velocityVec.x = walkSpeed * walkDirection;
        }
        
        if (  !Gdx.input.isKeyPressed(Keys.UP)
        && !Gdx.input.isKeyPressed(Keys.DOWN)  )
        {
            float decelerationAmount = walkDeceleration * dt;

            float walkDirection;
            
            if ( velocityVec.y > 0 )
                walkDirection = 1;
            else
                walkDirection = -1;

            float walkSpeed = Math.abs( velocityVec.y );

            walkSpeed -= decelerationAmount;

            if (walkSpeed < 0)
                walkSpeed = 0;

            velocityVec.y = walkSpeed * walkDirection;
        }

        accelerationVec.add(0, 0);
        velocityVec.add( accelerationVec.x * dt, accelerationVec.y * dt );
        velocityVec.x = MathUtils.clamp( velocityVec.x, -maxSpeed, maxSpeed );
        velocityVec.y = MathUtils.clamp( velocityVec.y,  -maxSpeed, maxSpeed );
        moveBy( velocityVec.x * dt, velocityVec.y * dt );

        // reset acceleration
        accelerationVec.set(0,0);

        // move the below sensor below the koala
        belowSensor.setPosition( getX() + 4, getY() - 8 );

        // manage animations
        if ( this.isOnSolid() )
        {
            
            if ( velocityVec.x == 0 && velocityVec.y == 0  )
                setAnimation(stand);
            else
                setAnimation(walk);
        }
        else
        {
          
            
        }

        if ( velocityVec.x > 0 ) // face right
           
        	setScaleX(1);
        
        if ( velocityVec.x < 0 ) // face left
            setScaleX(-1);
        
     
        alignCamera();
        boundToWorld();
    }

    public boolean belowOverlaps(BaseActor actor)
    {
        return belowSensor.overlaps(actor);
    }

    public boolean isOnSolid()
    {
        for (BaseActor actor : BaseActor.getList( getStage(), "Solid" ))
        {
            Solid solid = (Solid)actor;
            if ( belowOverlaps(solid) && solid.isEnabled() )
                return true;
        }   

        return true;
    }

    public void atacar(int direccionX,int direccionY)
    {
    	if(direccionX ==0 && direccionY==0) {
    		if(direccionRX) {
    	ataques.get(ataqueActual).atacar(30,direccionY);
    		}
    	else {
        	ataques.get(ataqueActual).atacar(-30,direccionY);

    	}}else {
    		ataques.get(ataqueActual).atacar(direccionX,direccionY);
    	}
		ataqueActual++;
		ataqueActual=ataqueActual%numAtaques;
		cuentaCoolDownAtaque=coolDownAtaque;
		
    	
    }
    public void atacarUp(int direccionX,int direccionY)
    {
    	if(direccionX ==0 && direccionY==0) {
    		if(direccionRX) {
    	ataquesUp.get(ataqueActual).disparar(30,direccionY);
    		}
    	else {
        	ataquesUp.get(ataqueActual).disparar(-30,direccionY);

    	}}else {
    		ataquesUp.get(ataqueActual).disparar(direccionX,direccionY);
    	}
		ataqueActual++;
		ataqueActual=ataqueActual%numAtaques;
		cuentaCoolDownAtaque=coolDownAtaque;
		
    	
    }
    public void disparar(int direccionX,int direccionY)
    {
    	if(direccionX ==0 && direccionY==0) {
    		if(direccionRX) {
    			disparos.get(disparoActual).disparar(30,direccionY,powerup2);
    		}
    	else {
    		disparos.get(disparoActual).disparar(-30,direccionY,powerup2);

    	}}else {
    		disparos.get(disparoActual).disparar(direccionX,direccionY,powerup2);
    	}
    	disparoActual++;
		disparoActual=disparoActual%numDisparos;
		numDisparos=0;
		cuentaCoolDownDisparo=coolDownDisparo;
		
    	
    }
    
    

    public boolean isPowerup1() {
		return powerup1;
	}
	public void setPowerup1(boolean powerup1) {
		this.powerup1 = powerup1;
	}
	public boolean isPowerup2() {
		return powerup2;
	}
	public void setPowerup2(boolean powerup2) {
		this.powerup2 = powerup2;
	}
	public boolean isFalling()
    {
        return (velocityVec.y < 0);
    }

   
    

	public float getMaxHorizontalSpeed() {
		return maxSpeed;
	}

	public void setMaxHorizontalSpeed(float maxHorizontalSpeed) {
		this.maxSpeed = maxHorizontalSpeed;
	}
	public void setNumDisparos(int numDisparos) {
		this.numDisparos = numDisparos;
	}
	public int getNumDisparos() {
		return numDisparos;
	}
	public float getWalkAcceleration() {
		return walkAcceleration;
	}

	public void setWalkAcceleration(float walkAcceleration) {
		this.walkAcceleration = walkAcceleration;
	}

	public float getWalkDeceleration() {
		return walkDeceleration;
	}

	public void setWalkDeceleration(float walkDeceleration) {
		this.walkDeceleration = walkDeceleration;
	}

	





	
    

}