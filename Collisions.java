import java.util.ArrayList;
public class Collisions {
    private static Collisions instance; 
    private boolean isChanged;
    public Collisions() {
        this.isChanged = true;
    }

    public void checkColisions() {
        if(this.isChanged) {

            Bullet[] bullets = BulletPool.getInstance().getBullets();
            Enemy[] enemies = EnemyPool.getInstance().getEnemyArray();
            ArrayList<Enemy> enemiesDelete = new ArrayList<Enemy>();
            ArrayList<Bullet> bulletsDelete = new ArrayList<Bullet>();

            //TODO kazdy bullet bude mat vlastny array kde pri vystrele prida vsetkych ktorych vobec moze trafit a pozera sa len na vysku a az potom pozicu X 
            for (Bullet bullet : bullets) {

                int y = bullet.getY();
                if(y < 0) {

                    bulletsDelete.add(bullet);
                    continue;
                }
                int x = bullet.getX();

                enemyForEach:
                for (Enemy enemy : enemies) {
                    //TODO idk whats happening
                    if(enemy.checkColision(x, y)) {
                        System.out.println("hit");
                        enemiesDelete.add(enemy);
                        bulletsDelete.add(bullet);
                        break enemyForEach;
                    }
                }
            }
            BulletPool.getInstance().Delete(bulletsDelete);
            EnemyPool.getInstance().Delete(enemiesDelete);
            
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
