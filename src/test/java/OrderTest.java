import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
//import utils.Log;

import java.io.IOException;


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

    //вход на страницу
    @Test
    @Order(1)
    public void loginTest() throws IOException {

        loginPage.welcomeMessage.shouldBe(visible);
     //   Log.info("Находимся на главной странице товаров");
        Assertions.assertEquals("PRODUCTS", loginPage.welcomeMessage.getText());
    }

    //Покупка
    @Test
    @Order(2)
    public void buyingGoodsTest() throws IOException {

        productPage.addSauceLabsBikeLight.click();
        workCart.cartLink();
        productPage.finishOrder.click();
        loginPage.finishOrderPage.shouldBe(visible);
       // Log.info("Проверяем возможность купить товар.");
        Assertions.assertEquals("THANK YOU FOR YOUR ORDER", loginPage.finishOrderPage.getText());
      //  Log.info("После покупки продолжили выбирать товар.");
        productPage.back.click();
    }

    @Test
    @Order(3)
    public void notBuyingGoodsTest() throws IOException {

        productPage.addSauceLabsBikeLight.click();
     //   Log.info("Отработал метод заполнения корзины");
        workCart.cartLink();
        productPage.cancel.click();
        loginPage.welcomeMessage.shouldBe(visible);
    //    Log.info("Без оплаты вышли из оформления заказа");
        Assertions.assertEquals("PRODUCTS", loginPage.welcomeMessage.getText());
        //вернулись на заказы
    }

    //удаление заказов
    @Test
    @Order(4)
    public void deletingAllProductsFromTheShoppingCart() throws IOException {

        add.AddAllProductsFromTheShoppingCart();
        productPage.shoppingCartLink.click();
        productPage.tableBody.shouldBe(visible);
        delete.deletingFromTheShoppingСarts();
       // Log.info("Проверка на удалине из корзины");
        Assertions.assertEquals(delete.shoppingSizeBefore, delete.shoppingSizeAfter + delete.shoppingSizeBefore);
        // проверка  мне не нравиться , корявая, но рабочая.
        Assertions.assertFalse(productPage.tableBody.$("div[class='cart_item']") == null);
        //проверка селектора на существование
    }
    //проверка цены
    @Test
    @Order(5)
    public void prise() throws IOException {

        add.AddAllProductsFromTheShoppingCart();
        workCart.cartLink();
        productPage.allPage.shouldBe(visible);
        summCost.summ();
     //   Log.info("Проверка итоговой суммы");
        Assertions.assertTrue(summCost.summ == summCost.summInThePage);

    }


}