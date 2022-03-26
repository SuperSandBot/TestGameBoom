import javafx.scene.Scene;

public class Controler {

    public Player player;


    public Controler(Scene scene)
    {
        scene.setOnKeyPressed(event ->
        {
            switch(event.getCode())
            {
                case UP:
                    player.setplayerpos(player.pos.top);
                    break;

                case DOWN:
                    player.setplayerpos(player.pos.down);
                    break; 
                    
                case LEFT:
                    player.setplayerpos(player.pos.left);
                    break;

                case RIGHT:
                    player.setplayerpos(player.pos.right);
                    break;

                default:
                    break;
            }
        });
    }
}
