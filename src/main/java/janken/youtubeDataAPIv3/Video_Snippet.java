package janken.youtubeDataAPIv3;

public class Video_Snippet {

	private String publishedAt;
	private String channelId;
	private String title;
	private String description;
	private Video_Snippet_Thumbnails thumbnails;
	private String channelTitle;
	private String publishTime;

	public String toString(String prefix) {
		return prefix + "{\n"
				+ prefix + "  \"publishedAt\": \"" + publishedAt + "\",\n"
				+ prefix + "  \"channelId\": \"" + channelId + "\",\n"
				+ prefix + "  \"title\": \"" + title + "\",\n"
				+ prefix + "  \"description\": \"" + description + "\",\n"
				+ prefix + "  \"thumbnails\": "
				+ thumbnails.toString(prefix + "  ")
				+ prefix + "  \"channelTitle\": \"" + channelTitle + "\",\n"
				+ prefix + "  \"publishTime\": \"" + publishTime + "\"\n"
				+ prefix + "}\n";
	}

	public String getPublishedAt() {
		return publishedAt;
	}

	public String getChannelId() {
		return channelId;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Video_Snippet_Thumbnails getThumbnails() {
		return thumbnails;
	}

	public String getChannelTitle() {
		return channelTitle;
	}

	public String getPublishTime() {
		return publishTime;
	}
}
