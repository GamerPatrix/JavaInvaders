import java.util.ArrayList;

/**
 * Write a description of class BulletPool here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BulletPool {
    private static BulletPool instance;
    private ArrayList<Bullet> pool;
    //private EnemyPool enemyPool;
    public BulletPool() {
        pool = new ArrayList<Bullet>(); 
        //this.enemyPool = EnemyPool.getInstance();
    }

    public void bulletShoot(int x, int y, SmerNum smer) {
        System.out.println("Bullet");
        Bullet a = new Bullet(x,y,SmerNum.up);
        this.pool.add(a); 
        System.out.println("created");
    }

    public void update() {
        this.moveBullets();
    }

    private void moveBullets() {
        for(Bullet bullet : pool) {
            bullet.move();
        }
    }

    public void Delete (Bullet bullets) {
        pool.remove(bullets);
    }

    public void Delete (ArrayList<Bullet> bullets) {
        for(Bullet obj : bullets) {
            obj.hide();
            pool.remove(obj);
        }
    }

    public Bullet[] getBullets() {
        
        Bullet[] ret = new Bullet[this.pool.size()];
        for(int i = 0; i < ret.length; i++) {
            ret[i] = this.pool.get(i);
        }
        return ret;

    }
    
    public Bullet getBullet(int a) {
        return this.pool.get(a);
    }

    public static BulletPool getInstance() {
        if (instance == null) {
            instance = new BulletPool();  
        }
        return instance;
    }
    
}
