package com.dee.hamrobazzar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.dee.hamrobazzar.TermsandCondition.PostingActivity;
import com.dee.hamrobazzar.TermsandCondition.SafetyActivity;
import com.dee.hamrobazzar.TermsandCondition.TermsActivity;

public class MainActivity extends AppCompatActivity {
CheckBox cbTerms, cbSafety, cbPosting;
Button btnAgreed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

   cbTerms = findViewById(R.id.cbTerms);
   cbSafety = findViewById(R.id.cbSafety);
   cbPosting = findViewById(R.id.cbPosting);
    btnAgreed = findViewById(R.id.btnAgreed);

    cbTerms.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(), TermsActivity.class));
        }
    });

    cbSafety.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(), SafetyActivity.class));
        }
    });

    cbPosting.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(), PostingActivity.class));
        }
    });

    btnAgreed.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (cbTerms.isChecked()){
            startActivity(new Intent(getApplicationContext(),DashboardActivity.class));
            }
             if (cbSafety.isChecked()){
                startActivity(new Intent(getApplicationContext(),DashboardActivity.class));
            }
             if (cbPosting.isChecked()){
                 startActivity(new Intent(getApplicationContext(),DashboardActivity.class));
             }
            else {
                Toast.makeText(MainActivity.this, "Please Read and agree all term and condition", Toast.LENGTH_SHORT).show();
            }
        }
    });


    }
}
