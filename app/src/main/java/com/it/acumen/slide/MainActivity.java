package com.it.acumen.slide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.hololo.tutorial.library.TutorialActivity;
import com.hololo.tutorial.library.Step;
import android.graphics.Color;


public class MainActivity extends TutorialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addFragment(new Step.Builder().setTitle("welcome to online examination")
                .setContent("   ")
                .setBackgroundColor(Color.parseColor("#424242")) // int background color
                .setDrawable(R.drawable.a3) // int top drawable
                .setSummary("@copyright")
                .build());

        addFragment(new Step.Builder().setTitle("How Online Examination System Works")
                .setContent("Our online testHow Online Examination System Works generator will help you creating your online exam with timer. You’ve decided to give an online examination. Now you’re wondering which steps to follow to accomplish that.")
                .setBackgroundColor(Color.parseColor("#424242")) // int background color
                .setDrawable(R.drawable.ii) // int top drawable
                .setSummary("@team of developers")
                .build());

        addFragment(new Step.Builder().setTitle("ABOUT")
                .setContent("It’s easy to get started with our online examination software. First you are able to write a short introduction. In this introduction you can write what participants can expect from your exam. After that, you can add questions (multiple choice, fill in the blanks or free text). To make your exam more lively, you can add an image, audio or video. An explanation of the answer will be shown after you’ve made the exam")
                .setBackgroundColor(Color.parseColor("#424242")) // int background color
                .setDrawable(R.drawable.examresult) // int top drawable
                .setSummary("")
                .build());
    }
    @Override
    public void finishTutorial() {
        // Your implementation
        Intent intent2=new Intent(this,ChooseUser.class);
        startActivity(intent2);
    }
}
