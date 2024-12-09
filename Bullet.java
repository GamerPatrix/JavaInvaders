/** 
 * @author Patrik Zak 
 * @version 6
 */
public class Bullet extends GameObject {
    private DirectionNum direction;
    private int speed;
    public Bullet(int x , int y, DirectionNum direction) {
        this.direction = direction;
        this.setPos(x, y);
        this.changeImage("pics\\Bullet.png");
        this.speed = 10;
        this.setSize(5, 10 + this.speed);
    }

    /**
     * Moves the bullet in the desired direction 
     */
    public void move() {
        switch (this.direction) {
            case UP: 
                this.moveY(-this.speed);
                break;
            case DOWN:
                this.moveY(this.speed);
                break;
            
        }
    }
    
}
