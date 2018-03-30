package com.it.acumen.slide;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by ohlordino on 30/3/18.
 */

public class QuestionHolder extends RecyclerView.ViewHolder {
    public TextView question;
    public Button a;
    public Button b;
    public Button c;
    public Button d;
    public Button correct;
    public RelativeLayout relativeLayout;

    public QuestionHolder(View itemView) {
        super(itemView);
        question = (TextView) itemView.findViewById(R.id.question);
        a = (Button) itemView.findViewById(R.id.a);
        b = (Button) itemView.findViewById(R.id.b);
        c = (Button) itemView.findViewById(R.id.c);
        d = (Button) itemView.findViewById(R.id.d);
        relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relLayout);
    }



}
