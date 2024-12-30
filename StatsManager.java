
/**
 * Write a description of class GlobalValues here.
 * 
 * @author Patrik Zak 
 * @version (a version number or a date)
 */
public  class StatsManager {

    private static StatsManager instance;
    private static int misses = 0;
    private static int hits = 0;
    private static double time = 0;    
    
    public void addMiss() {
        StatsManager.misses++;
    }
    
    public void addHit() {
        StatsManager.hits++;
    }
    
    public void showCoolWindowOfStats() {
        
    }
    
    private void resetStats() {
        this.hits = 0;
        this.misses = 0;
    }
    
    public static StatsManager getInstance() {
        if ( StatsManager.instance == null) {
            StatsManager.instance = new StatsManager();
        }
        return StatsManager.instance;
    }
}
