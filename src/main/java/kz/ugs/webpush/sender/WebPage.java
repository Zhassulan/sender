package kz.ugs.webpush.sender;

import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class WebPage {
	
	public WebPage(String url) throws ClientProtocolException, IOException	{
		 CloseableHttpClient httpclient = HttpClients.createDefault();
	        try {
	            HttpPost httppost = new HttpPost(url);

	            System.out.println("Executing request: " + httppost.getRequestLine());
	            CloseableHttpResponse response = httpclient.execute(httppost);
	            try {
	                System.out.println("----------------------------------------");
	                System.out.println(response.getStatusLine());
	                System.out.println(EntityUtils.toString(response.getEntity()));
	            } finally {
	                response.close();
	            }
	        } finally {
	            httpclient.close();
	        }
	}
	
}
