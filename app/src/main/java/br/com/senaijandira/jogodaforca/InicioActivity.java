package br.com.senaijandira.jogodaforca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class InicioActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_inicio);/*DEFINE O CONTEUDO DA TELA*/
    }

    public void iniciarJogo(View v){

        Intent intent = new Intent (this, MainActivity.class);/*ABRIR UMA NOVA TELA*/
        startActivity(intent);

    }
}
