package janken.cotohaAPI;

public class SentimentData_Result_EmotionalPhrase {
	private String form;
	private String emotion;

	public String getForm() {
		return form;
	}
	public String getEmotion() {
		return emotion;
	}

	public String toString(String prefix) {
		return  prefix + "{\n" +
				prefix + "  \"form\": \"" + form + "\",\n" +
				prefix + "  \"emotion\": \"" + emotion + "\"\n" +
				prefix + "}\n";
	}

	public String toString() {
		return  toString("");
	}
}
