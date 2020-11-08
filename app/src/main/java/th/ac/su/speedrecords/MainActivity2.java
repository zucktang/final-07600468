package th.ac.su.speedrecords;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button save = findViewById(R.id.save) ;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText distance = findViewById(R.id.distance);
                EditText time = findViewById(R.id.time);

                String Distance = distance.getText().toString();
                String Time = time.getText().toString();
                if (Distance.isEmpty() || Time.isEmpty()) {
                    Toast t = Toast.makeText(MainActivity2.this, R.string.Distanceandtimearerequired, Toast.LENGTH_LONG);
                    t.show();
                } else {
                    Double X = Double.parseDouble(Distance);
                    Double Y = Double.parseDouble(Time);
                    if (Y == 0) {
                        Toast t = Toast.makeText(MainActivity2.this, R.string.Timemustbegreaterthanzero, Toast.LENGTH_LONG);
                        t.show();
                    } else {
                        Double ANS = (X / 1000) / (Y / 3600);

                        if (ANS > 80) {
                            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity2.this);
                            dialog.setTitle("SPEED CALCULATOR");
                            dialog.setMessage(R.string.Speedisoverlimit);
                            dialog.setPositiveButton("OK", null);
                            dialog.show();
                        }
                    }
                }
            }
        });

        }
    }
