package N11.pages;

import N11.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class N11_Spor {
    public N11_Spor() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[@id=\"header\"]/nav/ul/li[7]/a")
    public WebElement spor;
    @FindBy(xpath = "//*[@id=\"header\"]/nav/ul/li[7]/div/ul/li[2]/a/img")
    public WebElement sporAyakkabi;
    @FindBy(xpath = "//div[@class='item i1']")
    public WebElement artanFiyat;
    @FindBy(xpath = "//*[@id=\"smartListOption\"]/div[2]/div/div[1]")
    public WebElement akilliSiralama;

















}
