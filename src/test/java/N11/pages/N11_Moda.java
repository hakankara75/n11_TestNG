package N11.pages;

import N11.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class N11_Moda {
    public N11_Moda() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//a[@title='Ayakkabı & Çanta']//img")
    public WebElement ayakkabiCanta;
    @FindBy(xpath = "//section[@class='filter filterSearch']")
    public WebElement sonuclardaAra;
    @FindBy(xpath = "(//section[@class='filter acc '])[1]")
    public WebElement marka;
    @FindBy(xpath = "//*[@id=/'contentListing/']/div/div[2]/div[1]/section[7]/div/div[2]/div[5]/a")
    public WebElement benetton;
    @FindBy(xpath = "(//strong[text()=.])[3]")
    public WebElement secilenUrunSayisi;
    @FindBy(xpath = "(//div[@class='columnContent'])[1]")
    public WebElement secilenUrunler;

    @FindBy(xpath = "//div[@class='banner__reject-button']")
    public WebElement tumunuReddet;
    @FindBy(xpath = "//input[@id='minPrice']")
    public WebElement fiyatEnAz;
    @FindBy(xpath = "//div[@class='filterArea']")
    public WebElement kategoriler;







}
