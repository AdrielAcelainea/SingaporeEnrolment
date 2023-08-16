package sg.edu.rp.c346.id22016845.singaporeenrolment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    ListView SingaporeList;
    AsyncHttpClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SingaporeList=findViewById(R.id.SingaporeList);
        client = new AsyncHttpClient();

    }
    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<Enrolment> enrolmentArray = new ArrayList<Enrolment>();
        client.get("https://data.gov.sg/api/action/datastore_search?resource_id=fdd36db3-3317-4790-8c27-8e58f7dd1a42&limit=5", new JsonHttpResponseHandler() {
            int year;
            String studyType;
            int enrolmentCount;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray jsonArrRecords = response.getJSONObject("result").getJSONArray("records");
                    for (int i = 0; i < jsonArrRecords.length(); i++) {
                        JSONObject jsonObjEnrolment = jsonArrRecords.getJSONObject(i);
                        year = jsonObjEnrolment.getInt("year");
                        studyType = jsonObjEnrolment.getString("type_of_study");
                        enrolmentCount = jsonObjEnrolment.getInt("enrolment"); 

                        Enrolment enrolment = new Enrolment(year, studyType, enrolmentCount);
                        enrolmentArray.add(enrolment);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // Code to display List View
                ArrayAdapter<Enrolment> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, enrolmentArray);
                SingaporeList.setAdapter(adapter);
            }

        });
    }//end onResume


}