package N11.pages;

import N11.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class N11_Elektronik {
    public N11_Elektronik() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//li[@class='catMenuItem'])[2]")
    public WebElement elektronik;
    @FindBy(xpath = "(//a[@href='https://www.n11.com/telefon-ve-aksesuarlari'])[1]")
    public WebElement telefonAksesuar;
    @FindBy(xpath = "//img[@src='https://n11scdn.akamaized.net/a1/70/22/06/23/65/68/54/91/35/83/37/03/64/87843262666886237075.png']")
    public WebElement bilgisayar;
    @FindBy(xpath = "//img[@src='https://n11scdn.akamaized.net/a1/70/22/06/23/62/39/67/84/81/69/94/16/83/76285410644875430358.png']")
    public WebElement televizyon;

    @FindBy(xpath = "//a[@class='Samsung']")
    public WebElement samsung;
       @FindBy(xpath = "//div[@class='resultText ']")
    public WebElement samsungSonuc;
    @FindBy(xpath = "//div[@data-iv='Samsung']")
    public WebElement samsungIptal;
    @FindBy(xpath = "//a[@title='Samsung']")
    public WebElement samsungCheckBox;



}
