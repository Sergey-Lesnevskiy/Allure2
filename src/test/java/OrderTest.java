import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import utils.Log;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.closeWebDriver;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderTest {
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    WorkCart workCart = new WorkCart();
    Add add = new Add();
    SummCost summCost = new SummCost();
    Delete delete = new Delete();

    @BeforeEach
    public void setUp() throws IOException {
//        Configuration.headless = true;
        Configuration.startMaximized = true;
        loginPage.openLoginPage();
        loginPage.login();
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Attachment
    @Description("login Test")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("login Test")
    @Issue("123321")
    @Link("https://www.saucedemo.com/")
    @Owner("Sergey")
    @Test
    @Order(2)
    public void loginTest() {
        loginPage.welcomeMessage();
        Log.info("Находимся на главной странице товаров");
        Assertions.assertEquals("PRODUCTS", loginPage.welcomeMessage.getText());
    }

    //Покупка
    @Attachment
    @Description("Bye product")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Bye product")
    @Issue("123321")
    @Link("https://www.saucedemo.com/")
    @Owner("Sergey")
    @Test
    @Order(1)
    public void buyingGoodsTest() {
        productPage.addBike();
        workCart.cartLink();
        productPage.finishOrder();
        loginPage.finishOrderPage();
        Log.info("Проверяем возможность купить товар.");
        Assertions.assertEquals("THANK YOU FOR YOUR ORDER", loginPage.finishOrderPage.getText());
        Log.info("После покупки продолжили выбирать товар.");
        productPage.back();
    }

    @Description("not bye product")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("not bye product")
    @Issue("123321")
    @Link("https://www.saucedemo.com/")
    @Owner("Sergey")
    @Test
    @Order(3)
    public void notBuyingGoodsTest() throws IOException {

        productPage.addSauceLabsBikeLight();
        Log.info("Отработал метод заполнения корзины");
        workCart.cartLink();
        productPage.cancel();
        loginPage.welcomeMessage();
        //    Log.info("Без оплаты вышли из оформления заказа");
        Assertions.assertEquals("PRODUCTS", loginPage.welcomeMessage.getText());
        //вернулись на заказы
    }

    @Description("deleting products")
    @Severity(SeverityLevel.NORMAL)
    @Feature("deleting products")
    @Issue("123321")
    @Link("https://www.saucedemo.com/")
    @Owner("Sergey")
    @Test
    @Order(5)
    public void deletingAllProductsFromTheShoppingCartTest() throws IOException {

        add.AddAllProductsFromTheShoppingCart();
        productPage.shoppingCartLink();
        productPage.tableBody();
        delete.deletingFromTheShoppingСarts();
        Log.info("Проверка на удалине из корзины");
        Assertions.assertEquals(delete.shoppingSizeBefore, delete.shoppingSizeAfter + delete.shoppingSizeBefore);
        // проверка  мне не нравиться , корявая, но рабочая.
        Assertions.assertFalse(productPage.tableBody.$("div[class='cart_item']") == null);
        //проверка селектора на существование
    }

    @Description("check summ")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("check summ")
    @Issue("123321")
    @Link("https://www.saucedemo.com/")
    @Owner("Sergey")
    @Test
    @Order(4)
    public void priseTest() {
        add.AddAllProductsFromTheShoppingCart();
        workCart.cartLink();
        productPage.allPage();
        summCost.summ();
        //   Log.info("Проверка итоговой суммы");
        Assertions.assertTrue(summCost.summ == summCost.summInThePage);

    }


}