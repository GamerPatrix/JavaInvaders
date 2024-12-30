
/**
 * 
 * @author Fri 
 */
public class PlayerStopWatch {
    private int pocetTikov = 0;
    private int maxPocetTikov = 0;
    private boolean isActive;
    private PlayerController controller;
    public PlayerStopWatch(PlayerController controller) {
        this.controller = controller;
    }

    public void start (int paMax) {
        this.maxPocetTikov = paMax;
        this.pocetTikov = 0;
        this.isActive = true;
    }

    public void tick() {
        if (this.isActive) {
            this.pocetTikov++;
            if ( this.pocetTikov == this.maxPocetTikov) {
                this.stop();
            }
        }
    }

    public void stop() {
        this.isActive = false;
        if (this.controller != null) {
            this.controller.canFireAgain();
        }
    }
}
