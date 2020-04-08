import org.newdawn.slick.*;

public class Cannon extends CannonGame {

    //Variables del cañon
    double rotation = 5;
    double strength = 21;
    Image cannon;
    Image base_cannon;

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {

        Input input = gameContainer.getInput();

        //Keys de angulo y fuerza
        if (input.isKeyDown(Input.KEY_DOWN)) {
            if (cannon.getRotation() * -1 > 5) {
                cannon.rotate(2);
                rotation = cannon.getRotation() * -1;
            }
        }
        if (input.isKeyDown(Input.KEY_UP)) {
            if (cannon.getRotation() * -1 < 80) {
                cannon.rotate(-2);
                rotation = cannon.getRotation() * -1;
            }
        }

        if (input.isKeyDown(Input.KEY_RIGHT)){
            if (strength < 120){
                strength++;
            }
        }
        if (input.isKeyDown(Input.KEY_LEFT)){
            if (strength > 20) {
                strength--;
            }
        }

        //Disparar bola
        if (input.isKeyDown(Input.KEY_SPACE)) {
            fire(ball);
        }

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        //Cargamos imagenes y los dibujamos
        cannon = ResourceManager.getImage("resources/cannon.png");
        base_cannon = ResourceManager.getImage("resources/cannon_base.png");
        graphics.drawImage(cannon, 25, 450);
        graphics.drawImage(base_cannon, 25, 480);
        //Indicamos el centro de rotación
        cannon.setCenterOfRotation(35, 35);

    }

    //Disparo
    void fire(Ball ball){
        ball.setFire();
    }

    void updateRotation(double deltaRotation){
        cannon.setRotation(45);}

    void updateStrength(double deltaStrength){}

    double getRotation(){return this.rotation;}

    double getStrength(){return this.strength;}
}
