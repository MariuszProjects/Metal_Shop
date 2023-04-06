import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login_Tests {
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
    public static void logInMethod(String userName, String password){
        WebElement myAccountMenuItem = driverChrome.findElement(SelectorsList.MY_ACCOUNT_MENU_ITEM_SELECTOR);
        myAccountMenuItem.click();
        WebElement inputUserNameItem = driverChrome.findElement(SelectorsList.INPUT_USER_NAME_ITEM_SELECTOR);
        inputUserNameItem.sendKeys(userName);
        WebElement inputPassword = driverChrome.findElement(SelectorsList.INPUT_USER_PASSWORD_SELECTOR);
        inputPassword.sendKeys(password);
        WebElement buttonLogin = driverChrome.findElement(SelectorsList.BUTTON_LOGIN_SELECTOR);
        buttonLogin.click();
    }
    @Test
    @Description("Positive login test with correct user name and password")
    public void shouldVerifyPositiveLogin(){
        logInMethod("tester","KXVMHcx" );

        WebElement logInLink = driverChrome.findElement(SelectorsList.BUTTON_LOGOUT_SELECTOR);
        Assertions.assertTrue(logInLink.isDisplayed());
    }
    @Test
    @Description("Negative login test without user name and correct password")
    public void shouldVerifyNegativeLoginWithNoUserName(){
        logInMethod("", "KXVMHcx");

        WebElement errorMessage = driverChrome.findElement(SelectorsList.ERROR_MESSAGE_WITH_NO_USER_NAME_SELECTOR);
        Assertions.assertEquals(SelectorsList.EXPECTED_ERROR_MESSAGE_LOGIN_WITH_NO_USER_NAME, errorMessage.getText());
    }
    @Test
    @Description("Negative login test without password and correct user name")
    public void shouldVerifyNegativeLoginWithNoPassword(){
        logInMethod("tester", "");

        WebElement errorMessage = driverChrome.findElement(SelectorsList.ERROR_MESSAGE_LOGIN_WITHOUT_PASSWORD_SELECTOR);
        Assertions.assertEquals(SelectorsList.EXPECTED_ERROR_MESSAGE_LOGIN_WITHOUT_PASSWORD, errorMessage.getText());
    }
    @Test
    @Description("Negative login test with correct user name and wrong password - additional letter")
    public void shouldVerifyNegativeLoginWrongNoPassword(){
        logInMethod("tester", "KXVMHcxA");

        WebElement errorMessageWrongPassword = driverChrome.findElement(SelectorsList.ERROR_MESSAGE_WITH_WRONG_PASSWORD_SELECTOR);
        Assertions.assertEquals(SelectorsList.EXPECTED_ERROR_MESSAGE_WITH_WRONG_PASSWORD, errorMessageWrongPassword.getText());
    }

}
