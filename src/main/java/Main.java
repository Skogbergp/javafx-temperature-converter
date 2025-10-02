import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private TextField celsiusField = new TextField();
    private Label resultLabel = new Label();
    private double fahrenheit;
    private TemperatureConverter converter = new TemperatureConverter();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {


        ComboBox<String> unitSelector = new ComboBox<>();
        unitSelector.getItems().addAll("Celsius to Fahrenheit","Fahrenheit to Celsius", "Celsius to Kelvin","Kelvin to Celsius");
        unitSelector.setValue("Fahrenheit to Celsius");


        celsiusField.setPromptText("Enter Celsius");

        Button convertButton = new Button("Convert");
        convertButton.setOnAction(e -> convertTemperature(unitSelector.getValue()));

        Button saveButton = new Button("Save to DB");
        saveButton.setOnAction(e -> Database.saveTemperature(
                Double.parseDouble(celsiusField.getText()), fahrenheit,unitSelector.getValue(), resultLabel));

        VBox root = new VBox(10, celsiusField, unitSelector,convertButton, resultLabel, saveButton);
        Scene scene = new Scene(root, 300, 200);


        stage.setTitle("Celsius to Fahrenheit");
        stage.setScene(scene);
        stage.show();
    }

    private void convertTemperature(String value) {
        try {
            double input = Double.parseDouble(celsiusField.getText());
            double result;

            switch (value) {
                case "Celsius to Fahrenheit":
                    result = converter.celsiusToFahrenheit(input);
                    printConvertedTemperature(String.format("Fahrenheit: %.2f", result));
                    break;
                case "Fahrenheit to Celsius":
                    result = converter.fahrenheitToCelsius(input);
                    printConvertedTemperature(String.format("Celsius: %.2f", result));
                    break;
                case "Celsius to Kelvin":
                    result = converter.celsiusToKelvin(input);
                    printConvertedTemperature(String.format("Kelvin: %.2f", result));
                    break;
                case "Kelvin to Celsius":
                    result = converter.kelvinToCelsius(input);
                    printConvertedTemperature(String.format("Celsius: %.2f", result));
                    break;
                default:
                    resultLabel.setText("Unknown conversion type!");
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input!");
        }
    }
    private void printConvertedTemperature(String temperature) {
        resultLabel.setText(temperature);
    }
}