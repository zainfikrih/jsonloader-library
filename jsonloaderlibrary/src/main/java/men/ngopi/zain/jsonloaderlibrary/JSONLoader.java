package men.ngopi.zain.jsonloaderlibrary;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JSONLoader {

    private Context mContext;
    private String mFileName;

    private JSONLoader(Context context) {
        this.mContext = context;
    }

    public static JSONLoader with(Context applicationContext) {
        return new JSONLoader(applicationContext);
    }

    public JSONLoader fileName(String fileName) {
        mFileName = fileName;
        return this;
    }

    public String get() {
        String json = null;
        try {
            InputStream inputStream = mContext.getAssets().open(mFileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            //noinspection ResultOfMethodCallIgnored
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public JSONObject getAsJSONObject() {
        JSONObject jsonObject = null;
        try {
            InputStream inputStream = mContext.getAssets().open(mFileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            //noinspection ResultOfMethodCallIgnored
            inputStream.read(buffer);
            inputStream.close();
            String json = new String(buffer, StandardCharsets.UTF_8);
            jsonObject = new JSONObject(json);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public JSONArray getAsJSONArray() {
        JSONArray jsonArray = null;
        try {
            InputStream inputStream = mContext.getAssets().open(mFileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            //noinspection ResultOfMethodCallIgnored
            inputStream.read(buffer);
            inputStream.close();
            String json = new String(buffer, StandardCharsets.UTF_8);
            jsonArray = new JSONArray(json);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }
}
