package com.temp.task.icecream;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

public class mindMaping extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mind_maping);
    }

    public void onBackPressed()
    {
        Intent intent = new Intent(mindMaping.this, MainActivity.class);
        Activity activity = (Activity) mindMaping.this;
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.right_anim,R.anim.left_anim);
    }

}
