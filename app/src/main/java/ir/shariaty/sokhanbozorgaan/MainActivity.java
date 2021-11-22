package ir.shariaty.sokhanbozorgaan;

import static ir.shariaty.sokhanbozorgaan.R.string.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random = new Random();
    TextView TextQuote;
    Button buttonQuote;
    String randQuote = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextQuote = findViewById(R.id.textQuote);
        buttonQuote = findViewById(R.id.buttonNextQuote);

        buttonQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayQuote();
            }
        });
        displayQuote();
    }

    public void displayQuote() {

        int randNum = random.nextInt((6+1) - 1) + 1;


        switch (randNum) {
            case 1:
                randQuote = getString(quote1);
                break;
            case 2:
                randQuote = getString(quote2);
                break;
            case 3:
                randQuote = getString(quote3);
                break;
            case 4:
                randQuote = getString(quote4);
                break;
            case 5:
                randQuote = getString(quote5);
                break;
            case 6:
                randQuote = getString(quote6);
                break;
            case 7:
                randQuote = getString(quote7);
                break;
        }

        TextQuote.setText(randQuote);


    }

    public void shareQuote(View view) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT,randQuote);
        startActivity(Intent.createChooser(shareIntent,"لطفا انتخاب کنید"));
    }
}