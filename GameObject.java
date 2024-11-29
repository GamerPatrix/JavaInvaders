import fri.shapesge.Image;
public class GameObject
{
    private BoundingBox box;
    private Image image;
    public GameObject()
    {
        image = new Image("pics\\Empty.png");
        image.makeVisible();
        box = new BoundingBox();
    }
    
    public void changeImage(String path) {
        image.changeImage(path);
    }

    public void SetPos(int x, int y) {
        image.changePosition(x, y);
        box.set(x, y, BoxEnum.PositionFirst);
    }

    public void moveX(int x) {
        image.moveHorizontal(x);
        box.set(x, BoxEnumSimple.moveX);
    }

    public void moveY(int y) {
        image.moveVertical(y);
        box.set(y, BoxEnumSimple.moveY);
    }

    public void setSize(int sizeX, int sizeY) {
        box.set(sizeX, sizeY, BoxEnum.sizes);
    }

    public BoundingBox getBox() {
        return box;
    }

    public void hide() {
        image.makeInvisible();
    }

    public void show() {
        image.makeVisible();
    }

    public int getX() {
        return getBox().getFirstX();
    }

    public int getY() {
        return getBox().getFirstY();
    }
    
    public int getEndX() {
        return getBox().getSecondX();
    }

    public int getEndY() {
        return getBox().getSecondY();
    }
    
    public boolean checkColision(int x, int y) {
        return this.getBox().checkInsideBox(x, y);
    }

    public Image getImage() {
        return image;
    }
    
    public int getSizeX() {
        return box.getSizeX();
    }
    
    public int getSizeY() {
        return box.getSizeY();
    }
}
