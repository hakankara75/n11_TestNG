package N11.tests.day01;

import N11.pages.N11_Moda;
import N11.utilities.ConfigReader;
import N11.utilities.Driver;
import N11.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.swing.text.html.Option;
import java.time.Duration;
import java.util.List;

import static N11.utilities.ReusableMethods.clickByJavaScript;
import static N11.utilities.ReusableMethods.visibleWait;
import static org.testng.Assert.assertTrue;

public class C04_Moda {
    /*
       "https://www.n11.com/" adresine git
        giris yap
     */
    @Test
    public void testName() {

        // "https://www.n11.com/" adresine git
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        N11_Moda n11Moda = new N11_Moda();

        Driver.getDriver().get(ConfigReader.getProperty("N11Url"));
        ReusableMethods.uyarilariKapat();

        //giris yap
        ReusableMethods.girisYap();
        ReusableMethods.bekle(2);

        //moda menusu ustune git
        ReusableMethods.moveToElement(Driver.getDriver().findElement(By.xpath("(//a[@href='https://www.n11.com/giyim-ayakkabi'])[1]")));
        ReusableMethods.bekle(2);

        //ayakkabi/canta menusune tikla
        ReusableMethods.clickByJavaScript(Driver.getDriver().findElement(By.xpath("//a[@title='Ayakkabı & Çanta']//img")));
        ReusableMethods.bekle(2);

        //Marka menusunu ac
        WebElement icerik = (WebElement) js.executeScript("return document.querySelector('#contentListing > div > div.listingHolder > div.filterArea > section:nth-child(10) > h2')");
        ReusableMethods.scrollToElementWithWebElement(icerik);

        WebElement marka = (WebElement) js.executeScript("return document.querySelector('#contentListing > div > div.listingHolder > div.filterArea > section:nth-child(7) > h2')");
        ReusableMethods.scrollToElementWithWebElement(marka);
        marka.click();
        ReusableMethods.bekle(2);

        //Benetton markasini sec, secildigini test et
        WebElement benettonBul = (WebElement) js.executeScript("return document.querySelector('#contentListing > div > div.listingHolder > div.filterArea > section:nth-child(7) > div > div.filterList > div:nth-child(5) > a')");
        ReusableMethods.clickByJavaScript(benettonBul);
               assertTrue(benettonBul.isSelected());


        //secim sonucunda cikan sayiyi al
        String secimSayisi = js.executeScript("return document.querySelector(/'#p-563614689/')").toString();
        int urunSecimSayisi = Integer.parseInt(secimSayisi);
        System.out.println(urunSecimSayisi);

        //secilen urunlerin sayisini secim sonucuyla esit oldugunu dogrula
        for (int i = 1; i <= urunSecimSayisi; i++) {

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
            WebElement urun = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='columnContent'])[" + i + "]")));
            ReusableMethods.scrollToElementWithString("(//div[@class='columnContent'])[" + i + "]");

        }


        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//div[@class='columnContent']"));
        int listSize = list.size();

        assertTrue(urunSecimSayisi == listSize);


    }
}