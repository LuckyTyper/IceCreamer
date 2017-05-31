package com.temp.task.icecream;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

public class concentration extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concentration);
    }

    public void onBackPressed()
    {
        Intent intent = new Intent(concentration.this, MainActivity.class);
        Activity activity = (Activity) concentration.this;
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.right_anim,R.anim.left_anim);
    }
}
