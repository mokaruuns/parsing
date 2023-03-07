package grammar;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClassPrinter {
    protected String packageName;
    protected String className;
    protected ArrayList<String> imports;
    protected ArrayList<String> fields;
    protected ArrayList<Method> constructors;
    protected ArrayList<Method> methods;

    public ClassPrinter(String packageName, String className) {
        this.packageName = packageName;
        this.className = className;
        imports = new ArrayList<>();
        fields = new ArrayList<>();
        constructors = new ArrayList<>();
        methods = new ArrayList<>();
    }


    public void addImport(String importName) {
        imports.add(importName);
    }

    public void addImports(String... importNames) {
        imports.addAll(List.of(importNames));
    }

    public void addField(String field) {
        fields.add(field);
    }

    public void addConstructor(Method constructor) {
        constructors.add(constructor);
    }

    public void addMethod(Method method) {
        methods.add(method);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("package ").append(packageName).append(";").append("\n\n");
        for (String importName : imports) {
            sb.append("import ").append(importName).append(";").append("\n");
        }
        sb.append("\n");
        sb.append("public class ").append(className).append(" {\n");
        for (String field : fields) {
            sb.append("\t").append(field).append(";\n");
        }
        sb.append("\n");
        for (Method constructor : constructors) {
            sb.append("\t").append(constructor).append("\n\n");
        }
        for (Method method : methods) {
            sb.append("\t").append(method).append("\n\n");
        }
        sb.append("}");
        return sb.toString();
    }

    public void writeToFile(String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
