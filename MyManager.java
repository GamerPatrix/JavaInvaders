import fri.shapesge.Manager;
public abstract class MyManager {   
    private static Manager instance;

    public static Manager getInstance() {
        if (instance == null) {
            instance = new Manager();
        }
        return instance;
    }
}
