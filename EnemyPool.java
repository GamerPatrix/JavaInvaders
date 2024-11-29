import java.util.ArrayList;
import java.util.Scanner;
import java.util.Scanner;
/**
 * Write a description of class EnemyPool here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyPool {
    private static EnemyPool instance;
    private ArrayList<Enemy> pool;
    private ArrayList<Enemy> endLeft;
    private ArrayList<Enemy> endRight;
    private int allwedMoveDistance;
    private int actualMoveDistance;
    private boolean isright;
    private int speed;
    private int minHeight;
    private int rightSide;
    private EnemyPool() {
        pool = new ArrayList<Enemy>(); 
        endLeft = new ArrayList<Enemy>(); 
        endRight = new ArrayList<Enemy>(); 
        speed = 6;
        allwedMoveDistance = 10;
        actualMoveDistance = 0;
        isright = true;
        minHeight = 90;        
        rightSide = 1000;
    }

    public int getMinHeight() {
        return minHeight;
    }

    private Enemy createEnemy(int x, int y) {
        Enemy a = new Enemy();
        a.SetPos(x, y);
        pool.add(a);
        return a;
    }
    //move is supposed to be different
    public void update() {
        if(checkEdge()) {
            isright=!isright;
            for(Enemy obj : pool) {
                obj.moveY(speed);
            }
        }

        int distance;
        if(isright) {
            distance = speed;
        } else {
            distance = -speed;
        }

        for(Enemy obj : pool) {
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
        for(int i = 0; i < ret.length; i++) {
            ret[i] = this.pool.get(i);
        }
        return ret;
    }

    public void Delete (Enemy enemy) {
        enemy.hide();
        enemy.getImage().makeInvisible();
        if(endLeft.contains(enemy)) {
            endLeft.remove(enemy);
        }
        if (endRight.contains(enemy)) {
            endRight.remove(enemy);
        }
        pool.remove(enemy);
        this.checkEdgeArrays();
    }

    public void Delete (ArrayList<Enemy> enemies) {
        for(Enemy obj : enemies) {
            this.Delete(obj);
        }
    }

    public void createEnemyGrid(int spacing,int numberX, int numberY) {
        int created = 0;
        int x = 10;
        int y = 10;

        for(int i = 0; i < numberY; i++){
            for(int j = 0; j < numberX; j++) {
                x += spacing;
                Enemy a = createEnemy(x, y);
                if(j==0) {
                    endLeft.add(a);                    
                } else if(j== (numberX-2) ){
                    endRight.add(a);                    
                }
                created++;
            }
            x = 10;
            y += spacing;
        }

    }

    private boolean checkEdge() {
        if(isright) {
            for(Enemy obj : endRight) {
                if(obj.getEndX()>this.rightSide) {
                    return true;
                }
            }
            return false;
        } else {
            for(Enemy obj : endLeft) {
                if(obj.getX()<0) {
                    return true;
                }
            }
            return false;
        }

    }

    private void checkEdgeArrays() {
        //najdi najvedcise potom ziskaj vsetky v rovnakej vzdialenosti
        if(endRight.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int tmpx = 0;
            Enemy maxE = null;
            for(Enemy obj : pool) {
                tmpx = obj.getX();
                if( tmpx > max) {
                    max = tmpx;
                    maxE = obj;
                }
            }
            int eX = maxE.getX();
            for(Enemy obj : pool) {

                if( eX == obj.getX()) {
                    endRight.add(obj);
                }
            }
        }

        if(endLeft.isEmpty()) {
            int min = Integer.MAX_VALUE;
            int tmpx = 0;
            Enemy minE = null;
            for(Enemy obj : pool) {
                tmpx = obj.getX();
                if( tmpx < min) {
                    min = tmpx;
                    minE = obj;
                }
            }
            int eX = minE.getX();
            for(Enemy obj : pool) {
                if( eX == obj.getX()) {
                    endLeft.add(obj);
                }
            }
        }
    }

    public static EnemyPool getInstance() {
        if (instance == null) {
            instance = new EnemyPool();  
        }
        return instance;
    }

}
