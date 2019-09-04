package com.example.localisation;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner mLanguagesSpinner;
    private Button mApplyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initSpinnerLanguages();
    }

    public void initViews() {
        mLanguagesSpinner = findViewById(R.id.spnLangs);
        mApplyBtn = findViewById(R.id.btnApply);

        mApplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedLang = mLanguagesSpinner.getSelectedItemPosition();
                Configuration config = new Configuration();
                Locale locale = new Locale("ru");
                Locale locale1 = new Locale("en");
                Locale locale2 = new Locale("de");
                switch (selectedLang) {
                    case 0:
                        config.setLocale(locale);
                        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                        recreate();
                    case 1:
                        config.setLocale(locale1);
                        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                        recreate();
                    case 2:
                        config.setLocale(locale2);
                        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                        recreate();
                }
            }
        });
    }

    public void initSpinnerLanguages() {
        ArrayAdapter<CharSequence> adapterLanguages = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapterLanguages.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mLanguagesSpinner.setAdapter(adapterLanguages);
        mLanguagesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }
}
