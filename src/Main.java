import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        //["void func(int k) {","   k = k*2/4;","   k = k/2;*/","}"]
        //["void func(int k) {","   k = k*2/4;","}"]
        System.out.println(main.removeComments(new String[]{
                "void func(int k) {", "// this function does nothing /*", "   k = k*2/4;", "   k = k/2;*/", "}"
        }));
    }

    public List<String> removeComments(String[] source) {
        List<String> list = new ArrayList<>();
        boolean isComment = false;
        String st = "";
        for (int i = 0; i < source.length; i++) {
            String str = source[i];
            int startIndex = str.indexOf("/*");
            int endIndex = str.indexOf("*/", startIndex + 2);
            int lineIndex = str.indexOf("//");
            if (!isComment && startIndex == -1 && endIndex == -1 && lineIndex == -1) {
                list.add(str);
            } else {
                if (!isComment && (startIndex != -1)) {
                    if ((startIndex != -1 && lineIndex == -1) || (startIndex < lineIndex)) {
                        isComment = true;
                        st = st + str.substring(0, startIndex);
                    }
                }
                if (!isComment && lineIndex != -1) {
                    st = str.substring(0, lineIndex);
                    if (st.length() > 0) {
                        list.add(st);
                    }
                    st = "";
                    continue;
                }
                if (!isComment && endIndex != -1 && st.length() == 0) {
                    list.add(str);
                }
                if (isComment && endIndex != -1) {
                    isComment = false;
                    st = st + str.substring(endIndex + 2);
                    if (st.length() > 0) {
                        list.add(st);
                    }
                    st = "";
                }


            }


        }
        return list;
    }

}

