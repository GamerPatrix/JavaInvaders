
/**
 * 
 * @author Fri 
 */
public class StopWatch {
    private int pocetTikov = 0;
    private int maxPocetTikov = 0;
    private boolean isActive;
    private Game h;
    public StopWatch(Game h) {
        this.h = h;
    }

    public void start (int paMax) {
        this.maxPocetTikov = paMax;
        this.pocetTikov = 0;
        this.isActive = true;
    }

    public void update() {
        if (this.isActive) {
            this.pocetTikov++;
            if ( this.pocetTikov == this.maxPocetTikov) {
                this.stop();
            }
        }
    }

    public void stop() {
        this.isActive = false;
        if (this.h != null) {
            this.h.end();
        }
    }
}
