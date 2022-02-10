package com.example.calculo_interes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnCalcular;
    private EditText editCapital, editPeriodo;
    private TextView interesPeriodo, interesMensual,pagoTotal, textInteres, textCapital;
    private double interes = 0.02;
    private double cInteresMensual,cInteresPeriodo,cPagoTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Inicializar();
    }

    private void Inicializar(){

        editCapital = (EditText)findViewById(R.id.idCapital);
        editPeriodo= (EditText)findViewById(R.id.idPeriodo);
        btnCalcular = (Button) findViewById(R.id.idCalcular);
        interesPeriodo = (TextView) findViewById(R.id.textIPeriodo);
        interesMensual = (TextView) findViewById(R.id.textIMensual);
        pagoTotal = (TextView) findViewById(R.id.textPTotal);
        textInteres = (TextView)findViewById(R.id.textInteres);
        textCapital = (TextView)findViewById(R.id.textCapital);


        this.btnCalcular.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                CalcularInteres();
                DevolverResultado();
            }
        });
    }

    private void CalcularInteres(){

        double capital = Double.parseDouble(editCapital.getText().toString());
        double periodo = Double.parseDouble(editPeriodo.getText().toString());

        cInteresMensual = capital * interes;
        cInteresPeriodo = cInteresMensual * periodo;
        cPagoTotal = capital + cInteresPeriodo;

    }

    private void DevolverResultado(){

        this.textCapital.setText("> Capital Incial: $" + editCapital.getText().toString());
        this.textInteres.setText("> Interés: "+ String.valueOf(interes* 100) + "%");
        this.interesMensual.setText("> Interés Mensual: $"+ String.valueOf(cInteresMensual));
        this.interesPeriodo.setText("> Interés Total del Periodo: $"+ String.valueOf(cInteresPeriodo)+
                " ("+editPeriodo.getText().toString()+" meses)");
        this.pagoTotal.setText("> Total a Pagar: $"+ String.valueOf(cPagoTotal));

    }
}