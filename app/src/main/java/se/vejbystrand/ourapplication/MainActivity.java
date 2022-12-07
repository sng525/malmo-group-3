package se.vejbystrand.ourapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText activity;
    EditText weight;
    EditText set;
    EditText reps;
    EditText date;
    ListView ListViewLog;
    ArrayAdapter arrayAdapter;
    Button btn_view;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = findViewById(R.id.txtActivityp2);
        weight = findViewById(R.id.numWeight3);
        set = findViewById(R.id.numSet3);
        reps = findViewById(R.id.numRepoa3);
        date = findViewById(R.id.dateTime3);

    }
    public void onBtnAddClick(View view) {
        Intent intent = new Intent(this, ViewAll.class);
        startActivity(intent);
    }
}
