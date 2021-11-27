import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class SpawnGob extends BaseActor
{
	private ArrayList<Goblin> goblin;
	private int goblins;
	private int goblinActual;
	private float time;
    public SpawnGob(float x, float y, Stage s ,LevelScreen l)
    { 
        super(x,y,s);
        time=0;
        goblins=20;
        		goblinActual=0;		
        goblin=new ArrayList<Goblin>();
		for(int i=0; i<goblins; i++) {
			goblin.add(new Goblin(0,0,s,l));
		}
    } 
    public SpawnGob(float x, float y, Stage s ,LevelScreen2 l)
    { 
        super(x,y,s);
        time=0;
        goblins=20;
        		goblinActual=0;		
        goblin=new ArrayList<Goblin>();
		for(int i=0; i<goblins; i++) {
			goblin.add(new Goblin(0,0,s,l));
		}
    } 
    public SpawnGob(float x, float y, Stage s ,LevelScreen3 l)
    { 
        super(x,y,s);
        time=0;
        goblins=20;
        		goblinActual=0;		
        goblin=new ArrayList<Goblin>();
		for(int i=0; i<goblins; i++) {
			goblin.add(new Goblin(0,0,s,l));
		}
    } 
    public void act(float dt)
    {
    	super.act( dt );
    	time = time+dt;
    }
    public void spawn() {
    	if((Math.random()*300<1 &&goblinActual<goblins &&time >5) || time >10) {
    goblin.get(goblinActual).spawn(getX(),getY());
    	goblinActual++;
    	time=0;
    	}
    }
	public float getTime() {
		return time;
	}
	public void setTime(float time) {
		this.time = time;
	}
    
}