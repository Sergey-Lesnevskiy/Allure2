import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

public class Delete {
    ProductPage productPage = new ProductPage();
    int shoppingSizeBefore = 0;
    int shoppingSizeAfter = 0;

    public void deletingFromTheShoppingСarts() {

        ElementsCollection shoppingCollection = productPage.tableBody.$$("div[class='cart_item']");
        shoppingSizeBefore = shoppingCollection.size();
        for (int i = 0; i < shoppingSizeBefore; i++) {
            shoppingCollection.first().$(By.xpath(".//button[text()='Remove']")).click();
        }
        shoppingSizeAfter = shoppingCollection.size();
    }
}
