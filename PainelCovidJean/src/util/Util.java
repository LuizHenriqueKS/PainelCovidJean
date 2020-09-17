package util;

import java.util.List;

/**
 *
 * @author luizh
 */
public class Util {

    public static boolean hasContent(String str) {
        return str!=null&&!str.isEmpty();
    }

    public static <T> boolean hasContent(List<T> list) {
        return list!=null&&!list.isEmpty();
    }
    
}
