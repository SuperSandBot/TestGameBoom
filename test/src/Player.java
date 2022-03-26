

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Player{

    ArrayList<Image> playerwalk;
    int i = 0;
    block pos;
    double speed = 5;

    int worldX,worldY;
    int screenX, screenY;

    public Player()
    {     
        playerwalk = new ArrayList<Image>();
        playerwalk.add(new Image(getClass().getResourceAsStream("Asset/girlwalk_01.png")));
        playerwalk.add(new Image(getClass().getResourceAsStream("Asset/girlwalk_02.png")));
        playerwalk.add(new Image(getClass().getResourceAsStream("Asset/girlwalk_03.png")));
        playerwalk.add(new Image(getClass().getResourceAsStream("Asset/girlwalk_04.png")));
        playerwalk.add(new Image(getClass().getResourceAsStream("Asset/girlwalk_05.png")));


    }


    public void setplayerpos(block pos)
    {
        if(pos == null) return;
        this.pos = pos; 
    }

    public void draw(GraphicsContext gp) {
        gp.drawImage(playerwalk.get(i), screenX - playerwalk.get(0).getWidth()/2, screenY - playerwalk.get(0).getHeight()/2);
    }

    public void update() {

        if(this.worldX != pos.getWorldX() || this.worldY != pos.getWorldY())
        {
            this.worldX += (pos.getWorldX() - this.worldX) / 3;
            this.worldY += (pos.getWorldY() - this.worldY) / 3;
        }

        if(i >= playerwalk.size()-1)
        {
            i = 0;
        }
        i++;
    }

}
