package N11.tests.day01;

import N11.pages.N11;
import N11.pages.N11_Elektronik;
import N11.utilities.ConfigReader;
import N11.utilities.Driver;
import N11.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class C02 {

    @Test
    public void testName() {

        // "https://www.n11.com/" adresine git
        Driver.getDriver().get(ConfigReader.getProperty("N11Url"));

        N11 n11 = new N11();
        n11.tamam.click();
        ReusableMethods.bekle(4);
        n11.dahaSonra.click();
        ReusableMethods.bekle(2);

        //elektronik menusu ustune git

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        N11_Elektronik n11_elektronik = new N11_Elektronik();
        Actions actions = new Actions(Driver.getDriver());

        js.executeScript("arguments[0].scrollIntoView();", n11_elektronik.elektronik);
        actions.moveToElement(n11_elektronik.elektronik).perform();

        //telefon tikla
        ReusableMethods.bekle(2);
        n11_elektronik.telefonAksesuar.click();

        //samsung tikla
        n11_elektronik.samsung.click();

        //cikan arama sonucu al
        js = (JavascriptExecutor) Driver.getDriver();

        WebElement element = (WebElement) js.executeScript("return document.evaluate(\"//div[@class='resultText ']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;");
        String samsungSon=element.getText();
        String text=samsungSon.replaceAll("[\\D]", "");
        System.out.println("cikan arama sonucu"+text);

        //soldaki menude de "Samsung" checkboxinin secili oldugunu dogrula

         element = Driver.getDriver().findElement(By.xpath("(//a[@href='https://www.n11.com/telefon-ve-aksesuarlari?m=Samsung'])[2]"));
        js.executeScript("arguments[0].scrollIntoView();", element);

         js = (JavascriptExecutor) Driver.getDriver();

        Boolean isChecked = (Boolean) js.executeScript("return arguments[0].checked;", n11_elektronik.samsungCheckBox);
        assertTrue(isChecked);

        //secimi iptal et
         js = (JavascriptExecutor) Driver.getDriver();

         element = Driver.getDriver().findElement(By.xpath("//div[@data-iv='Samsung']"));
        js.executeScript("arguments[0].click();", element);

        //arama sonucunun degistigini dogrula
        String samsungSonucIptal=n11_elektronik.samsungSonuc.getText();
        String iptalText=samsungSonucIptal.replaceAll("[\\D]", "");
        System.out.println("son sonuc"+iptalText);
        assertFalse(samsungSonucIptal.equals(iptalText));





    }


}
