
import fri.shapesge.Manager;
import java.util.ArrayList;

public class MainMenu {
    private Manager manager;
    private Hra game;
    private ArrayList<Button> buttons;
    public MainMenu() {
        this.manager = MyManager.getInstance();
        this.manager.manageObject(this);
        buttons = new ArrayList<Button>();
        System.out.println("MainMenu" );
        this.fillArray();
    }

    private void fillArray() {
        for ( int i = 0; i < 3; i++) {
            Button tmp = new Button();
            tmp.SetPos(30*i, 50);
            buttons.add(tmp);
        }
    }

    public void gameTime() {
        if(game == null) {
            this.game = Hra.getInstance();
        }
        game.start();  
        manager.stopManagingObject(this);
    }

    public void chooseCoordinates(int x, int y) {
        
        //System.out.println("click");
        System.out.print("" + x +", " + y );
        System.out.println("");
        for (Button button : buttons) {
            if(button.getBox().checkInsideBox(x, y)){
                System.out.println("MAINSTART");
                this.gameTime();
            }
        }
    }
}
