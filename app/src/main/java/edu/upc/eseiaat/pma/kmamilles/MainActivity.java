package edu.upc.eseiaat.pma.kmamilles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_a_mill = (Button) findViewById(R.id.btn_a_mill);
        Button btn_a_km = (Button) findViewById(R.id.btn_a_km);

        final EditText edit_km = (EditText) findViewById(R.id.edit_km);
        final EditText edit_mill = (EditText) findViewById(R.id.edit_mill);

        btn_a_mill.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String skm = edit_km.getText().toString();
                Log.i("a milles", "btn_a_mill apretat");
                if(skm.equals("")){
                    Log.i("no hi ha text", "No hi ha text");
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Escriu els kilòmetres", Toast.LENGTH_LONG);
                    toast1.show();
                }
                else {
                    float km = Float.parseFloat(skm);
                    float milles = km / 1.609f;
                    String smilles = String.format("%f", milles);
                    edit_mill.setText(smilles);
                }
            }

        });

        btn_a_km.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String smilles = edit_mill.getText().toString();
                Log.i("a km", "btn_a_km apretat");
                if(smilles.equals("")){
                    Log.i("no hi ha text", "No hi ha text");
                    Toast toast2 = Toast.makeText(getApplicationContext(), "Escriu les milles", Toast.LENGTH_LONG);
                    toast2.show();
                }
                else {
                    float milles = Float.parseFloat(smilles);
                    float km = milles * 1.609f;
                    String skm = String.format("%f", km);
                    edit_km.setText(skm);
                }



            }
        });

    }
}
