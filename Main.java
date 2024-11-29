public abstract class Main {
    
    public Main() {
        
    }
    
    public static void main() {
        
        new MainMenu();
        System.out.println("main"); 
    }
    
    public static void mainHra() {
        
        Hra.getInstance().start();
        System.out.println("hra"); 
    }
}
