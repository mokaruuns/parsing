package my_gen.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
	private Pattern PATTERN_EXPRESSION = Pattern.compile("[a-zA-Z]|\\||\\*|\\(|\\)");
	private final Matcher tokenMatcher;
	private TypeToken curToken;
	private String curTokenStr;

	public  Lexer(String expression) {
		this.tokenMatcher = PATTERN_EXPRESSION.matcher(expression);
	}

	public void nextToken() {
		while (tokenMatcher.find()) {
		if (Character.isWhitespace(tokenMatcher.group().charAt(0))) {
		continue;
		}
		for (var typeToken : TypeToken.values()) {
		String tokenStr = tokenMatcher.group();
		if (typeToken.match(tokenStr)) {
		curToken = typeToken;
		curTokenStr = tokenStr;
		return;
		}
		}
		}
		curToken = TypeToken.END;
	}

	public String toString() {
		return curToken.toString();
	}

	public TypeToken getToken() {
		return curToken;
	}

	public String getTokenStr() {
		return curTokenStr;
	}

}