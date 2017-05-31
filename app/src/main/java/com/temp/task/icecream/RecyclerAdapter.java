package com.temp.task.icecream;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.Image;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by User on 31.05.2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private String[] titles =
            {
                    "Title1",
                    "Title2",
                    "Title3",
                    "SomeTitel",
                    "SomeTitel",
                    "SomeTitel",
                    "SomeTitel"
            };

    private String[] difficulty =
            {
                    "beginner",
                    "normal",
                    "advanced"
            };

    private int[] progress =
            {
                    1,
                    2,
                    3,
                    3,
                    2,
                    1,
                    2
            };

    private int[] images =
            {
                    R.drawable.ic_motorcycle_white_48dp,
                    R.drawable.ic_rowing_white_48dp,
                    R.drawable.ic_shopping_cart_white_48dp,
                    R.drawable.ic_pets_white_48dp,
                    R.drawable.ic_pets_white_48dp,
                    R.drawable.ic_pets_white_48dp,
                    R.drawable.ic_pets_white_48dp
            };

    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public ProgressBar progressBar;
        public TextView itemDesc;
        public ImageView goImage;

        public ViewHolder(View itemView)
        {
            super(itemView);
            itemImage = (ImageView)itemView.findViewById(R.id.imgMsg);
            itemTitle = (TextView) itemView.findViewById(R.id.txtMsg);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressbar);
            itemDesc = (TextView) itemView.findViewById(R.id.txtDesc);
            goImage = (ImageView) itemView.findViewById(R.id.GoImg);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();

                    switch (position) {
                        case 0:
                            MainActivity.OpenSpeedRead(v);
                            break;
                        case 1:
                            MainActivity.OpenMindMaping(v);
                            break;
                        default:
                            MainActivity.OpenConcentration(v);
                            break;
                    }
                }
            });

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.progressBar.getIndeterminateDrawable().setColorFilter(Color.rgb(217, 123, 41), PorterDuff.Mode.MULTIPLY);
       // viewHolder.progressBar.getProgressDrawable().setColorFilter(
       //         android.graphics.Color.rgb(217, 123, 41), android.graphics.PorterDuff.Mode.SRC_IN);
        viewHolder.progressBar.setProgress(progress[i]);
        viewHolder.itemImage.setImageResource(images[i]);
        viewHolder.itemDesc.setText(difficulty[progress[i] - 1]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
