package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {



    TextView Username, Password, prefLang, LearnLang, Flashcard, showFlashcard;
    Button makeAccount, displayFlashcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Username = findViewById(R.id.Username);
        Password = findViewById(R.id.Password);
        prefLang = findViewById(R.id.prefLang);
        LearnLang = findViewById(R.id.LearnLang);
        Flashcard = findViewById(R.id.Flashcard);
        showFlashcard = findViewById(R.id.showFlashcard);
        makeAccount = findViewById(R.id.makeAccount);
        displayFlashcard = findViewById(R.id.displayFlashcard);



        makeAccount.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Sucess=" , Toast.LENGTH_SHORT).show();

                Account account;
                try {
                   account = new Account(-1, Username.getText().toString(), Password.getText().toString(), prefLang.getText().toString(), LearnLang.getText().toString());

                    Toast.makeText(MainActivity.this, account.toString(), Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                    Toast.makeText(MainActivity.this, "Error creating customer", Toast.LENGTH_SHORT).show();
                    account = new Account(-1, "error","error","error","error");
                }

                AccountDatabase accountDatabase = new AccountDatabase(MainActivity.this);

                boolean success = accountDatabase.addOne(account);
                Toast.makeText(MainActivity.this, "Sucess=" + success , Toast.LENGTH_SHORT).show();


            }
        });

        displayFlashcard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                AccountDatabase accountDatabase = new AccountDatabase( (MainActivity.this));
                List<Account> all = accountDatabase.getAll();

            Toast.makeText(MainActivity.this, all.toString(), Toast.LENGTH_SHORT).show();


            }

        });



    }
}