
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class HelloWorld extends Application{


    final int TitleScale = 64;  //48 x 48

    final int maxScreenCol = 14;
    final int maxScreenRow = 11;
    final int screenWidth = TitleScale * maxScreenCol; // 860 pixel 
    final int screenHight = TitleScale * maxScreenRow; // 640 pixel

    final int maxWorldCol = 50;
    final int maxWorldRow = 50;
    final int worldWidth = TitleScale * maxWorldCol;
    final int worldHight = TitleScale * maxWorldRow;

    Controler controler;
    
    canvastest cv;
    Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {

        cv = new canvastest(worldWidth,worldHight,screenWidth,screenHight);


        scene = new Scene(cv,Color.BLACK); 
        controler = new Controler(scene);
        controler.player = cv.player;

        primaryStage.setTitle("BoomBoom");
        primaryStage.setWidth(screenWidth);
        primaryStage.setHeight(screenHight);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        
        launch(args);
    }
}
