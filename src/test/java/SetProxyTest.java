import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-5-16
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
public class SetProxyTest {

    public static void main(String[] args) throws Exception{
            Properties systemProperties = System.getProperties();
            Boolean isHttpProxyEnabled = true;
        if (isHttpProxyEnabled) {
                systemProperties.setProperty("http.proxyHost", "127.0.0.1");
                systemProperties.setProperty("http.proxyPort", "" + 8080);
                //systemProperties.setProperty("http.nonProxyHosts", "" + getHttpNonProxyHosts());
            }

    }

}
