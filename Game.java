import javax.swing.JOptionPane;
/**
 * Write a description of class Hra here.
 * 
 * @author Patrik Zak 
 * @version 3
 */
public class Game /*implmenets IMainUI */ {
    private static Game instance;
    private static GameState gameState;
    private long startTime;
    private boolean isRunnung;
    //private ArrayList<Object> objekty;
    
    private int enemyX;
    private int enemyY;
    public Game() {
        //this.cas = new Casovac(this);
        MyManager.getInstance().manageObject(this);

        System.out.println("game" );
        
        this.enemyX = 5;
        this.enemyY = 5;
        //this.manager.spravujObjekt(this);
        //EnemyPool.getInstance().createEnemyGrid(30, 3, 3);
    }

    public void tick() {
        this.tryMoveEnemies();
        this.tryMoveBullets();
        this.checkCollisions();
    }

    public void escape() {
        this.end();
    }

    // public void enter() {
    // System.out.print("enemy");
    // this.createEnemyGrid();
    // System.out.println(": Created \n");
    // }

    private void tryMoveEnemies() {
        EnemyPool.getInstance().update();
    }

    private void tryMoveBullets() {
        BulletPool.getInstance().update();
    }

    private void checkCollisions() {
        Collisions.getInstance().checkColisions();
    }

    private void createEnemyGrid() {
        EnemyPool.getInstance().createEnemyGrid(50, this.enemyX, this.enemyY);
    }

    public void end() {
        this.hideGame();
        this.goToMainMenu();
        MyManager.getInstance().stopManagingObject(this);
    }

    /**
     * hides all gameObjects in game scene
     */
    public void hideGame() {
        EnemyPool.getInstance().clear();
        BulletPool.getInstance().clear();
        PlayerController.getInstance().clear();
    }
    
    /**
     *inicializes all needed methods and
     */
    private void showGame() {
        EnemyPool.getInstance().myInit();
        BulletPool.getInstance().myInit();
        PlayerController.getInstance().myInit();
    }

    /** 
     * starts the game 
     */
    public void start() {
        this.isRunnung = true;
        this.showGame();
        this.startTime = System.nanoTime();
        this.createEnemyGrid();
        MyManager.getInstance().manageObject(this);     
    }

    /** 
     *   hides game and shows main Menu 
     */
    private void goToMainMenu() {
        this.isRunnung = false;
        this.hideGame();
        MainMenu.getInstance().showMenu();
        Game.gameState = GameState.MAIN_MENU;
    }

    public void lose() {
        this.end();
        this.openPopUpWindowWithMessage("you Lost, REMATCH?");
    }

    public void win() {
        this.end();
        this.openPopUpWindowWithMessage("you Won good job \n wanna beat your high score?");
    }

    public void showStats() {
        double timeInSec = System.nanoTime() - this.startTime;
        System.out.print(timeInSec);
    }

    private void openPopUpWindowWithMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
    public void setEnemyX(int x) {
        this.enemyX = x;
    }
    
    public void setEnemyY(int y) {
        this.enemyY = y;
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
