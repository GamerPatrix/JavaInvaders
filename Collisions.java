import java.util.ArrayList;
/**
 * this class is a manager of game releated colisions in the scene
 * 
 * @author Patrik Zak 
 * @version 7
 */
public class Collisions {
    private static Collisions instance; 
    private boolean isChanged;
    public Collisions() {
        this.isChanged = true;
    }

    /** 
     * checks each bullet with every enemy on scene 
     * is called every tick
     */ 
    public void checkColisions() {
        if (this.isChanged) {

            Bullet[] bullets = BulletPool.getInstance().getBullets();
            Enemy[] enemies = EnemyPool.getInstance().getEnemyArray();
            ArrayList<Enemy> enemiesDelete = new ArrayList<Enemy>();
            ArrayList<Bullet> bulletsDelete = new ArrayList<Bullet>();

            // TODO when using the break in the enemy foreach & when there is only one bullet in the scene it doesnt destroy the enemy for some reason
            for (Bullet bullet : bullets) {

                int y = bullet.getY();
                if (y < 0) {
                    //bullet has reached the top of the window
                    bulletsDelete.add(bullet);
                    continue;
                }
                int x = bullet.getX();

                //enemyForEach:
                for (Enemy enemy : enemies) {                
                    if (enemy.checkColision(x, y)) {
                        //the bullet has hit this enemy
                        //System.out.println("hit");
                        enemiesDelete.add(enemy);
                        bulletsDelete.add(bullet);
                        //break enemyForEach;

                    }
                }
            }
            
            BulletPool.getInstance().delete(bulletsDelete);
            EnemyPool.getInstance().delete(enemiesDelete);

            //this.isChanged = false;
        } else {
            return;
        }
    }
    //TODO not Implemented
    private void changed() {
        this.isChanged = true;
    }

    public static Collisions getInstance() {
        if (instance == null) {
            instance = new Collisions();  
        }
        return instance;
    }
}
