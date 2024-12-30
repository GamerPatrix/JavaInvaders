/**
 * This class represents a shooteble object that the player needs to shoot to win
 * 
 * @author Patrik Zak 
 * @version 2
 */
public class Enemy extends GameObject {
    public Enemy() {
        this.changeImage("pics\\Enemy.png");
        this.setSize(100, 100);
    }

}
