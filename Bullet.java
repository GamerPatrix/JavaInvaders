public class Bullet extends GameObject {
    private SmerNum smer;
    private int speed;
    public Bullet(int x , int y, SmerNum smer) {
        this.smer = smer;
        this.SetPos(x, y);
        this.changeImage("pics\\Bullet.png");
        this.speed = 10;
        this.setSize(5, 10*speed);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void move() {
        switch (this.smer) {
            case up: 
            this.moveY(-this.speed);
            break;
            case down:
            this.moveY(this.speed);
            break;
            
        }
    }
    
}