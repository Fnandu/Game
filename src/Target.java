import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Graphics;

import org.newdawn.slick.Image;

import java.awt.*;
import java.util.Random;

public class Target extends CannonGame {
    //Variables del target
    Shape shape;
    Image target;
    static Random r = new Random();
    static int randomnumber = r.nextInt(450)+250;

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {



    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        //Cargamos imagenes y lo dibujamos
        target = ResourceManager.getImage("resources/target.png");
        graphics.drawImage(target,randomnumber,gameContainer.getHeight()-80);
    }

    static boolean hit(){return false;}

    //Reseteamos el target en una zona aleatoria
    static void reset(){
        randomnumber = r.nextInt(450)+250;
    }

    Shape getShape(){
        this.shape = new Rectangle(target.getWidth(), target.getHeight());

        return shape;
    }
}
