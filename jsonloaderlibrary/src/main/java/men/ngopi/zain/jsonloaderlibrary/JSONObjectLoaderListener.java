package men.ngopi.zain.jsonloaderlibrary;

import org.json.JSONObject;

public interface JSONObjectLoaderListener {
    void onResponse(JSONObject response);

    void onFailure(Exception error);
}
