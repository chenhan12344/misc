package util;

import org.bson.Document;

import java.util.List;

/**
 * Created by DJH on 2018/9/26
 */
public class MongoUtil {

    private MongoUtil() {
        throw new RuntimeException();
    }

    public static Object get(Document document, String key) {
        if (key.indexOf(".") > 0) {
            String nextKey = key.substring(0, key.indexOf("."));
            key = key.substring(key.indexOf(".") + 1);
            return get(getDocument(document, nextKey), key);
        } else {
            return document.get(key);
        }
    }

    public static Document getDocument(Document document, String key) {
        return (Document) get(document, key);
    }

    public static String getString(Document document, String key) {
        return (String) get(document, key);
    }

    public static Integer getInteger(Document document, String key) {
        return (Integer) get(document, key);
    }

    public static Long getLong(Document document, String key) {
        return (Long) get(document, key);
    }

    public static Double getDouble(Document document, String key) {
        return (Double) get(document, key);
    }

    public static Boolean getBoolean(Document document, String key) {
        return (Boolean) get(document, key);
    }

    public static <T> List<T> getArrayList(Document document, String key, Class<T> classOfT) {
        return (List<T>) get(document, key);
    }
}
