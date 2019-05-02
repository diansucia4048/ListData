package org.d3ifcool.com.listdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RequestQueue mQueue;
    private ArrayList<Data> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listdata = findViewById(R.id.list_data);
        arrayList = new ArrayList<>();
        listdata.setAdapter(new DataAdapter(this, arrayList));

        mQueue = Volley.newRequestQueue(this);

        jsonParse();

    }

    private void jsonParse(){
        String url = "https://test.shirobyte.com/API/list.php";

        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray data = response.getJSONArray("data");
                    for (int i = 0; i < data.length(); i++){
                        JSONObject index = data.getJSONObject(i);
                        String image = index.getString("image");
                        String name = index.getString("name");
                        String version = index.getString("version");
                        String desc = index.getString("description");

                        Log.d("TAG", "getListData: " + image +", " + name + ", " + version + ", " + desc);

                        arrayList.add(new Data(Integer.parseInt(image), name, version, desc));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }
}
