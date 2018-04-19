package component.http;

import org.apache.http.HttpStatus;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * 类备注：http工具类
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-04-11 20:49
 * @desc
 * @since 1.8
 */
public class HttpUtils {

    /**
     * https 请求
     */
    public static byte[] post(String urlValue) throws Exception {

        URL url = new URL(urlValue);

        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestProperty("Accept", "text/xml,text/javascript,text/html");
        connection.setRequestProperty("User-Agent", "stargate");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        connection.setHostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {

                return true;
            }
        });

        // 连接
        connection.connect();

        OutputStream outputStream = connection.getOutputStream();

        InputStream inputStream = connection.getInputStream();

        // 返回值 200
        if (connection.getResponseCode() != HttpStatus.SC_OK) {

            return null;
        }

        return readBytes(inputStream);
    }

    public static byte[] readBytes(InputStream inputStream) throws Exception {

        byte[] bytes = new byte[1024];

        int len = 0;

        StringBuilder byteBuffer = new StringBuilder();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        while ((len = inputStream.read(bytes)) != -1) {

            stream.write(bytes, 0, len);

            byteBuffer.append(new String(bytes, "UTF-8"));
        }

        return byteBuffer.toString().getBytes();
    }
}
