package codacy.api.util;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Collection;

public class SSLHelper {

    private static SSLSocketFactory factory = null;

    public static SSLSocketFactory getSSLFactory() throws KeyStoreException, CertificateException, NoSuchAlgorithmException, KeyManagementException, IOException, URISyntaxException {
        if(factory == null) {
            factory = createSSLFactory();
        }
        return factory;
    }

    private static SSLSocketFactory createSSLFactory() throws KeyStoreException, CertificateException, NoSuchAlgorithmException, KeyManagementException, IOException, URISyntaxException {
        ClassLoader classLoader = SSLHelper.class.getClassLoader();
        final CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        final Collection<? extends Certificate> certs = certFactory.generateCertificates(classLoader.getResourceAsStream("startssl.pem"));

        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, null);
        certs.iterator().forEachRemaining(cert -> {
            try {
                keyStore.setCertificateEntry(java.util.UUID.randomUUID().toString(), cert);
            } catch (KeyStoreException e) {
                e.printStackTrace();
            }
        });

        TrustManagerFactory tmf =
                TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(keyStore);

        TrustManager[] trustManager = tmf.getTrustManagers();

        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, trustManager, new java.security.SecureRandom());

        return context.getSocketFactory();
    }
}
