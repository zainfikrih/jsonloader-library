package men.ngopi.zain.jsonloader;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import men.ngopi.zain.jsonloaderlibrary.JSONArrayLoaderListener;
import men.ngopi.zain.jsonloaderlibrary.JSONLoader;
import men.ngopi.zain.jsonloaderlibrary.JSONObjectLoaderListener;
import men.ngopi.zain.jsonloaderlibrary.StringLoaderListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // JSON as String
        JSONLoader.with(getApplicationContext())
                .fileName("sample.json")
                .get(new StringLoaderListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("JSONString", response);
                    }

                    @Override
                    public void onFailure(Exception error) {

                    }
                });

        // JSON as JSONObject
        JSONLoader.with(getApplicationContext())
                .fileName("sample.json")
                .getAsJSONObject(new JSONObjectLoaderListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d("JSONObject", response.getJSONArray("hama").toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Exception error) {

                    }
                });


        // JSON as JSONArray
        JSONLoader.with(getApplicationContext())
                .fileName("sample_array.json")
                .getAsJSONArray(new JSONArrayLoaderListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("JSONArray", response.toString());
                    }

                    @Override
                    public void onFailure(Exception error) {

                    }
                });

    }
}
