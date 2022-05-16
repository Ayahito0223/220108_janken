package janken.youtubeDataAPIv3;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map.Entry;

import janken.Main;


public class Search_RequestParameter {

	HashMap<String, String> params = new HashMap<>();

	public Search_RequestParameter(String part) {
		params.put("part", part);

		params.put("channelId", "");
		params.put("channelType", "");
		params.put("eventType", "");
		params.put("maxResults", "");
		params.put("order", "");
		params.put("q", "");
		params.put("type", "");
	}

	public String makeURL() {
		String result = "";
		try {
			for (Entry<String, String> entry : params.entrySet()) {
				if (entry.getValue().isEmpty()) {
					continue;
				}
				result += "&" + entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), "UTF-8");
			}
		} catch (Exception e) {
			if(Main.DEBUG) {
				e.printStackTrace();
			}
			System.out.println("YouTubeリクエスト用のURL作成時にエラーがおきました。");
		}
		return result;
	}

	public String getPart() {
		return params.get("part");
	}

	public void setPart(String part) {
		params.put("part", part);
	}

	public String getChannelId() {
		return params.get("channelId");
	}

	public void setChannelId(String channelId) {
		params.put("channelId", channelId);
	}

	public String getChannelType() {
		return params.get("channelType");
	}

	public void setChannelType(String channelType) {
		if (channelType.equals("any") || channelType.equals("show")) {
			params.put("channelId", channelType);
		} else {
			System.out.println("channelTypeは不適切な値です。");
		}
	}

	public String getEventType() {
		return params.get("eventType");
	}

	public void setEventType(String eventType) {
		if (eventType.equals("completed") || eventType.equals("live") || eventType.equals("upcoming")) {
			params.put("eventType", eventType);
		} else {
			System.out.println("eventTypeは不適切な値です。");
		}
	}

	public int getMaxResults() {
		return Integer.parseInt(params.get("maxResults"));
	}

	public void setMaxResults(int maxResults) {
		if (0 <= maxResults && maxResults <= 50) {
			params.put("maxResults", Integer.toString(maxResults));
		} else {
			System.out.println("maxResultsは不適切な値です。");
		}
	}

	public String getOrder() {
		return params.get("order");
	}

	public void setOrder(String order) {
		if (order.equals("date")) {
			params.put("order", "date");
		} else if (order.equals("rating")) {
			params.put("order", "rating");
		} else if (order.equals("title")) {
			params.put("order", "title");
		} else if (order.equals("relevance")) {
			params.put("order", "relevance");
		} else if (order.equals("videoCount")) {
			params.put("order", "videoCount");
		} else if (order.equals("viewCount")) {
			params.put("order", "viewCount");
		} else {
			System.out.println("orderは不適切な値です。");
		}
	}

	public String getQ() {
		return params.get("q");
	}

	public void setQ(String q) {
		params.put("q", q);
	}

	public String getType() {
		return params.get("type");
	}

	public void setType(String type) {
		if(type.equals("channel") || type.equals("playlist") || type.equals("video")) {
			params.put("type", type);
		} else {
			System.out.println("typeは不適切な値です。");
		}
	}
}
