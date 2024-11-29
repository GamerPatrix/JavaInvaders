import java.util.ArrayList;
import fri.shapesge.Manager;
/**
 * Write a description of class Hra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hra {
    private static Hra instance;
    private static GameState gameState;
    private Manager manager;
    private Casovac cas;
    private boolean isRunnung;
    private ArrayList<Object> objekty;
    public Hra() {
        this.manager = MyManager.getInstance();
        objekty = new ArrayList<Object>();
        objekty.add(BulletPool.getInstance());
        objekty.add(EnemyPool.getInstance());
        objekty.add(OvladanieHracom.getInstance());
        cas = new Casovac(this);
        this.manager.manageObject(this);
        
        System.out.println("game" );
        //this.manager.spravujObjekt(this);
        //EnemyPool.getInstance().createEnemyGrid(30, 3, 3);
    }

    public void tick() {
        this.checkCollisions();
        this.tryMoveEnemies();
        this.tryMoveBullets();
        
    }
    
    private void tryMoveEnemies() {
         EnemyPool.getInstance().update();
    }
    
     private void tryMoveBullets() {
         BulletPool.getInstance().update();
    }
        
    private void checkCollisions() {
        Collisions.getInstance().checkColisions();
    }

    public void end() {
        this.isRunnung = false;

    }

    public void hideGame() {
    }

    public void showGame() {
    }

    public void start() {
        this.isRunnung = true;
        for (Object obj : this.objekty) {
            this.manager.manageObject(obj);
        }

        this.manager.manageObject(this);
    }

    //TODO is called 3 by hra on enter idk why
    public void enter() {
        System.out.print("enemy");
        EnemyPool.getInstance().createEnemyGrid(40, 5, 5);
        System.out.println(": Created \n");
    }

    public void escape() {
        this.end();
    }

    public void goToMainMenu() {
        if(isRunnung) {
            this.end();  
        }
        this.hideGame();
        this.gameState = GameState.MainMenu;
    }

    public static Hra getInstance() {
        if (instance == null) {
            instance = new Hra();  
        }
        return instance;
    }

    public static GameState getGameState() {
        return gameState;
    }
    public enum GameState {
        MainMenu, Paused, Running,
    }
}
