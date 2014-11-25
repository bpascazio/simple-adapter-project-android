package edu.pace.pclc.simpleadapterproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListingActivity extends Activity {
    //////
    List<Map<String,String>> mealList = new ArrayList<Map<String,String>>();
    /////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);

        ///////////////////////////////////////
        initList();

        ListView listview = (ListView)findViewById(R.id.listView);

        SimpleAdapter adapter = new SimpleAdapter(

                this,                                 // this is our activity
                mealList,                             // this is our data
                R.layout.custom_list_layout,          // built in layout with one text item
                new String[] {"dishname","calories"}, // name in the hashmap
                new int[] {R.id.dishName, R.id.calorieCount} // id of the textView in layout
        );

        listview.setAdapter(adapter);
        //////////////////////////////////////
    }

    /////////////////////////////////

    public void initList() {
        mealList.add( createDish("turkey","100") );
        mealList.add( createDish("corn","50") );
        mealList.add( createDish("stuffing","200") );
        mealList.add( createDish("potato","150") );
        mealList.add( createDish("pie","100") );
        mealList.add( createDish("beans","30") );
        mealList.add( createDish("peas","50") );
        mealList.add( createDish("rice","80") );
        mealList.add( createDish("bread","100") );
        mealList.add( createDish("cranberries","130") );
        mealList.add( createDish("spinach","20") );
        mealList.add( createDish("squash","40") );
    }

    HashMap<String,String> createDish(String name, String calories) {
        HashMap<String,String> dish = new HashMap<String, String>();
        dish.put("dishname", name);
        dish.put("calories", calories);
        return dish;
    }

    /////////////////////////////////

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
