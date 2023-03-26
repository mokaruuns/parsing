package generators;

import utils.Term;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TypeTokenGenerator extends ClassPrinter {

    public TypeTokenGenerator(String packageName, String className, String type) {
        super(packageName, className, type);
    }

    public void generateTypeToken(ArrayList<Term> terms) {
        addImport("java.util.regex.Pattern");
        String fields = terms
                .stream()
                .map(term -> String.format("\t%s(%s)", term.name(), term.value()))
                .collect(Collectors.joining(",\n"));
        fields += ",\nEPS(\"\"),\nEND(\"$\")";
        addField(fields);
        addField("private final Pattern pattern");
        addConstructor(new Method(className, "", "", List.of("String regexp"), List.of("this.pattern = Pattern.compile(regexp);")));
        addMethod(new Method("match", "public", "boolean", List.of("String text"), List.of("return pattern.matcher(text).matches();")));
        addMethod(new Method("getRegexp", "public", "String", List.of("String s"), List.of("return pattern.pattern();")));
    }
}
