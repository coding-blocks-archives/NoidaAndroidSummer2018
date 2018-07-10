package qwerty.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button increment;
    TextView value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        increment = (Button) findViewById(R.id.increment);
        value = (TextView) findViewById(R.id.value);
        setIncrement();


    }

    public void setIncrement() {
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String current = value.getText().toString();
                int num = Integer.valueOf(current);
                num+=1;
                final String updatedValue = String.valueOf(num);

                value.post(new Runnable() {
                    @Override
                    public void run() {
                        value.setText(updatedValue);
                    }
                });
            }
        });
    }
}
