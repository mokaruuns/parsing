package grammar;

import java.util.List;

public record Class(String name, String returnType, String returnName) {

    public String toString() {
        if (returnName.equals("")) {
            return "public class " + name + " extends Tree {\n" +
                    "public " + name + "(String node) { super(node);}" + "\n}";
        } else {
            return "public class " + name + " extends Tree {\n" +
                    "public " + returnType + " " + returnName + ";\n" +
                    "public " + name + "(String node) { super(node);}" + "\n}";
        }

    }
}
