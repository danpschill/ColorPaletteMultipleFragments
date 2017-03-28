package edu.temple.colorpalettemultiplefragments;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements PaletteFragment.PaletteInterface {

    PaletteFragment paletteFragment;
    CanvasFragment canvasFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paletteFragment = new PaletteFragment(this);
        canvasFragment = new CanvasFragment();

        getFragmentManager()
                .beginTransaction()
                .add(R.id.container1, paletteFragment)
                .commit();
        getFragmentManager()
                .beginTransaction()
                .add(R.id.container2, canvasFragment)
                .commit();








    }


    @Override
    public void getColor(String color) {
        canvasFragment.setColor(color);
    }
}
