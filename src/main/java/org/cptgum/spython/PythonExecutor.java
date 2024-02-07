package org.cptgum.spython;

import org.bukkit.plugin.java.JavaPlugin;
import org.cptgum.spython.GetData.DataBridge;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PythonExecutor {

    public static void executeScriptAsync(JavaPlugin plugin, String fullPath, Object... args) {
        new Thread(() -> {
            executeScript( fullPath, args);
        }).start();
    }

    public static void executeScript(String fullPath, Object... args) {
        File scriptFile = new File("plugins", fullPath);

        if (!scriptFile.exists()) {
            Spython.getInstance().getLogger().warning("Script not found: " + fullPath);
            return;
        }

        try (Engine engine = Engine.newBuilder()
                .option("engine.WarnInterpreterOnly", "false")
                .build();
             Context context = Context.newBuilder("python")
                     .allowAllAccess(true)
                     .engine(engine)
                     .build()) {

            // Adding the libs folder to the python path
            context.getBindings("python").putMember("sys", context.eval("python", "import sys\nsys.path.append('./plugins/spython/libraries/')"));

            // Adding Data Bridge
            context.getBindings("python").putMember("dataBridge", new DataBridge());
            Value javaArgs = context.asValue(args);

            // Executing the script
            context.eval(Source.newBuilder("python", new FileReader(scriptFile), scriptFile.getName()).build()).execute("main", javaArgs);
            // Call the main function
            Value pythonFunction = context.getBindings("python").getMember("main");
            if (pythonFunction != null) {
                pythonFunction.execute(args);
            } else {
                Spython.getInstance().getLogger().warning("Main function not found: " + fullPath);
            }

        } catch (IOException e) {
            Spython.getInstance().getLogger().severe("Error executing script: " + fullPath);
        }
    }
}
