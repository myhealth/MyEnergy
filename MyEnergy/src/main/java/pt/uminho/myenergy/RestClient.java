package pt.uminho.myenergy; /**
 * Created by arsenio on 04-07-2013.
 */

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class RestClient {
    private static final String BASE_URL = Config.SERVER_BASE_URL;
    private static final String TAG = RestClient.class.getName();

    private static AsyncHttpClient client = new AsyncHttpClient();

    public RestClient() {
        // make sure we get responses in json
        client.addHeader("Accept", "application/json");
    }

    private void get(String url,
                           RequestParams params, 
                           AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    private  void post(String url,
                            RequestParams params, 
                            AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }



    public List<FoodCategory> getFoodCategories() {

        final ArrayList<FoodCategory> foodCategories = new ArrayList<FoodCategory>();

        get("/values", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(JSONArray jsonArray) {
                int count = jsonArray.length();

                JSONObject foodCategory = null;
                for(int i = 0; i < count; i++) {
                    try {
                        foodCategory = (JSONObject) jsonArray.get(i);
                        foodCategories.add(FoodCategory.fromJson(foodCategory));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }


        });

        return foodCategories;
    }
}
