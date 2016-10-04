package com.jkb.automaxtrailersinc;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class LoadSheet extends AppCompatActivity {

    String totalNumberStr;
    int totalNumber = 0;
    int[] pos = new int[12];
    ImageView position1, position2, position3, position4, position34, position5, position6, position7, position8, position78, position9, position10;
    ImageView[] posLoc = new ImageView[12];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_sheet);

        position1 = (ImageView)findViewById(R.id.position1);
        position2 = (ImageView)findViewById(R.id.position2);
        position3 = (ImageView)findViewById(R.id.position3);
        position4 = (ImageView)findViewById(R.id.position4);
        position34 = (ImageView)findViewById(R.id.position34);
        position5 = (ImageView)findViewById(R.id.position5);
        position6 = (ImageView)findViewById(R.id.position6);
        position7 = (ImageView)findViewById(R.id.position7);
        position8 = (ImageView)findViewById(R.id.position8);
        position78 = (ImageView)findViewById(R.id.position78);
        position9 = (ImageView)findViewById(R.id.position9);
        position10 = (ImageView)findViewById(R.id.position10);

        posLoc[0] = position1;
        posLoc[1] = position2;
        posLoc[2] = position3;
        posLoc[3] = position4;
        posLoc[4] = position34;
        posLoc[5] = position5;
        posLoc[6] = position6;
        posLoc[7] = position7;
        posLoc[8] = position8;
        posLoc[9] = position78;
        posLoc[10] = position9;
        posLoc[11] = position10;

        Intent getData = getIntent();
        totalNumberStr = getData.getStringExtra("totalVehicles");
        totalNumber = Integer.parseInt(totalNumberStr);


        for (int i = 0; i < pos.length ; i++) {
            String holder = getData.getStringExtra("pos" + String.valueOf(i));
            pos[i] = Integer.parseInt(holder);
        }

        for (int i = 0; i < pos.length; i++) {
            System.out.println("Load Sheet - Position " + i +": " + pos[i]);

            //coupe=1, sedan=2, smallSuv=3, midSuv=4, bigSuv=5, smallTruck=6, bigTruck=7
            if (pos[i] == 1) {
                posLoc[i].setImageResource(R.drawable.coupe_small);
            } else if (pos[i] == 2) {
                posLoc[i].setImageResource(R.drawable.sedan_small);
            } else if (pos[i] == 3) {
                posLoc[i].setImageResource(R.drawable.crossover_small);
            } else if (pos[i] == 4) {
                posLoc[i].setImageResource(R.drawable.suv_small);
            } else if (pos[i] == 5) {
                posLoc[i].setImageResource(R.drawable.bigsuv_small);
            } else if (pos[i] == 6) {
                posLoc[i].setImageResource(R.drawable.smalltruck_small);
            } else if (pos[i] == 7) {
                posLoc[i].setImageResource(R.drawable.truck_small);
            }
        }
    }
}