/**
 * Write a description of class Hra here.
 * 
 * @author Patrik Zak 
 * @version 2
 */
public class PlayerController {
    private Turret turret;
    private static PlayerController instance;
    private int speed;
    public PlayerController() {
        this.turret = new Turret();
        this.speed = 5;
    }
   /* public void moveUp() {
        turret.moveY(-speed);
        System.out.println("up");
    }
    public void moveDown() {
        turret.moveY(speed);
        System.out.println("down");
    }*/
    public void moveLeft() {
        this.turret.moveX(-this.speed);
        System.out.println("left");
    }
    public void moveRight() {
        this.turret.moveX(this.speed);
        System.out.println("right");
    }
    public void activate() {
        this.turret.shoot();
        System.out.println("shoot");
    }
    
    public static PlayerController getInstance() {
        if (instance == null) {
            instance = new PlayerController();  
        }
        return instance;
    }
}
