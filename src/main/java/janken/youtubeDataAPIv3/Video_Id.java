package janken.youtubeDataAPIv3;

public class Video_Id {

	private String kind;
	private String videoId;

	public String toString(String prefix) {
		return prefix + "{\n"
				+ prefix + "  \"kind\": \"" + kind + "\",\n"
				+ prefix + "  \"videoId\": \"" + videoId + "\"\n"
				+ prefix + "}\n";
	}

	public String getKind() {
		return kind;
	}

	public String getVideoId() {
		return videoId;
	}
}
