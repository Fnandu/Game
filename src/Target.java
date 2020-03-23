import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

import java.awt.*;

public class Target extends CannonGame {
    Shape shape;

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {



    }

    @Override
    public void render(GameContainer gameContainer, org.newdawn.slick.Graphics graphics) throws SlickException {


    }

    static boolean hit(){return false;}

    static void reset(){}

    Shape getShape(){
        this.shape = new Rectangle(0,0);

        return shape;
    }
}
