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

        /*DEFINE O CONTEUDO DA TELA*/
        setContentView(R.layout.activity_inicio);



    }

    /*@Override
    protected void onResume() {
        super.onResume();
    }*/

    public void iniciarJogo(View v){
        /*ABRIR UMA NOVA TELA*/
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);

    }
}
