import com.mongodb.*;
import net.sf.sahi.client.Browser;
import net.sf.sahi.config.Configuration;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;

public class SahiDriverDemo {

    public static void main(String[] args) throws Exception {
        //String sahiBase = "C:\\Users\\Administrator\\sahi"; // where Sahi is installed or unzipped
        //String userDataDirectory = "C:\\Users\\Administrator\\sahi\\userdata"; //path to the userdata directory

        String sahiBase = "/home/jackie/sahi"; // where Sahi is installed or unzipped
        String userDataDirectory = "/home/jackie/sahi/userdata"; //path to the userdata directory

        Configuration.initJava(sahiBase, userDataDirectory);
        // Sets up configuration for proxy. Sets Controller to java mode.

        String browserType = "chrome";

        // You can specify the browser you want to run the tests on.
        // browserType can take any value defined in
        // sahi/userdata/config/browser_types.xml

        // Create a browser and open it
        Browser browser = new Browser(browserType);
        browser.open();

        browser.navigateTo("http://localhost:8001/static/register.html");
        browser.textbox("name").setValue("aa");
        String img = browser.image("captcha.jpg").getAttribute("src");
        System.out.println("image address is:" + img);

        //String code = parseCode("http://localhost:8001/ocr/parse", img);
        //browser.textbox("code").setValue(code);

        browser.submit(0).click();

        Browser browser2 =  browser.popup("_blank");
        String result = browser2.div(0).getValue();
        System.out.println("result is:" + result);

        browser2.close();
        browser.close();

    }

    private static void parseCode(String parseUrl, String imageUrl) throws Exception {
        HttpClient htttpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(parseUrl);

        MultipartEntity reqEntity = new MultipartEntity();
        httpPost.setEntity(reqEntity);


        FileBody bin = new FileBody(new File("temp"));
        reqEntity.addPart("Filedata", bin);

        System.out.println("executing: " + httpPost.getRequestLine());

        org.apache.http.HttpResponse response = htttpClient.execute(httpPost);
        HttpEntity responseEntity = response.getEntity();

        System.out.println("-----------------------------");
        System.out.println(response.getStatusLine());

        if(responseEntity != null) {
            //return inputStream2String(responseEntity.getContent());
        }

        htttpClient.getConnectionManager().shutdown();
    }

    private static String inputStream2String(InputStream in) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int i = -1;
        while ((i = in.read()) != -1) {
            baos.write(i);
        }
        return baos.toString();
    }
    /*
    private static HttpMethod getPostMethod(){
        PostMethod post = new PostMethod("/simcard.php");
        NameValuePair simcard = new NameValuePair("simcard","1330227");
        post.setRequestBody(new NameValuePair[] { simcard});
        return post;
    }
    */

    public String getImagePath(String imageUrl) {
        try {
            MongoClient  mongoClient = new MongoClient();
            DB db = mongoClient.getDB("test");
            DBCollection coll = db.getCollection("imgurls");
            BasicDBObject q = new BasicDBObject()
                    .append("url", imageUrl);
            DBCursor cursor = coll.find(q);
            if (cursor.hasNext()) {
                DBObject result = cursor.next();
                cursor.close();
                mongoClient.close();
                return result.get("imagePath").toString();
            } else {
                cursor.close();
                mongoClient.close();
                return "";
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return "";
        }

    }

}