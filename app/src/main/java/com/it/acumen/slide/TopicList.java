package com.it.acumen.slide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TopicList extends AppCompatActivity {
    ListView listview;
    private FirebaseListAdapter<Test> firebaseListAdapter;
    private ArrayList<String> topics = new ArrayList<>();
    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        listview = (ListView) findViewById(R.id.ListView);
        Query query = FirebaseDatabase.getInstance().getReferenceFromUrl("https://slide-6c62e.firebaseio.com/Tests");
        FirebaseListOptions<Test> options = new FirebaseListOptions.Builder<Test>()
                .setQuery(query, Test.class)
                .setLayout(R.layout.testwithdate)
                .build();

        //Toast.makeText(this, "Entered this activity", Toast.LENGTH_LONG).show();
        firebaseListAdapter = new FirebaseListAdapter<Test>(options) {
            @Override
            protected void populateView(View v, Test model, int position) {
                //Toast.makeText(v.getContext(), "Populateview", Toast.LENGTH_LONG).show();
                TextView test = (TextView) v.findViewById(R.id.testname);
                TextView branch = (TextView) v.findViewById(R.id.branch);
                TextView startdate = (TextView) v.findViewById(R.id.startdate);
                TextView enddate = (TextView) v.findViewById(R.id.enddate);

                test.setText(model.getTestname());
                startdate.setText(model.getStartdate());
                enddate.setText(model.getEnddate());
                branch.setText(model.getBranch());
                topics.add(model.getTestname().toLowerCase());
            }

        };

        listview.setAdapter(firebaseListAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putString("topic", topics.get(i));
                Intent intent = new Intent(TopicList.this, QuestionList.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseListAdapter.startListening();
    }


    @Override
    protected void onStop() {
        super.onStop();
        firebaseListAdapter.stopListening();
    }
}
