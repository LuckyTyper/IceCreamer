package com.temp.task.icecream;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.provider.CalendarContract;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class MainActivity extends AppCompatActivity {

    private  Drawer.Result drawerResult;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    public void onBackPressed()
    {
        if(drawerResult!=null && drawerResult.isDrawerOpen()){
            drawerResult.closeDrawer();
        }else{
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            if(toolbar!=null) {
                setSupportActionBar(toolbar);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }



            IProfile profile = new ProfileDrawerItem()
                    .withEmail("example@gmail.com")
                    .withIcon(getResources().getDrawable(R.drawable.unknown_male))
                    .withName("Username");

            AccountHeader.Result accHeader = new AccountHeader()
                    .withActivity(this)
                    .addProfiles(profile)
                    .withHeaderBackground(R.drawable.study_picture_01)
                    .withTextColor(Color.WHITE)
                    .build();

            drawerResult = new Drawer()
                    .withActivity(this)
                    .withAccountHeader(accHeader)
                    .withToolbar(toolbar)
                    .withDisplayBelowToolbar(true)
                    .withActionBarDrawerToggleAnimated(true)
                    .withSliderBackgroundColor(getResources().getColor(R.color.colorPrimary))
                    .addDrawerItems(
                            new PrimaryDrawerItem()
                                    .withName(R.string.nav_menu_item_home)
                                    .withTextColor(Color.WHITE)
                                    .withIdentifier(1)
                                    .withIcon(R.drawable.ic_home_white_18dp),
                            new DividerDrawerItem(),
                            new SecondaryDrawerItem()
                                    .withName(R.string.nav_menu_item_contacts)
                                    .withTextColor(Color.WHITE),
                            new SecondaryDrawerItem()
                                    .withName(R.string.nav_menu_item_email)
                                    .withTextColor(Color.WHITE),
                            new SecondaryDrawerItem()
                                    .withName(R.string.nav_menu_item_phone)
                                    .withTextColor(Color.WHITE)
                            )
                    .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener(){
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem)
                        {
                            Intent intent = new Intent(MainActivity.this, Contacts.class);
                            startActivity(intent);
                            MainActivity.this.overridePendingTransition(R.anim.enter, R.anim.exit);
                        }
                    })
                    .build();

            drawerResult.closeDrawer();

            Toast.makeText(this,"Greetings User!", Toast.LENGTH_LONG).show();

            recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);

            adapter = new RecyclerAdapter();
            recyclerView.setAdapter(adapter);
        }

    public static void OpenSpeedRead(View v)
    {
        Intent intent = new Intent(v.getContext(), speedRead.class);
        Activity activity = (Activity) v.getContext();
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.enter, R.anim.exit);
    }

    public static void OpenMindMaping(View v)
    {
        Intent intent = new Intent(v.getContext(), mindMaping.class);
        Activity activity = (Activity) v.getContext();
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.enter, R.anim.exit);
    }

    public static void OpenConcentration(View v)
    {
        Intent intent = new Intent(v.getContext(), concentration.class);
        Activity activity = (Activity) v.getContext();
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.enter, R.anim.exit);
    }

    }


