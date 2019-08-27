package com.example.conversordivisas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText dolar, euro, cambio;
    private RadioButton rbdolar, rbEuro;
    private double cotizacionEuro = 0.90;
    private double cotizacionDolar = 1.11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dolar = (EditText) findViewById(R.id.inputDolar);
        euro = findViewById(R.id.inputEuro);
        rbdolar = findViewById(R.id.radioDaE);
        rbEuro = findViewById(R.id.radioEaD);
        cambio = findViewById(R.id.inputCambio);
        dolar.setEnabled(false);
        euro.setEnabled(false);
        findViewById(R.id.inputCambio).setEnabled(false);
    }


    // metodo

    public void calcular(View view) {

        try{
            Double result;


            if (rbdolar.isChecked()) {

                result = Double.parseDouble(dolar.getText().toString()) * cotizacionEuro;
                cambio.setText(result.toString());
            } else {
                if (rbEuro.isChecked()) {

                    result = Double.parseDouble(euro.getText().toString()) * cotizacionDolar;
                    cambio.setText(result.toString());
                } else {
                    Toast.makeText(this, "Seleccione un tipo de conversion", Toast.LENGTH_LONG).show();
                }
            }
        }catch (Exception e){


            Log.d("error", e.getMessage());


        }




    }// end calcular

    public void radioDolar(View view){
        dolar.setEnabled(true);
        euro.setEnabled(false);
    }

    public void radioEuro(View view){
        dolar.setEnabled(false);
        euro.setEnabled(true);
    }

}//end


