import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class Add {
    @Step("Add products")
    @Attachment
    public void AddAllProductsFromTheShoppingCart() {
        ProductPage productPage = new ProductPage();
        productPage.addSauceLabsBikeLight.click();
        productPage.addTestallTheThingsT_ShirtRed.click();
        productPage.addSauceLabsBackpack.click();
        productPage.addSauceLabsFleeceJacket.click();
        productPage.addSauceLabsBoltT_Shirt.click();
        productPage.addSauceLabsOnesie.click();
    }
}
