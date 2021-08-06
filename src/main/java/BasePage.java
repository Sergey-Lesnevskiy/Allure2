import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    SelenideElement finishOrderPage = $("h2[class='complete-header']");
    SelenideElement welcomeMessage = $("span[class='title']");
}
