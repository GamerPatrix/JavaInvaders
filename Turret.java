public class Turret extends GameObject {
    private BulletPool bulletPool;
    
    public Turret() {
        this.bulletPool = BulletPool.getInstance();
        this.changeImage("pics\\Turret.png");
        this.setPos(1, 600);
        //set size of image
        this.setSize(100, 50);
    }
    
    public void setPosition(int x, int y) {
        this.setPos(x, y);
    }
    
    public void shoot() {
        
        int x = this.getX() + (this.getSizeX() / 2);
        int y = this.getY() + 2;
        this.bulletPool.bulletShoot(x, y, SmerNum.UP);
    }
    
    
}
