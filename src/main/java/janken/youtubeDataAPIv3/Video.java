package janken.youtubeDataAPIv3;

public class Video {

	private String kind;
	private String etag;
	private Video_Id id;
	private Video_Snippet snippet;

	public String toString(String prefix) {
		return prefix + "{\n"
				+ prefix + "  \"kind\": \"" + kind + "\",\n"
				+ prefix + "  \"etag\": \"" + etag + "\",\n"
				+ prefix + "  \"id\": \n"
				+ id.toString(prefix + "  ")
				+ prefix + "  \"snippet\": \n"
				+ snippet.toString(prefix + "  ")
				+ prefix + "}\n";
	}

	public String getKind() {
		return kind;
	}

	public String getEtag() {
		return etag;
	}

	public Video_Id getId() {
		return id;
	}

	public Video_Snippet getSnippet() {
		return snippet;
	}
}
