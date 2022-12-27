package swt;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] arguments) throws Throwable{

        final String relativePluginFolderPath = "src/swt";
        List<String> listPluginPaths = findPlugins(relativePluginFolderPath);

        /* ToDo: Sub-Task:
         * Use PluginManager to load plugins
         */

        PluginManager pm = new PluginManager(listPluginPaths);

        List<IPlugin> plugins = pm.listPlugins;

        for(var pi:plugins){
            System.out.println(pi.getPluginName() + " loaded!");
        }

        /* ToDo: Sub-Task:
         * Write small GUI to visualize plugin information, see 'PluginManager.getLoadedPlugins'
         * Alternatively you may simply create a console user interface
         */




    }




    /*
     * Note: - Path to plugin folder (='relativePluginFolderPath') must be relative to your IDE project path
     *       - Not working recursively
     *       - No need to touch this method
     */
    public static List<String> findPlugins(String relativePluginFolderPath) throws Exception {
        System.out.println("Result of 'findPlugins':");

        if (!Files.exists(Path.of(relativePluginFolderPath))) {
            throw new Exception("Specified folder does not exist or is not relative to the project folder: \"" + relativePluginFolderPath + "\"");
        }

        List<String> listPluginBinaryNames = new ArrayList();

        // Iterate over files in specified folder
        File f = new File(relativePluginFolderPath);

        for (File e : f.listFiles()) {
            String fileName = e.getName();

            // It is a file, but is it a *.class-file?
            int i = fileName.lastIndexOf('.');
            if (i > 0) {
                String extension = fileName.substring(i + 1);

                if (extension.equals("class")) {
                    // Result may be, e.g., the binary name 'swt.PluginAnswer42' which can be read by the Java 'ClassLoader'
                    String relativePluginPath = relativePluginFolderPath + "." + fileName.substring(0, i);
                    listPluginBinaryNames.add(relativePluginPath);
                    System.out.println("\tFound possible plugin: " + relativePluginPath);
                }
            }
        }

        return listPluginBinaryNames;
    }

}