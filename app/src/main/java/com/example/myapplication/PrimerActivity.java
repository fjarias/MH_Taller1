package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class PrimerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    int[] valoresSpinners;

    static final String[] orTime = new String[] {"< 30","31-60","61-120","121-180",">181"};
    static final String[] losAnticipated = new String[] {"out patient","23 hrs","24-48 hrs","< 3d",">4d"};
    static final String[] postOpICU = new String[] {"very unlikely","< 5%","5%-10%","11%-25%","> 25%"};
    static final String[] bleedingRisk = new String[] {"< 100","101-250","251-500","501-750","> 750"};
    static final String[] surgicalSize = new String[] {"1","2","3","4","> 4"};
    static final String[] intubation = new String[] {"< 1%","1%-5%","6%-10%","11%-25%","> 25%"};
    static final String[] surgicalSite = new String[] {"none of the following","adbominopelvic MIS surgery","abdominopelvic Open Surgery (infraumbilical)","abdominopelvic Open Surgery (supraumbilical)","OHNS/Upper GI/Thoracic"};
    Spinner spORTime;
    Spinner spLosAnticipated;
    Spinner spPostOPICU;
    Spinner spBleeding;
    Spinner spSurgicalSize;
    Spinner spIntubation;
    Spinner spSurgicalSite;

    TextView tvMents;
    int ments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primer);

        setTitle("MeNTS Calculator");

        valoresSpinners = new int[7];
        int i;
        for (i = 0;i < 7;i++) {
            valoresSpinners[i] = 0;
        }

        tvMents = findViewById(R.id.tvMents);
        spORTime = findViewById(R.id.spORTime);
        spLosAnticipated = findViewById(R.id.spLosAnticipated);
        spPostOPICU=findViewById(R.id.spPostOpICU);
        spBleeding=findViewById(R.id.spBleeding);
        spSurgicalSize=findViewById(R.id.spSurgicalSize);
        spIntubation=findViewById(R.id.spIntubation);
        spSurgicalSite=findViewById(R.id.spSurgicalSite);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, orTime);
        spORTime.setAdapter(adapter);
        spORTime.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, losAnticipated);
        spLosAnticipated.setAdapter(adapter1);
        spLosAnticipated.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, postOpICU);
        spPostOPICU.setAdapter(adapter2);
        spPostOPICU.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bleedingRisk);
        spBleeding.setAdapter(adapter3);
        spBleeding.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, surgicalSize);
        spSurgicalSize.setAdapter(adapter4);
        spSurgicalSize.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, intubation);
        spIntubation.setAdapter(adapter5);
        spIntubation.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, surgicalSite);
        spSurgicalSite.setAdapter(adapter6);
        spSurgicalSite.setOnItemSelectedListener(this);


        // Manejador eventos botón Next
        findViewById(R.id.btnNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SegundoActivity.class);
                intent.putExtra("ments", ments);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        switch (parent.getId()) {
            case R.id.spORTime: //Manejar el spinner 1
                valoresSpinners[0] = pos + 1;
                break;
            case R.id.spLosAnticipated:
                valoresSpinners[1] = pos + 1;
                break;
            case R.id.spPostOpICU:
                valoresSpinners[2] = pos + 1;
                break;
            case R.id.spBleeding:
                valoresSpinners[3] = pos + 1;
                break;
            case R.id.spSurgicalSize:
                valoresSpinners[4] = pos + 1;
                break;
            case R.id.spIntubation:
                valoresSpinners[5] = pos + 1;
                break;
            case R.id.spSurgicalSite:
                valoresSpinners[6] = pos + 1;
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
        for (i = 0;i < 7;i++){
            total += valoresSpinners[i];
        }
        ments = total;
        tvMents.setText(Integer.toString(total));
    }
}
// holiii
