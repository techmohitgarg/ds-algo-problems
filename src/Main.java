import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efsfgh)"
                , "root/c 3.txt(abdfcd)", "root/c/d 4.txt(efggdfh)"}));
    }

    //
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < paths.length; i++) {
            String[] path = paths[i].split(" ");
            for (int j = 1; j < path.length; j++) {
                String temp = path[j];
                String fileName = temp.substring(0, temp.indexOf("("));
                String content = temp.substring(temp.indexOf("(") + 1, temp.indexOf(")"));
                List<String> list = new ArrayList<>();
                if (!map.containsKey(content)) {
                    list.add(path[0] + "/" + fileName);
                } else {
                    list = map.get(content);
                    list.add(path[0] + "/" + fileName);
                }
                map.put(content, list);
            }
        }
        List<List<String>> list = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1)
                list.add(map.get(key));
        }
        return list;
    }
}

