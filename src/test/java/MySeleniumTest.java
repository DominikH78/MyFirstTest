import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.netty.util.internal.SystemPropertyUtil.contains;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.By.partialLinkText;

public class MySeleniumTest {
     static WebDriver driverChrome;
    @BeforeAll
    static void prepareBrowser(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driverChrome = new ChromeDriver();
        driverChrome.manage().window().maximize();
        driverChrome.get("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/");
    }

    @BeforeEach
    void cleanCookies() {
        driverChrome.manage().deleteAllCookies();
    }

    @AfterEach
    void cleanCookiesAfterTest() {
        driverChrome.manage().deleteAllCookies();
    }

    @AfterAll
    static void closeBrowser(){
        driverChrome.quit();
    }
    @Test
    void ShopTitleTest() {
        WebDriver driverChrome = new ChromeDriver();
                driverChrome.get("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/");
           Assertions.assertEquals("Sklep - Softie Metal Shop", driverChrome.getTitle());
        driverChrome.quit();
    }
    @Test
    void shouldVerifyLoginNoLogin() {
        driverChrome.get("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/");

        WebElement goToMyAccountPage = driverChrome.findElement(By.id("menu-item-125"));
        goToMyAccountPage.click();
        WebElement userNameInput = driverChrome.findElement(By.id("username"));
        userNameInput.sendKeys("");
        WebElement passwordInput = driverChrome.findElement(By.id("password"));
        passwordInput.sendKeys("Xhubal123!");
        WebElement loginButton = driverChrome.findElement(By.cssSelector("button[name='login"));
        loginButton.click();
        WebElement errorMessage = driverChrome.findElement(By.className("woocommerce-error"));
        String expectedErrorMessage
                ="Błąd: Nazwa użytkownika jest wymagana.";
        Assertions.assertEquals(expectedErrorMessage, errorMessage.getText());
        driverChrome.quit();

    }
    @Test
    void shouldVerifyLoginNoPassword() {
        driverChrome.get("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/");

        WebElement goToMyAccountPage = driverChrome.findElement(By.id("menu-item-125"));
        goToMyAccountPage.click();
        WebElement userNameInput = driverChrome.findElement(By.id("username"));
        userNameInput.sendKeys("tylkowitold@gmail.com");
        WebElement passwordInput = driverChrome.findElement(By.id("password"));
        passwordInput.sendKeys("");
        WebElement loginButton = driverChrome.findElement(By.cssSelector("button[name='login"));
        loginButton.click();
        WebElement errorMessage = driverChrome.findElement(By.className("woocommerce-error"));
        String expectedErrorMessage
                ="Błąd: pole hasła jest puste.";
        Assertions.assertEquals(expectedErrorMessage, errorMessage.getText());

        driverChrome.quit();
    }
    @Test
    void shouldNewCustomer() {
        driverChrome.get("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/");

        WebElement goToMRegistrationPage = driverChrome.findElement(By.id("menu-item-146"));
        goToMRegistrationPage.click();
        WebElement userNameInput = driverChrome.findElement(By.id("user_login"));
        userNameInput.sendKeys("Marysian");
        WebElement userEmailInput = driverChrome.findElement(By.id("user_email"));
        userEmailInput.sendKeys("marysia.rysy@wp.pl");
        WebElement userPasswordInput = driverChrome.findElement(By.id("user_pass"));
        userPasswordInput.sendKeys("Xhubal123!");
        WebElement userPassConfirmInput = driverChrome.findElement(By.id("user_confirm_password"));
        userPassConfirmInput.sendKeys("Xhubal123!");
        WebElement buttonSubmit = driverChrome.findElement(By.xpath("//button[contains(.,'Submit')]"));
        buttonSubmit.click();
        WebDriverWait wait = new WebDriverWait(driverChrome, Duration.ofSeconds(5));
        WebElement registrationConfirm =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ur-submit-message-node']")));
        String expectedErrorMessage
                ="Username already exists.";
        Assertions.assertEquals(expectedErrorMessage, registrationConfirm.getText());

    }
    @Test
    void checkElementWithLogo() {
        driverChrome.manage().window().maximize();
        driverChrome.get("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/");
        driverChrome.findElement(By.linkText("Softie Metal Shop"));
        driverChrome.findElement(By.name("s"));

        driverChrome.get("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/moje-konto/");
        driverChrome.findElement(By.linkText("Softie Metal Shop"));
        driverChrome.findElement(By.name("s"));
        driverChrome.quit();
    }
    @Test
    void shouldGoToContactPage() {
        driverChrome.manage().window().maximize();
        driverChrome.get("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/");

        WebElement goToContactPage = driverChrome.findElement(By.id("menu-item-132"));
        goToContactPage.click();
        driverChrome.quit();
    }
    @Test
    void shouldGoToHomePage() {
        driverChrome.manage().window().maximize();
        driverChrome.get("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/moje-konto/");

        WebElement goToHomePage = driverChrome.findElement(By.id("menu-item-124"));
        goToHomePage.click();
        driverChrome.quit();
    }
    @Test
    void sendMessage() {
        driverChrome.manage().window().maximize();
        driverChrome.get("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/");

        WebElement sendMessageTest = driverChrome.findElement(By.id("menu-item-132"));
        sendMessageTest.click();
        WebElement useNameImput = driverChrome.findElement(By.name("your-name"));
        useNameImput.sendKeys("Dominik");
        WebElement useEmailAdressInput = driverChrome.findElement(By.name("your-email"));
        useEmailAdressInput.sendKeys("dawid.osiol@op.pl");
        WebElement writeTextMessage = driverChrome.findElement(By.name("your-message"));
        writeTextMessage.sendKeys("Jestem królem świata!");
        WebElement submitButtonTest = driverChrome.findElement(By.className("wcpf7-submit"));
        submitButtonTest.click();
        driverChrome.quit();

    }
    @Test
    void testPutAndRemoveToCArt() {
        driverChrome.manage().window().maximize();
        driverChrome.get("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/");
//    kliknij w koszyk
        WebElement testCarttest = driverChrome.findElement(By.className("cart-contents"));
        testCarttest.click();
//    Sprawdz czy wyswietla sie komunikat ze koszyk jest pusty
//        String expectedErrorMessage1 = "Twój koszyk jest aktualnie pusty.";
//        Assertions.assertEquals(expectedErrorMessage1,"Twój koszyk jest aktualnie pusty");
//    Kliknij zakładkę Sklep
        WebElement goToShop = driverChrome.findElement(By.id("menu-item-124"));
        goToShop.click();
//        Dodaj produkt do koszyka
        WebElement newProductInBag = driverChrome.findElement(By.cssSelector("[href='?add-to-cart-29']"));
        newProductInBag.click();

    }


//    WebElement driverChrome.findElement(By.linkText("Produkty")).click();
//    WebElement firstProductElement = driverChrome.findElement(By.cssSelector(".products .product:first-child"));
//    String productName = firstProductElement.findElement(By.cssSelector(".product-title a")).getText();
//    firstProductElement.findElement(By.cssSelector(".add_to_cart_button")).click();
//// dodanie produktu do koszyka
//    WebElement successMessageElement = driverChrome.findElement(By.cssSelector(".woocommerce-message"));
//    String successMessage = successMessageElement.getText();
//    Assertions.assertTrue(successMessage.contains("został dodany do koszyka."));
///// asercja: sprawdzenie, czy wyświetlony komunikat o sukcesie dodania produktu do koszyka jest taki sam jak oczekiwany
//    driverChrome.findElement(By.cssSelector(".site-header-cart .cart-contents")).click();
//    // kliknięcie przycisku koszyka
//    WebElement cartProductElement = driverChrome.findElement(By.cssSelector(".cart_item .product-name a"));
//    String cartProductName = cartProductElement.getText();
////    Assertions.assertEquals();productName, cartProductName);
//// asercja: sprawdzenie, czy nazwa produktu w koszyku jest taka sama jak dodany produkt
//        driverChrome.findElement(By.cssSelector(".cart_item .remove")).click();
//    // kliknięcie przycisku usuwania produktu z koszyka
//
//    WebElement emptyCartElement = driverChrome.findElement(By.cssSelector(".cart-empty"));
//    String emptyCartText = emptyCartElement.getText();
//    Assertions.assertTrue(emptyCartText.contains("Twój koszyk jest pusty."));
//
//// asercja: sprawdzenie, czy wyświetlony komunikat o pustym koszyku jest taki sam jak oczekiwany
}
//to mój pierwszy commit



