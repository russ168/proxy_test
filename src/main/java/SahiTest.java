import java.io.IOException;
import java.util.HashMap;
import net.sf.sahi.test.TestRunner;
/**
 * Launch a Sahi script or suite.
 *
 */
public class SahiTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        final String suiteName = "C:\\Users\\Administrator\\sahiTest\\src\\main\\java\\test.sah";
        //final String suiteName = "test.sah";
        final String browserType = "ie";
        String base = "http://192.168.1.101:8001/static/register.html";
        String threads = "1";
        TestRunner testRunner =
                new TestRunner(suiteName, browserType, base, threads);
        HashMap<String, Object> variableHashMap = new HashMap<String, Object>();
        variableHashMap.put("$user", "test");
        //variableHashMap.put("$pwd", "secret");
        testRunner.setInitJS(variableHashMap);
        String status = testRunner.execute();
        System.out.println(status);
    }
}