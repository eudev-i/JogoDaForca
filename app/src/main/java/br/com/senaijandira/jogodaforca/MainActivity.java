package br.com.senaijandira.jogodaforca;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends Activity{

    TextView txtLetra[] = new TextView[4];
    TextView txtDica;
    Button btnAlfabeto[] = new Button[26];
    int palavraAleatoria;

    /*PALAVRAS QUE SERÃO SORTEADAS NO JOGO*/
    String[][] palavras = {
            {"A", "M", "O", "R"},
            {"F", "A", "T", "O"},
            {"B", "O", "L", "A"},
            {"M", "I", "T", "O"},
            {"D", "O", "C", "E"},
            {"A", "L", "E", "M"},
            {"T", "R", "E", "M"},
            {"R", "U", "I", "M"},
            {"C", "E", "D", "O"},
            {"P", "E", "S", "O"},
            {"S", "H", "O", "W"},
            {"C", "O", "T", "A"},
            {"R", "A", "I", "Z"},
            {"T", "A", "B", "U"},
            {"I", "L", "H", "A"},
            {"D", "O", "A", "R"},
            {"V", "O", "A", "R"},
            {"F", "O", "G", "E"},
            {"V", "I", "D", "A"},
            {"S", "E", "L", "A"},
            {"L", "I", "X", "O"},
            {"C", "E", "L", "A"},
            {"P", "O", "S", "E"},
            {"C", "A", "B", "O"},
            {"C", "O", "V", "A"},
            {"L", "U", "V", "A"},
            {"M", "O", "D", "A"},
            {"C", "R", "U", "Z"},
            {"F", "A", "S", "E"},
            {"F", "A", "C", "E"},
            {"A", "G", "I", "R"},
            {"S", "U", "C", "O"},
            {"R", "U", "D", "E"},
            {"F", "E", "T", "O"},
            {"M", "I", "A", "U"},
            {"I", "D", "E", "M"},
            {"L", "U", "A", "R"},
            {"R", "I", "S", "O"},
            {"B", "A", "S", "E"},
            {"R", "I", "M", "A"},
            {"V", "A", "L", "E"},
            {"M", "A", "N", "U"},
            {"A", "S", "N", "O"},
            {"H", "T", "M", "L"},
            {"T", "I", "P", "O"},
            {"H", "O", "J", "E"},
            {"M", "E", "I", "A"},
            {"Y", "O", "R", "K"},
            {"C", "O", "N", "E"},
            {"H", "U", "L", "K"}
    };

    /*DICAS*/
    String[] dicas = {
            "Sentimento inexistente",
            "Algo cuja existência pode ser constatada de modo indiscutível",
            "Objeto com formato mais ou menos esférico ou arredondado",
            "Lenda",
            "De sabor açucarado",
            "Mais à frente ou?",
            "Meio de transporte formado por uma série de vagões",
            "Destituído de préstimo",
            "Antes do tempo ou da ocasião própria",
            "Força invisível que atrai os corpos para a superfície da Terra",
            "Espetáculo apresentado em teatro, televisão, rádio, casas noturnas ou mesmo ao ar livre",
            "Quantia, parcela determinada de um todo",
            "Eixo de uma planta vascular",
            "Proibição da prática de qualquer atividade social que seja moral, religiosa ou culturalmente reprovável",
            "Extensão de terra firme cercada de modo durável por água doce ou salgada em toda a sua periferia",
            "Transferir de modo legal e gratuito",
            "Deslocar-se pelo ar",
            "Escapar do lugar em que se estava preso",
            "Existência evolui do nascimento até a morte",
            "Peça de couro posta sobre o lombo da cavalgadura",
            "Tudo aquilo que já não tem utilidade e é jogado fora",
            "Diminuto quarto de dormir",
            "Ato ou efeito de se apossar de alguma coisa",
            "Apresenta vários condutores isolados uns dos outros, e que é protegido(a) por algum tipo de revestimento",
            "Sepultura",
            "Peça de vestuário para a mão",
            "Maneira ou costume mais predominante em um determinado grupo em um determinado momento que se refere a forma de vestir-se",
            "Comum nas igrejas e cemitérios",
            "Cada um dos estados de algo em evolução",
            "Cada uma das partes laterais dessa região",
            "Tomar providências",
            "Refresco ou bebida de fruta ou de vegetal",
            "Que apresenta asperezas; áspero, rugoso",
            "Estágio intrauterino após o embrião",
            "Som que o gato emite",
            "O mesmo",
            "Claridade proveniente da reflexão da luz sola pela Lua",
            "Expressão facial decorrente da contração dos músculos das extremidades da boca",
            "Parte inferior de alguma coisa",
            "Repetição de uma sequência de sons parecidos",
            "Documento com um valor monetário determinado",
            "Aluna da INF3M que ama JAVA",
            "Indivíduo desprovido de inteligência",
            "linguagem de marcação de hipertexto",
            "Espécie, gênero",
            "O dia em que se está",
            "Peça de roupa que cobre o pé",
            "Nova ...?",
            "Possui uma base circular formada por segmentos de reta que têm uma extremidade num vértice em comum",
            "O incrível ...?"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);/*DEFINE O CONTEUDO DA TELA*/

        criarBtnAlfabeto();
        palavraAleatoria = aleatorio();
        txtDica = findViewById(R.id.txtDica);
        txtDica.setText(dicas[palavraAleatoria]);

    }

    /*RETORNANDO O ID DO BTN*/
    public void criarBtnAlfabeto(){
        for (int auxiliar=0; auxiliar < btnAlfabeto.length; auxiliar++){
            int id = getResources().getIdentifier("btn" + auxiliar, "id", getPackageName());
            btnAlfabeto[auxiliar] = findViewById(id);/*RESGATA O ID DO XML*/
            btnAlfabeto[auxiliar].setTag(auxiliar);/*TODOS OS BOTAOS ESTAO RECEBENDO UMA TAG*/
            btnAlfabeto[auxiliar].setOnClickListener(clique);/*APLICANDO O EVENTO CLIQUE*/
            btnAlfabeto[auxiliar].setEnabled(true);/*ABILITANDO OS BOTOES*/
            btnAlfabeto[auxiliar].setBackgroundColor(getResources().getColor(R.color.blue));/*INICIANDO OS BOTOES COM A COR AZUL*/
        }
    }

    int pontuacaoAcerto = 0;
    int pontuacaoErro = 4;
    int letraErrada = 0;
    int venceu = 0;

    View.OnClickListener clique = new View.OnClickListener() { /*VERIFICA QUAL BOTAO FOI CLICADO*/
        @Override
        public void onClick(View v) {

            int identicadorBtn = (int) v.getTag();
            int contador = 0;

            Button btnClicado = (Button) v;

            CharSequence letraBtn = btnAlfabeto[identicadorBtn].getText();/*RESGATANDO O TEXTO DO BOTAO*/

            for (int i=0; i <= 3; i++){ /*VERIFICANDO A POSICAO DA PALAVRA*/

                if (letraBtn.equals(palavras[palavraAleatoria][i])){

                    int id = getResources().getIdentifier("txtLetra" + i, "id", getPackageName());/*RESGATANDO O ID DO XML*/

                    txtLetra[i] = findViewById(id);

                    txtLetra[i].setText(letraBtn);

                    v.setEnabled(false);

                    contador++; /*A PALAVRA EXISTE PELO MENOS UMA VEZ*/
                }
            }

            if(contador != 0){
                btnClicado.setBackgroundColor(getResources().getColor(R.color.green)); /*MUDA A COR PARA VERDE SE A PALAVRA EXISTIR*/
                pontuacaoAcerto++;

            }
            else {
                btnClicado.setBackgroundColor(getResources().getColor(R.color.red)); /*MUDA A COR PARA VERMELHO SE A PALAVRA NÃO EXISTIR*/
                pontuacaoErro--;
                letraErrada++;
                if(pontuacaoErro == 0){
                    JanelaFimJogo();
                }
            }
            btnClicado.setEnabled(false);/*DESABILITA O BOTÃO*/



            if(pontuacaoAcerto == 4){

                JanelaFimJogo();
                venceu = 1;
            }
        }
    };

    public int aleatorio(){

        Random gerador = new Random();

        return gerador.nextInt(50);/*RETORNA O NUMERO ALEATORIO DE 0 A 50*/
    }

    public void JanelaFimJogo(){

        Intent janelaFinal = new Intent(this, FimActivity.class);/*ABRIR UMA NOVA TELA*/

        janelaFinal.putExtra("pontuacaoAcerto", pontuacaoAcerto);
        startActivity(janelaFinal);
        janelaFinal.putExtra("letraErrada", letraErrada);
        startActivity(janelaFinal);

       Bundle bundleFimDeJogo = new Bundle();
       bundleFimDeJogo.putInt("verificarConquista", pontuacaoErro);
       janelaFinal.putExtras(bundleFimDeJogo);
       startActivity(janelaFinal);

    }

}
