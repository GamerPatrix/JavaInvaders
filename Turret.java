public class Turret extends GameObject {
    private BulletPool bulletPool;
    
    public Turret() {
        bulletPool = BulletPool.getInstance();
        this.changeImage("pics\\Turret.png");
        this.SetPos(1,600);
        //set size of image
        this.setSize(100, 50);
    }
    
    public void setPosition(int x, int y) {
        this.SetPos(x, y);
    }
    
    public void shoot() {
        
        int x = this.getX() + (this.getSizeX()/2);
        int y = this.getY()+2;
        bulletPool.bulletShoot(x,y, SmerNum.up);
    }
    
    
}
