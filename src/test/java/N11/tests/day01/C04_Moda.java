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

        ReusableMethods.pageDown();
        ReusableMethods.bekle(2);
        //Benetton markasini sec, secildigini test et
        WebElement benettonBul = null;
        int attempts = 0;
        while(attempts < 5) {
            try {
                benettonBul = (WebElement) js.executeScript("return document.querySelector('#contentListing > div > div.listingHolder > div.filterArea > section:nth-child(7) > div > div.filterList > div:nth-child(5) > a')");
                ReusableMethods.clickByJavaScript(benettonBul);
                assertTrue(benettonBul.isSelected());
                break;
            } catch(Exception e) {
            }
            attempts++;
        }

        //secilen urunlerin goruntulendigini dogrula
       WebElement list = (WebElement) js.executeScript("return document.querySelector(/'#listingUl/')");
                int listSize = Integer.parseInt(list.getText());
        attempts = 0;
        while(attempts > listSize) {
            try {

                break;
            } catch(Exception e) {
            }
            attempts++;
        }
        System.out.println("listSize"+listSize);
        WebElement sayi= Driver.getDriver().findElement(By.xpath("(//div[@class='columnContent'])["+listSize+"]"));
        assertTrue(sayi.isDisplayed());


    }


}