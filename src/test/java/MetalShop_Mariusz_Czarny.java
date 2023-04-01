import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MetalShop_Mariusz_Czarny {

    static WebDriver driverChrome;

    @BeforeAll
    static void prepareBrowser() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driverChrome = new ChromeDriver();
        driverChrome.manage().window().maximize();
        driverChrome.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driverChrome.get("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/");
    }

    @BeforeEach
    void cleanCookiesBeforeEach() {
        driverChrome.manage().getCookies();
        driverChrome.manage().deleteAllCookies();
    }

    @AfterEach
    void cleanCookiesAfterEach() {
        driverChrome.manage().deleteAllCookies();
        //driverChrome.quit();
    }

    @AfterAll
    static void closeBrowser() {
        driverChrome.manage().deleteAllCookies();
        driverChrome.quit();
    }

    //Zad 1. OK
    //Napisz test, który zweryfikuje działanie aplikacji , gdy przy próbie logowania nie podano loginu.

    @Test
    void shouldVerifyLoginWithNoLogin() {
        //Zdefiniowanie zmiennej Moje Konto z Menu Głownego
        WebElement myAccountMenuItem = driverChrome.findElement(By.id("menu-item-125"));
        myAccountMenuItem.click();

        //Zdefiniowanie input'u do wprowadzenia 'user name'
        WebElement inputUserNameItem = driverChrome.findElement(By.cssSelector("#username"));
        inputUserNameItem.sendKeys("");

        //Zdefiniowanie input'u do wprowadzenia 'password'
        WebElement inputPassword = driverChrome.findElement(By.cssSelector("#password"));
        inputPassword.sendKeys("KXVMHcx");

        //Zdefiniowanie funkcji przycisnij button 'zaloguj sie'
        WebElement buttonLogin = driverChrome.findElement(By.cssSelector("button[name='login']"));
        buttonLogin.click();

        //Zdefiniowanie elementu i zmiennej okreslajacej wyswietlany blad
        // .woocommerce-error li
        WebElement errorMessage = driverChrome.findElement(By.className("woocommerce-error"));
        String expectedErrorMessage = "Błąd: Nazwa użytkownika jest wymagana.";

        //Asercja na wyswietlany komunikat o bledzie
        Assertions.assertEquals(expectedErrorMessage, errorMessage.getText());
    }

    // Zad 2. OK
    //Napisz test, który zweryfikuje działanie aplikacji , gdy przy próbie logowania nie podano hasła.

    @Test
    void shouldVerifyLoginWithoutPassword() {
        //Zdefiniowanie zmiennej Moje Konto z Menu Głownego by id 'menu-item-125'
        WebElement myAccountMenuItem = driverChrome.findElement(By.id("menu-item-125"));
        myAccountMenuItem.click();

        //Zdefiniowanie input'u do wprowadzenia 'user name' by id "username"
        WebElement inputUserNameItem = driverChrome.findElement(By.cssSelector("#username"));
        inputUserNameItem.sendKeys("tester");

        //Zdefiniowanie input'u do wprowadzenia 'password', by id "password", haslo jest puste
        WebElement inputPassword = driverChrome.findElement(By.cssSelector("#password"));
        inputPassword.sendKeys("");

        //Zdefiniowanie funkcji przycisnij button 'zaloguj sie' by button name 'login'
        WebElement buttonLogin = driverChrome.findElement(By.cssSelector("button[name='login']"));
        buttonLogin.click();

        //Zdefiniowanie elementu i zmiennj okreslajacej wyswietlany blad
        WebElement errorMessage = driverChrome.findElement(By.className("woocommerce-error"));
        String expectedErrorMessage = "Błąd: pole hasła jest puste.";

        //Asercja na wyswietlany komunikat o bledzie
        Assertions.assertEquals(expectedErrorMessage, errorMessage.getText());
    }


    // Zad 3. KO
    //Napisz test, który zweryfikuje poprawną rejestrację nowego użytkownika. Nie zapomnij o weryfikacji czy
    //rejestracja się powiodła.
    // na potrzeby zadania zostal stworzony nowy uzytkownik i adres email, ktory jeszcze nie zostal zarejestrowany w sklepie

    @Test
    void shouldVerifyCorrectRegistrationNewUser() {

        Random random = new Random();int randomNumber = random.nextInt(99999);
       //Zdefiniowanie zmiennej register z Menu Głownego    WebElement registerMenuItem = driverChrome.findElement(By.id("menu-item-146"));    registerMenuItem.click();    //Zdefiniowanie input'u do wprowadzenia 'username' by #user_login"    WebElement inputUserName = driverChrome.findElement(By.cssSelector("#user_login"));    inputUserName.sendKeys("mariusztestowy" + randomNumber + randomNumber);    //Zdefiniowanie input'u do wprowadzenia 'user Password' by id 'user_pass'    WebElement inputUserPassword = driverChrome.findElement(By.cssSelector("#user_pass"));    inputUserPassword.sendKeys("Mariusz_Testowy_12342");    //Zdefiniowanie input'u do wprowadzenia 'user Email' by id 'user_email'    WebElement inputUserEMail = driverChrome.findElement(By.cssSelector("#user_email"));    inputUserEMail.sendKeys("mariusztestowy" + randomNumber + "@yopmail" + randomNumber + ".com");
        //Zdefiniowanie zmiennej register z Menu Głownego
        WebElement registerMenuItem = driverChrome.findElement(By.id("menu-item-146"));
        registerMenuItem.click();

        //Zdefiniowanie input'u do wprowadzenia 'username' by #user_login"
        WebElement inputUserName = driverChrome.findElement(By.cssSelector("#user_login"));
        inputUserName.sendKeys("mariusztestowy" + randomNumber + randomNumber);
        //inputUserName.sendKeys(random);

        //Zdefiniowanie input'u do wprowadzenia 'user Password' by id 'user_pass'
        WebElement inputUserPassword = driverChrome.findElement(By.cssSelector("#user_pass"));
        inputUserPassword.sendKeys("Mariusz_Testowy_12343");

        //Zdefiniowanie input'u do wprowadzenia 'user Email' by id 'user_email'
        WebElement inputUserEMail = driverChrome.findElement(By.cssSelector("#user_email"));
        inputUserEMail.sendKeys("mariusztestowy" + randomNumber + "@yopmail" + randomNumber + ".com");
        //inputUserEMail.sendKeys("mariusztestowy43@yopmail.com");

        //Zdefiniowanie input'u do wprowadzenia 'confirm Password' by id 'user_confirm_password'
        WebElement inputUserEmail = driverChrome.findElement(By.cssSelector("#user_confirm_password"));
        inputUserEmail.sendKeys("Mariusz_Testowy_12343");

        //klikniecie ENTER
        driverChrome.findElement(By.name("user_confirm_password")).sendKeys(Keys.ENTER);

        //Zdefiniowanie elementu i zmiennj okreslajacej wyswietlany test potwierdzajacy pozytywne stworzenie uzytkownika

        Wait wait = new WebDriverWait(driverChrome, Duration.ofSeconds(10));wait.until(ExpectedConditions        .visibilityOfElementLocated(By.className("user-registration-password-strength")));


//        Wait wait = new WebDriverWait(driverChrome, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ur-submit-message-node >ul")));
        //WebElement successMessage = driverChrome.findElement(By.id("ur-submit-message-node >ul")); //nok
        WebElement successMessage = driverChrome.findElement(By.cssSelector("#ur-submit-message-node >ul")); //nok

        if (!successMessage.isDisplayed()) {    driverChrome.findElement(By.name("user_confirm_password")).sendKeys(Keys.ENTER);}

        //WebElement successMessage = driverChrome.findElement(By.id("ur-submit-message-node")); //nok
        //WebElement successMessage = driverChrome.findElement(By.cssSelector(".user-registration-message >ul")); //nok
        //WebElement successMessage = driverChrome.findElement(By.cssSelector(".ur-message > ul")); // nok
        //WebElement successMessage = driverChrome.findElement(By.xpath("//*[@id='ur-submit-message-node']/ul"));  //nok

        String expectedSuccessMessage = "User successfully registered.";

        Assertions.assertEquals(expectedSuccessMessage, successMessage.getText());
    }


    // Zad 4. OK
    //Sprawdź, czy strona główna oraz strona logowania zawiera logo (nazwę i pole wyszukiwania).

    @Test
    void mainPageShouldContainsLogo() {
        //Wyszukanie nazwy 'Sklep z metalami szlachetnymi', by .site-branding > p
        WebElement mainPageLogoName = driverChrome.findElement(By.cssSelector(".site-branding > p"));
        String expectedNameLogo = "Sklep z metalami szlachetnymi";
        Assertions.assertEquals(expectedNameLogo, mainPageLogoName.getText());
    }

    @Test
    void loginPageShouldContainSearchBar() {
        //Zdefiniowanie zmiennej Moje Konto z Menu Głownego by id 'menu-item-125'
        WebElement myAccountMenuItem = driverChrome.findElement(By.id("menu-item-125"));
        myAccountMenuItem.click();

        //Zdefiniowanie listy z elementami 'search field' po wybraniu 'Moje konto' i asercja
        List<WebElement> elements = driverChrome.findElements(By.id("woocommerce-product-search-field-0"));
        Assertions.assertEquals(1, elements.size());
    }


    // Zad 5. OK
    //Napisz test sprawdzający przejście ze strony głównej do strony Kontakt.

    @Test
    void shouldEnterContactSiteFromMainPage() {
        //Zdefiniowanie zmiennej Moje Konto z Menu Głownego by id 'menu-item-125'
        WebElement myAccountMenuItem = driverChrome.findElement(By.id("menu-item-125"));
        myAccountMenuItem.click();

        //Klikniecie w menu Kontakt, menu-item-132
        WebElement contactMenuItem = driverChrome.findElement(By.id("menu-item-132"));
        contactMenuItem.click();

        //Znalezienie tekstu 'Kontakt' i asercja
        WebElement nameKontakt = driverChrome.findElement(By.cssSelector(".entry-header"));
        String expectedStringKontakt = "Kontakt";
        Assertions.assertTrue(nameKontakt.getText().contains(expectedStringKontakt));
    }

    //Zad 6. OK
    //Napisz test sprawdzający przejście ze strony logowania do strony głównej.

    @Test
    void shouldEnterFromLoginPageToMainPage() {

        //Zdefiniowanie zmiennej Moje Konto z Menu Głownego by id 'menu-item-125'
        WebElement myAccountMenuItem = driverChrome.findElement(By.id("menu-item-125"));
        myAccountMenuItem.click();

        //Zdefiniowanie Strony glownej by link text
        WebElement mainPage = driverChrome.findElement(By.linkText("Strona główna"));

        String expectedStringMainPage = "Strona główna";

        //Asercja na wyswietlany komunikat o bledzie
        Assertions.assertEquals(expectedStringMainPage, mainPage.getText());
    }


    //Zad 7. OK
    //Napisz test sprawdzający próbę wysłania wiadomości w zakładce kontakt. I zweryfikuj wyświetlenie error Message.

    @Test
    void shouldVerifyDisplayErrorMessageWhenSendingText() {

        //Klikniecie w menu Kontakt, menu-item-132
        WebElement contactMenuItem = driverChrome.findElement(By.id("menu-item-132"));
        contactMenuItem.click();

        //Zdefiniowanie input'u do wprowadzenia 'Twoje imie i nazwisko' by name 'your-name'
        WebElement inputUserNameLastName = driverChrome.findElement(By.name("your-name"));
        inputUserNameLastName.sendKeys("Mario");

        //Zdefiniowanie input'u do wprowadzenia 'Twoj adres email', by name 'your-email'
        WebElement inputUserEmail = driverChrome.findElement(By.name("your-email"));
        inputUserEmail.sendKeys("mario@gmail.com");

        //Zdefiniowanie input'u do wprowadzenia 'Temat', by name 'your-subject'
        WebElement inputUserText = driverChrome.findElement(By.name("your-subject"));
        inputUserText.sendKeys("Zamowienie");

        //Zdefiniowanie input'u do wprowadzenia 'Twoja wiadomosc' by name 'your-message'
        WebElement inputUserLongText = driverChrome.findElement(By.name("your-message"));
        inputUserLongText.sendKeys("Testowa wiadomosc");

        //Zdefiniowanie przycisku "Wyślij"
        WebElement buttonSend = driverChrome.findElement(By.cssSelector(".wpcf7-submit"));
        buttonSend.click();

        driverChrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Zdefiniowanie elementu i zmiennj okreslajacej wyswietlany blad by class name 'wpcf7-response-output'
        WebElement errorMessage = driverChrome.findElement(By.cssSelector(".wpcf7-response-output"));

        Wait wait = new WebDriverWait(driverChrome, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".wpcf7-response-output")));
        String expectedErrorMessage = "Wystąpił problem z wysłaniem twojej wiadomości. Spróbuj ponownie później.";

        driverChrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Asercja na wyswietlany komunikat o bledzie
        Assertions.assertEquals(expectedErrorMessage, errorMessage.getText());
        Assertions.assertTrue(errorMessage.getText().contains(expectedErrorMessage));
    }

    //Zad 8. OK
    //Napisz test, który na początku sprawdza czy koszyk jest pusty, a następnie dodaje produkt do koszyka.
    // Zweryfikuj , czy dodanie powiodło się.

    @Test
    void shouldVerifyBasketisEmptyAndAddProductToBasket() {

        //Zdefiniowanie zmiennej Moje Konto z Menu Głownego by id 'menu-item-125'
        WebElement myAccountMenuItem = driverChrome.findElement(By.id("menu-item-125"));
        myAccountMenuItem.click();

        //Znalezienie obiektu 'koszyk' by class name 'cart-contents'
        WebElement basket = driverChrome.findElement(By.className("cart-contents"));
        basket.click();

        // Zobaczenie zawartości koszyka
        WebElement basketContent = driverChrome.findElement(By.cssSelector(".woocommerce-Price-amount"));
        String expectedBasketcontentontent = "0,00";

        //Asercja czy jest pusty koszyk
        Assertions.assertTrue(basketContent.getText().contains(expectedBasketcontentontent));

        //Zdefiniowanie obiektu do klikniecia na logo sklepu 'Softie Metal Shop'
        WebElement logoLink = driverChrome.findElement(By.linkText("Softie Metal Shop"));
        logoLink.click();

        //Dodanie produktu „Srebrna sztabka 500g” do koszyka, by xpath //[@id='main']/ul/li[3]/a[2]
        WebElement productSrebrnaSztabka500g = driverChrome.findElement(By.xpath("//*[@id=\'main\']/ul/li[3]/a[2]"));
        productSrebrnaSztabka500g.click();

        // Zobaczenie zawartości koszyka
        WebElement basketButton = driverChrome.findElement(By.cssSelector("a[title='Zobacz zawartość koszyka']"));
        basketButton.click();

        //refresh strony z koszykiem
        driverChrome.navigate().refresh();

        //Znalezienie produktu 'Srebrna sztabka 500g' w koszyku, by link name "Srebrna sztabka 500g"
        //WebElement productInBasket = driverChrome.findElement(By.linkText("Srebrna sztabka 500g"));
        WebElement productInBasket = driverChrome.findElement(By.cssSelector(".product-name >a"));
        //WebElement productInBasket = driverChrome.findElement(By.xpath("//a[text()='Srebrna sztabka 500g']"));

        Wait wait = new WebDriverWait(driverChrome, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-name >a")));
        String expectedProductName = "Srebrna sztabka 500g";
        //Asercja czy jest produkt w koszyku
        Assertions.assertEquals(expectedProductName, productInBasket.getText());
    }


    // Zad 9. OK
    //Napisz test, który dodaje produkt do koszyka , a następnie usuwa go. Zweryfikuj,czy usunięcie powiodło się.

    @Test
    void shouldVerifyIfProductFromBasketIsRemoved() {

        //Zdefiniowanie zmiennej Moje Konto z Menu Głownego by id 'menu-item-125'
        WebElement myAccountMenuItem = driverChrome.findElement(By.id("menu-item-125"));
        myAccountMenuItem.click();

        //Znalezienie obiektu 'koszyk' by class name 'cart-contents'
        WebElement basket = driverChrome.findElement(By.cssSelector("a[title='Zobacz zawartość koszyka']"));
        basket.click();

        //Znalezienie tekstu na stronie 'Twój koszyk aktualnie jest pusty.' by classname 'woocommerce-notices-wrapper'
        WebElement basketEmptyText1 = driverChrome.findElement(By.className("woocommerce"));

        String expectedMessage1 = "Twój koszyk aktualnie jest pusty.";

        //Asercja na wyswietlany komunikat o usunieciu
        Assertions.assertTrue(basketEmptyText1.isDisplayed());

        //Zdefiniowanie obiektu do klikniecia na logo sklepu 'Softie Metal Shop'
        WebElement logoLink = driverChrome.findElement(By.linkText("Softie Metal Shop"));
        logoLink.click();

        //Dodanie produktu „Srebrna sztabka 500g” do koszyka, by xpath //[@id='main']/ul/li[3]/a[2]
        WebElement productSrebrnaSztabka500g = driverChrome.findElement(By.xpath("//*[@id=\'main\']/ul/li[3]/a[2]"));
        productSrebrnaSztabka500g.click();

        //Klik przycisk 'Zobacz koszyk',
        WebElement buttonSeeBasket = driverChrome.findElement(By.cssSelector("a[title='Zobacz zawartość koszyka']"));
        buttonSeeBasket.click();
        WebElement koszyk = driverChrome.findElement(By.xpath("//*[@id=\'post-7\']/header/h1"));
        String koszykString = "Koszyk";
        Assertions.assertTrue(koszyk.getText().contains(koszykString));

        //refresh strony z koszykiem
        driverChrome.navigate().refresh();

        driverChrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Usunięcie produktu „Srebrna sztabka 500g” z koszyka by css selector 'a[data-product_id='28']'
        WebElement removeProductFromBasket = driverChrome.findElement(By.cssSelector("a[data-product_id='28']"));
        removeProductFromBasket.click();

        //Znalezienie tekstu na stronie 'Usunięto: „Srebrna sztabka 500g”.'
        WebElement basketEmptyText2 = driverChrome.findElement(By.className("woocommerce-message"));

        String expectedMessage2 = "Usunięto: „Srebrna sztabka 500g”.";

        //Asercja na wyswietlany komunikat o usunieciu
        Assertions.assertTrue(basketEmptyText2.isDisplayed());
        Assertions.assertTrue(basketEmptyText2.getText().contains(expectedMessage2));

    }


}
