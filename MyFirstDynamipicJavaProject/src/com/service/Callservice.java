package com.service;

import java.io.BufferedReader;
//import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
import java.net.URL;

public class Callservice {

	public static String callMethod(String call, String serverUrl, String jsonobject) {

		StringBuilder sb = new StringBuilder();

		String http = serverUrl;

		HttpURLConnection urlConnection = null;
		try {
			URL url = new URL(http);
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setDoOutput(true);
			urlConnection.setRequestMethod(call);
			urlConnection.setRequestProperty("Content-Type", "application/json");
			urlConnection.connect();

			if (call.equalsIgnoreCase("POST")) {
				// You Can also Create JSONObject here
				OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
				out.write(jsonobject);// here i sent the parameter
				out.close();
			}

			int HttpResult = urlConnection.getResponseCode();
			if (HttpResult == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "ISO-8859-1"));
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line + "\n");
				}
				br.close();

				return sb.toString();
			} else {
			//System.out.println(Connection.getResponseMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}
		return null;
	}

}
