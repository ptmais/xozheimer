package com.alzheimer.jzone.showalzheimer;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnIniciarAplicacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        this.btnIniciarAplicacao = (Button) findViewById(R.id.btnIniciarAplicacao);

        btnIniciarAplicacao.setOnClickListener(this);
    }

    private void iniciarAplicacao() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.layout_dialog_inserir_nome, null);
        builder.setView(dialogView);

        final EditText etNome = (EditText) dialogView.findViewById(R.id.etLayoutDialogNome);
        Button btnConfirmar = (Button) dialogView.findViewById(R.id.btnLayoutDialogConfirmar);

        final AlertDialog show = builder.show();

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = etNome.getText().toString();
                if (nome.length() > 0) {
                    Toast.makeText(getApplicationContext(), nome, Toast.LENGTH_SHORT).show();
                    show.dismiss();
                }
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnIniciarAplicacao:
                iniciarAplicacao();
                break;
            default:
                break;
        }
    }
}
