package men.ngopi.zain.jsonloaderlibrary;

import org.json.JSONArray;

public interface JSONArrayLoaderListener {
    void onResponse(JSONArray response);
    void onFailure(Exception error);
}
