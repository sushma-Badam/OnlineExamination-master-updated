package com.it.acumen.slide;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if(!extras.isEmpty())
        {
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
                        Toast.makeText(QuestionList.this, models.getCorrect().toLowerCase(), Toast.LENGTH_SHORT).show();
                        arc.a.setEnabled(false);
                        arc.b.setEnabled(false);
                        arc.c.setEnabled(false);
                        arc.d.setEnabled(false);

                        if(!arc.a.getText().toString().toLowerCase().equals(models.getCorrect().toLowerCase()))
                        {
                            arc.relativeLayout.setBackgroundColor(Color.RED);
                        }

                        else
                            arc.relativeLayout.setBackgroundColor(Color.GREEN);
                    }
                });

                holder.b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(QuestionList.this, models.getCorrect().toLowerCase(), Toast.LENGTH_SHORT).show();
                        arc.a.setEnabled(false);
                        arc.b.setEnabled(false);
                        arc.c.setEnabled(false);
                        arc.d.setEnabled(false);

                        if(!arc.a.getText().toString().toLowerCase().equals(models.getCorrect().toLowerCase()))
                        {
                            arc.relativeLayout.setBackgroundColor(Color.RED);
                        }

                        else
                            arc.relativeLayout.setBackgroundColor(Color.GREEN);
                    }


                });

                holder.c.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(QuestionList.this, models.getCorrect().toLowerCase(), Toast.LENGTH_SHORT).show();
                        arc.a.setEnabled(false);
                        arc.b.setEnabled(false);
                        arc.c.setEnabled(false);
                        arc.d.setEnabled(false);

                        if(!arc.a.getText().toString().toLowerCase().equals(models.getCorrect().toLowerCase()))
                        {
                            arc.relativeLayout.setBackgroundColor(Color.RED);
                        }

                        else
                            arc.relativeLayout.setBackgroundColor(Color.GREEN);

                    }
                });

                holder.d.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(QuestionList.this, models.getCorrect().toLowerCase(), Toast.LENGTH_SHORT).show();
                        arc.a.setEnabled(false);
                        arc.b.setEnabled(false);
                        arc.c.setEnabled(false);
                        arc.d.setEnabled(false);

                        if(!arc.a.getText().toString().toLowerCase().equals(models.getCorrect().toLowerCase()))
                        {
                            arc.relativeLayout.setBackgroundColor(Color.RED);
                        }

                        else
                            arc.relativeLayout.setBackgroundColor(Color.GREEN);

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
