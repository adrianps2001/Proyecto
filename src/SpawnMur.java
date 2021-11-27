import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class SpawnMur extends BaseActor
{
	private ArrayList<Murcielago> murcielago;
	private int murcielagos;
	private int murcielagoActual;
	private float time;
    public SpawnMur(float x, float y, Stage s ,LevelScreen l)
    { 
        super(x,y,s);
        time=0;
        murcielagos=30;
        murcielagoActual=0;		
        		murcielago=new ArrayList<Murcielago>();
		for(int i=0; i<murcielagos; i++) {
			murcielago.add(new Murcielago(0,0,s,l));
		}
    } 
    public SpawnMur(float x, float y, Stage s ,LevelScreen2 l)
    { 
        super(x,y,s);
        time=0;
        murcielagos=30;
        murcielagoActual=0;		
        murcielago=new ArrayList<Murcielago>();
		for(int i=0; i<murcielagos; i++) {
			murcielago.add(new Murcielago(0,0,s,l));
		}
    } 
    public SpawnMur(float x, float y, Stage s ,LevelScreen3 l)
    { 
        super(x,y,s);
        time=0;
        murcielagos=30;
        murcielagoActual=0;		
        murcielago=new ArrayList<Murcielago>();
		for(int i=0; i<murcielagos; i++) {
			murcielago.add(new Murcielago(0,0,s,l));
		}
    } 
    public void act(float dt)
    {
    	super.act( dt );
    	time = time+dt;
    }
    public void spawn() {
    	if((Math.random()*300<1 &&murcielagoActual<murcielagos &&time >5) || time >10) {
    		murcielago.get(murcielagoActual).spawn(getX(),getY());
    murcielagoActual++;
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