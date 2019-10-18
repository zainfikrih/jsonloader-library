package men.ngopi.zain.jsonloader;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import men.ngopi.zain.jsonloaderlibrary.JSONLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // JSON as String
        String jsonString = JSONLoader.with(getApplicationContext()).fileName("sample.json").get();
        Log.d("JSONString", jsonString);

        // JSON as JSONObject
        JSONObject jsonObject = JSONLoader.with(getApplicationContext()).fileName("sample.json").getAsJSONObject();
        try {
            Log.d("JSONObject", jsonObject.getJSONArray("hama").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // JSON as JSONArray
        JSONArray jsonArray = JSONLoader.with(getApplicationContext()).fileName("sample_array.json").getAsJSONArray();
        Log.d("JSONArray", jsonArray.toString());
    }
}
