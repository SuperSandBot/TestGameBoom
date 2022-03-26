

public class block {

    private int worldX,worldY;
    private int screenX, screenY;
    public block top, down, left, right;

    public block()
    {
        
    }

    public int getScreenY() {
        return screenY;
    }

    public void setScreenY(int screenY) {
        this.screenY = screenY;
    }

    public int getScreenX() {
        return screenX;
    }

    public void setScreenX(int screenX) {
        this.screenX = screenX;
    }

    public int getWorldX()
    {
        return this.worldX;
    }

    public int getWorldY()
    {
        return this.worldY;
    }

    public void setWorldX(int x) {
        this.worldX = x;
    }

    public void setWorldY(int y) {
        this.worldY = y;
    }

}
