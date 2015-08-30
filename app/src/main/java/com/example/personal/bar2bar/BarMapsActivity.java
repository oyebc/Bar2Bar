package com.example.personal.bar2bar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.SlidingDrawer;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class BarMapsActivity extends FragmentActivity implements View.OnClickListener {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private Button slideHandleButton, button1, button2, button3;
    private SlidingDrawer slidingDrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_maps);
        setUpMapIfNeeded();
        slidingDrawer = (SlidingDrawer)findViewById(R.id.SlidingDrawer);
        slideHandleButton = (Button) findViewById(R.id.slideHandleButton);
      // button1 = (Button) findViewById(R.id.Button01);
     //   button2 = (Button) findViewById(R.id.Button02);
     //   button3 = (Button) findViewById(R.id.Button03);

     //   button1.setOnClickListener(this);
     //   button2.setOnClickListener(this);
      //  button3.setOnClickListener(this);

        slidingDrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
            @Override
            public void onDrawerOpened() {

            }
        });

        slidingDrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {
            @Override
            public void onDrawerClosed() {

            }
        });

        //custom searchView colour
       SearchView searchView = (SearchView)findViewById(R.id.searchView);
        int searchPlateId = searchView.getContext().getResources().getIdentifier("android:id/search_plate", null, null);
        View searchPlate = searchView.findViewById(searchPlateId);
        searchPlate.setBackgroundResource(R.drawable.textfield_search_selected_holo_light_green);
        //custom searchView icon
       int defaultSearchIconId = searchView.getContext().getResources().getIdentifier("android:id/search_button", null, null);
        ImageView searchImageView = (ImageView)searchView.findViewById(defaultSearchIconId);
        Bitmap searchIcon = BitmapFactory.decodeResource(getResources(),R.drawable.search_icon);
        searchImageView.setMaxHeight(32);
        searchImageView.setMaxWidth(32);
       // searchImageView.
        searchImageView.setImageBitmap(Bitmap.createScaledBitmap(searchIcon, searchIcon.getWidth() / 2, searchIcon.getHeight() / 2, true));//resize and use as new icon
       // searchView.setBackgroundColor(Color.WHITE);

       // searchView.setOnQueryTextListener(this);

        //BarView
        LinearLayout barLinearLayout = (LinearLayout)findViewById(R.id.contentLayout);
        barLinearLayout.addView(new BarView(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
        mMap.setMyLocationEnabled(true);
    }

    @Override
    public void onClick(View v)
    {
        Button clickedButton = (Button)v;
        Toast.makeText(BarMapsActivity.this,clickedButton.getText()+ " Clicked", Toast.LENGTH_SHORT).show();
    }
}
