package N11.tests.day02;

import N11.pages.N11_Mucevher;
import N11.utilities.ConfigReader;
import N11.utilities.Driver;
import N11.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.IRetryAnalyzer;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class C01_Mucevher_AzalanFiyat<retryAnalyzer> {
    /*
        "https://www.n11.com/" adresine git
        giris yap
        mucevher menusu ustune git
        gozluk menusune tikla
        akilli siralama menusunu ac
        azalan fiyati sec
        fiyat bilgilerini al. Fiyatlarin azaldigini dogrula/*

         */
    @Test(retryAnalyzer = N11.utilities.Listeners.class)
    public void testName(){

        // "https://www.n11.com/" adresine git
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        N11_Mucevher n11_Mucevher = new N11_Mucevher();

        Driver.getDriver().get(ConfigReader.getProperty("N11Url"));
        ReusableMethods.uyarilariKapat();

        //giris yap
        ReusableMethods.girisYap();
        ReusableMethods.bekle(2);

        //mucevher menusu ustune git
        ReusableMethods.moveToElement(n11_Mucevher.mucevher);

        //gozluk menusune tikla
        n11_Mucevher.gozluk.click();

        //akilli siralama menusunu ac
        n11_Mucevher.akilliSiralama.click();

        //azalan fiyati sec
        n11_Mucevher.azalanFiyat.click();

        //fiyat bilgilerini al. Fiyatlarin azaldigini dogrula
        List<WebElement> fiyatlar = Driver.getDriver().findElements(By.xpath("//div[@class='priceContainer ']"));
        double first = 0;
        double sec = 111111111;
        System.out.println("liste elemanlari:" + fiyatlar.size());
        for (WebElement f : fiyatlar) {
            try {
                String fText = f.getText().replaceAll("TL", "").replaceAll(" ", "").replaceAll(",", "").replaceAll("\\.", "");

                first = fText.isEmpty() ? 0 : Double.parseDouble(fText);
            } catch (Exception e) {

            }
            System.out.println(first);
            if (first == sec) {
                continue;
            }
            assertTrue(first < sec);
            sec=first;
        }

        Driver.closeDriver();
    }
}
