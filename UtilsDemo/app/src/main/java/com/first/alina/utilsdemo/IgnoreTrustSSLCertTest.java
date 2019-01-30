package com.first.alina.utilsdemo;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;

/**
 * Created by alina on 2018/9/18.
 */

public class IgnoreTrustSSLCertTest {


    private void initOkHttp(){

        OkHttpClient.Builder okHttpClient=new OkHttpClient().newBuilder();
        okHttpClient.socketFactory(createSSLFacatory())
                .hostnameVerifier(new TrustAllHosetNameVerifier());

    }

    //信任https所有的证书
   private static class TrustAllCerts implements X509TrustManager{

        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private static SSLSocketFactory createSSLFacatory(){
        SSLSocketFactory sslSocketFactory=null;
        try {
            //获取sslContext实例 加入cert证书，格式与后台保持一致，目前知道的有TLS格式还有SSL格式
            SSLContext sslContext=SSLContext.getInstance("TLS");
            sslContext.init(null,new TrustManager[]{new TrustAllCerts()},new SecureRandom());
            sslSocketFactory=sslContext.getSocketFactory();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return sslSocketFactory;
    }


    private static class TrustAllHosetNameVerifier implements HostnameVerifier{

        //返回true 信任所有分主机名
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }
}
