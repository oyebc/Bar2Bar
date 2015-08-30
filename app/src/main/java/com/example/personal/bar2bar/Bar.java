package com.example.personal.bar2bar;

/**
 * Object to represent bars available on the Bar2Bar Platform
 * Created by Oy on 8/25/2015.
 */
public class Bar {

    //public Bar(String Bar)
    private String barName;
    private int barRating;
    private String barLocation;//Coordinates??
    private String ongoingDeal="No special deal available";//Object on its own rights??

    public Bar(String barName, String location, int rating, String ongoingDeal)
    {
       this.barName = barName;
        this.barLocation= location;
        this.barRating = rating;
        this.ongoingDeal = ongoingDeal;
    }

    public String getBarLocation() {
        return barLocation;
    }

    public String getBarName(){
        return barName;
    }

    public int getBarRating(){
        return  barRating;
    }

    public String getOngoingDeal()
    {
        return ongoingDeal;
    }
}
