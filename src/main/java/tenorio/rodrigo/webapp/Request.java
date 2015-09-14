package tenorio.rodrigo.webapp;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class Request {

    public static void main(final String[] args) throws Exception {
        final CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        final HttpPost httpPost = new HttpPost("http://www.kartodromogranjaviana.com.br/live_timing/livetiming.php");
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
        // httpPost.addHeader("Accept-Language", "en-US,en;q=0.8,he;q=0.6");
        // httpPost.addHeader("Origin",
        // "http://www.kartodromogranjaviana.com.br");
        // httpPost.addHeader("Referer",
        // "http://www.kartodromogranjaviana.com.br/live_timing/livetiming.php");

        final ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("xajax", "InsertData"));
        params.add(new BasicNameValuePair("xajaxr", Long.toString(new Date().getTime())));
        final UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params);
        httpPost.setEntity(formEntity);

        System.out.println(httpPost);
        final CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpPost);
        final InputStream content = closeableHttpResponse.getEntity().getContent();
        byte b;
        while ((b = (byte) content.read()) != -1) {
            System.out.print((char) b);
        }

        // DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        // dbf.setValidating(true);
        // dbf.setIgnoringElementContentWhitespace(true);
        // DocumentBuilder db = dbf.newDocumentBuilder();
        // Document document = db.parse(content);
    }
}
