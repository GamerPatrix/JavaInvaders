import java.util.ArrayList;

/**
     * MainMenu NOT YET IMPLEMENTED
     * 
     * @author Patrik Zak 
     * @version 1
     */
public class MainMenu {
    private ArrayList<Button> buttons;
    private static MainMenu instance;
    private MainMenu() {

        this.buttons = new ArrayList<Button>();
        System.out.println("MainMenu" );
        this.fillArray();
        MyManager.getInstance().manageObject(this);
    }

    private void fillArray() {
        for ( int i = 0; i < 3; i++) {
            Button tmp = new Button(ButtonType.values()[i]);
    
            switch (i) {
                case 0: 
                    tmp.setPos(30, 200);
                    break;
                case 1:
                    tmp.setPos(130, 200);
                    break;
                case 2:
                    tmp.setPos(230, 200);
                    break;
            }
            this.buttons.add(tmp);
        }
    }
    
    public void enter() {
        this.startGame();
    }

    public void escape() {
        this.quit();
    }
    public void startGame() {
        Game.getInstance().start();  
        MyManager.getInstance().stopManagingObject(this);
        this.hideMenu();
    }

    public void quit() {
        System.exit(0);
    }

    public void openSettings() {
        System.out.println("Opening settings");
    }

    public void chooseCoordinates(int x, int y) {

        //System.out.println("click");
        // System.out.print("" + x + ", " + y );
        // System.out.println("");
        for (Button obj : this.buttons) {
            if (obj.checkColision(x, y)) {
                // System.out.println("MAINSTART");
                obj.click();
            }
        }
    }

    public void showMenu() {
        for (Button obj : this.buttons) {
            obj.show();
        }
        MyManager.getInstance().manageObject(this);
    }

    private void hideMenu() {
        MyManager.getInstance().stopManagingObject(this);
        for (Button obj : this.buttons) {
            obj.hide();
        }

    }

    public static MainMenu getInstance() {
        if (MainMenu.instance == null) {
            MainMenu.instance = new MainMenu();
        }
        return MainMenu.instance;
    }
}
