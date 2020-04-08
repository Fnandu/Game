import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Ball extends CannonGame {

    //Variables de la bola
    int x = 30;
    int y = 475;
    double vel = 0;
    double ang = 0;
    double grav = -9.8;
    double px = 0;
    double py = 0;
    Image ball;
    boolean fire = false;


    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {

        //Si dispara calculamos la parabola
        if (fire) {
            vel = cannon.strength;
            ang = cannon.rotation * Math.PI /180f;
            double vx = vel * Math.cos(ang);
            double vy = vel * Math.sin(ang);
            float t = 0;

            while (py >= 0) {
                px = x + vx * t;
                py = y + vy*t + grav*t*t/2f;
                t += 0.1f;
            }

            x += vx;
            y -= vy;
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        //Cargamos imagenes y lo dibujamos
        ball = ResourceManager.getImage("resources/ball.png");
        graphics.drawImage(ball, x, y);

        //Si se para de largo o altura se detiene y la pelota vuelve a la posición inicial
        if (x > gameContainer.getWidth() * 2 || y > gameContainer.getHeight()){

            fire = false;
            setInitialPosition();

        }

    }

    static boolean hasFallen() {
        return true;
    }

    //Disparo
    void setFire(){
        fire = true;
    }

    //Posición inicial
    void setInitialPosition(){
        x = 30;
        y = 475;
    }


}
