import org.openqa.selenium.By;

public class SelectorsList {

    static final String URL_PATH = "http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/";
    static final By MY_ACCOUNT_MENU_ITEM_SELECTOR = By.id("menu-item-125");
    static final By INPUT_USER_NAME_ITEM_SELECTOR = By.cssSelector("#username");
    static final  By INPUT_USER_PASSWORD_SELECTOR = By.cssSelector("#password");
    static final By BUTTON_LOGIN_SELECTOR = By.cssSelector("button[name='login']");
    static final By BUTTON_LOGOUT_SELECTOR = By.className("woocommerce-MyAccount-navigation-link--customer-logout");
    static final By ERROR_MESSAGE_WITH_NO_USER_NAME_SELECTOR = By.className("woocommerce-error");
    static final String EXPECTED_ERROR_MESSAGE_LOGIN_WITH_NO_USER_NAME = "Błąd: Nazwa użytkownika jest wymagana.";
    static final By ERROR_MESSAGE_WITH_WRONG_PASSWORD_SELECTOR = By.className("woocommerce-error");
    static final String EXPECTED_ERROR_MESSAGE_WITH_WRONG_PASSWORD = "Błąd: wpisano niepoprawne hasło dla użytkownika tester. Nie pamiętasz hasła?";
    static final By POSITIVE_LOGIN_MESSAGE_SELECTOR = By.className("woocommerce-notices-wrapper");
    static final String EXPECTED_POSITIVE_LOGIN_MESSAGE = "Witaj Adam Testowy (nie jesteś Adam Testowy?";
    static final By ERROR_MESSAGE_LOGIN_WITHOUT_PASSWORD_SELECTOR = By.className("woocommerce-error");
    static final String EXPECTED_ERROR_MESSAGE_LOGIN_WITHOUT_PASSWORD = "Błąd: pole hasła jest puste.";
    static final By CONTACT_MENU_ITEM = By.id("menu-item-132");
    static final By INPUT_FIRST_LAST_NAME_IN_CONTACT_MENU_SELECTOR = By.name("your-name");
    static final By INPUT_EMAIL_IN_CONTACT_MENU_SELECTOR = By.name("your-email");
    static final By INPUT_SUBJECT_IN_CONTACT_MENU_SELECTOR = By.name("your-subject");
    static final By INPUT_YOUR_MESSAGE_IN_CONTACT_MENU_SELECTOR = By.name("your-message");
    static final By SEND_BUTTON_IN_CONTACT_MENU_SELECTOR = By.cssSelector(".wpcf7-submit");
    static final By ERROR_MESSAGE_SENDING_MESSAGE_IN_CONTACT_MENU_SELECTOR = By.cssSelector(".wpcf7-response-output");
    static final String EXPECTED_ERROR_MESSAGE_SEND_MESSAGE_IN_CONTACT_MENU = "Wystąpił problem z wysłaniem twojej wiadomości. Spróbuj ponownie później.";
    static final String EXPECTED_ERROR_MESSAGE_SEND_MESSAGE_WITHOUT_REQUIRED_INPUT = "Przynajmniej jedno pole zawiera błąd. Proszę sprawdzić wpisaną treść i spróbować ponownie.";
    static final By CART_ITEM_SELECTOR = By.className("cart-contents");
    static final By CART_CONTENT_PRICE_VALUE_SELECTOR = By.cssSelector(".woocommerce-Price-amount");
    static final String EXPECTED_EMPTY_CART_VALUE = "0,00";
    static final By SHOP_LOGO_SELECTOR = By.linkText("Softie Metal Shop");
    static final By BUTTON_ADD_TO_CART_SREBRNA_SZTABKA_500g_SELECTOR = By.cssSelector("a[href='?add-to-cart=28']");
    static final By CART_BUTTON_CONTENT_SELECTOR = By.cssSelector("a[title='Zobacz zawartość koszyka']");
    static final By SREBRNA_SZTABKA_500g_IN_CART_SELECTOR = By.cssSelector(".product-name >a");
    static final String EXPECTED_NAME_IN_CART_SREBRNA_SZTABKA_500g = "Srebrna sztabka 500g";
    static final By BUTTON_REMOVAL_SREBRNA_SZTABKA_500G_FROM_CART_SELECTOR = By.cssSelector("a[data-product_id='28']");
    static final String EXPECTED_MESSAGE_AFTER_REMOVE_SZTABKA_SREBRNA_500G_FROM_CART = "Usunięto: „Srebrna sztabka 500g”.";
    static final By REMOVE_MESSAGE_SREBRNA_SZTABKA_500G_FROM_CART = By.className("woocommerce-message") ;
    static final By CART_TEXT_MENU_CART_SELECTOR = By.cssSelector("h1[class='entry-title']");
    static final String EXPECTED_TEXT_ON_PAGE_CART_MENU_CART = "Koszyk";
    static final By MAIN_LOGO_TEXT_SKLEP_Z_METALAMI_SZLACHETNYMI_SELECTOR = By.cssSelector(".site-branding > p");
    static final String EXPECTED_NAME_LOGO ="Sklep z metalami szlachetnymi";
    static final By PRODUCT_SEARCH_FIELD_MY_ACCOUNT_MENU = By.id("woocommerce-product-search-field-0");
    static final By CONTACT_TEXT_ON_CONTACT_PAGE_SELECTOR = By.cssSelector(".entry-header");
    static final String EXPECTED_CONTACT_TEXT_ON_PAGE_CONTACT = "Kontakt";
    static final By MAIN_PAGE_SELECTOR = By.linkText("Strona główna");
    static final String EXPECTED_TEXT_MAIN_PAGE = "Strona główna";
    static final By REGISTER_ITEM_MENU_SELECTOR = By.id("menu-item-146");
    static final By INPUT_USER_NAME_REGISTRATION_REGISTER_MENU_SELECTOR = By.cssSelector("#user_login");
    static final By INPUT_USER_EMAIL_REGISTRATION_REGISTER_MENU_SELECTOR = By.cssSelector("#user_email");
    static final By INPUT_USER_PASSWORD_REGISTRATION_REGISTER_MENU_SELECTOR = By.cssSelector("#user_pass");
    static final By STRENGHT_PASSWORD_MESSAGE_REGISTRATION_REGISTER_MENU_SELECTOR = By.className("user-registration-password-strength");
    static final By CONFIRM_USER_PASSWORD_REGISTRATION_REGISTER_MENU_SELECTOR = By.cssSelector("#user_confirm_password");
    static final By BUTTON_SUBMIT_REGISTRATION_REGISTER_MENU_SELECTOR = By.cssSelector(".ur-submit-button ");
    static final By MESSAGE_CONFIRMED_POSITIVE_REGISTRATION_REGISTER_MENU_SELECTOR = By.id("ur-submit-message-node");
    static final String EXPECTED_SUCCESS_MESSAGE_REGISTRATION_REGISTER_MENU = "User successfully registered.";












}
