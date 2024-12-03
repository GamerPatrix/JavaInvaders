import fri.shapesge.Image;
public abstract class GameObject {
    private BoundingBox box;
    private Image image;
    public GameObject() {
        this.image = new Image("pics\\Empty.png");
        this.image.makeVisible();
        this.box = new BoundingBox();
    }

    public void changeImage(String path) {
        this.image.changeImage(path);
    }

    public void setPos(int x, int y) {
        this.image.changePosition(x, y);
        this.box.set(x, y, BoxEnum.POSITIONFIRST);
    }

    public void moveX(int x) {
        this.image.moveHorizontal(x);
        this.box.set(x, BoxEnumSimple.MOVEX);
    }

    public void moveY(int y) {
        this.image.moveVertical(y);
        this.box.set(y, BoxEnumSimple.MOVEY);
    }

    public void setSize(int sizeX, int sizeY) {
        this.box.set(sizeX, sizeY, BoxEnum.SIZES);
    }

    private BoundingBox getBox() {
        return this.box;
    }

    public void hide() {
        this.image.makeInvisible();
    }

    public void show() {
        this.image.makeVisible();
    }

    public int getX() {
        return this.getBox().getFirstX();
    }

    public int getY() {
        return this.getBox().getFirstY();
    }

    public int getEndX() {
        return this.getBox().getSecondX();
    }

    public int getEndY() {
        return this.getBox().getSecondY();
    }

    public boolean checkColision(int x, int y) {
        return this.getBox().checkInsideBox(x, y);
    }

    private Image getImage() {
        return this.image;
    }

    public int getSizeX() {
        return this.box.getSizeX();
    }

    public int getSizeY() {
        return this.box.getSizeY();
    }
}
