package grammar;

import java.util.List;

public record Class(String name, String modifier, String returnType, String returnName) {

    public String toString() {
        return modifier + " " + " class "+ name + " extends Tree {\n" +
                modifier + " " + returnType + " " + returnName + ";\n" + """
                public\s""" + name +
                """
                \s(String node) {
                              super(node);
                        }""" + "\n}";
    }
}
