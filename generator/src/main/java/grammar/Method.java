package grammar;

import java.util.List;

public record Method(String name, String modifier, String returnType, List<String> parameters, List<String> bodyLines) {

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(modifier).append(" ").append(returnType).append(" ").append(name).append("(");
        sb.append(String.join(", ", parameters));
        sb.append(") {\n");
        String INDENT = "\t";
        for (String line : bodyLines) {
            sb.append(INDENT).append(INDENT).append(line).append("\n");
        }
        sb.append(INDENT).append("}");
        return sb.toString();
    }
}
