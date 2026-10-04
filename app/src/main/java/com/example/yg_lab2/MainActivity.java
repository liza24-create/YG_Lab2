package com.example.yg_lab2;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Spinner spSelectionOptions;
    private EditText edPhrase;
    private TextView tvMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.edPhrase = findViewById(R.id.edPhrase);
        this.tvMain = findViewById(R.id.tvMain);

        this.spSelectionOptions = findViewById(R.id.spSelectionOptions);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.selection_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spSelectionOptions.setAdapter(adapter);
    }

    public void onBtnCountClick(View view) {
        String selectedOption = this.spSelectionOptions.getSelectedItem().toString();
        String defaultCharsSelectedOption = getString(R.string.chars_selection);
        String defaultWordsSelectedOption = getString(R.string.words_selection);
        String defaultSentencesSelectedOption = getString(R.string.sentences_selection);
        String defaultNumbersSelectedOption = getString(R.string.numbers_selection);
        if(selectedOption.equals(defaultCharsSelectedOption)){
            String userInputText = this.edPhrase.getText().toString();
            if(TextUtils.isEmpty(userInputText)){

                Toast.makeText(this, "Please enter a text", Toast.LENGTH_SHORT).show();

            }
            else {
                String charsCount = TextCounter.getCharsCount(userInputText);

                this.tvMain.setText(charsCount);
            }
        }

        if(selectedOption.equals(defaultWordsSelectedOption)){
            String userInputText = this.edPhrase.getText().toString();
            if(TextUtils.isEmpty(userInputText)){

                Toast.makeText(this, "Please enter a text", Toast.LENGTH_SHORT).show();

            }
            else {
                String wordsCount = TextCounter.getWordsCount(userInputText);

                this.tvMain.setText(wordsCount);
            }
        }

        if(selectedOption.equals(defaultSentencesSelectedOption)){
            String userInputText = this.edPhrase.getText().toString();
            if(TextUtils.isEmpty(userInputText)){

                Toast.makeText(this, "Please enter a text", Toast.LENGTH_SHORT).show();

            }
            else {
                String sentencesCount = TextCounter.getSentencesCount(userInputText);

                this.tvMain.setText(sentencesCount);
            }
        }

        if(selectedOption.equals(defaultNumbersSelectedOption)){
            String userInputText = this.edPhrase.getText().toString();
            if(TextUtils.isEmpty(userInputText)){

                Toast.makeText(this, "Please enter a text", Toast.LENGTH_SHORT).show();

            }
            else {
                String numbersCount = TextCounter.getNumbersCount(userInputText);

                this.tvMain.setText(numbersCount);
            }
        }

    }
}