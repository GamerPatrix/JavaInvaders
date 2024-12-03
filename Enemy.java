public class Enemy extends GameObject {
    // instance variables - replace the example below with your own
    private EnemyType type;

    /**
     * Constructor for objects of class Enemy
     */
    public Enemy() {
        this.type = EnemyType.defult;
        this.changeImage("pics\\Enemy.png");
        this.setSize(100, 100);
    }

    public Enemy(EnemyType type) {
        this.type = type;

    }
    public enum EnemyType {
        defult,
        shooter,
        tank,
    }
}
