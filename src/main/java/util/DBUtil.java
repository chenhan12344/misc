package util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.util.Map;

public class DBUtil {

    private DBUtil() {
        throw new RuntimeException();
    }

    public static DBObject parseDBObject(JSONObject jsonObject) {
        DBObject dbObject = new BasicDBObject();
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            dbObject.put(entry.getKey(), entry.getValue());
        }
        return dbObject;
    }

    public static <T> T toJavaBean(DBObject dbObject, Class<T> classOfT) {
        if (dbObject == null) {
            return null;
        }
        return new Gson().fromJson(dbObject.toString(), classOfT);
    }

    public static JSONArray toJSONArray(AggregationOutput aggregationOutput) {
        return JSONArray.parseArray(aggregationOutput.results().toString());
    }
}
