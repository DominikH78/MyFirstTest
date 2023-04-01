import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestowanieStrony {

    public static void main(String[] args) {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rozancowa-chrzanow.pl/");
        System.out.println(driver.getTitle());
        driver.quit();

    }
    @Test
    void shouldPrintHello() {
        System.out.println("hello");
    }
@Test
        void shouldCompareTwoSameNumbers() {
            Assertions.assertEquals(123,123);
        }
        @Test
    void shouldCompareTwoBooleanValues() {
        Assertions.assertEquals(true,1 == 1);
        }
@Test
    void shouldCompareTwoSameStrings() {
        Assertions.assertEquals("eryk123","eryk123");
}
@Test
    void shouldChangesStringToUppercase() {
        Assertions.assertEquals("ERYK123","eryk123".toUpperCase());
}
@Test
    void shouldAddNumbers() {
        int result = addNumbers(2, 3);
        Assertions.assertEquals(5, result, "should return sum of two numbers ");

}
int addNumbers(int a, int b) {
        return a + b;
}
@Test
    void shouldCalculateCorrectCircleArea() {
        Assertions.assertEquals(6.28, calculateCircleArea(1));
}
double calculateCircleArea(int r){
        double PI = 3.14;
        return 2 * PI * r;
}
String removeSpaces(String wordToTransform){
        return  wordToTransform.trim().toUpperCase();
}
@Test
    void shouldReturnUpperCaseWordWithoutSpaces(){
        Assertions.assertEquals("KOT W WORKU", removeSpaces(" kot w WoRku "));
}
}

