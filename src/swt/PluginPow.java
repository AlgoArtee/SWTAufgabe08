package swt;

import java.util.Arrays;
import java.util.List;

public class PluginPow implements IPlugin{
    @Override
    public String getPluginName() {
        return "PluginPow";
    }

    @Override
    public String getCreationDate() {

        String date = "27.12.2022";
        return date;
    }

    @Override
    public List<String> getGroupMembers() {

        List<String> groupMembers = Arrays.asList(new String[]{"Chachulski", "Mathea", "Mora", "Schwiderski"});

        return groupMembers;
    }

    @Override
    public int run(int a, int b) throws Exception {

        int base = a;
        int exp = b;

        int res = 1;

        while (exp != 0) {
            res *= base;
            --exp;
        }

        return res;
    }
}
