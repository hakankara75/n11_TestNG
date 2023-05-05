package N11.tests.day01;

import N11.pages.N11_Moda;
import N11.utilities.ConfigReader;
import N11.utilities.Driver;
import N11.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class C04_Moda {
    /*
       "https://www.n11.com/" adresine git
        giris yap
     */
    @Test
    public void testName() {

        // "https://www.n11.com/" adresine git
        Driver.getDriver().get(ConfigReader.getProperty("N11Url"));
        N11_Moda n11Moda = new N11_Moda();

        ReusableMethods.uyarilariKapat();

        //giris yap
        ReusableMethods.girisYap();
        ReusableMethods.bekle(2);

        //moda menusu ustune git
        ReusableMethods.moveToElement(Driver.getDriver().findElement(By.xpath("(//a[@href='https://www.n11.com/giyim-ayakkabi'])[1]")));
        ReusableMethods.bekle(2);

        //ayakkabi/canta menusune tikla
        ReusableMethods.clickByJavaScript(Driver.getDriver().findElement(By.xpath("//a[@title='Ayakkabı & Çanta']//img")));


    }
}