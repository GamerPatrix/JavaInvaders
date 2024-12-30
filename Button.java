import fri.shapesge.TextBlock;
/**
 * represents objects clickable with a mouse
 * 
 * @author Patrik Zak 
 * @version 1
 */
public class Button extends GameObject {
    private ButtonType type;
    private TextBlock buttonText;
    public Button(ButtonType type) {
        // initialise instance variables
        this.buttonText = new TextBlock("text");
        this.buttonText.makeVisible();
        this.buttonText.changeColor("red");
        this.changeImage("pics\\Button.png");
        this.setSize(50, 50);
        this.type = type;
    }

    public void click() {
        switch (this.type) {
            case START:
                MainMenu.getInstance().startGame();
                break;
            case SETTINGS:
                MainMenu.getInstance().openSettings();
                break;
            case END:
                MainMenu.getInstance().quit();
                break;
            case ENEMY_NUMBER_X:
                Settings.getInstance().setEnemyXnumber();
                break;
            case ENEMY_NUMBER_Y:
                Settings.getInstance().setEnemyYnumber();
                break;    
            case ENEMY_SPEED:
                Settings.getInstance().setEnemySpeed();
                break;
            case PLAYER_FIRERATE:
                Settings.getInstance().setPlayerFireRate();
                break;    
            case PLAYER_SPEED:
                Settings.getInstance().setPlayerSpeed();
                break;
        }
    }

    public void setPos(int x, int y) {
        super.setPos(x, y);
        this.buttonText.changePosition(x + 5, y + 10);
    }

    public void hide() {
        super.hide();
        this.buttonText.makeInvisible();
    }

    public void show() {
        super.show();
        this.buttonText.makeVisible();
    }
}
