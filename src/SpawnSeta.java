import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class SpawnSeta extends BaseActor
{
	private ArrayList<Seta> seta;
	private int setas;
	private int setaActual;
	private float time;
    public SpawnSeta(float x, float y, Stage s ,LevelScreen l)
    { 
        super(x,y,s);
        setas=60;
        		setaActual=0;		
        seta=new ArrayList<Seta>();
		for(int i=0; i<setas; i++) {
			seta.add(new Seta(0,0,s,l));
		}
    } 
    
    public SpawnSeta(float x, float y, Stage s ,LevelScreen2 l)
    { 
        super(x,y,s);
        setas=60;
        		setaActual=0;		
        seta=new ArrayList<Seta>();
		for(int i=0; i<setas; i++) {
			seta.add(new Seta(0,0,s,l));
		}
    } 
    public SpawnSeta(float x, float y, Stage s ,LevelScreen3 l)
    { 
        super(x,y,s);
        setas=60;
        		setaActual=0;		
        seta=new ArrayList<Seta>();
		for(int i=0; i<setas; i++) {
			seta.add(new Seta(0,0,s,l));
		}
    } 
    public void act(float dt)
    {
    	super.act( dt );
    	time = time+dt;
    }
    public void spawn() {
    	if((Math.random()*300<1 &&setaActual<setas &&time >5) || time >10) {
    seta.get(setaActual).spawn(getX(),getY());
    	setaActual++;
    	time=0;
    	}
    }
    }
    