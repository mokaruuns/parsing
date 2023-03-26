package my_gen.Regex;

import java.util.regex.Pattern;

public enum TypeToken {
		VAR("[a-zA-Z]"),
	OR("\\|"),
	STAR("\\*"),
	OPEN("\\("),
	CLOSE("\\)"),
EPS(""),
END("$");
	private final Pattern pattern;

	  TypeToken(String regexp) {
		this.pattern = Pattern.compile(regexp);
	}

	public boolean match(String text) {
		return pattern.matcher(text).matches();
	}

	public String getRegexp(String s) {
		return pattern.pattern();
	}

}