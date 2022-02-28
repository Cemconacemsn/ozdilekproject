import com.thoughtworks.gauge.Logger;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

public class BasePage extends BaseTest {

    @Step("<wait> saniye kadar bekle")
    public void waitMethods(int wait) throws InterruptedException {
        Thread.sleep(1000 * wait);
    }

    @Step("<id> li uygulama kontrolü")
    public void controlMethods(String id) {
        String checkText = appiumDriver.findElement(By.id(id)).getText();
        Assert.assertEquals("ALIŞVERİŞE BAŞLA", checkText);
    }

    @Step("<id> li uygulama giriş sayfası kontrolü")
    public void startControlMethods(String id) {
        String checkText = appiumDriver.findElement(By.id(id)).getText();
        Logger.info("Anasayfa açıldı");
    }


    @Step("<asagıya kaydır>")
    public void swipeDownMethods(String kaydır) {
        TouchAction ts = new TouchAction(appiumDriver);
        ts.press(PointOption.point(530, 1900)).moveTo(PointOption.point(530, 400)).release().perform();
        Logger.info("Aşağıya kaydırıldı");

    }

    @Step("<Rasgele bir ürün seç> rastgele ürün secildi")
    public void selectRandomMethods(String rastgele) {
        Random random = new Random();
        List<MobileElement> product = appiumDriver.findElements(By.xpath(rastgele));
        System.out.println("pd" + product);
        MobileElement element = product.get(random.nextInt(product.size()));
        System.out.println("element" + element);
        element.click();
    }

    @Step("id <id> li elemente tıkla")
    public void clickByid(String id) {
        appiumDriver.findElement(By.id(id)).click();
        System.out.println(id + "elementine tıklandı");

    }

    @Step("xpath <xpath> li elemente tıkla")
    public void clickXpath(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();

    }
    @Step("<id> İd'li elemente <text> değerini yaz")
    public void yaz(String id,String text){
        appiumDriver.findElement(By.id(id)).sendKeys(text);
        System.out.println(id + "elementini bul ve " + text + " değerini yaz"  );
        Logger.info("Kullanıcı adı ve şifre yazıldı.");
    }
}
