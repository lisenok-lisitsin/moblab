package g313.alexeev.lab01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ta;
    EditText tb;
    TextView tr;

    float a,b;

    Button ba,bs,bm,bd;

    boolean get_numbers()
    {
        String sa = ta.getText().toString();
        String sb = tb.getText().toString();

        try {
            a = Float.parseFloat(sa);
            b = Float.parseFloat(sb);
            }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
    void set_res(float res)
    {
        String sr = String.valueOf(res);
        tr.setText(sr);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ta = findViewById(R.id.txt_a);
        tb = findViewById(R.id.txt_b);
        tr = findViewById(R.id.txt_res);

        ba = findViewById(R.id.addbut);
        bs = findViewById(R.id.rembut);
        bm = findViewById(R.id.mulbut);
        bd = findViewById(R.id.divbut);
    }

    public void do_act(View v)
    {
        if (get_numbers() == false)
        {
            tr.setText("Invalid input");
            return;
        }
        float r = 0;
        if (v == ba) r = (a+b);
        if (v == bs) r = (a-b);
        if (v == bm) r = (a*b);
        if (v == bd)
        {
            if (b == 0)
            {
                tr.setText("Invalid input");
                return;
            }
            else
            {
                r = (a/b);
            }
        }
        set_res(r);
    }

    public void add_click(View v)
    {
        get_numbers();
        set_res(a+b);
    }
    public void rem_click(View v)
    {
        get_numbers();
        set_res(a-b);
    }
    public void mul_click(View v)
    {
        get_numbers();
        set_res(a*b);
    }
    public void div_click(View v)
    {
        get_numbers();
        set_res(a/b);
    }
}
