package grammar;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TypeTokenGenerator {

    public void generateTypeToken(ArrayList<Term> terms) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/java/my_gen/TypeToken.java"))) {
            bufferedWriter.write("""
                    package my_gen;

                    import java.util.regex.Pattern;

                    public enum TypeToken {
                    """);

            bufferedWriter.write(terms
                    .stream()
                    .map(term -> String.format("\t%s(%s)", term.name(), term.value()))
                    .collect(Collectors.joining(",\n")));
            bufferedWriter.write(",\nEPS(\"\")");
            bufferedWriter.write(",\nEND(\"$\")");
            bufferedWriter.write(";\n");

            bufferedWriter.write("""
                    private final Pattern pattern;

                    TypeToken(String regexp) {
                        this.pattern = Pattern.compile(regexp);
                    }

                    public boolean match(String text) {
                        return pattern.matcher(text).matches();
                    }
                    """);

            bufferedWriter.write("}");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
