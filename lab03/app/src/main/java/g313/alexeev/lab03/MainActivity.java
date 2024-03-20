package g313.alexeev.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    Spinner fromSp;
    Spinner toSp;
    EditText fromMan;
    TextView toMan;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fromSp = findViewById(R.id.fromSp);
        toSp = findViewById(R.id.toSp);
        fromMan = findViewById(R.id.fromMan);
        toMan = findViewById(R.id.textRes);
        ArrayAdapter <String> adp = new <String> ArrayAdapter(this, android.R.layout.simple_list_item_1);
        adp.add("mm");
        adp.add("cm");
        adp.add("m");
        adp.add("km");

        fromSp.setAdapter(adp);
        toSp.setAdapter(adp);
    }

    public static class Converter
    {
        public static double ToDif(double g, String FromMan, String Eq)
        {
            double geter = 0.0d;
            if (FromMan.equals("mm"))
            {
                if (Eq.equals("mm")) geter = g*1.0d;
                if (Eq.equals("cm")) geter = g*0.1d;
                if (Eq.equals("m")) geter = g*0.001d;
                if (Eq.equals("km")) geter = g*0.000001d;
                return geter;
            }
            if (FromMan.equals("cm"))
            {
                if (Eq.equals("mm")) geter = g*0.1d;
                if (Eq.equals("cm")) geter = g*1.0d;
                if (Eq.equals("m")) geter = g*0.01d;
                if (Eq.equals("km")) geter = g*0.00001d;
                return geter;
            }
            if (FromMan.equals("m"))
            {
                if (Eq.equals("mm")) geter = g*1000.0d;
                if (Eq.equals("cm")) geter = g*100.0d;
                if (Eq.equals("m")) geter = g*1.0d;
                if (Eq.equals("km")) geter = g*0.001d;
                return geter;
            }
            if (FromMan.equals("km"))
            {
                if (Eq.equals("mm")) geter = g*0.000001d;
                if (Eq.equals("cm")) geter = g*100000.0d;
                if (Eq.equals("m")) geter = g*100.0d;
                if (Eq.equals("km")) geter = g*1.0d;
                return geter;
            }
            return geter;
        }
    }


    public void onClick(View v)
    {
        try {
            double  get = Double.parseDouble(fromMan.getText().toString());
            String frS = (String) fromSp.getSelectedItem();
            String toS = (String) toSp.getSelectedItem();

            toMan.setText(String.valueOf(Converter.ToDif(get,frS,toS)));
        }
        catch (Exception e)
        {
            Toast.makeText(this, "че пишешь", Toast.LENGTH_SHORT).show();
        }
    }


}