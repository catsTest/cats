package framework.elements;

import framework.utils.LoggerMes;
import org.openqa.selenium.By;

public class TextBox extends BaseElement {
    public TextBox(By locator, String name) {
        super(locator, name);
    }

    public void fillField(String string) {
//        LoggerMes.log("fill text field");
        element.click();
        element.sendKeys(string);
    }

    public void clear() {
        element.clear();
    }
}
