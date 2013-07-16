package pt.myenergy;

import android.os.Bundle;
import android.util.Log;

import com.actionbarsherlock.app.SherlockActivity;

import java.util.List;

import pt.myenergy.R;

public class MainActivity extends SherlockActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestClient client = new RestClient();

        List<FoodCategory> categories = client.getFoodCategories();


        Log.d(TAG, "break");
    }
}
