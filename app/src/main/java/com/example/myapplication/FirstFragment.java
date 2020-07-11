package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment implements AdapterView.OnItemSelectedListener
{
    static final String[] orTime = new String[] {"< 30","31-60","61-120","121-180",">181"};
    static final String[] losAnticipated = new String[] {"out patient","23 hrs","24-48 hrs","< 3d",">4d"};
    static final String[] postOpICU = new String[] {"very unlikely","< 5%","5%-10%","11%-25%","> 25%"};
    static final String[] bleedingRisk = new String[] {"< 100","101-250","251-500","501-750","> 750"};
    static final String[] surgicalSize = new String[] {"1","2","3","4","> 4"};
    static final String[] intubation = new String[] {"< 1%","1%-5%","6%-10%","11%-25%","> 25%"};
    static final String[] surgicalSite = new String[] {"none of the following","adbominopelvic MIS surgery","abdominopelvic Open Surgery (infraumbilical)","abdominopelvic Open Surgery (supraumbilical)","OHNS/Upper GI/Thoracic"};
    Spinner spORTime;
    TextView tv;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_first, container, false);
    }
/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_first);
        textoBebidas = findViewById(R.id.textValor1);
        textoPostres = findViewById(R.id.textPostres);

        //Asigna el spinner del XML a la variable spinner
        spinnerBebidas = findViewById(R.id.spinnerBebidas);
        //Crea un adaptador para el spinner, que va a meterle los strings que se encuentran en el arreglo "options"
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, BEBIDAS);
        //Agrega el adaptador al spinner, para que muestre todos los items de la lista "options"
        spinnerBebidas.setAdapter(adapter);
        //Selecciona esta activity como quien escucha cuando se selecciona un item
        spinnerBebidas.setOnItemSelectedListener(this);

        //Spinner Postres
        spinnerPostres = findViewById(R.id.spinnerPostre);
        //adaptador
        ArrayAdapter<String> adapterPostres = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, POSTRES);
        //Asignar adaptador al spinner postres
        spinnerPostres.setAdapter(adapterPostres);
        //Seleccionar esto como el listener
        spinnerPostres.setOnItemSelectedListener(this);

    }

    private void setContentView(int fragment_first) {
    }
*/
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv = view.findViewById(R.id.textview_first);
        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tv.setText("Hola mundo");
            }
        });


        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}