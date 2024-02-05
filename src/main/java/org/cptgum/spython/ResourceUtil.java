package org.cptgum.spython;

public class ResourceUtil {

    public static void copy() {
        //nbtlib
        Spython.getInstance().saveResource("libaries/nbtlib/__init__.py", true);
        Spython.getInstance().saveResource("libaries/nbtlib/__main__.py", true);
        Spython.getInstance().saveResource("libaries/nbtlib/cli.py", true);
        Spython.getInstance().saveResource("libaries/nbtlib/nbt.py", true);
        Spython.getInstance().saveResource("libaries/nbtlib/path.py", true);
        Spython.getInstance().saveResource("libaries/nbtlib/schema.py", true);
        Spython.getInstance().saveResource("libaries/nbtlib/tag.py", true);
        Spython.getInstance().saveResource("libaries/nbtlib/contrib/__init__.py", true);
        Spython.getInstance().saveResource("libaries/nbtlib/contrib/minecraft/__init__.py", true);
        Spython.getInstance().saveResource("libaries/nbtlib/contrib/minecraft/structure.py", true);
        Spython.getInstance().saveResource("libaries/nbtlib/literal/__init__.py", true);
        Spython.getInstance().saveResource("libaries/nbtlib/literal/parser.py", true);
        Spython.getInstance().saveResource("libaries/nbtlib/literal/serializer.py", true);

    }
}