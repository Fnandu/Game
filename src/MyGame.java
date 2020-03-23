import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;

public class MyGame {
    public static void main(String[] args) throws SlickException {
        CannonGame game = new CannonGame();
        AppGameContainer app = new AppGameContainer(game,800,600,false);
        app.start();
    }
}

class CannonGame extends BasicGame{
    public CannonGame() {
        super("Game");
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        gameContainer.setTargetFrameRate(60);
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

    }
}

