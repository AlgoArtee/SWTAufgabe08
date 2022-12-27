/*
 * Important: Do not change the package identifier!
 */
package swt;

import java.util.List;

public interface IPlugin {

    String getPluginName();
    String getCreationDate();
    List<String> getGroupMembers();

    int run(int a, int b) throws Exception;

}
