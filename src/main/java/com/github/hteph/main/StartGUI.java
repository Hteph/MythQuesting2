package com.github.hteph.main;
/**
 * @author Mikael Hansson {@literal <mailto:mikael.hansson@so4it.com/>}
 */

import com.github.hteph.TableLoader.DirectoryLoader;
import com.github.hteph.model.StoryEntity;
import com.github.hteph.tables.OpeneningSceneSetting;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class StartGUI extends Application {

    @Override
    public void start(Stage primaryStage) {

        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Tables Utilities");
        chooser.setInitialDirectory(new File(System.getProperty("user.home")));
        File selectedDirectory = chooser.showDialog(primaryStage);

        DirectoryLoader.collectAllFiles(selectedDirectory.getPath());

        Scene scene = getSettingScene();

        //Setting title to the Stage
        primaryStage.setTitle("Sample Application");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private Scene getSettingScene() {
        Text text = new Text();

        StoryEntity questGiver = OpeneningSceneSetting.getIndividual();
        String title = "";
        String ofPlace ="";
        if(!questGiver.getTitle().isEmpty()){
            title = questGiver.getTitle();
            ofPlace = ", ruler of Thisplace";
        }

        StringBuilder baseText = new StringBuilder("A MythSeed\n")
                                         .append("A ")
                                         .append(questGiver.getArchetype().replace("<faction>", "")).append(" ")
                                         .append("called").append(" ")
                                         .append(title).append(" ")
                                         .append(questGiver.getName()).append(" ")
                                         .append(ofPlace)
                                         .append(", who also is known as the").append(" ")
                                         .append(questGiver.getKenning())
                                         .append(".\n")
                .append("They Promise you ")
                .append(questGiver.getQuestRewards().get(0))
                .append(" if you just do this for them:");


        //Setting the text to be added.
        text.setText(baseText.toString().trim());

        //setting the position of the text
        text.setX(50);
        text.setY(50);
        TextFlow textFlow = new TextFlow(text);

        StackPane layout = new StackPane();
        layout.setStyle("-fx-background-color: linen; -fx-padding: 10;");
        layout.getChildren().setAll(textFlow);

        //Creating a scene object
        return new Scene(layout);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
