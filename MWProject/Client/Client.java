
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Client extends Application {
	  float shapeArea = 0;
      AreaStub clientStub;

//Creating components of the User interface
    public void start(Stage primaryStage) {
    primaryStage.setTitle("Area Calculator");
    Button calculate = new Button("Calculate");
    Button clear = new Button("Clear");
    Label radiusInput = new Label("Enter radius");
    Label areaOutput = new Label("Area");
    Label circleInput = new Label("Circle");
    Label sphereInput = new Label("Sphere");


    TextField radius = new TextField();
    TextField area = new TextField();
    final ToggleGroup shapes = new ToggleGroup();
    RadioButton circle = new RadioButton();
    circle.setToggleGroup(shapes);
    circle.setSelected(true);
    RadioButton sphere = new RadioButton();
    sphere.setToggleGroup(shapes);

//Execution procedure  when calculate button is clicked along with error handling
calculate.setOnAction((ActionEvent e) ->
{
    try {
		float n = Float.parseFloat(radius.getText());
		if(circle.isSelected()){
			if(n>0){
				clientStub= new AreaStub("Circle");
                shapeArea = clientStub.calculateCircleArea(n);
                area.setText(new Float(shapeArea).toString());
			}
			else{
			    radius.setText("Enter a value greater than 0");
			    }
			}

  			else{
				if(n>0){
				clientStub= new AreaStub("Sphere");
				shapeArea = clientStub.calculateCircleArea(n);
                area.setText(new Float(shapeArea).toString());
			}
			else{
				radius.setText("Enter a value greater than 0");
				}
			}
          } catch (IOException m) {
        }
}
);

//Clearing of the two text fields when clear button is clicked
clear.setOnAction((ActionEvent e) ->
{
	radius.setText(" ");
	area.setText(" ");
}
);


    Pane root = new Pane();
    calculate.setLayoutX(30);
    calculate.setLayoutY(250);

    clear.setLayoutX(300);
    clear.setLayoutY(250);

    radius.setLayoutX(150);
    radius.setLayoutY(50);

    circleInput.setLayoutX(60);
    circleInput.setLayoutY(130);

    sphereInput.setLayoutX(250);
    sphereInput.setLayoutY(130);



    circle.setLayoutX(110);
    circle.setLayoutY(130);

    sphere.setLayoutX(310);
    sphere.setLayoutY(130);



    area.setLayoutX(150);
    area.setLayoutY(180);


    radiusInput.setLayoutX(50);
    radiusInput.setLayoutY(50);

    areaOutput.setLayoutX(50);
    areaOutput.setLayoutY(180);


    root.getChildren().add(calculate);
    root.getChildren().add(clear);
    root.getChildren().add(radiusInput);
    root.getChildren().add(areaOutput);
    root.getChildren().add(radius);
    root.getChildren().add(area);
    root.getChildren().add(circle);
    root.getChildren().add(sphere);
    root.getChildren().add(circleInput);
    root.getChildren().add(sphereInput);
    primaryStage.setScene(new Scene(root, 400, 300));
    primaryStage.show();
}

    public static void main(String[] args) {
        launch(args);
    }

}
