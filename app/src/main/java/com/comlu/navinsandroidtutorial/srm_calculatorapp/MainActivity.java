package com.comlu.navinsandroidtutorial.srm_calculatorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQ_CODE = 1;
    EditText v1;
    EditText v2;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=(TextView)findViewById(R.id.textView5);
        v1=(EditText)findViewById(R.id.editText3);
        v2=(EditText)findViewById(R.id.editText4);

        Button submit=(Button)findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    double val1 = Integer.parseInt(v1.getText().toString());
                    double val2 = Integer.parseInt(v2.getText().toString());


                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.addCategory("com.nawin");
                    i.putExtra("value1", val1);
                    i.putExtra("value2", val2);
                    startActivityForResult(i, REQ_CODE);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Toast.makeText(getBaseContext(), "One of the field entry is not entered or Wrongly entered",
                            Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQ_CODE) {
            if (resultCode == RESULT_OK) {
                t.setText(data.getData().toString());

            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
