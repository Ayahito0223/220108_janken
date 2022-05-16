package janken.cotohaAPI;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import janken.Main;

public class CotohaAPI {

	private String client_id;
	private String client_secret;
	private String accessToken;
	private AccessTokenData accessTokenData;

	public CotohaAPI(String client_id, String client_secret) {
		this.client_id = client_id;
		this.client_secret = client_secret;

		getAccessToken();
	}

	private void getAccessToken() {
		HttpURLConnection connection = null;
		try {
			URL url = new URL("https://api.ce-cotoha.com/v1/oauth/accesstokens");
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");

			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			String json
			= "{"
					+ " \"grantType\": \"client_credentials\","
					+ " \"clientId\": \"" + client_id + "\","
					+ " \"clientSecret\": \"" + client_secret + "\""
					+ "}";
			out.write(json);
			out.flush();
			connection.connect();

			String result = "";

			InputStream inputStream = connection.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			String tmp = "";

			while ((tmp = in.readLine()) != null) {
				result += tmp;
			}
			in.close();

			Gson gson = new GsonBuilder().serializeNulls().create();
			accessTokenData = gson.fromJson(result, AccessTokenData.class);
			if(Main.DEBUG) {
				System.out.println("アクセストークン取得の結果");
				System.out.println(accessTokenData);
			}
			accessToken = accessTokenData.getAccess_token();
		} catch (Exception e) {
			accessTokenData = null;
			accessToken = null;
			System.out.println("getAccessTokenで何かしらの問題が起きましたので、\naccessTokenを取得出来ませんでした。");
			if (Main.DEBUG) {
				e.printStackTrace();
			}
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	public SentimentData doSentiment(String text) {
		if (accessToken == null) {
			System.out.println("accessTokenがありません。");
			return null;
		}

		HttpURLConnection connection = null;
		SentimentData sentimentData = null;
		try {
			Gson gson = new GsonBuilder().serializeNulls().create();

			URL url = new URL("https://api.ce-cotoha.com/api/dev/nlp/v1/sentiment");
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestProperty("Authorization", "Bearer " + this.accessToken);
			connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");

			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			String json
			= "{"
					+ " \"sentence\": \"" + text + "\""
					+ "}";
			out.write(json);
			out.flush();
			connection.connect();

			String result = "";

			InputStream inputStream = connection.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			String tmp = "";

			while ((tmp = in.readLine()) != null) {
				result += tmp;
			}
			in.close();

			sentimentData = gson.fromJson(result, SentimentData.class);
		} catch (Exception e) {
			sentimentData = null;
			if (Main.DEBUG) {
				System.out.println("doSentimentで何かしらの問題が起きました。");
				e.printStackTrace();
			}
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}

		return sentimentData;
	}
}
