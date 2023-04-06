import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main_Menu_Tests {
    static WebDriver driverChrome;

    @BeforeAll
    static void prepareBrowser() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driverChrome = new ChromeDriver();
        driverChrome.manage().window().maximize();
        driverChrome.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
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

    @Test
    @Description("Test positive should validate if the Main Page contains 'Sklep z metalami szlachetnymi' text under the logo shop")

    void shouldValidateMainPageContainsTextUnderLogo(){
            WebElement mainPageLogoName = driverChrome.findElement(SelectorsList.MAIN_LOGO_TEXT_SKLEP_Z_METALAMI_SZLACHETNYMI_SELECTOR);
            Assertions.assertEquals(SelectorsList.EXPECTED_NAME_LOGO, mainPageLogoName.getText());
    }
    @Test
    @Description("Test positive should validate if on the Login Page there is 'search' bar")

    void loginPageShouldContainSearchBar(){
        WebElement myAccountMenuItem = driverChrome.findElement(SelectorsList.MY_ACCOUNT_MENU_ITEM_SELECTOR);
        myAccountMenuItem.click();
        List<WebElement> webElements =driverChrome.findElements(SelectorsList.PRODUCT_SEARCH_FIELD_MY_ACCOUNT_MENU);

        Assertions.assertEquals(1, webElements.size());
    }
    @Test
    @Description("Test positive should validate change from Main Menu to Contact Menu")

    void shouldValidateChangeContactSiteFromMainPage(){
        WebElement myAccountMenuItem = driverChrome.findElement(SelectorsList.MY_ACCOUNT_MENU_ITEM_SELECTOR);
        myAccountMenuItem.click();
        WebElement contactMenuItem = driverChrome.findElement(SelectorsList.CONTACT_MENU_ITEM);
        contactMenuItem.click();
        WebElement nameContact = driverChrome.findElement(SelectorsList.CONTACT_TEXT_ON_CONTACT_PAGE_SELECTOR);

        Assertions.assertTrue(nameContact.getText().contains(SelectorsList.EXPECTED_CONTACT_TEXT_ON_PAGE_CONTACT));
    }
    @Test
    @Description("Test positive should validate change from Login Page to Main Menu")

    void shouldValidateChangeFromLoginPageToMainPage(){
        WebElement myAccountMenuItem = driverChrome.findElement(SelectorsList.MY_ACCOUNT_MENU_ITEM_SELECTOR);
        myAccountMenuItem.click();
        WebElement mainPage = driverChrome.findElement(SelectorsList.MAIN_PAGE_SELECTOR);

        Assertions.assertEquals(SelectorsList.EXPECTED_TEXT_MAIN_PAGE, mainPage.getText());
    }

}
