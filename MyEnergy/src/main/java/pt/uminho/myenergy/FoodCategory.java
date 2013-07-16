package pt.uminho.myenergy;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by arsenio on 04-07-2013.
 */
public class FoodCategory {
    public int id;
    public String name;

    public static FoodCategory fromJson (JSONObject jsonObject) throws JSONException {
        FoodCategory foodCategory = new FoodCategory();

        foodCategory.id = jsonObject.getInt("id");
        foodCategory.name = jsonObject.getString("name");

        return foodCategory;
    }
}
