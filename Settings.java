import fri.shapesge.TextBlock;
import javax.swing.JOptionPane;
/**
 * Write a description of class Settings here.
 * 
 * @author Patrik Zak 
 * @version 8
 */
public class Settings /*implmenets IMainUI */ {
    private static Settings instance;
    private Settings() {
        
    }
    
    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }
    
    public void setEnemyXnumber() {
        int newint = this.gimmeNumberUsingThePopUpWindow("Enemy number in rows ");
        Game.getInstance().setEnemyY(newint);
    }
    
    public void setEnemyYnumber() {
        int newint = this.gimmeNumberUsingThePopUpWindow("Enemy number in colums");
        Game.getInstance().setEnemyY(newint);
    }
    
    public void setEnemySpeed() {
        int newSpeed = this.gimmeNumberUsingThePopUpWindow("Enemy speed");
        EnemyPool.getInstance().setSpeed(newSpeed);
    }
    
    public void setPlayerSpeed() {
        int newSpeed = this.gimmeNumberUsingThePopUpWindow("player speed");
        PlayerController.getInstance().setSpeed(newSpeed);
    }
    
    public void setPlayerFireRate() {
        int newInt = this.gimmeNumberUsingThePopUpWindow("player speed");
        PlayerController.getInstance().setFireRate(newInt);
    }
    
    private int gimmeNumberUsingThePopUpWindow(String message) {
        //JOptionPane.show
        String gotString = "1";
        Integer.valueOf(gotString);
        return 1;
    }
}
