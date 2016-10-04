package com.jkb.automaxtrailersinc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LoadInfo extends AppCompatActivity {

    RelativeLayout loadInfo;
    RelativeLayout popUpLayout;
    RelativeLayout recentLoadsLayout;
    NumberPicker np;

    ImageView coupe;
    ImageView sedan;
    ImageView smallSuv;
    ImageView midSuv;
    ImageView bigSuv;
    ImageView smallTruck;
    ImageView bigTruck;

    PopupWindow popUp;

    TextView totalNumberTV;
    TextView error;
    TextView recentLoadsTV;

    TextView coupeNum;
    TextView sedanNum;
    TextView smallSuvNum;
    TextView midSuvNum;
    TextView bigSuvNum;
    TextView smallTruckNum;
    TextView bigTruckNum;

    Button submit;

    int singleTotal;
    int coupeTot;
    int sedanTot;
    int smallSuvTot;
    int midSuvTot;
    int bigSuvTot;
    int smallTruckTot;
    int bigTruckTot;
    int totalNumber;

    int[] position = new int[12];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_info);
        setTitle("Load Information");
        loadInfo = (RelativeLayout)findViewById(R.id.loadInfo);
        popUpLayout = (RelativeLayout)findViewById(R.id.popUp);
        recentLoadsLayout = (RelativeLayout)findViewById(R.id.recentLoadsRL);
        totalNumberTV = (TextView)findViewById(R.id.totalVehicles);
        error = (TextView)findViewById(R.id.error);
        recentLoadsTV = (TextView)findViewById(R.id.recentLoads);
        coupeNum = (TextView)findViewById(R.id.coupeTV);
        sedanNum = (TextView)findViewById(R.id.sedanTV);
        smallSuvNum = (TextView)findViewById(R.id.smallSuvTV);
        midSuvNum = (TextView)findViewById(R.id.midSuvTV);
        bigSuvNum = (TextView)findViewById(R.id.bigSuvTV);
        smallTruckNum = (TextView)findViewById(R.id.smallTruckTV);
        bigTruckNum = (TextView)findViewById(R.id.bigTruckTV);
        submit = (Button)findViewById(R.id.button);

        singleTotal = 0;
        coupeTot = 0;
        sedanTot = 0;
        smallSuvTot = 0;
        midSuvTot = 0;
        bigSuvTot = 0;
        smallTruckTot = 0;
        bigTruckTot = 0;
        totalNumber = 0;

        np = new NumberPicker(this);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);

        params.addRule(RelativeLayout.CENTER_IN_PARENT);

        np.setLayoutParams(params);
        np.setMinValue(0);
        np.setMaxValue(10);
        np.setWrapSelectorWheel(true);

        popUpLayout.addView(np);

        coupe = (ImageView)findViewById(R.id.imageView2);
        sedan = (ImageView)findViewById(R.id.imageView5);
        smallSuv = (ImageView)findViewById(R.id.imageView4);
        midSuv = (ImageView)findViewById(R.id.imageView9);
        bigSuv = (ImageView)findViewById(R.id.imageView10);
        smallTruck = (ImageView)findViewById(R.id.imageView3);
        bigTruck = (ImageView)findViewById(R.id.imageView8);

        popUp = new PopupWindow(this);

        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                // TODO Auto-generated method stub
                setNumber(newVal);
            }
        });
    }

    public void coupeClick(View view) {
        coupe.setAlpha(1f);
        popUpLayout.setVisibility(RelativeLayout.VISIBLE);
        coupe.bringToFront();
        coupe.invalidate();
        popUpLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                np.setValue(0);
                popUpLayout.setVisibility(RelativeLayout.INVISIBLE);
                coupeTot = singleTotal;
                coupeNum.setText(String.valueOf(coupeTot));
                calcTotalVehicles();
                if (coupeTot == 0) {
                    coupe.setAlpha(.5f);
                }
            }
        });
    }

    public void sedanClick(View view) {
        sedan.setAlpha(1f);
        popUpLayout.setVisibility(RelativeLayout.VISIBLE);
        popUpLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                np.setValue(0);
                popUpLayout.setVisibility(RelativeLayout.INVISIBLE);
                sedanTot = singleTotal;
                sedanNum.setText(String.valueOf(sedanTot));
                calcTotalVehicles();
                if (sedanTot == 0) {
                    sedan.setAlpha(.5f);
                }
            }
        });
    }

    public void smallSuvClick(View view) {
        smallSuv.setAlpha(1f);
        popUpLayout.setVisibility(RelativeLayout.VISIBLE);
        popUpLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                np.setValue(0);
                popUpLayout.setVisibility(RelativeLayout.INVISIBLE);
                smallSuvTot = singleTotal;
                smallSuvNum.setText(String.valueOf(smallSuvTot));
                calcTotalVehicles();
                if (smallSuvTot == 0) {
                    smallSuv.setAlpha(.5f);
                }
            }
        });
    }

    public void midSuvClick(View view) {
        midSuv.setAlpha(1f);
        popUpLayout.setVisibility(RelativeLayout.VISIBLE);
        popUpLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                np.setValue(0);
                popUpLayout.setVisibility(RelativeLayout.INVISIBLE);
                midSuvTot = singleTotal;
                midSuvNum.setText(String.valueOf(midSuvTot));
                calcTotalVehicles();

                if (midSuvTot == 0) {
                    midSuv.setAlpha(.5f);
                }
            }
        });
    }

    public void bigSuvClick(View view) {
        bigSuv.setAlpha(1f);
        popUpLayout.setVisibility(RelativeLayout.VISIBLE);
        popUpLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                np.setValue(0);
                popUpLayout.setVisibility(RelativeLayout.INVISIBLE);
                bigSuvTot = singleTotal;
                bigSuvNum.setText(String.valueOf(bigSuvTot));
                calcTotalVehicles();

                if (bigSuvTot == 0) {
                    bigSuv.setAlpha(.5f);
                }
            }
        });
    }

    public void smallTruckClick(View view) {
        smallTruck.setAlpha(1f);
        popUpLayout.setVisibility(RelativeLayout.VISIBLE);
        popUpLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                np.setValue(0);
                popUpLayout.setVisibility(RelativeLayout.INVISIBLE);
                smallTruckTot = singleTotal;
                smallTruckNum.setText(String.valueOf(smallTruckTot));
                calcTotalVehicles();
                if (smallTruckTot == 0) {
                    smallTruck.setAlpha(.5f);
                }
            }
        });
    }

    public void bigTruckClick(View view) {
        bigTruck.setAlpha(1f);
        popUpLayout.setVisibility(RelativeLayout.VISIBLE);
        popUpLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                np.setValue(0);
                popUpLayout.setVisibility(RelativeLayout.INVISIBLE);
                bigTruckTot = singleTotal;
                bigTruckNum.setText(String.valueOf(bigTruckTot));
                calcTotalVehicles();
                if (bigTruckTot == 0) {
                    bigTruck.setAlpha(.5f);
                }
            }
        });
    }

    public void setNumber(int num) {
        singleTotal = num;
    }

    public void calcTotalVehicles() {
        checkForError();
        totalNumber = coupeTot + sedanTot + smallSuvTot + midSuvTot + bigSuvTot + smallTruckTot + bigTruckTot;
        totalNumberTV.setText("Total Vehicles: " + totalNumber);
    }

    public void checkForError() {
        int a = bigTruckTot + bigSuvTot;
        int b = coupeTot + sedanTot + smallSuvTot + midSuvTot + smallTruckTot;

        if (a > 6) {
            error.setText("Overweight. Reduce load.");
            submit.setEnabled(false);
        } else if (a == 6 && b > 0) {
            error.setText("Overweight. Reduce load.");
            submit.setEnabled(false);
        } else if (a == 5 && b > 3) {
            error.setText("Overweight. Reduce load.");
            submit.setEnabled(false);
        } else if (a == 4 && b > 4) {
            error.setText("Overweight. Reduce load.");
            submit.setEnabled(false);
        } else if (a == 3 && b > 5) {
            error.setText("Overweight. Reduce load.");
            submit.setEnabled(false);
        } else if (a == 2 && b > 7) {
            error.setText("Overweight. Reduce load.");
            submit.setEnabled(false);
        } else if (coupeTot + sedanTot + smallSuvTot + midSuvTot + bigSuvTot + smallTruckTot + bigTruckTot > 10) {
            error.setText("Please select 10 vehicles or less.");
            submit.setEnabled(false);
        } else {
            error.setText("");
            submit.setEnabled(true);
        }
    }

    //Last Loads Database
    /**public void saveToDB() {

        try {

            SQLiteDatabase recentLoads = openOrCreateDatabase("Recent Loads", MODE_PRIVATE, null);
            recentLoads.execSQL("CREATE TABLE IF NOT EXISTS loads2 (coupe INTEGER(2), sedan INTEGER(2), crossover INTEGER(2), smallTruck INTEGER(2), midSuv INTEGER(2), id INTEGER PRIMARY KEY)");
            recentLoads.execSQL("INSERT INTO loads2 (coupe, sedan, crossover, smallTruck, midSuv) VALUES ('"+coupeTot+"', '"+sedanTot+"', '"+smallSuvTot+"', '"+smallTruckTot+"', '"+midSuvTot+"')");

            Cursor c = recentLoads.rawQuery("SELECT * FROM loads2", null);
            int coupeIndex = c.getColumnIndex("coupe");
            int sedanIndex = c.getColumnIndex("sedan");
            int smallSuvIndex = c.getColumnIndex("crossover");
            int smallTruckIndex = c.getColumnIndex("smallTruck");
            int midSuvIndex = c.getColumnIndex("midSuv");
            int idIndex = c.getColumnIndex("id");


            c.moveToFirst();

            while(c != null) {
                recentLoadsMessage += c.getString(coupeIndex) + " - " + c.getString(sedanIndex) + " - " + c.getString(smallSuvIndex) + " - " + c.getString(smallTruckIndex) + " - " + c.getString(midSuvIndex) + "\r\n";
                recentLoadsTV.setText(recentLoadsMessage);

                Log.i("GradeResults - coupe", c.getString(coupeIndex));
                Log.i("GradeResults - sedan", c.getString(sedanIndex));
                Log.i("GradeResults - smallSuv", c.getString(smallSuvIndex));
                Log.i("GradeResults - smallTruck", c.getString(smallTruckIndex));
                Log.i("GradeResults - midSuv", c.getString(midSuvIndex));

                c.moveToNext();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }**/

    public void reset(View view) {
        coupeTot = 0;
        sedanTot = 0;
        smallSuvTot = 0;
        smallTruckTot = 0;
        midSuvTot = 0;
        bigTruckTot = 0;
        bigSuvTot = 0;
        calcTotalVehicles();

        if (coupeTot == 0) {
            coupe.setAlpha(.5f);
        }
        if (sedanTot == 0) {
            sedan.setAlpha(.5f);
        }
        if (smallSuvTot == 0) {
            smallSuv.setAlpha(.5f);
        }
        if (smallTruckTot == 0) {
            smallTruck.setAlpha(.5f);
        }
        if (midSuvTot == 0) {
            midSuv.setAlpha(.5f);
        }
        if (bigTruckTot == 0) {
            bigTruck.setAlpha(.5f);
        }
        if (bigSuvTot == 0) {
            bigSuv.setAlpha(.5f);
        }

        coupeNum.setText(String.valueOf(coupeTot));
        sedanNum.setText(String.valueOf(sedanTot));
        smallSuvNum.setText(String.valueOf(smallSuvTot));
        midSuvNum.setText(String.valueOf(midSuvTot));
        bigSuvNum.setText(String.valueOf(bigSuvTot));
        smallTruckNum.setText(String.valueOf(smallTruckTot));
        bigTruckNum.setText(String.valueOf(bigTruckTot));
        error.setText("");
    }

    public void submit(View view) {
        //saveToDB();
        //coupe=1, sedan=2, smallSuv=3, midSuv=4, bigSuv=5, smallTruck=6, bigTruck=7
        for (int i = 0; i < position.length; i++) {
            position[i] = -1;
        }

        //Position smallTrucks
        //Position 1
        if (bigTruckTot > 0) {
            position[0] = 7;
            bigTruckTot--;
        } else if (bigSuvTot > 0) {
            position[0] = 5;
            bigSuvTot--;
        }

        //Position 2
        /**if (smallTruckTot > 0) {
            position[1] = 3;
         smallTruckTot--;
        } else if (midSuvTot > 0) {
            position[1] = 5;
         midSuvTot--;
        }**/

        //Position 5
        if (bigTruckTot > 0) {
            position[5] = 7;
            bigTruckTot--;
        } else if (bigSuvTot > 0) {
            position[5] = 5;
            bigSuvTot--;
        }

        //Position 3/4
        if (bigTruckTot > 0) {
            position[4] = 7;
            bigTruckTot--;
            position[2] = -2;
            position[3] = -2;
        } else if (bigSuvTot > 0) {
            position[4] = 5;
            bigSuvTot--;
            position[2] = -2;
            position[3] = -2;
        } else {
            position[4] = -2;
        }

        //Position 10
        if (bigSuvTot > 0) {
            position[11] = 5;
            bigSuvTot--;
        } else if (bigTruckTot > 0) {
            position[11] = 7;
            bigTruckTot--;
        }

        //Position 7/8
        if (bigTruckTot > 0) {
            position[9] = 7;
            bigTruckTot--;
            position[7] = -2;
            position[8] = -2;
        } else if (bigSuvTot > 0) {
            position[9] = 5;
            bigSuvTot--;
            position[7] = -2;
            position[8] = -2;
        } else {
            position[9] = -2;
        }

        //Make room for smallTrucks in position 4 and 8
        /**if (position[3] == 3) {
            position[2] = -2;
        }

        if (position[7] == 3) {
            position[6] = -2;
        }**/

        //Load coupes everywhere else
            for (int i = 0; i < position.length; i++) {
                if (coupeTot > 0) {
                    if (position[i] == -1) {
                        position[i] = 1;
                        coupeTot--;
                    }
                }
        }

        //Load sedans everywhere else
        for (int i = 0; i < position.length; i++) {
            if (sedanTot > 0) {
                if (position[i] == -1) {
                    position[i] = 2;
                    sedanTot--;
                }
            }
        }

        //Load small SUVs everywhere else
        for (int i = 0; i < position.length; i++) {
            if (smallSuvTot > 0) {
                if (position[i] == -1) {
                    position[i] = 3;
                    smallSuvTot--;
                }
            }
        }

        //Load medium SUVs everywhere else
        for (int i = 0; i < position.length; i++) {
            if (midSuvTot > 0) {
                if (position[i] == -1) {
                    position[i] = 4;
                    midSuvTot--;
                }
            }
        }

        //Load small trucks everywhere else
        for (int i = 0; i < position.length; i++) {
            if (smallTruckTot > 0) {
                if (position[i] == -1) {
                    position[i] = 6;
                    smallTruckTot--;
                }
            }
        }

        Intent positionData = new Intent(getApplicationContext(), LoadSheet.class);
        positionData.putExtra("totalVehicles", String.valueOf(totalNumber));
        for (int i = 0; i < position.length; i++) {
            positionData.putExtra("pos" + String.valueOf(i), String.valueOf(position[i]));
            System.out.println("Load Info - Position " + i + ": " + position[i]);
        }
        startActivity(positionData);
    }
}