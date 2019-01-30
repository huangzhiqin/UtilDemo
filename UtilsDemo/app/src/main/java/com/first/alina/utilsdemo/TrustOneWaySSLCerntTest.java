package com.first.alina.utilsdemo;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

/**
 * Created by alina on 2018/9/18.
 * 单向验证https
 */

public class TrustOneWaySSLCerntTest {


    private int certPath=0;//R.raw.test

    //https单向验证  注意Okhttp设置hostnameVerifier信任
    private SSLSocketFactory setCertificates(Context context) {

        InputStream inputStream=context.getResources().openRawResource(0);//R.raw.test
        CertificateFactory certificateFactory;
        SSLContext sslContext=null;
        try {
            certificateFactory = CertificateFactory.getInstance("X.509");
            Certificate certificate=certificateFactory.generateCertificate(inputStream);
            KeyStore keyStore=KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null,null);
            keyStore.setCertificateEntry("ca",certificate);
            TrustManagerFactory trustManagerFactory=TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            sslContext=SSLContext.getInstance("SSL");
            sslContext.init(null,trustManagerFactory.getTrustManagers(),null);
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sslContext.getSocketFactory();


    }
}
