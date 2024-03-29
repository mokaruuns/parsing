package my_gen.Math;

import java.util.regex.Pattern;

public enum TypeToken {
		SUM("\\+"),
	SUB("-"),
	MUL("\\*"),
	DIV("/"),
	OPEN("\\("),
	CLOSE("\\)"),
	NUMBER("[0-9]+"),
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