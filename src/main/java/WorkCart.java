import io.qameta.allure.Step;

public class WorkCart {
    @Step("Cart link")
    public void cartLink() {
        ProductPage productPage = new ProductPage();
        productPage.shoppingCartLink.click();
        productPage.checkout.click();
        productPage.addOrderFirstName.sendKeys("we");
        productPage.addOrderLastName.sendKeys("we");
        productPage.addOrderPostalCode.sendKeys("123");
        productPage.clicContinue.click();
    }
}
