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
public class Cart_Tests {
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
    void cartManagementSetup(){
        WebElement logoLink = driverChrome.findElement(SelectorsList.SHOP_LOGO_SELECTOR);
        logoLink.click();
        addingSrebrnaSztabka500gToCart();
    }
    void addingSrebrnaSztabka500gToCart(){
        WebElement productSrebrnaSztabka500g = driverChrome.findElement(SelectorsList.BUTTON_ADD_TO_CART_SREBRNA_SZTABKA_500g_SELECTOR);
        productSrebrnaSztabka500g.click();
       }
    void emptyCartSetup(){
        WebElement myAccountMenuItem = driverChrome.findElement(SelectorsList.MY_ACCOUNT_MENU_ITEM_SELECTOR);
        myAccountMenuItem.click();
        WebElement cartItem = driverChrome.findElement(SelectorsList.CART_ITEM_SELECTOR);
        cartItem.click();
    }
    void seeCart(){
        WebElement cartContent = driverChrome.findElement(SelectorsList.CART_BUTTON_CONTENT_SELECTOR);
        cartContent.click();
        driverChrome.navigate().refresh();
    }

    @Test
    @Description("Positive test adding a product 'Srebrna sztabka 500g' to the cart, checking before if the cart is empty")

    void shouldVerifyIfCartIsEmptyAndPositiveAddProductToCart(){
        emptyCartSetup();
        WebElement basketContent = driverChrome.findElement(SelectorsList.CART_CONTENT_PRICE_VALUE_SELECTOR);
        Assertions.assertTrue(basketContent.getText().contains(SelectorsList.EXPECTED_EMPTY_CART_VALUE));

        cartManagementSetup();
        seeCart();

        WebElement SrebrnaSztabka500gInCart = driverChrome.findElement(SelectorsList.SREBRNA_SZTABKA_500g_IN_CART_SELECTOR);
        Wait wait = new WebDriverWait(driverChrome, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SelectorsList.SREBRNA_SZTABKA_500g_IN_CART_SELECTOR));

        Assertions.assertEquals(SelectorsList.EXPECTED_NAME_IN_CART_SREBRNA_SZTABKA_500g, SrebrnaSztabka500gInCart.getText());
    }
    @Test
    @Description("Positive test verifying removal of a product 'Srebrna sztabka 500g' from the cart")

    void shouldVerifyIfProductFromBasketIsRemoved(){
        cartManagementSetup();
        seeCart();
        WebElement cart = driverChrome.findElement(SelectorsList.CART_TEXT_MENU_CART_SELECTOR);

        Assertions.assertTrue(cart.getText().contains(SelectorsList.EXPECTED_TEXT_ON_PAGE_CART_MENU_CART));
        driverChrome.navigate().refresh();

        WebElement removeProductFromCart = driverChrome.findElement(SelectorsList.BUTTON_REMOVAL_SREBRNA_SZTABKA_500G_FROM_CART_SELECTOR);
        removeProductFromCart.click();
        WebElement cartRemoveText = driverChrome.findElement(SelectorsList.REMOVE_MESSAGE_SREBRNA_SZTABKA_500G_FROM_CART);

        Assertions.assertTrue(cartRemoveText.getText().contains(SelectorsList.EXPECTED_MESSAGE_AFTER_REMOVE_SZTABKA_SREBRNA_500G_FROM_CART));
    }
}
