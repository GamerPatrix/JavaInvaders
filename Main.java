public abstract class Main {
    
    public Main() {
        
    }
    
    public static void main() {
        
        //new MainMenu();
        // System.out.println("main"); 
        
        Game.getInstance().start();
        System.out.println("hra"); 
    }
}
