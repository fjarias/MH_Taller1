package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class TercerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    int ments2;
    int ments3;
    int[] valoresSpinners;

    static final String[] age = new String[] {"< 20 yo","21-40 yo","41-50 yo","51-65 yo",">65 yo"};
    static final String[] lungDisease = new String[] {"None","Minimal (Rare Inhaler)","< Minimal"};
    static final String[] OSA = new String[] {"Not present","Mild/Moderate (no CPAP)","On CPAP"};
    static final String[] CVDisease = new String[] {"None","Minimal (no meds)","Mild (1 med)","Moderate (2 meds)","Severe >= 3 meds"};
    static final String[] diabetes = new String[] {"None","Mild (no meds)","Moderate (PO meds only)","> Moderate (insulin)"};
    static final String[] immunocompromised = new String[] {"No","Moderate","Severe"};
    static final String[] IliSx = new String[] {"None (Asymptomatic)","Yes"};
    static final String[] exposureCOVID19 = new String[] {"No","Probably Not","Possibly","Probably","Yes"};

    Spinner spAge;
    Spinner spLungDisease;
    Spinner spOSA;
    Spinner spCVDisease;
    Spinner spDiabetes;
    Spinner spImmunocompromised;
    Spinner spIliSx;
    Spinner spExposureCOVID19;
    TextView tvMent3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer);

        setTitle("MeNTS Calculator");

        valoresSpinners = new int[8];
        int i;
        for (i = 0;i < 8;i++) {
            valoresSpinners[i] = 0;
        }
        tvMent3 = findViewById(R.id.tvMent3);
        spAge = findViewById(R.id.spAge);
        spLungDisease = findViewById(R.id.spLungDisease);
        spOSA = findViewById(R.id.spOSA);
        spCVDisease = findViewById(R.id.spCVDisease);
        spDiabetes =  findViewById(R.id.spDiabetes);
        spImmunocompromised = findViewById(R.id.spImmunocompromised);
        spIliSx = findViewById(R.id.spIliSx);
        spExposureCOVID19 = findViewById(R.id.spExposureCOVID19);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, age);
        spAge.setAdapter(adapter);
        spAge.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lungDisease);
        spLungDisease.setAdapter(adapter1);
        spLungDisease.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, OSA);
        spOSA.setAdapter(adapter2);
        spOSA.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CVDisease);
        spCVDisease.setAdapter(adapter3);
        spCVDisease.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, diabetes);
        spDiabetes.setAdapter(adapter4);
        spDiabetes.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, immunocompromised);
        spImmunocompromised.setAdapter(adapter5);
        spImmunocompromised.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, IliSx);
        spIliSx.setAdapter(adapter6);
        spIliSx.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter7 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, exposureCOVID19);
        spExposureCOVID19.setAdapter(adapter7);
        spExposureCOVID19.setOnItemSelectedListener(this);

        Bundle extras = getIntent().getExtras();
        ments2 = extras.getInt("ments");

        // Manejador eventos botón Next
        findViewById(R.id.btnReset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PrimerActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        switch (parent.getId()) {
            case R.id.spAge:
                valoresSpinners[0] = pos + 1;
                break;
            case R.id.spLungDisease:
                if (pos == 0)
                    valoresSpinners[1] = 1;

                if (pos == 1)
                    valoresSpinners[1] = 4;

                if (pos == 2)
                    valoresSpinners[1] = 5;
                break;
            case R.id.spOSA:
                if (pos == 0)
                    valoresSpinners[2] = 1;

                if (pos == 1)
                    valoresSpinners[2] = 4;

                if (pos == 2)
                    valoresSpinners[2] = 5;
                break;
            case R.id.spCVDisease:
                valoresSpinners[3] = pos + 1;
                break;
            case R.id.spDiabetes:
                if (pos == 0)
                    valoresSpinners[4] = 1;

                if (pos == 1)
                    valoresSpinners[4] = 3;

                if (pos == 2)
                    valoresSpinners[4] = 4;

                if (pos == 3)
                    valoresSpinners[4] = 5;
                break;
            case R.id.spImmunocompromised:
                if (pos == 0)
                    valoresSpinners[5] = 1;

                if (pos == 1)
                    valoresSpinners[5] = 4;

                if (pos == 2)
                    valoresSpinners[5] = 5;
                break;
            case R.id.spIliSx:
                if (pos == 0)
                    valoresSpinners[6] = 1;

                if (pos == 1)
                    valoresSpinners[6] = 5;
                break;
            case R.id.spExposureCOVID19:
                valoresSpinners[7] = pos + 1;
                break;
        }
        sumarParametros();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void sumarParametros(){
        int i, total;
        total = 0;
        for (i = 0;i < 8;i++){
            total += valoresSpinners[i];
        }
        ments3 = ments2 + total;
        tvMent3.setText(Integer.toString(ments3));
    }
}