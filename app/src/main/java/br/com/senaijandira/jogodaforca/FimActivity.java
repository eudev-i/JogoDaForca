package br.com.senaijandira.jogodaforca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

public class FimActivity extends Activity {

    TextView txtLetraCorreta;
    TextView txtLetraErrada;
    TextView txtResultadoFinal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fim);/*DEFINE O CONTEUDO DA TELA*/

        txtLetraCorreta = findViewById(R.id.txtLetraCorreta);
        txtLetraErrada = findViewById(R.id.txtLetraErrada);
        txtResultadoFinal = findViewById(R.id.txtResultadoFinal);

        Intent intent = getIntent();/*PEGA O intent QUE CHEGOU NA TELA*/

        int qtdAcertos = intent.getIntExtra("pontuacaoAcerto", 0);
        txtLetraCorreta.setText(qtdAcertos+"");
        int qtdErros = intent.getIntExtra("letraErrada", 0);
        txtLetraErrada.setText(qtdErros+"");
        String venceu = intent.getStringExtra("PARABENS");

        Bundle bundleFimDeJogo = getIntent().getExtras();
        int verificarConquista = bundleFimDeJogo.getInt("verificarConquista");
        if (verificarConquista >= 1){
            txtResultadoFinal.setText("PARABÉNS! VOCÊ ACERTOU");
        }
        else {
            txtResultadoFinal.setText("EITA! NÃO FOI DESSA VEZ");
        }

    }

    public void reiniciarJogo(View v){
        /*ABRIR UMA NOVA TELA*/
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);

    }
}
