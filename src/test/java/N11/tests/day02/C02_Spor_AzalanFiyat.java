package N11.tests.day02;

import N11.pages.N11_Login;
import N11.pages.N11_Spor;
import N11.utilities.ConfigReader;
import N11.utilities.Driver;
import N11.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class C02_Spor_AzalanFiyat {
    @Test
    public void testName() {
        // "https://www.n11.com/" adresine git
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        N11_Spor n11Spor = new N11_Spor();
        N11_Login n11Login = new N11_Login();

        Driver.getDriver().get(ConfigReader.getProperty("N11Url"));
        ReusableMethods.uyarilariKapat();

        //giris yap
        ReusableMethods.girisYap();
        ReusableMethods.bekle(2);
        n11Login.dahaSonra.click();


        //spor menusu ustune git
        try {
            ReusableMethods.moveToElement(n11Spor.spor);
            ReusableMethods.bekle(2);
        } catch (Exception e) {

        }
//        WebElement marka = (WebElement) js.executeScript("return document.querySelector(/'#header > nav > ul > li:nth-child(7) > a/')");
//        ReusableMethods.scrollToElementWithWebElement(marka);

        //spor ayakkabi tikla
        ReusableMethods.bekle(2);
        n11Spor.sporAyakkabi.click();
        ReusableMethods.bekle(2);

        //akilli siralama menusunu ac
        n11Spor.akilliSiralama.click();

        //artan fiyat menusunu sec
        n11Spor.artanFiyat.click();

        //fiyat bilgilerini al. Fiyatlarin arttigini dogrula
        List<WebElement> fiyatlar = Driver.getDriver().findElements(By.xpath("//div[@class='priceContainer ']"));
        double first = 0.0;
        double sec = 0.0;
        int sayac=0;
        System.out.println("liste elemanlari:" + fiyatlar.size());
        for (WebElement f : fiyatlar) {

            try {  ReusableMethods.scrollToElementWithWebElement(f);
                String fText = f.getText().replaceAll("TL", "").replaceAll(" ", "").replaceAll(",", "").replaceAll("\\.", "");
                first = fText.isEmpty() ? 0 : Double.parseDouble(fText);
            } catch (Exception e) {

            }
            System.out.println(first);
            if (first == sec) {
                continue;
            }
            try {
                assertTrue(first > sec);
            } catch (Exception e) {

            }
            sec = first;
        }


        Driver.closeDriver();
    }
}
