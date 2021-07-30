package com.example.bankliberty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends AppCompatActivity {
    private Button bt_sair, btSend;
    private EditText etTo, etSubject, etMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        getSupportActionBar().hide();
        iniciarComponente();

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("Usuário: " + etTo.getText().toString()));
                intent.putExtra(Intent.EXTRA_SUBJECT, etSubject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, etMessage.getText().toString());
            }
        });


        //Apenas faz a função do butão sair
        bt_sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Email.this, FormLogin.class);
                startActivity(intent);
            }
        });

    }

    //Aqui inicio os componentes da tela
    private void iniciarComponente() {
        bt_sair = findViewById(R.id.bt_sair);
        btSend = findViewById(R.id.bt_send);
        etTo = findViewById(R.id.et_to);
        etSubject = findViewById(R.id.et_subject);
        etMessage = findViewById(R.id.et_message);
    }
}