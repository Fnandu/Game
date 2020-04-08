import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Landscape extends CannonGame {

    //Variables del fondo
    Image background;
    Image cloud;
    int x = 0;

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        x--;
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        //Cargamos imagenes y los dibujamos
        background = ResourceManager.getImage("resources/landscape.jpg");
        cloud = ResourceManager.getImage("resources/cloud.png");
        background = background.getScaledCopy(gameContainer.getWidth(),gameContainer.getHeight());
        graphics.drawImage(background,0,0);
        graphics.drawImage(cloud,x,100);
        graphics.drawImage(cloud,x+800,100);

        //Reseteamos el movimiento de la nube
        if (x+800 == 0){
            x = 0;
        }
    }
}
