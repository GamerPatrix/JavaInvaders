import fri.shapesge.Manager;
import java.util.ArrayList;

public class MainMenu {
    private Manager manager;
    private Hra game;
    private ArrayList<Button> buttons;
    public MainMenu() {
        this.manager = MyManager.getInstance();
        this.manager.manageObject(this);
        this.buttons = new ArrayList<Button>();
        System.out.println("MainMenu" );
        this.fillArray();
    }

    private void fillArray() {
        for ( int i = 0; i < 3; i++) {
            Button tmp = new Button();
            tmp.setPos(30 * i, 50);
            this.buttons.add(tmp);
        }
    }

    public void gameTime() {
        if (this.game == null) {
            this.game = Hra.getInstance();
        }
        this.game.start();  
        this.manager.stopManagingObject(this);
    }

    public void chooseCoordinates(int x, int y) {
        
        //System.out.println("click");
        System.out.print("" + x + ", " + y );
        System.out.println("");
        for (Button button : this.buttons) {
            if (button.checkColision(x, y)) {
                System.out.println("MAINSTART");
                this.gameTime();
            }
        }
    }
}
