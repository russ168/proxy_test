import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-5-16
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
public class JsonParseTest {

    public static void main(String[] args) throws Exception{
            // read file by line
        File file = new File("/home/jackie/items.j1");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            while ((tempString = reader.readLine()) != null) {
                System.out.println("line " + line + ": " + tempString);
                line++;
                //parse line as json object
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, Map<String, Object>> maps = objectMapper.readValue(tempString, Map.class);
                Set<String> key = maps.keySet();
                Iterator<String> iter = key.iterator();
                while (iter.hasNext()) {
                    String field = iter.next();
                    System.out.println(field + ":" + maps.get(field));
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }



    }

}
