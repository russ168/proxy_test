import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-5-16
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
public class TestHttpPost {

    public static void main(String[] args) throws Exception{
        String url = "http://192.168.1.101:8001/ocr/parse";
        //String filePath = "about:cache:http://xxx/image.jpeg";
        String filePath = "C:\\22.log";

        HttpClient htttpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        MultipartEntity reqEntity = new MultipartEntity();
        httpPost.setEntity(reqEntity);

        FileBody bin = new FileBody(new File(filePath));
        reqEntity.addPart("Filedata", bin);

        StringBody userId = new StringBody("1");
        reqEntity.addPart("userId", userId);

        System.out.println("executing: " + httpPost.getRequestLine());

        org.apache.http.HttpResponse response = htttpClient.execute(httpPost);
        HttpEntity responseEntity = response.getEntity();

        System.out.println("-----------------------------");
        System.out.println(response.getStatusLine());

        if(responseEntity != null) {
            System.out.println("Response contenten is: " +  inputStream2String(responseEntity.getContent()));
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

}
