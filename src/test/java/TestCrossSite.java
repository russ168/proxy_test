import net.sf.sahi.client.Browser;
import net.sf.sahi.config.Configuration;

public class TestCrossSite {
    public static void main(String[] args) {
        String sahiBase = "C:\\Users\\Administrator\\sahi"; // where Sahi is installed or unzipped
        String userDataDirectory = "C:\\Users\\Administrator\\sahi\\userdata"; //path to the userdata directory
        Configuration.initJava(sahiBase, userDataDirectory);
        // Sets up configuration for proxy. Sets Controller to java mode.



        String browserType = "chrome";

        // You can specify the browser you want to run the tests on.
        // browserType can take any value defined in
        // sahi/userdata/config/browser_types.xml

        // Create a browser and open it
        Browser browser = new Browser(browserType);
        browser.open();

        /*
        browser.navigateTo("http://192.168.1.101:8001/static/register.html");
        browser.textbox("name").setValue("aa");
        browser.submit("Resgister").click();
        */

        browser.navigateTo("http://www.baidu.com");
        browser.textbox("wd").setValue("sahi");
        browser.submit("百度一下").click();
        browser.waitFor(1000);
        browser.link("Sahi Web Test Automation Tool").click();
        browser.waitFor(1000);

        browser.domain("http://sahi.co.in/").link("ABOUT").click();

        //browser.popup("_blank").link("BLOG").click();
        //browser.popup("_blank").close();
        browser.waitFor(2000);
        browser.domain("http://sahi.co.in/").close();
        /*
        browser.navigateTo("http://www.google.com");
        browser.textbox("q").setValue("sahi forums");
        browser.submit("Google Search").click();
        browser.waitFor(1000);
        browser.link("Forums – Sahi – Web Automation and Test Tool").click();
        browser.link("Login").click();
        System.out.println(":: browser.textbox(\"req_username\").exists() = "
        + browser.textbox("req_username").exists());
        */

        // close the browser
        browser.close();
    }
}