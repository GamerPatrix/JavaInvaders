import fri.shapesge.Manager;
/**
 * Write a description of class MyManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class MyManager {   
    private static Manager instance;
    
    public static Manager getInstance() {
        if (instance == null) {
            instance = new Manager();
        }
        return instance;
    }
}
