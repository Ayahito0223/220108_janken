package janken.cotohaAPI;

public class SentimentData {
	private SentimentData_Result result;
	private Integer status;
	private String message;

	public SentimentData_Result getResult() {
		return result;
	}
	public Integer getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}

	public String toString() {
		return "{\n" +
				"  \"result\":\n" +
				result.toString("    ") +
				"  \"status\": \"" + status + "\",\n" +
				"  \"message\": \"" + status + "\"\n" +
				"}\n";
	}
}