package men.ngopi.zain.jsonloaderlibrary;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
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

    private String loadAsString() throws IOException {
        InputStream inputStream = mContext.getAssets().open(mFileName);
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;

        while ((length = inputStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        inputStream.close();
        return result.toString(StandardCharsets.UTF_8.name());
    }

    public void get(StringLoaderListener stringLoaderListener) {
        try {
            stringLoaderListener.onResponse(loadAsString());
        } catch (IOException e) {
            stringLoaderListener.onFailure(e);
        }
    }

    public void getAsJSONObject(JSONObjectLoaderListener jsonObjectLoaderListener) {
        try {
            jsonObjectLoaderListener.onResponse(new JSONObject(loadAsString()));
        } catch (IOException | JSONException e) {
            jsonObjectLoaderListener.onFailure(e);
        }
    }

    public void getAsJSONArray(JSONArrayLoaderListener jsonArrayLoaderListener) {
        try {
            jsonArrayLoaderListener.onResponse(new JSONArray(loadAsString()));
        } catch (IOException | JSONException e) {
            jsonArrayLoaderListener.onFailure(e);
        }
    }
}
