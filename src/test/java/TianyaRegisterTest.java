import net.sf.sahi.client.Browser;
import net.sf.sahi.client.ElementStub;
import net.sf.sahi.config.Configuration;

public class TianyaRegisterTest {
    public static void main(String[] args) {
        String sahiBase = "C:\\Users\\Administrator\\sahi"; // where Sahi is installed or unzipped
        String userDataDirectory = "C:\\Users\\Administrator\\sahi\\userdata"; //path to the userdata directory
        Configuration.initJava(sahiBase, userDataDirectory);
        // Sets up configuration for proxy. Sets Controller to java mode.
        String name;
        String browserType = "chrome";

        // You can specify the browser you want to run the tests on.
        // browserType can take any value defined in
        // sahi/userdata/config/browser_types.xml

        // Create a browser and open it
        Browser browser = new Browser(browserType);

        browser.open();

        browser.navigateTo("http://passport.tianya.cn/register/default.jsp?sourceURL=http%3A%2F%2Fwww.tianya.cn&from=index&_goto=register");
        name = "testname";
        browser.textbox("userName").setValue(name);
        browser.textbox("userName").click();
        if(browser.exists(browser.image("wrong.gif"))) {
            browser.textbox("userName").setValue("newName");
        }
        browser.password("password").setValue("I5youyouyou");
        browser.password("password2").setValue("I5youyouyou");
        browser.textbox("email").setValue("xx");
        browser.textbox("vcode").setValue("123");
        browser.submit("cmdSubmit").click();
        String img = browser.image("vcodeImg").getAttribute("src");
        System.out.println(img);

        /*
        browser.navigateTo("http://zc.qq.com/");
        name = "testname";
        browser.textbox("nick").setValue(name);
        browser.password("password").setValue("I5youyouyou");
        browser.password("pass_again").setValue("I5youyouyou");
        browser.link("男").click();
        browser.listItem("1993年").click();
        browser.listItem("2月").click();
        browser.listItem("1日").click();
        browser.textbox("code").setValue("123");
        browser.submit("submit").click();
        */


        //browser.close();
    }
}