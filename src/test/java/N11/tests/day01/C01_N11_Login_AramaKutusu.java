package N11.tests.day01;

import N11.pages.N11_Login;

import N11.utilities.ConfigReader;
import N11.utilities.Driver;
import N11.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class C01_N11_Login_AramaKutusu {

    /*
    "https://www.n11.com/" adresine git
    giris yap
    arama kutusuna "fındık kreması" kelimesi girip aratin
    listelenen urunlerde "Fındık Kreması" oldugunu dogrula

     */
    @Test
    public void loginTest() {
        N11_Login n11 = new N11_Login();
        // "https://www.n11.com/" adresine git
        Driver.getDriver().get(ConfigReader.getProperty("N11Url"));

        //giris yap
        ReusableMethods.girisYap();

        //arama kutusuna "fındık kreması" kelimesi girip aratin

        n11.aramaKutusu.sendKeys("Fındık Kreması", Keys.ENTER);
        ReusableMethods.bekle(2);

        //listelenen urunlerde "Fındık Kreması" oldugunu dogrula
        ReusableMethods.scrollToElement("//label[@class='feed-question']");
        ReusableMethods.bekle(5);
        ReusableMethods.scrollTopByJavaScript();
        List<WebElement> findikKremasi = Driver.getDriver().findElements(By.xpath("//h3[@class='productName']"));
        int listSize = findikKremasi.size();
        int sayac=1;
       do {
                         ReusableMethods.bekle(2);
               ReusableMethods.scrollToElement("(//a[@class='plink'])[" + sayac + "]");
               if (sayac>140){
                   ReusableMethods.bekle(7);
                   ReusableMethods.scrollToElement("(//a[@class='plink'])[" + sayac + "]");
               }
           sayac++;
       }while (sayac<listSize);


        ReusableMethods.bekle(3);

        for (WebElement find : findikKremasi) {
            System.out.println(find.getText());
            assertTrue(find.getText().contains("Fındık")|| find.getText().contains("FINDIK")&&
                    find.getText().contains("Kreması") || find.getText().contains("KREMASI"));
        }

    }
}
