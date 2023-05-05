package N11.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class N11_Moda {
    @FindBy(xpath = "//a[@title='Ayakkabı & Çanta']//img")
    public WebElement ayakkabiCanta;
    @FindBy(xpath = "(//a[@href='https://www.n11.com/giyim-ayakkabi'])[1]")
    public WebElement moda;
}
