package com.example.fabbugapplication;

import android.content.res.ColorStateList;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity
        extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting colors of first fab
        FloatingActionButton fab =
                (FloatingActionButton) findViewById(R.id.fab_1);
        setFloatingActionButtonColors(fab,
                getResources().getColor(R.color.blue),
                getResources().getColor(R.color.blue_dark));

        //Setting colors of second fab
        fab = (FloatingActionButton) findViewById(R.id.fab_2);
        setFloatingActionButtonColors(fab,
                getResources().getColor(R.color.red),
                getResources().getColor(R.color.red_dark));

        //Setting colors of third fab
        final FloatingActionButton clickableFab = (FloatingActionButton) findViewById(R.id.fab_3);
        setFloatingActionButtonColors(clickableFab,
                getResources().getColor(R.color.green),
                getResources().getColor(R.color.green_dark));
        clickableFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFloatingActionButtonColors(clickableFab,
                        getResources().getColor(R.color.purple),
                        getResources().getColor(R.color.purple_dark));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setFloatingActionButtonColors(FloatingActionButton fab,
                                               int primaryColor,
                                               int rippleColor)
    {
        int[][] states = {
                {android.R.attr.state_enabled},
                {android.R.attr.state_pressed},
        };

        int[] colors = {
                primaryColor,
                rippleColor,
        };

        ColorStateList colorStateList = new ColorStateList(states, colors);
        fab.setBackgroundTintList(colorStateList);
    }
}
