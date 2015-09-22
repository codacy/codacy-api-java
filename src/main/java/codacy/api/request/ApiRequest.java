package codacy.api.request;

import codacy.api.util.SSLHelper;
import org.apache.commons.io.IOUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ApiRequest {

    private String scheme = null;
    private String url = null;
    private int port = 80;


    public ApiRequest(final String scheme, final String url, final int port) {
        this.scheme = scheme;
        this.url = url;
        this.port = port;
    }

    public String request(final String requestType,
                          final String endpoint,
                          final HashMap<String, String> parameters)
            throws KeyStoreException, CertificateException, NoSuchAlgorithmException, KeyManagementException, IOException, URISyntaxException {

        HttpURLConnection conn = null;

        try {

            List<NameValuePair> nameValues = new ArrayList<NameValuePair>();
            for (String identifier : parameters.keySet()) {
                NameValuePair pair = new BasicNameValuePair(identifier, parameters.get(identifier));
                nameValues.add(pair);
            }

            URI uri = new URIBuilder()
                    .setScheme(this.scheme)
                    .setHost(this.url)
                    .setPort(this.port)
                    .setPath(endpoint)
                    .setParameters(nameValues)
                    .build();


            if (this.scheme.equals("https")) {
                HttpsURLConnection httpsConn = (HttpsURLConnection) uri.toURL().openConnection();
                httpsConn.setRequestMethod(requestType);
                httpsConn.setDoInput(true);
                httpsConn.setInstanceFollowRedirects(true);
                httpsConn.connect();
                conn = httpsConn;
            } else {
                HttpURLConnection httpConn = (HttpURLConnection) uri.toURL().openConnection();
                httpConn.setRequestMethod(requestType);
                httpConn.setDoInput(true);
                httpConn.setInstanceFollowRedirects(true);
                httpConn.connect();
                conn = httpConn;
            }

            StringWriter writer = new StringWriter();
            if(conn.getResponseCode() == 200) {
                IOUtils.copy(conn.getInputStream(), writer, "UTF-8");
            } else {
                IOUtils.copy(conn.getErrorStream(), writer, "UTF-8");
                throw new IOException(writer.toString());
            }

            return writer.toString();

        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
}
