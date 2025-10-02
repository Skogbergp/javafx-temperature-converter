import java.sql.*;
import javafx.scene.control.Label;

public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/javafx_mariadb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void saveTemperature(double inputValue, double outputValue, String conversionType, Label statusLabel) {
        String inputUnit = getInputUnit(conversionType);
        String outputUnit = getOutputUnit(conversionType);

        String sql = "INSERT INTO temperature_log (input_value, input_unit, output_value, output_unit, conversion_type) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, inputValue);
            stmt.setString(2, inputUnit);
            stmt.setDouble(3, outputValue);
            stmt.setString(4, outputUnit);
            stmt.setString(5, conversionType);

            stmt.executeUpdate();
            statusLabel.setText("Saved to database!");

        } catch (SQLException e) {
            statusLabel.setText("DB Error: " + e.getMessage());
        }
    }

    private static String getInputUnit(String conversionType) {
        if (conversionType.contains("Celsius")) return "Celsius";
        if (conversionType.contains("Fahrenheit")) return "Fahrenheit";
        if (conversionType.contains("Kelvin")) return "Kelvin";
        return "Unknown";
    }

    private static String getOutputUnit(String conversionType) {
        String[] parts = conversionType.split(" to ");
        return parts.length == 2 ? parts[1] : "Unknown";
    }
}
