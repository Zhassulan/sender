package kz.ugs.webpush.sender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class App 
{
    public static void main( String[] args )  
    {
    	String key = "AAAAziPorYQ:APA91bF7cG2OpliRZK9tiua-j2ziaJohyxKamabj-o1Bu-VPaLfg-XOO6dFitGc-Ivaaal4CNuQD10W9XYWs9UU-8mW9tGgADn5cuetf5MOvdRvOqIoH5CMEp8y87PTw2vB44C3kccRh";
    	String token = "fS_17t7lZNw:APA91bEcSN7rH-gWAO375e39uO90C1hYKkaF7a9BqqLEMvWiwwliy4deRW6OvNmVNTIr-_4XogFunYQU1Sxg6M7z_7begXIl_H__BugVwwFjk8Y61fDd3EokrcNbyYvV7XlIH-haa_7E";
    	String url = "https://e-smart.ugs.kz:8444/serviceworker/?token=fWc9hTafwks:APA91bH0YxgkLSNdBKpzgPhQ5rixuLxnGX2ck1igfMjS1wHsEXiS9pzYWkT7IQVWEvNumKNjMRLr9gw0N_j3ZKuIKLy3Os8wJSAw-uY-SKwNLwueKFLym5_-RbmRQSCHxgdlTyIzQhmT";
    	
    	Sender sender = new Sender(key, token, "115");
    }
}
