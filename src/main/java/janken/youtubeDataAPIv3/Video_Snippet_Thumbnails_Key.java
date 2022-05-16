package janken.youtubeDataAPIv3;

public class Video_Snippet_Thumbnails_Key {

	private String url;
	private Integer width;
	private Integer height;

	public String toString(String prefix) {
		return prefix + "{\n"
				+ prefix + "  \"url\": \"" + url + "\",\n"
				+ prefix + "  \"width\": \"" + width + "\",\n"
				+ prefix + "  \"height\": \"" + height + "\"\n"
				+ prefix + "}\n";
	}

	public String getUrl() {
		return url;
	}

	public Integer getWidth() {
		return width;
	}

	public Integer getHeight() {
		return height;
	}
}
