import java.util.ArrayList;
public class Collisions {
    private static Collisions instance; 
    private boolean isChanged;
    public Collisions() {
        this.isChanged = true;
    }

    public void checkColisions() {
        if (this.isChanged) {

            Bullet[] bullets = BulletPool.getInstance().getBullets();
            Enemy[] enemies = EnemyPool.getInstance().getEnemyArray();
            ArrayList<Enemy> enemiesDelete = new ArrayList<Enemy>();
            ArrayList<Bullet> bulletsDelete = new ArrayList<Bullet>();

            // when there is only one bullet in the scene it doesnt destroy the enemy for some reason
            for (Bullet bullet : bullets) {

                int y = bullet.getY();
                if (y < 0) {

                    bulletsDelete.add(bullet);
                    continue;
                }
                int x = bullet.getX();

                //enemyForEach:
                for (Enemy enemy : enemies) {                
                    if (enemy.checkColision(x, y)) {
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
