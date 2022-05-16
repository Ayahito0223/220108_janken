package janken.youtubeDataAPIv3;

public class Search_PageInfo {
	private Integer totalResults;
	private Integer resultsPerPage;

	public Integer getTotalResults() {
		return totalResults;
	}

	public Integer getResultsPerPage() {
		return resultsPerPage;
	}

	public String toString(String prefix){
		return prefix + "{\n"
				+ prefix + "  \"totalResults\": \"" + totalResults + "\",\n"
				+ prefix + "  \"resultsPerPage\": \"" + resultsPerPage + "\"\n"
				+ prefix + "}\n";
	}

}
