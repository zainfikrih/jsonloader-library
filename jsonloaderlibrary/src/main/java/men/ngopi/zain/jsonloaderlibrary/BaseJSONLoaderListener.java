package men.ngopi.zain.jsonloaderlibrary;

public interface BaseJSONLoaderListener<T> {
    void onResponse(T response);

    void onFailure(Exception error);
}
