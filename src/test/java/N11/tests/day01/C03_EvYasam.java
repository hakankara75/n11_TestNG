package N11.tests.day01;

import N11.pages.N11_Login;
import N11.pages.N11_EvYasam;
import N11.utilities.ConfigReader;
import N11.utilities.Driver;
import N11.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class C03_EvYasam {
    @Test
    public void testName() {

        // "https://www.n11.com/" adresine git
        Driver.getDriver().get(ConfigReader.getProperty("N11Url"));

        ReusableMethods.uyarilariKapat();

        //ev/yasam menusu ustune git
        N11_EvYasam n11EvYasam = new N11_EvYasam();
        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.threadSleep(2);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement menu = Driver.getDriver().findElement(By.xpath("(//a[@href='https://www.n11.com/ev-yasam'])[1]"));
        js.executeScript("arguments[0].scrollIntoView(true);", menu);

        //supermarket tikla
        n11EvYasam.supermarket.click();



















    }
}