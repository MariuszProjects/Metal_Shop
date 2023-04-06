import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Registration_Tests {

    static WebDriver driverChrome;

    @BeforeAll
    static void prepareBrowser() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driverChrome = new ChromeDriver();
        driverChrome.manage().window().maximize();
        driverChrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverChrome.get(SelectorsList.URL_PATH);
    }
    @BeforeEach
    void cleanCookiesBeforeEach() {
        driverChrome.manage().getCookies();
        driverChrome.manage().deleteAllCookies();
    }
    @AfterEach
    void cleanCookiesAfterEach() {
        driverChrome.manage().deleteAllCookies();
    }
    @AfterAll
    static void closeBrowser() {
        driverChrome.manage().deleteAllCookies();
        driverChrome.quit();
    }
    void registrationMethod(){
        Random random = new Random();
        int randomNumber = random.nextInt(999999);
        WebElement registerMenuItem = driverChrome.findElement(SelectorsList.REGISTER_ITEM_MENU_SELECTOR);
        registerMenuItem.click();
        WebElement inputUserName = driverChrome.findElement(SelectorsList.INPUT_USER_NAME_REGISTRATION_REGISTER_MENU_SELECTOR);
        inputUserName.sendKeys("mariusztestowy"+randomNumber+randomNumber);
        WebElement inputUserEMail = driverChrome.findElement(SelectorsList.INPUT_USER_EMAIL_REGISTRATION_REGISTER_MENU_SELECTOR);
        inputUserEMail.sendKeys("mariusztestowy" + randomNumber + "@yopmail" + randomNumber + ".com");
        WebElement inputUserPassword = driverChrome.findElement(SelectorsList.INPUT_USER_PASSWORD_REGISTRATION_REGISTER_MENU_SELECTOR);
        inputUserPassword.sendKeys("Mariusz_Testowy_123439");
        Wait wait = new WebDriverWait(driverChrome, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SelectorsList.STRENGHT_PASSWORD_MESSAGE_REGISTRATION_REGISTER_MENU_SELECTOR));
        WebElement inputUserConfirmPassword = driverChrome.findElement(SelectorsList.CONFIRM_USER_PASSWORD_REGISTRATION_REGISTER_MENU_SELECTOR);
        inputUserConfirmPassword.sendKeys("Mariusz_Testowy_123439");
        WebElement buttonSubmit= driverChrome.findElement(SelectorsList.BUTTON_SUBMIT_REGISTRATION_REGISTER_MENU_SELECTOR);
        buttonSubmit.click();
    }

    @Test
    @Description("Positive registration of new user in register menu")

    void shouldVerifyCorrectRegistrationNewUser(){
        registrationMethod();
        WebDriverWait wait = new WebDriverWait(driverChrome, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(SelectorsList.MESSAGE_CONFIRMED_POSITIVE_REGISTRATION_REGISTER_MENU_SELECTOR));
        //Assertions.assertTrue(successMessage.getText().contains(SelectorsList.EXPECTED_SUCCESS_MESSAGE_REGISTRATION_REGISTER_MENU));
        Assertions.assertEquals(SelectorsList.EXPECTED_SUCCESS_MESSAGE_REGISTRATION_REGISTER_MENU,successMessage.getText());
    }
}
