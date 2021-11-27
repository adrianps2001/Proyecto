import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Puerta extends BaseActor
{
	boolean enabled;
	boolean open;
    public Puerta(float x, float y, Stage s)
    { 
       super(x,y,s);
       loadTexture("assets/platform_metroidvania asset pack v1.01/miscellaneous sprites/closedoor.png");
       open=true;
       enabled=true;
    }    
    
    @Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
    	if(enabled)
		super.draw(batch, parentAlpha);
	}
    
  
    public void open() {
    	this.open=true;
    }

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}
    
}