package janken.youtubeDataAPIv3;

public class Video_Snippet_Thumbnails {

	private Video_Snippet_Thumbnails_Key medium;
	private Video_Snippet_Thumbnails_Key high;

	public String toString(String prefix) {
		return prefix + "{\n"
				+ prefix + "  \"medium\": \n"
				+ medium.toString(prefix + "  ")
				+ prefix + "  \"high\": \n"
				+ high.toString(prefix + "  ")
				+ prefix + "}\n";
	}

	public Video_Snippet_Thumbnails_Key getMedium() {
		return medium;
	}

	public Video_Snippet_Thumbnails_Key getHigh() {
		return high;
	}
}
