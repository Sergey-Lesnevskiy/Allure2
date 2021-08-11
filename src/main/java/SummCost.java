import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.gen5.api.Assertions;

import java.util.List;

public class SummCost {
    ProductPage productPage = new ProductPage();
    double summ = 0;
    double summInThePage = 0;

    public void summ() {
        ElementsCollection costCollection = productPage.tableBody.$$("div[class='inventory_item_price']");
        List<String> st = costCollection.texts();
        System.out.println(st.toString());
        double d = 0;
        for (int i = 0; i < st.size(); i++) {
            String a = st.get(i);
            String s2 = a.substring(1);
            d = Double.parseDouble(s2);
            summ = summ + d;
        }
        System.out.println(summ);
        SelenideElement costSite = productPage.allPage.$("div[class='summary_subtotal_label']");
        // способ прим изменении кол-во текста не будет работать
//       String s = costSite.text();
//       String a=s.substring(13,19);
//       summInThePage = Double.parseDouble(a);
//       System.out.println(summInThePage);
        String taboo = "AaBbCcDdEeFfGgHhIikKjJLlMmnNoOpPqQrRsSTtvVxXyYzZ!@#$%^&*()_+!№;%:?*/\\\"~";
        String s = costSite.text();
        for (char c : taboo.toCharArray()) {
            s = s.replace(c, ' ');
        }
        summInThePage = Double.parseDouble(s);
        System.out.println(summInThePage);

    }
}
