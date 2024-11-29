public class OvladanieHracom {
    private Turret turret;
    private static OvladanieHracom instance;
    private int speed;
    public OvladanieHracom() {
        this.turret = new Turret();
        speed = 5;
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
        turret.moveX(-speed);
        System.out.println("left");
    }
    public void moveRight() {
        turret.moveX(speed);
        System.out.println("right");
    }
    public void activate() {
        turret.shoot();
        System.out.println("shoot");
    }
    
    public static OvladanieHracom getInstance() {
        if (instance == null) {
            instance = new OvladanieHracom();  
        }
        return instance;
    }
}
