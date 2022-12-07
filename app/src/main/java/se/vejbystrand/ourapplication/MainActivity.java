package se.vejbystrand.ourapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("Hello World!");
    }

    public void onBtnClickViewLog(View view) {
        TextView txtNumber1 = findViewById(R.id.txtActivity);
        String name = txtNumber1.getText().toString();
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }
}
