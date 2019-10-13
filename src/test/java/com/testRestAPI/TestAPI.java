package com.testRestAPI;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.restClient.RestClient;

import RestAPI.WebAPI.Testbase;

public class TestAPI extends Testbase {
	Testbase testbase;
	String urll;
	String serviceUrll;
	String URI;
	RestClient rclient;
	@BeforeMethod
	public void setUp(){
		testbase=new Testbase();
		urll=prop.getProperty("url");
		serviceUrll=prop.getProperty("serviceUrl");
		URI=urll+serviceUrll;
		}
	@Test
	public void testGetMethod() throws ClientProtocolException, IOException, JSONException {
	rclient=new RestClient();
	rclient.get(URI);
	}
}
