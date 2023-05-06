package N11.utilities;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import javax.xml.transform.Result;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.ResultSet;

import static N11.utilities.ReusableMethods.tumSayfaScreenShoot;

public class Listeners implements ITestListener, IRetryAnalyzer, IAnnotationTransformer {

    public void onStart(ITestContext context) {
        System.out.println("onStart()== > tum testlerden once bir kez calisir. yani classtan once");

    }
    public void onFinish(ITestContext context) {
        System.out.println("onFinish()== > tum testlerden sonra bir kez calisir. yani classtan sonra");
    }
    public void onTestStart(ITestResult context) {
        System.out.println("onTestStart()== > herbir @Test'ten once bir kez calisir.");
    }
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess()== > sadece PASS olan @Test'lerden sonra calisir.");
    }
    public void onTestFailure(ITestResult result) { //fail durumunda yapilacak tum isler bu metot icine yazilir
        System.out.println("onTestFailure()== > sadece FAIL olan @Test'lerden sonra calisir.");
        tumSayfaScreenShoot();
    }
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped()== > sadece SKIP olan @Test'lerden sonra calisir.");

    }
    //bu metot ile fail durumunda 1 kez daha calisir
    private int retryCount=0;
    private static final int maxRetryCount=1; //fail sonrasi tekrar sayisi
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(retryCount<maxRetryCount){
            retryCount++;
            return true;
        }
        return false;
    }

    //retry metotunu xml dosyasi ile kullanmak icin bu metotu ITestAnnotation'dan override ettik
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        IAnnotationTransformer.super.transform(annotation, testClass, testConstructor, testMethod);
/*
    Bu methodun amacı; test notasyonlarını, sınıfları, cons.ları ve methodları transform(dönüştürme) etmemize
olanak sağlar
    Bu method sayesinde Listeners sınıfını .xml dosyasında kullanabileceğiz ve istediğimiz class'ları fail
olma durumunda listeners sınıfı retry methodunu kullanarak istediğimiz kadar tekrar çalıştırabileceğiz.
 */
        System.out.println(annotation);

    }
}
