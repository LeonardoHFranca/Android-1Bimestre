package com.example.bankliberty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TelaPrincipal extends AppCompatActivity {

    private EditText edit_dinheiro;
    private TextView saldo;
    private Button bt_entrar;
    private Button bt_deslogar;
    private Button bt_sacar;

    double saldoConta = 5000.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        iniciaComponentes();
        saldo.setText("Saldo: " + saldoConta);
        bt_entrar = findViewById(R.id.email_entrar);
        bt_deslogar = findViewById(R.id.deslogar);
        getSupportActionBar().hide();

        //desloga da aplicação
        bt_deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irParaFormLogin();
            }
        });

        // vai para a tela de envio de e-mail
        bt_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPrincipal.this, Email.class);
                startActivity(intent);
            }
        });

        //evento de click do botão
        bt_sacar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double dinheiro;
                dinheiro = Double.parseDouble(edit_dinheiro.getText().toString());
                if (dinheiro < 10){
                    Toast.makeText(TelaPrincipal.this, "Valor minimo 10", Toast.LENGTH_SHORT).show();
                }else if (dinheiro == 10){
                    saldoConta -= dinheiro;
                    Toast.makeText(TelaPrincipal.this, "Transferencia feita", Toast.LENGTH_SHORT).show();
                    saldo.setText("Saldo: " + saldoConta);
                } else {
                    saldoConta -= dinheiro;
                    saldo.setText("Saldo" + saldoConta);
                    Toast.makeText(TelaPrincipal.this, + dinheiro + "0", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //vai para a tela principal
    private void irParaFormLogin(){
        Intent intent = new Intent(this, FormLogin.class);
        startActivity(intent);
        finish();
    }

    //Inicializando os componentes
    private void iniciaComponentes() {
        edit_dinheiro = findViewById(R.id.edit_dinheiro);
        bt_sacar = findViewById(R.id.bt_transferir);
        saldo = findViewById(R.id.saldo);
        bt_entrar = findViewById(R.id.email_entrar);
    }
}