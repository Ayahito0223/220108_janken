package janken.youtubeDataAPIv3;

import java.util.List;

public class Search_ResponseData {

	private String kind;
	private String etag;
	private String nextPageToken;
	private Search_PageInfo pageInfo;
	private List<Video> items;

	public String toString() {
		String videos = "";
		for(Video video: items) {
			videos += video.toString("    ");
		}

		return "{\n"
		+ "  \"kind\":\"" + kind + "\",\n"
		+ "  \"etag\": \"" + etag + "\",\n"
		+ "  \"nextPageToken\": \"" + nextPageToken + "\",\n"
		+ "  \"pageInfo\": \n"
		+ pageInfo.toString("  ")
		+ "  \"items\": [\n"
		+ videos
		+ "  ]\n"
		+ "}\n";
	}

	public String getKind() {
		return kind;
	}

	public String getEtag() {
		return etag;
	}

	public String getNextPageToken() {
		return nextPageToken;
	}

	public Search_PageInfo getPageInfo() {
		return pageInfo;
	}

	public List<Video> getItems() {
		return items;
	}
}
