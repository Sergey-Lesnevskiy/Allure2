import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage extends BasePage {
    //товары
    SelenideElement addSauceLabsBackpack = $(By.name("add-to-cart-sauce-labs-backpack"));
    SelenideElement addSauceLabsBoltT_Shirt = $("#add-to-cart-sauce-labs-bolt-t-shirt");
    SelenideElement addSauceLabsOnesie = $("#add-to-cart-sauce-labs-onesie");
    SelenideElement addTestallTheThingsT_ShirtRed = $(By.name("add-to-cart-test.allthethings()-t-shirt-(red)"));
    SelenideElement addSauceLabsFleeceJacket = $("#add-to-cart-sauce-labs-fleece-jacket");
    SelenideElement addSauceLabsBikeLight = $("#add-to-cart-sauce-labs-bike-light");
    //вход в козину и оформление заказа
    SelenideElement shoppingCartLink = $("a[class='shopping_cart_link']");
    SelenideElement checkout = $("#checkout");
    SelenideElement addOrderFirstName = $("#first-name");
    SelenideElement addOrderLastName = $("#last-name");
    SelenideElement addOrderPostalCode = $("#postal-code");
    SelenideElement clicContinue = $("#continue");
    SelenideElement finishOrder = $("#finish");
    SelenideElement back = $("#back-to-products");
    SelenideElement cancel = $("#cancel");
    //Страницы
    SelenideElement allPage = $("#checkout_summary_container");
    SelenideElement tableBody = $("div[class='cart_list']");


}