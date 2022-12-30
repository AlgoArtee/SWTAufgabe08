package swt;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class PluginManager {

    List<IPlugin> listPlugins = new ArrayList<>();

    public List<IPlugin> getLoadedPlugins() {
        return listPlugins;
    }

    public PluginManager(List<String> listPluginPaths) throws Throwable {
        /* ToDo: Sub-Task:
         * Use method 'loadPlugin' to create plugin instances for each plugin path in 'listPluginPaths'.
         */

        for (var p: listPluginPaths){

            try {
                IPlugin toLoad = loadPlugin(p);
                listPlugins.add(toLoad);
            } catch (ClassNotFoundException e) {
                System.out.println("Error: Plugin class not found: " + p);
            } catch (UnsupportedClassVersionError e) {
                System.out.println("Error: Plugin compiled with a newer version of Java: " + p);
            } catch (Throwable e) {
                System.out.println("Error: Failed to load plugin: " + p);
                e.printStackTrace();}
        }


    }

    private IPlugin loadPlugin(String pluginBinaryName) throws Throwable {
        /*
         * No need to touch the following code;
         * Creates ClassLoader object which has access to the current project folder.
         * (absolute path, e.g., print() might show 'file:/D:/MyProjects/HostApp/./'
         */
        File file = new File("./src/");
        ClassLoader cl = new URLClassLoader(new URL[]{file.toURI().toURL()});


        /* ToDo: Sub-Task: Create an IPlugin object out of Class 'c'
         * To do so look at the documentation of 'Class':
         * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Class.html
         *
         * Read about 'getDeclaredConstructor' its return type and 'newInstance'
         * Note: Solution is a one-liner
         */
        Class c = cl.loadClass(pluginBinaryName);
        IPlugin plugin = (IPlugin) c.getDeclaredConstructor().newInstance();

        return plugin;
    }

}
