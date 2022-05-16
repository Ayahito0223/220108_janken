package janken.cotohaAPI;

public class AccessTokenData {
	private String access_token;
	private String token_type;
	private String expires_in;
	private String scope;
	private String issued_at;

	public String getAccess_token() {
		return access_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public String getScope() {
		return scope;
	}

	public String getIssued_at() {
		return issued_at;
	}

	public String toString() {
		return "{\n" +
				"  \"access_token\": \"" + access_token + "\",\n" +
				"  \"token_type\": \"" + token_type + "\",\n" +
				"  \"expires_in\": \"" + expires_in + "\",\n" +
				"  \"scope\": \"" + scope + "\",\n" +
				"  \"issued_at\": \"" + issued_at + "\"\n" +
				"}\n";
	}
}
