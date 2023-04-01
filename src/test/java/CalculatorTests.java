import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CalculatorTests {
    @Test
    void shouldReturnCorrectSum() {
        Assertions.assertEquals(Calculator.add(4, 4), 8, "should return correct sum");
    }
    @Test
    @Disabled("Enable when substract method is fixed")
    void shouldReturnCorrectSubtractingResult(){
        Assertions.assertEquals(Calculator.subtract(4, 3), 7, "should return correct subtracting result ");
    }
    @Test
    void shouldReturnCorrectMultiplyingResult(){
        Assertions.assertEquals(Calculator.multiply(4, 4), 16, "Should return correct multiplying result");
    }
}

