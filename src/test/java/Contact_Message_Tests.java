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
import java.util.concurrent.TimeUnit;

public class Contact_Message_Tests {

    static WebDriver driverChrome;

    @BeforeAll
    static void prepareBrowser() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driverChrome = new ChromeDriver();
        driverChrome.manage().window().maximize();
        driverChrome.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
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
    public void setupMessageContactMenu(String userName, String email, String subjectMessage, String bodyMessage){
        WebElement contactMenu = driverChrome.findElement(SelectorsList.CONTACT_MENU_ITEM);
        contactMenu.click();
        WebElement inputUserName = driverChrome.findElement(SelectorsList.INPUT_FIRST_LAST_NAME_IN_CONTACT_MENU_SELECTOR);
        inputUserName.sendKeys(userName);
        WebElement inputUserEmail = driverChrome.findElement(SelectorsList.INPUT_EMAIL_IN_CONTACT_MENU_SELECTOR);
        inputUserEmail.sendKeys(email);
        WebElement inputSubject = driverChrome.findElement(SelectorsList.INPUT_SUBJECT_IN_CONTACT_MENU_SELECTOR);
        inputSubject.sendKeys(subjectMessage);
        WebElement inputUserLongText = driverChrome.findElement(SelectorsList.INPUT_YOUR_MESSAGE_IN_CONTACT_MENU_SELECTOR);
        inputUserLongText.sendKeys(bodyMessage);
        WebElement buttonSend = driverChrome.findElement(SelectorsList.SEND_BUTTON_IN_CONTACT_MENU_SELECTOR);
        buttonSend.click();
    }
    @Test
    @Description("Positive test should verify if error message is displayed when sending a message correct response ")
        public void shouldVerifyErrorMessageWhenSendingMessageFromContactMenu(){
        setupMessageContactMenu("Mario", "mario@gmail.com", "Order123", "This is test message");

        Wait wait = new WebDriverWait(driverChrome, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SelectorsList.ERROR_MESSAGE_SENDING_MESSAGE_IN_CONTACT_MENU_SELECTOR));
        WebElement errorMessage = driverChrome.findElement(SelectorsList.ERROR_MESSAGE_SENDING_MESSAGE_IN_CONTACT_MENU_SELECTOR);

        Assertions.assertEquals(SelectorsList.EXPECTED_ERROR_MESSAGE_SEND_MESSAGE_IN_CONTACT_MENU, errorMessage.getText());
    }
    @Test
    @Description("Positive test should verify if error message is displayed when sending a message without required 'user name' input")

    public void shouldVerifyErrorMessageWhenSendingMessageWithoutRequiredUserNameInputFromContactMenu(){
        setupMessageContactMenu("", "mario@gmail.com", "Order123", "This is test message");

        Wait wait = new WebDriverWait(driverChrome, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SelectorsList.ERROR_MESSAGE_SENDING_MESSAGE_IN_CONTACT_MENU_SELECTOR));
        WebElement errorMessage = driverChrome.findElement(SelectorsList.ERROR_MESSAGE_SENDING_MESSAGE_IN_CONTACT_MENU_SELECTOR);

        Assertions.assertEquals(SelectorsList.EXPECTED_ERROR_MESSAGE_SEND_MESSAGE_WITHOUT_REQUIRED_INPUT, errorMessage.getText());
    }
    @Test
    @Description("Positive test should verify if error message is displayed when sending a message without required 'email' input")

    public void shouldVerifyErrorMessageWhenSendingMessageWithoutRequiredEmailInputFromContactMenu(){
        setupMessageContactMenu("Mario", "", "Order123", "This is test message");

        Wait wait = new WebDriverWait(driverChrome, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SelectorsList.ERROR_MESSAGE_SENDING_MESSAGE_IN_CONTACT_MENU_SELECTOR));
        WebElement errorMessage = driverChrome.findElement(SelectorsList.ERROR_MESSAGE_SENDING_MESSAGE_IN_CONTACT_MENU_SELECTOR);

        Assertions.assertEquals(SelectorsList.EXPECTED_ERROR_MESSAGE_SEND_MESSAGE_WITHOUT_REQUIRED_INPUT, errorMessage.getText());
    }
}
