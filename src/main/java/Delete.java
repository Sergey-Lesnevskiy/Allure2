import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Delete {
    ProductPage productPage = new ProductPage();
    int shoppingSizeBefore = 0;
    int shoppingSizeAfter = 0;

    @Step("Delete products")
    @Attachment
    public void deletingFromTheShoppingСarts() {

        ElementsCollection shoppingCollection = productPage.tableBody.$$("div[class='cart_item']");
        shoppingSizeBefore = shoppingCollection.size();
        for (int i = 0; i < shoppingSizeBefore; i++) {
            shoppingCollection.first().$(By.xpath(".//button[text()='Remove']")).click();
        }
        shoppingSizeAfter = shoppingCollection.size();
    }
}
