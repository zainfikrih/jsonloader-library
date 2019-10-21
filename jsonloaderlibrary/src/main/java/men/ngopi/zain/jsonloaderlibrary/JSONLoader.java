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

    public void get(StringLoaderListener stringLoaderListener) {
        try {
            InputStream inputStream = mContext.getAssets().open(mFileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            //noinspection ResultOfMethodCallIgnored
            inputStream.read(buffer);
            inputStream.close();
            stringLoaderListener.onResponse(new String(buffer, StandardCharsets.UTF_8));
        } catch (IOException e) {
            stringLoaderListener.onFailure(e);
        }
    }

    public void getAsJSONObject(JSONObjectLoaderListener jsonObjectLoaderListener) {
        try {
            InputStream inputStream = mContext.getAssets().open(mFileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            //noinspection ResultOfMethodCallIgnored
            inputStream.read(buffer);
            inputStream.close();
            String json = new String(buffer, StandardCharsets.UTF_8);
            jsonObjectLoaderListener.onResponse(new JSONObject(json));
        } catch (IOException | JSONException e) {
            jsonObjectLoaderListener.onFailure(e);
        }
    }

    public void getAsJSONArray(JSONArrayLoaderListener jsonArrayLoaderListener) {
        try {
            InputStream inputStream = mContext.getAssets().open(mFileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            //noinspection ResultOfMethodCallIgnored
            inputStream.read(buffer);
            inputStream.close();
            String json = new String(buffer, StandardCharsets.UTF_8);
            jsonArrayLoaderListener.onResponse(new JSONArray(json));
        } catch (IOException | JSONException e) {
            jsonArrayLoaderListener.onFailure(e);
        }
    }
}
