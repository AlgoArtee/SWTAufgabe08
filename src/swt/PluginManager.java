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

        for (var p: listPlugins){
            IPlugin toLoad = loadPlugin(p.getPluginName());
            listPlugins.add(toLoad);
        }


    }

    private IPlugin loadPlugin(String pluginBinaryName) throws Throwable {
        /*
         * No need to touch the following code;
         * Creates ClassLoader object which has access to the current project folder.
         * (absolute path, e.g., print() might show 'file:/D:/MyProjects/HostApp/./'
         */
        File file = new File(".");
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
