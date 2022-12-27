package swt;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PluginSquare implements IPlugin {

    private String pluginName;
    private String creationDate;
    private List<String> groupMembers = new ArrayList<>();

    public PluginSquare(){
       this.pluginName = "PluginSquare";
       this.creationDate = "19.12.2022";
       groupMembers.add("Schäfer");
       groupMembers.add("Lumeau");
       groupMembers.add("Dios Vargas");

    }


    @Override
    public String getPluginName() {
        return pluginName;
    }

    @Override
    public String getCreationDate() {
        return creationDate;
    }

    @Override
    public List<String> getGroupMembers() {
        return groupMembers;
    }

    @Override
    public int run(int a, int b) throws Exception {
        return a*a+b*b;
    }
}
