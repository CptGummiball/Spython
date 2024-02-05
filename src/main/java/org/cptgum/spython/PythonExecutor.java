package org.cptgum.spython;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PythonExecutor {

    public static void executeScript(String scriptPath, Object... args) {
        File scriptFile = new File(scriptPath);

        if (!scriptFile.exists()) {
            Spython.getInstance().getLogger().warning("Script not found: " + scriptPath);
            return;
        }

        try (Context context = Context.newBuilder("python")
                .allowAllAccess(true)
                .build()) {

            // Adding additional libraries
            context.getBindings("python").putMember("sys", context.eval("python", "import sys\nsys.path.append('./plugins/spython/libs/')"));

            context.eval(Source.newBuilder("python", new FileReader(scriptFile), scriptFile.getName()).build());

            // Call the main function
            Value pythonFunction = context.getBindings("python").getMember("main");
            if (pythonFunction != null) {
                pythonFunction.execute(args);
            } else {
                Spython.getInstance().getLogger().warning("Main function not found: " + scriptPath);
            }

        } catch (IOException e) {
            Spython.getInstance().getLogger().severe("Error executing script: " + scriptPath);
        }
    }
}
