package nyc.c4q.practicingtextviewedittextbutton;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean isErase = false;
    private EditText et;
    private TextView tx;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.button);
        et = (EditText) findViewById(R.id.editText1);
        tx = (TextView) findViewById(R.id.textView1);

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {  //Displaying or clearing

                if (!isErase) {
                    String input = et.getText().toString();
                    if (input.isEmpty()) {
                        et.setError("Please don't leave this empty");
                        return;  //End the method here, and don't toggle.
                    } else {
                        tx.setText(input);  //Set the textview to whatever's entered into edittext
                        Toast.makeText(MainActivity.this, input, Toast.LENGTH_SHORT).show();
                        button.setText("Clear");  //Button will say Clear
                    }
                } else {
                    et.setText("");
                    tx.setText("");
                    button.setText("Display");  //Button will say Display
                }
                isErase = !isErase;  //Toggling the value of the boolean
            }
        });

    }
}