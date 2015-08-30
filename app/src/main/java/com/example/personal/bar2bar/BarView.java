package com.example.personal.bar2bar;

import android.content.Context;
import android.view.Gravity;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Oy on 8/25/2015.
 */
public class BarView extends RelativeLayout {

    private TextView barNameView;
    private TextView distanceView;
    private RatingBar barRatings;

    public BarView(Context context, Bar bar)
    {
        super(context);

        this.setBackgroundResource(R.color.bar_green_translucent);
        this.setGravity(Gravity.TOP);
        RelativeLayout.LayoutParams barViewParams = new RelativeLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        this.setLayoutParams(barViewParams);

        barNameView = new TextView(context, null, R.style.BarView);
        distanceView = new TextView(context, null, R.style.BarView);
        barRatings = new RatingBar(context, null, android.R.attr.ratingBarStyleSmall);

       // RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        barNameView.setText("Slumdog Grill & Bar");
        barNameView.setTextAppearance(context, R.style.BarView);
        barNameView.setId(111);
        RelativeLayout.LayoutParams barNameParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        barNameParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        barNameParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        barNameView.setLayoutParams(barNameParams);
        barNameView.setPadding(6, 6, 6, 6);

        distanceView.setText("1.9km");
        distanceView.setTextAppearance(context, R.style.BarView);
        RelativeLayout.LayoutParams distanceViewParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        distanceViewParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        distanceViewParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        distanceView.setLayoutParams(distanceViewParams);
        distanceView.setPadding(6,6,6,6);

        barRatings.setNumStars(5);
        barRatings.setRating(3.5f);
        barRatings.setIsIndicator(true);
        RelativeLayout.LayoutParams barRatingParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        barRatingParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT );
        barRatingParams.addRule(RelativeLayout.BELOW,barNameView.getId());
       // barRatingParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        barRatings.setLayoutParams(barRatingParams);
        barRatings.setPadding(6,6,6,6);

        this.addView(barNameView);
        this.addView(barRatings);
    }


}
