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
    private PlayerStopWatch timer;
    private boolean canFire;
    private int firerate;
    public PlayerController() {
        this.turret = new Turret();
        this.speed = 5;
        this.canFire = true;
        this.firerate = 10;
        
        this.timer = new PlayerStopWatch(this);
        MyManager.getInstance().manageObject(this.timer);
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

    public void setFireRate(int newFirerate) {
        this.firerate = newFirerate;
    }
    
    public void activate() {
        if (this.canFire) { 
            this.turret.shoot();
            System.out.println("shoot");
            this.canFire = false;
            this.timer.start(this.firerate); // number of ticks till next awailable fire
        }
    }

    public void canFireAgain() {
        this.canFire = true;
    }

    public void clear() {
        MyManager.getInstance().stopManagingObject(this);
        this.turret.hide();
        this.canFire = false;
        MyManager.getInstance().stopManagingObject(this.timer);
    }

    public void myInit() {
        MyManager.getInstance().manageObject(this);
        this.turret.show();
        this.canFire = true;
        MyManager.getInstance().manageObject(this.timer);
    }
    
    public static PlayerController getInstance() {
        if (instance == null) {
            instance = new PlayerController();  
        }
        return instance;
    }
    
    public void setSpeed(int newSpeed) {
        this.speed = newSpeed;
    }
}
