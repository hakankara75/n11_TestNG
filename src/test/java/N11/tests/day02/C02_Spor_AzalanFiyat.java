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
/*
 "https://www.n11.com/" adresine git
giris yap
spor menusu ustune git
spor ayakkabi tikla
akilli siralama menusunu ac
artan fiyat menusunu sec
fiyat bilgilerini al. Fiyatlarin arttigini dogrula

 */
public class C02_Spor_AzalanFiyat {
    @Test
    public void testName() {
        // "https://www.n11.com/" adresine git
        ReusableMethods.extentReport();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        N11_Spor n11Spor = new N11_Spor();
        N11_Login n11Login = new N11_Login();
        Driver.getDriver().get(ConfigReader.getProperty("N11Url"));
        ReusableMethods.uyarilariKapat();
        ReusableMethods.extentTestInfo("\"https://www.n11.com/\" adresine gidildi");

        //giris yap
        ReusableMethods.girisYap();
        ReusableMethods.bekle(2);
        n11Login.dahaSonra.click();
        ReusableMethods.extentTestInfo("giriş yapildi");

        //spor menusu ustune git
        try {
            ReusableMethods.moveToElement(n11Spor.spor);
            ReusableMethods.bekle(2);
        } catch (Exception e) {

        }
        ReusableMethods.extentTestInfo("spor menusu ustune gidildi");


        //spor ayakkabi tikla
        ReusableMethods.bekle(2);
        n11Spor.sporAyakkabi.click();
        ReusableMethods.bekle(2);
        ReusableMethods.extentTestInfo("spor ayakkabi tiklandi");

        //akilli siralama menusunu ac
        n11Spor.akilliSiralama.click();
        ReusableMethods.extentTestInfo("akilli siralama menusunu acildi");

        //artan fiyat menusunu sec
        n11Spor.artanFiyat.click();
        ReusableMethods.extentTestInfo("artan fiyat menusunu secildi");

        //fiyat bilgilerini al. Fiyatlarin arttigini dogrula
        List<WebElement> fiyatlar = Driver.getDriver().findElements(By.xpath("//div[@class='priceContainer ']"));
        double first = 0.0;
        double sec = 0.0;
        int sayac=0;
        System.out.println("liste elemanlari:" + fiyatlar.size());
        for (WebElement f : fiyatlar) {
if (sayac==6){
    break;
}
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
            sayac++;
            sec = first;
        }

        ReusableMethods.extentTestInfo("fiyat bilgileri alindi. Fiyatlarin arttigin dogrulandi");
        ReusableMethods.extentTestInfo("sayfa kapatildi");
        ReusableMethods.extentRaporBitir();
        Driver.closeDriver();

    }
}
