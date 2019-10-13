package com.qa.restClient;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class RestClient {
				
	public void get(String url) throws ClientProtocolException, IOException, JSONException {
		CloseableHttpClient httpClient= HttpClients.createDefault();
		HttpGet httpGet=new HttpGet(url);
		CloseableHttpResponse closeablehttpresponse=httpClient.execute(httpGet);
		int statusCode=closeablehttpresponse.getStatusLine().getStatusCode();
		System.out.println("Status Code is-----> "+statusCode);
		
		String response=EntityUtils.toString(closeablehttpresponse.getEntity(),"UTF-8");
		
		JSONObject json=new JSONObject(response);
		System.out.println("Response is------> "+json);
		
		Header[] headerArrays=closeablehttpresponse.getAllHeaders();
		HashMap<String,String> allHeader=new HashMap();
		for(Header h:headerArrays) {
			allHeader.put(h.getName(), h.getValue());
		}
		System.out.println("Headers are----> "+allHeader);
	}
}
