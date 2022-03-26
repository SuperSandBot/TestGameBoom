
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class canvastest extends Pane implements Runnable {


    public int worldWidth;
    public int worldHight;
    public int screenWidth;
    public int screenHight;

    Thread thread;
    GraphicsContext gp;
    Canvas canvas;
    GamePanel gamePanel;
    Player player;
    
    block[][] blocks;

    public canvastest(int worldWidth, int worldHight, int screenWidth, int screenHight)
    {
        this.worldWidth = worldWidth;
        this.worldHight = worldHight;
        this.screenWidth = screenWidth;
        this.screenHight = screenHight;
        
        //set up canvas side
        this.setPrefSize(screenWidth, screenHight);
        canvas = new Canvas(screenWidth,screenHight);
        this.getChildren().add(canvas);

        // else 
        player = new Player();
        player.worldX = worldWidth/2;
        player.worldY = worldHight/2;
        player.screenX =  screenWidth/2;
        player.screenY = screenHight/2;


        gamePanel = new GamePanel();
        gamePanel.worldX = worldWidth/2;
        gamePanel.worldY = worldHight/2;
        setup(gamePanel);


        System.out.println(player.screenX +"/" + player.screenY);
        player.setplayerpos(blocks[0][0]);

        //set up update and draw and thread need to be last
        gp = canvas.getGraphicsContext2D();
        thread = new Thread(this);
        thread.start();
        
    }

    @Override
    public void run() {

        while(thread != null)
        {
            Update();
            Draw();

            // need this thread.sleep or say good by to CPU and GPU
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
            }
        }
    }

    private void Draw() {

        gp.clearRect(0, 0,screenWidth, screenHight);
        gamePanel.draw(gp);
        player.draw(gp);
    }
    private void Update() {
        
        player.update();
        gamePanel.update();

        gamePanel.screenX = gamePanel.worldX - player.worldX + player.screenX;
        gamePanel.screenY = gamePanel.worldY - player.worldY + player.screenY;
        
        int x = 0;
        int y = 0;

        for(int i = 0; i < blocks.length; i++)
        {
            for(int j = 0; j < blocks[0].length; j++)
            {
                blocks[i][j].setScreenX(gamePanel.screenX + x );
                blocks[i][j].setScreenY(gamePanel.screenY + y );
                y += 64;
            }
            x += 64;
            y = 0;
        }

    }

    private void setup(GamePanel gamePanel)
    {
        blocks = new block[gamePanel.Row][gamePanel.Col];
        int x = 0;
        int y = 0;

        for(int i = 0; i < blocks.length; i++)
        {
            for(int j = 0; j < blocks[0].length; j++)
            {
                blocks[i][j] = new block();
                blocks[i][j].setWorldX((worldWidth - gamePanel.screenX)/2 + x + 32 );
                blocks[i][j].setWorldY((worldHight - gamePanel.screenY)/2 + y + 32 );
                blocks[i][j].setScreenX(gamePanel.screenX + x);
                blocks[i][j].setScreenY(gamePanel.screenY + y);

                y += 64;
            }
            x += 64;
            y = 0;
        }

        for(int i = 0; i < blocks.length; i++)
        {
            for(int j = 0; j < blocks[0].length; j++)
            {
                blocks[i][j].top = DFS(blocks,i,j - 1); // top
                blocks[i][j].down = DFS(blocks,i,j + 1); // down
                blocks[i][j].left = DFS(blocks,i - 1 ,j); // left
                blocks[i][j].right = DFS(blocks,i + 1 ,j); // right
            }
        }
    }

    private block DFS(block[][] b , int i, int j)
    {
        if(i >= 0 && i < blocks.length && j >= 0 && j < blocks[0].length)
        {
            return blocks[i][j];
        }
        return null;
    }
    
}
