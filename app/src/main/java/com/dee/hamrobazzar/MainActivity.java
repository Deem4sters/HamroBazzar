package com.dee.hamrobazzar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.dee.hamrobazzar.TermsandCondition.PostingActivity;
import com.dee.hamrobazzar.TermsandCondition.SafetyActivity;
import com.dee.hamrobazzar.TermsandCondition.TermsActivity;

public class MainActivity extends AppCompatActivity {
CheckBox cbTerms, cbSafety, cbPosting;
Button btnAgreed;
String terms,safety,posting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

   cbTerms = findViewById(R.id.cbTerms);
   cbSafety = findViewById(R.id.cbSafety);
   cbPosting = findViewById(R.id.cbPosting);
    btnAgreed = findViewById(R.id.btnAgreed);


    cbTerms.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
Intent intent= new Intent(getApplicationContext(),TermsActivity.class);
startActivity(intent);
terms="checked";
        }
    });

cbSafety.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Intent intent = new Intent(getApplicationContext(),SafetyActivity.class);
        startActivity(intent);
        safety = "checked";
    }
});

cbPosting.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Intent intent = new Intent(getApplicationContext(),PostingActivity.class);
        startActivity(intent);
        posting = "checked";
    }
});
btnAgreed.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
Agree();
    }
});


    }
private void Agree(){
if (!cbPosting.isChecked()){
    Toast.makeText(this, "check Posting Rule", Toast.LENGTH_SHORT).show();
return;
}
else if (!cbSafety.isChecked()){
    Toast.makeText(this, "Check Safety Rule", Toast.LENGTH_SHORT).show();
return;
}
else if (!cbTerms.isChecked()){
    Toast.makeText(this, "Check Terms and condition", Toast.LENGTH_SHORT).show();
return;
}
else{
    SharedPreferences sharedPreferences=getSharedPreferences("welcome",MODE_PRIVATE);
    SharedPreferences.Editor editor=sharedPreferences.edit();

    editor.putString("terms",terms);
    editor.putString("safety",safety);
    editor.putString("Posting",posting);
    editor.commit();

    Intent intent=new Intent(MainActivity.this,DashboardActivity.class);
    startActivity(intent);
}
}


}