
/**
 * @author (PatrikZak)
 */
public class BoundingBox {
    // instance variables - replace the example below with your own
    private int x1;
    private int y1;
    private int sizeX;
    private int sizeY;

    public BoundingBox(int x1, int y1, int sizeX, int sizeY) {
        this.init(x1, y1, sizeX, sizeY);
    }

    public BoundingBox() {
        this.init(0, 0, 0, 0);
    }

    private void init(int x1, int y1, int sizeX, int sizeY) {
        this.x1 = x1;
        this.y1 = y1;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public void setSize(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.checkSmartness();
    }

    

    public void set(int value1, int value2, BoxEnum num) {
        //TODO in manual change size acording to the change
        switch (num) {
            case OnlyXs:
            this.x1 = value1;        
            break;
            case OnlyYs:
            this.y1 = value1;        
            break;
            case manualPositionFirst:
            this.x1 = value1;
            this.y1 = value2;
            break;
            case PositionFirst:
            this.x1 = value1;
            this.y1 = value2;
            break;
            case move:
            this.x1 = this.x1 + value1;
            this.y1 = this.y1 + value2;
            break;
            case sizes:
            this.sizeX = value1;
            this.sizeY = value2;
            break;

        }
        this.checkSmartness();
    }

    public void set(int value, BoxEnumSimple num) {
        switch (num) {
            case X1:
            this.x1 = value;
            break;
            case Y1:
            this.y1 = value;
            break;
            case manualX1:
            this.x1 = value;
            break;
            case manualY1:
            this.y1 = value;
            break;
            case moveX:
            this.x1 = this.x1 + value;
            break;
            case moveY:
            this.y1 = this.y1 + value;
            break;
        }
        this.checkSmartness();
    }

    //this is just a debugCheck for values that shouldnt happen
    public void checkSmartness() {
        
        if(x1==0 || y1==0 || sizeX==0 || sizeY==0) {
            System.out.println("dw some shiz is 0"); 
        }
        if(x1<0 || y1<0) {
            System.out.println("Negative pos in BoundingBox"); 
        }
        
        if(sizeX<0 || sizeY<0) {
            System.err.println("Negative size in BoundingBox");
        }
    }

    public int getFirstX() {
        return this.x1;
    }

    public int getFirstY() {
        return this.y1;
    }

    public int getSecondX() {
        return this.x1+sizeX;
    }

    public int getSecondY() {
        return this.y1+sizeY;
    }

    public int getSizeX() {
        return this.sizeX; 
    }

    public int getSizeY() {
        return this.sizeY; 
    }

    public boolean checkInsideBox(int x, int y) {
        boolean checkXpos = (x >= this.x1) && (x <= this.x1 + sizeX);
        boolean checkYpos = (y >= this.y1) && (y <= this.y1 + sizeY);
        this.checkSmartness();
        return checkXpos && checkYpos;
    }

    public boolean checkInsideBox(BoundingBox box) {
        
        boolean checkpos1 = this.checkInsideBox(box.getFirstX(),box.getFirstY());
        boolean checkpos2 = this.checkInsideBox(box.getSecondX(),box.getSecondY());
        boolean checkpos3 = this.checkInsideBox(box.getFirstX(), box.getSecondY());
        boolean checkpos4 = this.checkInsideBox(box.getSecondX(), box.getFirstY());
        return checkpos1 || checkpos2 || checkpos3 || checkpos4;
    }
    
    
}
/**
 * @author (PatrikZak)
 */
