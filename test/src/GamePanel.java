
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GamePanel{

    Image battleground;

    int worldX,worldY;
    int screenX, screenY;

    public int Row = 13;
    public int Col = 10;

    public GamePanel()
    {

        battleground = new Image(getClass().getResourceAsStream("Asset/lanepanel.png"));

    }

    public void draw(GraphicsContext gp) {
        gp.drawImage(battleground, screenX, screenY);
    }

    public void update() {
    }
}
