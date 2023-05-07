package N11.pages;

import N11.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class N11_Mucevher {
    public N11_Mucevher() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@title='Mücevher & Saat']//img")
    public WebElement mucevher;

    @FindBy(xpath = "//*[@id=\"header\"]/nav/ul/li[6]/div/ul/li[3]/a/img")
    public WebElement gozluk;

    @FindBy(xpath = "//*[@id=\"smartListOption\"]/div[2]/div/div[1]")
    public WebElement akilliSiralama;
    @FindBy(xpath = "//*[@id=\"smartListOption\"]/div[2]/div/div[2]/div[3]")
    public WebElement azalanFiyat;
    @FindBy(xpath = "//div[@class='priceContainer ']")
    public WebElement fiyatClass;




















}
