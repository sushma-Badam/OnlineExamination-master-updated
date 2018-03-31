package com.it.acumen.slide;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;



import java.util.ArrayList;
//sdsd
/**
 * Created by ohlordino on 30/3/18.
 */

public class QuestionList extends AppCompatActivity{
    ListView listview;
    private FirebaseRecyclerAdapter<Questions, QuestionHolder> recyclerAdapter;
    private ArrayList<String> topics = new ArrayList<>();
    private String URL;
    int score=0;
    private Button scbtn;
    private EditText Scorei;
    FirebaseDatabase database;
    Camera camera;
    FrameLayout framelayout;
    ShowCamera showCamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        scbtn = (Button) findViewById(R.id.submitques);
        Scorei = (EditText) findViewById(R.id.score);
        framelayout = (FrameLayout) findViewById(R.id.framelayout);
        camera = Camera.open(1);
        showCamera = new ShowCamera(QuestionList.this, camera);
        framelayout.addView(showCamera);
        //camera-code
        if (!extras.isEmpty()) {
            URL = extras.getString("topic");
        }

        Query query = FirebaseDatabase.getInstance().getReferenceFromUrl("https://slide-6c62e.firebaseio.com/questions/" + URL);

        FirebaseRecyclerOptions<Questions> options = new FirebaseRecyclerOptions.Builder<Questions>()
                .setQuery(query, Questions.class)
                .build();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerAdapter = new FirebaseRecyclerAdapter<Questions, QuestionHolder>(options) {
            @Override
            protected void onBindViewHolder(QuestionHolder holder, int position, Questions model) {
                holder.question.setText(model.getQuestion());
                holder.a.setText(model.getA());
                holder.b.setText(model.getB());
                holder.c.setText(model.getC());
                holder.d.setText(model.getD());

                final Questions models = model;
                final QuestionHolder arc = holder;
                holder.a.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        arc.a.setEnabled(false);
                        arc.b.setEnabled(false);
                        arc.c.setEnabled(false);
                        arc.d.setEnabled(false);

                        if (!arc.a.getText().toString().toLowerCase().equals(models.getCorrect().toLowerCase())) {
                            arc.relativeLayout.setBackgroundColor(Color.RED);
                        } else {
                            arc.relativeLayout.setBackgroundColor(Color.GREEN);
                            score = score + 1;
                        }
                    }
                });

                holder.b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        arc.a.setEnabled(false);
                        arc.b.setEnabled(false);
                        arc.c.setEnabled(false);
                        arc.d.setEnabled(false);

                        if (!arc.b.getText().toString().toLowerCase().equals(models.getCorrect().toLowerCase())) {
                            arc.relativeLayout.setBackgroundColor(Color.RED);
                        } else {
                            arc.relativeLayout.setBackgroundColor(Color.GREEN);
                            score = score + 1;
                        }
                    }


                });

                holder.c.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        arc.a.setEnabled(false);
                        arc.b.setEnabled(false);
                        arc.c.setEnabled(false);
                        arc.d.setEnabled(false);

                        if (!arc.c.getText().toString().toLowerCase().equals(models.getCorrect().toLowerCase())) {
                            arc.relativeLayout.setBackgroundColor(Color.RED);
                        } else {
                            arc.relativeLayout.setBackgroundColor(Color.GREEN);
                            score = score + 1;
                        }
                    }
                });

                holder.d.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        arc.a.setEnabled(false);
                        arc.b.setEnabled(false);
                        arc.c.setEnabled(false);
                        arc.d.setEnabled(false);

                        if (!arc.d.getText().toString().toLowerCase().equals(models.getCorrect().toLowerCase())) {
                            arc.relativeLayout.setBackgroundColor(Color.RED);
                        } else {
                            arc.relativeLayout.setBackgroundColor(Color.GREEN);
                            score = score + 1;
                        }
                    }
                });


            }

            @Override
            public QuestionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.questionsdisp, parent, false);
                return new QuestionHolder(itemView);
            }
        };

        LinearLayoutManager linearLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);

        scbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Scorei.setText("Total Score:" + score);
            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();
        recyclerAdapter.startListening();
    }


    @Override
    protected void onStop() {
        super.onStop();
        recyclerAdapter.stopListening();
    }

}
