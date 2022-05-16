package janken.youtubeDataAPIv3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import janken.Main;

public class YoutubeDataAPI {

	private String api_key;
	private String endPointURL = "https://www.googleapis.com/youtube/v3";

	public YoutubeDataAPI(String api_key) {
		this.api_key = api_key;
	}

	public Search_ResponseData search(String q) {
		/**
		 * q 検索欄に入れる文字列と同じようなもの
		 */
		HttpURLConnection connection = null;
		Search_ResponseData responseData = null;
		Search_RequestParameter params = new Search_RequestParameter("snippet");
		try {
			Gson gson = new GsonBuilder().serializeNulls().create();

			params.setQ(q);
			params.setMaxResults(2);
			params.setType("video");

			String key = "?key=" + api_key;
			if (Main.DEBUG) {
				System.out.println("youtubeDataAPIのURL--------------");
				System.out.println(endPointURL + "/search" + key + params.makeURL());
				System.out.println("検索クエリ： " + q);
			}

			URL url = new URL(endPointURL + "/search" + key + params.makeURL());
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoInput(true);

			connection.connect();

			String result = "";

			InputStream inputStream = connection.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			String tmp = "";

			while ((tmp = in.readLine()) != null) {
				result += tmp;
			}
			in.close();

			responseData = gson.fromJson(result, Search_ResponseData.class);
		} catch (Exception e) {
			responseData = null;
			if (Main.DEBUG) {
				System.out.println("youtubeDataAPIのsearchで何かしらの問題が起きました。");
				e.printStackTrace();
			}
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}

		return responseData;
	}
}
