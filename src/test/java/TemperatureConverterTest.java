import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    private final TemperatureConverter converter = new TemperatureConverter();

    @org.junit.jupiter.api.Test
    void fahrenheitToCelsius() {
        assertEquals(0, converter.fahrenheitToCelsius(32), 0.0001);
        assertEquals(100, converter.fahrenheitToCelsius(212), 0.0001);
        assertEquals(-40, converter.fahrenheitToCelsius(-40), 0.0001);
    }

    @org.junit.jupiter.api.Test
    void celsiusToFahrenheit() {
        assertEquals(32, converter.celsiusToFahrenheit(0), 0.0001);
        assertEquals(212, converter.celsiusToFahrenheit(100), 0.0001);
        assertEquals(-40, converter.celsiusToFahrenheit(-40), 0.0001);
    }

    @org.junit.jupiter.api.Test
    void isExtremeTemperature() {
        assertTrue(converter.isExtremeTemperature(51));
        assertTrue(converter.isExtremeTemperature(-41));
        assertFalse(converter.isExtremeTemperature(0));
        assertFalse(converter.isExtremeTemperature(50));
        assertFalse(converter.isExtremeTemperature(-40));
    }

    @org.junit.jupiter.api.Test
    void kelvinToCelsius() {
        assertEquals(0, converter.kelvinToCelsius(273.15), 0.0001);
        assertEquals(100, converter.kelvinToCelsius(373.15), 0.0001);
        assertEquals(-273.15, converter.kelvinToCelsius(0), 0.0001);
    }

    @org.junit.jupiter.api.Test
    void celsiusToKelvin() {
        assertEquals(273.15, converter.celsiusToKelvin(0), 0.0001);
        assertEquals(373.15, converter.celsiusToKelvin(100), 0.0001);
        assertEquals(0, converter.celsiusToKelvin(-273.15), 0.0001);
    }
}