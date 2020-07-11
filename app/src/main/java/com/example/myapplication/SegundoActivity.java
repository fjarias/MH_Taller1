package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SegundoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    int ments2;
    int ments3;
    int[] valoresSpinners;

    TextView tvMent2;

    static final String[] NOTefec = new String[] {"None available","<40% as surgery","40% to 60% surgery","61% to 95% as surgery","equally effective"};
    static final String[] NOTexp= new String[] {"not applicable","Somewhat worse","Equivalent","Somewhat better","Significantly better"};
    static final String[] Imp2di = new String[] {"Significantly worse","Worse","Moderately worse","Slightly worse","No worse"};
    static final String[] Imp2su = new String[] {"Significantly worse","Worse","Moderately worse","Slightly worse","No worse"};
    static final String[] Imp6di = new String[] {"Significantly worse","Worse","Moderately worse","Slightly worse","No worse"};
    static final String[] Imp6su = new String[] {"Significantly worse","Worse","Moderately worse","Slightly worse","No worse"};

    Spinner spNOTefec;
    Spinner spNOTexp;
    Spinner spImp2di;
    Spinner spImp2su;
    Spinner spImp6di;
    Spinner spIImp6su;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        valoresSpinners = new int[6];
        int i;
        for (i = 0;i < 6;i++) {
            valoresSpinners[i] = 0;
        }
        tvMent2 = findViewById(R.id.tvMent2);
        spNOTefec = findViewById(R.id.spNOTefec);
        spNOTexp = findViewById(R.id.spNOTexp);
        spImp2di=findViewById(R.id.spImp2di);
        spImp2su=findViewById(R.id.spImp2su);
        spImp6di=findViewById(R.id.spImp6di);
        spIImp6su=findViewById(R.id.spImp6su);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, NOTefec);
        spNOTefec.setAdapter(adapter);
        spNOTefec.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, NOTexp);
        spNOTexp.setAdapter(adapter1);
        spNOTexp.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Imp2di);
        spImp2di.setAdapter(adapter2);
        spImp2di.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Imp2su);
        spImp2su.setAdapter(adapter3);
        spImp2su.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter4= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Imp6di);
        spImp6di.setAdapter(adapter4);
        spImp6di.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Imp6su);
        spIImp6su.setAdapter(adapter5);
        spIImp6su.setOnItemSelectedListener(this);


        Bundle extras = getIntent().getExtras();
        int message = extras.getInt("ments");
       //TextView text = findViewById(R.id.tvMent2);

       ments2 = message;
        //text.setText(Integer.toString(message));
        //suma=extras.getInt("suma");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        switch (parent.getId()) {
            case R.id.spNOTefec: //Manejar el spinner 1
                valoresSpinners[0] = pos + 1;
                break;
            case R.id.spNOTexp:
                valoresSpinners[1] = pos + 1;
                break;
            case R.id.spImp2di:
                valoresSpinners[2] = pos + 1;
                break;
            case R.id.spImp2su:
                valoresSpinners[3] = pos + 1;
                break;
            case R.id.spImp6di:
                valoresSpinners[4] = pos + 1;
                break;
            case R.id.spImp6su:
                valoresSpinners[5] = pos + 1;
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
        for (i = 0;i < 6;i++){
            total += valoresSpinners[i];
        }
        ments3= ments2 +total;
        tvMent2.setText(Integer.toString(ments3));
    }

}