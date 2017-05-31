package com.temp.task.icecream;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class speedRead extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_read);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.speedread_progressbar);
        progressBar.setProgress(1);

        TextView textView = (TextView) findViewById(R.id.speedread_txtDesc);

        switch (progressBar.getProgress()) {
            case 1: textView.setText("beginner");
                break;
            case 2:  textView.setText("normal");
                break;
            default: textView.setText("advanced");
                break;
        }

        ImageView imageView = (ImageView) findViewById(R.id.speedread_back_img);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {

                    Intent intent = new Intent(speedRead.this, MainActivity.class);
                    Activity activity = (Activity) speedRead.this;
                    activity.startActivity(intent);
                    activity.overridePendingTransition(R.anim.right_anim,R.anim.left_anim);
                }
            });

    }

    public void onBackPressed()
    {
        Intent intent = new Intent(speedRead.this, MainActivity.class);
        Activity activity = (Activity) speedRead.this;
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.right_anim,R.anim.left_anim);



    }



}
