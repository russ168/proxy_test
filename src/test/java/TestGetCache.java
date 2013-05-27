import net.sf.sahi.client.Browser;
import net.sf.sahi.config.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-5-18
 * Time: 下午1:41
 * To change this template use File | Settings | File Templates.
 */
public class TestGetCache {
    public static void main (String[] args) {
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

        browser.navigateTo("about:cache");
        browser.domain("about:cache");
        browser.close();

    }
}
