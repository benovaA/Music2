package com.example.adyhn.music;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimeLineActivity extends AppCompatActivity {

    private int sounda, soundb, soundbb, soundc, soundcis, soundd, sounddis, sounde, soundf, soundfis, soundg, soundgis, numberOfColumns;

    private Button bpm;

    private ImageButton play, start, pause, next, prev, end;

    private TextView tv_message;

    private GridView timeline, pianoRoll;

    private MediaPlayer mp = null;

    private SoundPool mySound = null;

    private final List<String> items = new ArrayList<String>();
    private final List<String> notes = new ArrayList<String>();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_activity);

        //int msWait = (60000/Integer.parseInt(bpm.getText().toString()))/2;

        numberOfColumns = 30;

        final int numberOfItems = numberOfColumns*12;

        notes.add("A");
        notes.add("Bb");
        notes.add("B");
        notes.add("C");
        notes.add("Cis");
        notes.add("D");
        notes.add("Dis");
        notes.add("E");
        notes.add("F");
        notes.add("Fis");
        notes.add("G");
        notes.add("Gis");


        for(int i = 0; i < numberOfItems; i++) {
            if(i < 30) {

                items.add("Gis");
            } else if(i < 60) {

                items.add("G");
            } else if(i < 90) {

                items.add("Fis");
            } else if(i < 120) {

                items.add("F");
            } else if(i < 150) {

                items.add("E");
            } else if(i < 180) {

                items.add("Dis");
            } else if(i < 210) {

                items.add("D");
            } else if(i < 240) {

                items.add("Cis");
            } else if(i < 270) {

                items.add("C");
            } else if(i < 300) {

                items.add("B");
            } else if(i < 330) {

                items.add("Bb");
            } else if(i < 360) {

                items.add("A");
            }

        }

        mySound = new SoundPool(12, AudioManager.STREAM_MUSIC,0);
        sounda = mySound.load(this, R.raw.sound_a,1);
        soundb = mySound.load(this, R.raw.sound_b,1);
        soundbb = mySound.load(this, R.raw.sound_bb,1);
        soundc = mySound.load(this, R.raw.sound_c,1);
        soundcis = mySound.load(this, R.raw.sound_cis,1);
        soundd = mySound.load(this, R.raw.sound_d,1);
        sounddis = mySound.load(this, R.raw.sound_dis,1);
        sounde = mySound.load(this, R.raw.sound_e,1);
        soundf = mySound.load(this, R.raw.sound_f,1);
        soundfis = mySound.load(this, R.raw.sound_fis,1);
        soundg = mySound.load(this, R.raw.sound_g,1);
        soundgis = mySound.load(this, R.raw.sound_gis,1);

        //Spustanie na sirku
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.setTheme(R.style.ThemeDark);

        //bpm = (Button) findViewById(R.id.bpm);
        start = (ImageButton) findViewById(R.id.start);
        end = (ImageButton) findViewById(R.id.end);
        pause = (ImageButton) findViewById(R.id.pause);
        next = (ImageButton) findViewById(R.id.next);
        prev = (ImageButton) findViewById(R.id.prev);
        play = (ImageButton) findViewById(R.id.play);
        bpm = (Button) findViewById(R.id.bpm);

        tv_message = (TextView) findViewById(R.id.tv_message);

        timeline = (GridView) findViewById(R.id.timeline);
        pianoRoll = (GridView) findViewById(R.id.pianoRoll);

        pianoRoll.setNumColumns(1);
        timeline.setNumColumns(numberOfColumns);




        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("NumColumns",timeline.getNumColumns()+"" );

                for(int j = 0; j < numberOfColumns; j++) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i = j; i < numberOfItems; i = i + numberOfColumns) {


                        TextView tv = (TextView) timeline.getChildAt(i);

                        if (("" + tv.getCurrentTextColor()).equals("-" + 16711936)) {

                            if (i < numberOfColumns) {
                                Log.d("sound", "sound 1");
                                sound(soundgis);
                            } else if (i < numberOfColumns*2) {
                                Log.d("sound", "sound 2");
                                sound(soundg);
                            } else if (i < numberOfColumns*3) {
                                Log.d("sound", "sound 3");
                                sound(soundfis);
                            } else if (i < numberOfColumns*4) {
                                Log.d("sound", "sound 3");
                                sound(soundf);
                            } else if (i < numberOfColumns*5) {
                                Log.d("sound", "sound 3");
                                sound(sounde);
                            } else if (i < numberOfColumns*6) {
                                Log.d("sound", "sound 3");
                                sound(sounddis);
                            } else if (i < numberOfColumns*7) {
                                Log.d("sound", "sound 3");
                                sound(soundd);
                            } else if (i < numberOfColumns*8) {
                                Log.d("sound", "sound 3");
                                sound(soundcis);
                            } else if (i < numberOfColumns*9) {
                                Log.d("sound", "sound 3");
                                sound(soundc);
                            } else if (i < numberOfColumns*10) {
                                Log.d("sound", "sound 3");
                                sound(soundb);
                            } else if (i < numberOfColumns*11) {
                                Log.d("sound", "sound 3");
                                sound(soundbb);
                            } else {
                                Log.d("sound", "sound 4");
                                sound(sounda);
                            }

                        }
                    }


                }


            }


        });



        // Populate a List from Array elements

        // Data bind GridView with ArrayAdapter (String Array elements)

        pianoRoll.setAdapter(new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, notes){
            public View getView(int position, View convertView, ViewGroup parent) {

                // Return the GridView current item as a View
                View view = super.getView(position,convertView,parent);

                // Convert the view as a TextView widget
                TextView tv = (TextView) view;



                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(170,35);
                tv.setLayoutParams(params);

                // Display TextView text in center position
                tv.setGravity(Gravity.CENTER);

                // Set the TextView text font family and text size
                tv.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);

                // Set the TextView text (GridView item text)
                tv.setText(items.get(position));


                switch (position) {
                    case 1: {

                        tv.setText("G");
                        tv.setBackgroundColor(Color.WHITE);
                        tv.setTextColor(Color.BLACK);
                        break;
                    }
                    case 3: {

                        tv.setText("F");
                        tv.setBackgroundColor(Color.WHITE);
                        tv.setTextColor(Color.BLACK);
                        break;
                    }
                    case 4: {

                        tv.setText("E");
                        tv.setBackgroundColor(Color.WHITE);
                        tv.setTextColor(Color.BLACK);
                        break;
                    }
                    case 6: {

                        tv.setText("D");
                        tv.setBackgroundColor(Color.WHITE);
                        tv.setTextColor(Color.BLACK);
                        break;
                    }
                    case 8: {

                        tv.setText("C");
                        tv.setBackgroundColor(Color.WHITE);
                        tv.setTextColor(Color.BLACK);
                        break;
                    }
                    case 9: {

                        tv.setText("B");
                        tv.setBackgroundColor(Color.WHITE);
                        tv.setTextColor(Color.BLACK);
                        break;
                    }
                    case 11: {

                        tv.setText("A");
                        tv.setBackgroundColor(Color.WHITE);
                        tv.setTextColor(Color.BLACK);
                        break;
                    }
                    case 0: {

                        tv.setText("Gis");
                        tv.setBackgroundColor(Color.BLACK);
                        tv.setTextColor(Color.WHITE);
                        break;
                    }

                    case 2: {

                        tv.setText("Fis");
                        tv.setBackgroundColor(Color.BLACK);
                        tv.setTextColor(Color.WHITE);
                        break;
                    }

                    case 5: {

                        tv.setText("Dis");
                        tv.setBackgroundColor(Color.BLACK);
                        tv.setTextColor(Color.WHITE);
                        break;
                    }

                    case 7: {

                        tv.setText("Cis");
                        tv.setBackgroundColor(Color.BLACK);
                        tv.setTextColor(Color.WHITE);
                        break;
                    }

                    case 10: {

                        tv.setText("Bb");
                        tv.setBackgroundColor(Color.BLACK);
                        tv.setTextColor(Color.WHITE);
                        break;
                    }
                }


                // Return the TextView widget as GridView item
                return tv;
            }
        });

        timeline.setAdapter(new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, items){
            public View getView(int position, View convertView, ViewGroup parent) {

                // Return the GridView current item as a View
                View view = super.getView(position,convertView,parent);

                // Convert the view as a TextView widget
                TextView tv = (TextView) view;

                // set the TextView text color (GridView item color)
                tv.setTextColor(Color.GRAY);

                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(58,35);
                tv.setLayoutParams(params);


                // Display TextView text in center position
                tv.setGravity(Gravity.CENTER);

                // Set the TextView text font family and text size
                tv.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);

                // Set the TextView text (GridView item text)
                tv.setText(items.get(position));

                // Set the TextView background color
                tv.setBackgroundColor(Color.GRAY);

                // Return the TextView widget as GridView item
                return tv;
            }
        });

        pianoRoll.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item text
                String selectedItem = parent.getItemAtPosition(position).toString();



                // Get the current selected view as a TextView
                TextView tv = (TextView) view;


                Log.d("Position",position+"");

                switch (position) {

                    case 0: {

                        sound(soundgis);
                        break;
                    }
                    case 1: {

                        sound(soundg);
                        break;
                    }
                    case 2: {

                        sound(soundfis);
                        break;
                    }
                    case 3: {

                        sound(soundf);
                        break;
                    }
                    case 4: {

                        sound(sounde);
                        break;
                    }
                    case 5: {

                        sound(sounddis);
                        break;
                    }
                    case 6: {

                        sound(soundd);
                        break;
                    }
                    case 7: {

                        sound(soundcis);
                        break;
                    }
                    case 8: {

                        sound(soundc);
                        break;
                    }
                    case 9: {

                        sound(soundb);
                        break;
                    }
                    case 10: {

                        sound(soundbb);
                        break;
                    }
                    case 11: {

                        sound(sounda);
                        break;
                    }
                }

                Log.d("Color",tv.getCurrentTextColor()+"");

                // Set the current selected item background color


                // Set the current selected item text color

            }
        });

        timeline.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item text
                String selectedItem = parent.getItemAtPosition(position).toString();

                // Display the selected item text to app interface
                tv_message.setText("Selected item : " + selectedItem);



                // Get the current selected view as a TextView
                TextView tv = (TextView) view;


                Log.d("Position",position+"");

                if((""+tv.getCurrentTextColor()).equals("-"+16711936)) {
                    tv.setBackgroundColor(Color.GRAY);
                    tv.setTextColor(Color.GRAY);
                } else {

                    tv.setBackgroundColor(Color.GREEN);
                    tv.setTextColor(Color.GREEN);
                }

                Log.d("Color",tv.getCurrentTextColor()+"");

                // Set the current selected item background color


                // Set the current selected item text color

            }
        });
    }

    public void sound(int soundID) {


        mySound.play(soundID,1,1,1,0,1);
    }
}
