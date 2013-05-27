import net.sf.sahi.client.Browser;
import net.sf.sahi.config.Configuration;

public class QQRegisterTest {
    public static void main(String[] args) {
        //String sahiBase = "C:\\Users\\Administrator\\sahi"; // where Sahi is installed or unzipped
        //String userDataDirectory = "C:\\Users\\Administrator\\sahi\\userdata"; //path to the userdata directory
        String sahiBase = "/home/jackie/sahi"; // where Sahi is installed or unzipped
        String userDataDirectory = "/home/jackie/sahi/userdata"; //path to the userdata directory

        Configuration.initJava(sahiBase, userDataDirectory);
        // Sets up configuration for proxy. Sets Controller to java mode.
        String QQnumber;
        String browserType = "chrome";

        // You can specify the browser you want to run the tests on.
        // browserType can take any value defined in
        // sahi/userdata/config/browser_types.xml

        // Create a browser and open it
        Browser browser = new Browser(browserType);

        browser.open();

        browser.navigateTo("http://zc.qq.com/");
        browser.link("nav_1").click();
        String name = "testname";
        browser.textbox("nick").setValue(name);
        browser.password("password").setValue("I5youyouyou");
        browser.password("pass_again").setValue("I5youyouyou");
        browser.link("Male").click();



        browser.navigateTo("http://zc.qq.com");
        browser.span("QQ Account").click();
        browser.link("Male").click();
        browser.textbox("year_value").setValue("1980");
        browser.textbox("month_value").setValue("1");
        browser.textbox("day_value").setValue("1");
        browser.textbox("province_value").setValue("Beijing");
        browser.textbox("city_value").setValue("Dongcheng");

        browser.textbox("code").setValue("123");

        browser.submit(0).click();

        QQnumber = browser.popup("_blank").span("defaultUin").getValue();
        System.out.println(QQnumber);
        browser.close();
    }
}