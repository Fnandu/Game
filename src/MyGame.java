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
    //Variables
    static Landscape ls;
    static Cannon cannon;
    static Ball ball;
    static Target target;
    boolean enter = false;
    boolean hit = false;
    Font font50;
    Font font20;
    Font bigfont;
    int count = 0;
    Image backgroundstart;
    int score = 0;

    public CannonGame() {
        super("Game");
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        //Iniciamos variables
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
        //Keys enter
        if (input.isKeyDown(Input.KEY_ENTER) || input.isKeyDown(Input.KEY_NUMPADENTER)) {
            enter = true;
        }
        //Reiniciamos el target
        if (input.isKeyDown(Input.KEY_R)){
            hit = true;
        }
        //Inicia el juego
        if (enter){
            cannon.update(gameContainer, i);
            target.update(gameContainer, i);
            ball.update(gameContainer, i);
            ls.update(gameContainer,i);
        }

        count++;
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        double strong = cannon.strength - 20;
        //Cuando inicia el juego
        if (enter) {
            //Cargamos las imagenes
            ls.render(gameContainer, graphics);
            ball.render(gameContainer,graphics);
            cannon.render(gameContainer, graphics);
            target.render(gameContainer,graphics);

            //Si hit es true reiniciamos el target
            if (hit){
                Target.reset();
                hit = false;
            }

            //Fuentes de texto
            font20.drawString(350,50, "Angle: " + cannon.rotation);
            font20.drawString(10,50,"Strength: ");
            font20.drawString(650,50,"Score: " + score);
            if (strong < 30){
                graphics.setColor(Color.green);
            } else if (strong < 65){
                graphics.setColor(Color.yellow);
            } else if (strong > 65) {
                graphics.setColor(Color.red);
            }
            graphics.fillRect(120,40, (float) (5 + strong),10);
            font20.drawString(150,30, String.valueOf(strong));

        } else {

            //Fuentes e imagenes de inicio
            backgroundstart = backgroundstart.getScaledCopy(gameContainer.getWidth(), gameContainer.getHeight());
            graphics.drawImage(backgroundstart, 0, 0);
            font50.drawString(80,
                    300, "PRESS");
            if (count < 60) {
                bigfont.drawString(270,
                        300, "ENTER", Color.yellow);
            } else if (count > 60) {
                bigfont.drawString(270,
                        300, "ENTER", Color.green);
                if (count > 119) {
                    count = 0;
                }
            }
            font50.drawString(480,
                    300, "TO PLAY");
            font20.drawString(gameContainer.getWidth() / 2,
                    gameContainer.getHeight() - 10, "Creado por Fernando da Silva");

        }
    }
}