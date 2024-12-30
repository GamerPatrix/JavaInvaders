import java.util.ArrayList;
/**
 * Write a description of class Hra here.
 * 
 * @author Patrik Zak 
 * @version 6
 */
public class EnemyPool /*implements iGameLogic*/ {
    private static EnemyPool instance;

    private ArrayList<Enemy> pool;
    private ArrayList<Enemy> endLeft;
    private ArrayList<Enemy> endRight;

    private int allwedMoveDistance;
    private int actualMoveDistance;
    private boolean isright;
    private int speed;
    private int lowestHeight;
    private int rightSide;
    
    private int numberOfAttemptsR;
    private int numberOfAttemptsL;
    private EnemyPool() {
        this.pool = new ArrayList<Enemy>(); 
        this.endLeft = new ArrayList<Enemy>(); 
        this.endRight = new ArrayList<Enemy>(); 
        this.speed = 6;
        this.allwedMoveDistance = 10;
        this.actualMoveDistance = 0;
        this.isright = true;
        this.lowestHeight = 0;        
        this.rightSide = 1000;
    }   
    
    public int getMinHeight() {
        return this.lowestHeight;
    }

    private Enemy createEnemy(int x, int y) {
        Enemy a = new Enemy();
        a.setPos(x, y);
        this.pool.add(a);
        return a;
    }

    public void update() {
        if (this.pool.isEmpty()) {
            this.noEnemiesLeft();
        }
        if (this.isFurtherThanEdge()) {
            this.isright = !this.isright;
            for (Enemy obj : this.pool) {
                obj.moveY(this.speed);
            }
        }

        int distance;
        if (this.isright) {
            distance = this.speed;
        } else {
            distance = -this.speed;
        }

        for (Enemy obj : this.pool) {
            obj.moveX(distance);
        }
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed;
    }

    public Enemy[] getEnemyArray() {
        Enemy[] ret = new Enemy[this.pool.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = this.pool.get(i);
        }
        return ret;
    }

    public void delete (Enemy enemy) {
        enemy.hide();
        //when hide is called only once it doesnt hide
        enemy.hide();

        if (this.endLeft.contains(enemy)) {
            this.endLeft.remove(enemy);
        }
        if (this.endRight.contains(enemy)) {
            this.endRight.remove(enemy);
        }
        this.pool.remove(enemy);

        this.numberOfAttemptsR = 0;
        this.numberOfAttemptsL = 0;
        this.checkEdgeArrays();

    }

    public void delete (ArrayList<Enemy> enemies) {
        for (Enemy obj : enemies) {
            this.delete(obj);
        }
    }

    public void createEnemyGrid(int spacing, int numberX, int numberY) {
        int created = 0;
        int x = 10;
        int y = 10;

        for (int i = 0; i < numberY; i++) {
            for (int j = 0; j < numberX; j++) {
                x += spacing;
                Enemy a = this.createEnemy(x, y);
                if (j == 0) {
                    this.endLeft.add(a);                    
                } else if (j == (numberX - 2)) {
                    this.endRight.add(a);                    
                }
                created++;
            }
            x = 10;
            y += spacing;
        }

    }

     
    private boolean isFurtherThanEdge() {
        if (this.isright) {
            for (Enemy obj : this.endRight) {
                if (obj.getEndX() > this.rightSide) {
                    return true;
                }
            }
            return false;
        } else {
            for (Enemy obj : this.endLeft) {
                if (obj.getX() < 0) {
                    return true;
                }
            }
            return false;
        }

    }

    
    private void checkEdgeArrays() {
        this.checkEdgeArrays(true);
        this.checkEdgeArrays(false);
    }
    
    private void checkEdgeArrays(boolean isCheckingRight) {
        if (isCheckingRight) {
            if (this.endRight.isEmpty()) {
                int max = Integer.MIN_VALUE;
                int tmpx = 0;
                Enemy maxE = null;
                for (Enemy obj : this.pool) {
                    tmpx = obj.getX();
                    if (tmpx > max) {
                        max = tmpx;
                        maxE = obj;
                    }
                }
                if (maxE == null) {
                    //checkEdgeArrays(true);
                    this.numberOfAttemptsR++;
                    return;
                }
                int eX = maxE.getX();
                for (Enemy obj : this.pool) {

                    if (eX == obj.getX()) {
                        this.endRight.add(obj);
                    }
                }
            }
        } else { 
            if (this.endLeft.isEmpty()) {
                int min = Integer.MAX_VALUE;
                int tmpx = 0;
                Enemy minE = null;
                for (Enemy obj : this.pool) {
                    tmpx = obj.getX();
                    if ( tmpx < min) {
                        min = tmpx;
                        minE = obj;
                    }
                }
                if (minE == null && this.numberOfAttemptsL < 5) {
                    //checkEdgeArrays(true);
                    this.numberOfAttemptsL++;
                    return;
                } else if (minE != null) {
                    int eX = minE.getX();
                    for (Enemy obj : this.pool) {
                        if (eX == obj.getX()) {
                            this.endLeft.add(obj);
                        }
                    }
                } else {
                    System.err.print("no valid edge enemies");
                }
            }
        }

    }

    public void clear() {
        MyManager.getInstance().stopManagingObject(this);
        for (Enemy obj : this.pool) {
            obj.hide();
        }
        this.pool.clear();
    }

    public void myInit() {
        this.isright = true;
    }
    
    private void noEnemiesLeft() {
        Game.getInstance().win();
    }
    
    private void enemyReachedBottom() {
        Game.getInstance().lose();
    }
    
    public static EnemyPool getInstance() {
        if (instance == null) {
            instance = new EnemyPool();  
        }
        return instance;
    }

}
