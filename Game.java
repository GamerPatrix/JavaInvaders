import java.util.ArrayList;
import fri.shapesge.Manager;
/**
 * Write a description of class Hra here.
 * 
 * @author Patrik Zak 
 * @version 3
 */
public class Game {
    private static Game instance;
    private static GameState gameState;
    private Manager manager;
    //private Casovac cas;
    private boolean isRunnung;
    private ArrayList<Object> objekty;
    
    public Game() {
        this.manager = MyManager.getInstance();
        this.objekty = new ArrayList<Object>();
        this.objekty.add(BulletPool.getInstance());
        this.objekty.add(EnemyPool.getInstance());
        this.objekty.add(PlayerController.getInstance());
        //this.cas = new Casovac(this);
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
        System.exit(0);
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

    //TODO is called 3 times by hra on enter idk why
    public void enter() {
        System.out.print("enemy");
        EnemyPool.getInstance().createEnemyGrid(40, 5, 5);
        System.out.println(": Created \n");
    }

    public void escape() {
        this.end();
    }
    
    /**
     * TODO NOT YET IMPLEMENTED
     */
    public void goToMainMenu() {
        if (this.isRunnung) {
            this.end();  
        }
        this.hideGame();
        this.gameState = GameState.MainMenu;
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();  
        }
        return instance;
    }

    public static GameState getGameState() {
        GameState ret = gameState;
        return ret;
    } 
}
