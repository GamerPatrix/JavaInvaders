public class OvladanieHracom {
    private Turret turret;
    private static OvladanieHracom instance;
    private int speed;
    public OvladanieHracom() {
        this.turret = new Turret();
        this.speed = 5;
    }
    /*public void moveUp() {
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
    
    public static OvladanieHracom getInstance() {
        if (instance == null) {
            instance = new OvladanieHracom();  
        }
        return instance;
    }
}
