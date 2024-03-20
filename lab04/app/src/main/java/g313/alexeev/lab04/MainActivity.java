package g313.alexeev.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox[] check = new CheckBox[4];
    EditText[] etext = new EditText[4];
    double[] price = new double[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etext[0] = findViewById(R.id.AppleN);
        etext[1] = findViewById(R.id.StrawN);
        etext[2] = findViewById(R.id.BlueN);
        etext[3] = findViewById(R.id.PotatoN);

        check[0] = findViewById(R.id.AppleBox);
        check[1] = findViewById(R.id.StrawBox);
        check[2] = findViewById(R.id.BlueBox);
        check[3] = findViewById(R.id.PotatoBox);

        price[0] = 10.25d;
        price[1] = 20.10d;
        price[2] = 5.99d;
        price[3] = 17.50d;
    }

    public void OnClick(View v)
    {
        try {
            double sum = 0.0d;
            String rep = "";
            int manpeople = 0;
            for (int i = 0; i < 4; i++)
            {
                if (check[i].isChecked())
                {
                    int q = Integer.parseInt(etext[i].getText().toString());
                    if (q == 0)
                    {
                        Toast toast2 = Toast.makeText(this,"Поле нулевое!",Toast.LENGTH_LONG);
                        toast2.show();
                        manpeople = 1;
                        break;
                    }
                    double val = q*price[i];
                    sum += q+val;
                    rep += String.format(q+" x "+check[i].getText().toString() + " = "+q+" x "+price[i]+" = "+val+"\n");
                }
            }
            if (manpeople == 0)
            {
                rep += String.format("total = "+sum);
                String man = String.valueOf(sum);
                Toast toast = Toast.makeText(this,rep,Toast.LENGTH_LONG);
                toast.show();
            }
        }
        catch (Exception e)
        {
            Toast toast1 = Toast.makeText(this,"Поле пустое!",Toast.LENGTH_LONG);
            toast1.show();
        }
    }


}