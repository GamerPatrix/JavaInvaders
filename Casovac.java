
/**
 * @version (a version number or a date)
 * Write a description of class casovac here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Casovac {
    private int pocetTikov = 0;
    private int maxPocetTikov = 0;
    private boolean isActive;
    private Hra h;
    public Casovac(Hra h) {
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
