package men.ngopi.zain.jsonloaderlibrary;

import java.io.IOException;

public interface StringLoaderListener {
    void onResponse(String response);
    void onFailure(IOException error);
}
