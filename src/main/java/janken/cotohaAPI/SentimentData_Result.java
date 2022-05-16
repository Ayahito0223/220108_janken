package janken.cotohaAPI;

import java.util.HashSet;
import java.util.List;

public class SentimentData_Result {

	public static final String POSITIVE = "Positive";
	public static final String NEGATIVE = "Negative";
	public static final String NEUTRAL = "Nuetral";

	private String sentiment;
	private Double score;
	private List<SentimentData_Result_EmotionalPhrase> emotional_phrase;

	public String getSentiment() {
		return sentiment;
	}

	public Double getScore() {
		return score;
	}

	public List<SentimentData_Result_EmotionalPhrase> getEmotional_phrase() {
		return emotional_phrase;
	}

	public String getEmotionals() {
		String result = "";

		HashSet<String> emotions = new HashSet<>();
		for (SentimentData_Result_EmotionalPhrase ep : emotional_phrase) {
			String[] emos = ep.getEmotion().split(",", 0);
			for(String emo: emos) {
				if (emo.equals("P")) {
					emotions.add("ポジティブ");
				} else if (emo.equals("N")) {
					emotions.add("ネガティブ");
				} else if (emo.equals("PN")) {
					emotions.add("普通");
				} else{
					emotions.add(emo);
				}
			}
		}

		boolean s = false;
		for (String emo : emotions) {
			if(s){
				result += "、";
			}
			result += emo;
			s = true;
		}

		return result;
	}

	public String toString(String prefix) {
		String emotional = "";
		for (SentimentData_Result_EmotionalPhrase ep : emotional_phrase) {
			emotional += ep.toString(prefix + "    ");
		}

		return prefix + "{\n"
		+ prefix + "  \"sentiment\": \"" + sentiment + "\",\n"
		+ prefix + "  \"score\": \"" + score + "\",\n"
		+ prefix + "  \"emotional_phrase\": [\n"
		+ emotional
		+ prefix + "  ]\n"
		+ prefix + "}\n";
	}

	public String toString() {
		return toString("");
	}
}
