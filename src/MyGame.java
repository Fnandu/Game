import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;

public class MyGame {
    public static void main(String[] args) throws SlickException {
        CannonGame game = new CannonGame();
        AppGameContainer app = new AppGameContainer(game, 800, 600, false);
        app.setShowFPS(false);
        app.start();
    }
}

class CannonGame extends BasicGame {
    Landscape ls;
    Cannon cannon;
    Ball ball;
    Target target;
    boolean enter = false;
    boolean hit = false;
    Font font50;
    Font font20;
    Font bigfont;
    int count = 0;
    Image backgroundstart;

    public CannonGame() {
        super("Game");
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        gameContainer.setTargetFrameRate(59);
        ls = new Landscape();
        cannon = new Cannon();
        ball = new Ball();
        target = new Target();
        font50 = ResourceManager.getFont("resources/WHITRABT.ttf", 50);
        font20 = ResourceManager.getFont("resources/WHITRABT.ttf", 20);
        bigfont = ResourceManager.getFont("resources/WHITRABT.ttf", 60);
        backgroundstart = ResourceManager.getImage("resources/startlandscape.jpg");

    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        Input input = gameContainer.getInput();
        if (input.isKeyDown(Input.KEY_ENTER) || input.isKeyDown(Input.KEY_NUMPADENTER)) {
            enter = true;

        }
        if (input.isKeyDown(Input.KEY_R)){
            hit = true;
        }

        if (enter) {
            cannon.update(gameContainer, i);
        }

        count++;
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        if (enter) {
            ls.render(gameContainer, graphics);
            cannon.render(gameContainer, graphics);
            target.render(gameContainer,graphics);
            if (hit){
                Target.reset();
                hit = false;
            }
            font20.drawString(gameContainer.getWidth()/2 - 50,50, "Angle: " + cannon.rotation);
            font20.drawString(10,50,"Strength: ");
            graphics.drawRect(120,40, (float) (5 + cannon.strength),10);
            font20.drawString(150,30, String.valueOf(cannon.strength));

        } else {

            backgroundstart = backgroundstart.getScaledCopy(gameContainer.getWidth(), gameContainer.getHeight());
            graphics.drawImage(backgroundstart, 0, 0);
            font50.drawString(gameContainer.getWidth() / 2 - 320,
                    gameContainer.getHeight() / 2, "PRESS");
            if (count < 60) {
                bigfont.drawString(gameContainer.getWidth() / 2 - 130,
                        gameContainer.getHeight() / 2, "ENTER", Color.yellow);
            } else if (count > 60) {
                bigfont.drawString(gameContainer.getWidth() / 2 - 130,
                        gameContainer.getHeight() / 2, "ENTER", Color.green);
                if (count > 119) {
                    count = 0;
                }
            }
            font50.drawString(gameContainer.getWidth() / 2 + 80,
                    gameContainer.getHeight() / 2, "TO PLAY");
            font20.drawString(gameContainer.getWidth() / 2,
                    gameContainer.getHeight() - 10, "Creado por Fernando da Silva");

        }
    }
}