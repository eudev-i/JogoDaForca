package br.com.senaijandira.jogodaforca;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity{

    TextView txtLetra[] = new TextView[4];
    TextView txtDica;
    Button btnAlfabeto[] = new Button[26];
    int palavraAleatoria;


    /*PALAVRAS*/
    String[][] palavras = {
            {"O", "S", "S", "O"},
            {"C", "A", "S", "A"},
            {"B", "O", "L", "A"},
            {"M", "O", "T", "O"},
            {"D", "O", "C", "E"},
            {"A", "M", "O", "R"},
            {"T", "R", "E", "M"},
            {"A", "G", "U", "A"},
            {"B", "O", "L", "O"},
            {"P", "E", "S", "O"},
            {"S", "H", "O", "W"},
            {"L", "E", "A", "L"},
            {"R", "A", "I", "Z"},
            {"T", "A", "B", "U"},
            {"I", "L", "H", "A"},
            {"D", "O", "A", "R"},
            {"V", "O", "A", "R"},
            {"F", "O", "G", "E"},
            {"V", "I", "D", "A"},
            {"S", "A", "I", "A"},
            {"L", "I", "X", "O"},
            {"F", "A", "M", "A"},
            {"V", "O", "T", "O"},
            {"C", "A", "B", "O"},
            {"C", "O", "V", "A"},
            {"L", "U", "V", "A"},
            {"M", "O", "D", "A"},
            {"C", "R", "U", "Z"},
            {"A", "M", "E", "M"},
            {"M", "O", "F", "O"},
            {"L", "U", "L", "A"},
            {"S", "U", "C", "O"},
            {"C", "A", "M", "A"},
            {"F", "E", "T", "O"},
            {"M", "I", "A", "U"},
            {"L", "A", "T", "A"},
            {"L", "U", "A", "R"},
            {"R", "I", "S", "O"},
            {"A", "N", "T", "A"},
            {"R", "I", "M", "A"},
            {"F", "A", "D", "A"},
            {"M", "A", "N", "U"},
            {"J", "A", "V", "A"},
            {"H", "T", "M", "L"},
            {"A", "L", "M", "A"},
            {"O", "L", "H", "O"},
            {"M", "E", "I", "A"},
            {"Y", "O", "R", "K"},
            {"C", "O", "N", "E"},
            {"H", "U", "L", "K"}
    };

    /*DICAS*/
    String[] dicas = {
            "Tecido rígido que forma o esqueleto da maioria dos animais vertebrados",
            "Moradia de formatos e tamanhos variados",
            "Objeto com formato mais ou menos esférico ou arredondado",
            "Veículo de duas rodas",
            "De sabor açucarado",
            "Sentimento inexistente",
            "Meio de transporte formado por uma série de vagões",
            "Líquido inodoro, insípido e incolor ",
            "Alimento à base de massa de farinha, geralmente doce e cozido no forno",
            "Força invisível que atrai os corpos para a superfície da Terra",
            "Espetáculo apresentado em teatro, televisão, rádio, casas noturnas ou mesmo ao ar livre",
            "Aquele que denota responsabilidade para com os compromissos assumidos, é?",
            "Eixo de uma planta vascular",
            "Proibição da prática de qualquer atividade social que seja moral, religiosa ou culturalmente reprovável",
            "Extensão de terra firme cercada de modo durável por água doce ou salgada em toda a sua periferia",
            "Transferir de modo legal e gratuito",
            "Deslocar-se pelo ar",
            "Escapar do lugar em que se estava preso",
            "Existência evolui do nascimento até a morte",
            "Uma das divisões de uma casa",
            "Tudo aquilo que já não tem utilidade e é jogado fora",
            "Reputação",
            "Manifestação oficial que declara a preferência do eleitor em um processo eleitoral",
            "Apresenta vários condutores isolados uns dos outros, e que é protegido(a) por algum tipo de revestimento",
            "Sepultura",
            "Peça de vestuário para a mão",
            "Maneira ou costume mais predominante em um determinado grupo em um determinado momento que se refere a forma de vestir-se",
            "Comum nas igrejas e cemitérios",
            "Utilizado para afirmar ou aderir a alguma coisa",
            "Também chamados de bolores",
            "É atribuída à divisão dos pés, que formaram os braços e tentáculos",
            "Refresco ou bebida de fruta ou de vegetal",
            "Item do mobiliário geralmente encontrado no quarto de uma residência",
            "Estágio intrauterino após o embrião",
            "Som que o gato emite",
            "A lata é qualquer recipiente de metal para acondicionamento de alimentos ou bebidas",
            "Claridade proveniente da reflexão da luz sola pela Lua",
            "Expressão facial decorrente da contração dos músculos das extremidades da boca",
            "Animail originário da América e um dos maiores da fauna brasileira",
            "Repetição de uma sequência de sons parecidos",
            "Ser mitológico, característico dos mitos célticos e germânicos",
            "Aluna da INF3M que ama JAVA",
            "Linguagem de programação que começou a ser criada em 1991",
            "linguagem de marcação de hipertexto",
            "A palavra latina anima significa também “vida”, “espírito”, “sede do pensamento”",
            "Formado por vários meios transparentes além de um sistema fisiológico com inúmeros componentes",
            "Peça de roupa que cobre o pé",
            "Nova ...?",
            "Possui uma base circular formada por segmentos de reta que têm uma extremidade num vértice em comum",
            "O incrível ...?"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*DEFINE O CONTEUDO DA TELA*/
        setContentView(R.layout.activity_main);

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

    /*VERIFICA QUAL BOTAO FOI CLICADO*/
    View.OnClickListener clique = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            int identicadorBtn = (int) v.getTag();
            /*int letraClicada = 0;*/

            CharSequence letraBtn = btnAlfabeto[identicadorBtn].getText();/*RESGATANDO O TEXTO DO BOTAO*/

            for (int i=0; i <= 3; i++){ /*VERIFICANDO A POSICAO DA PALAVRA*/

                if (letraBtn.equals(palavras[palavraAleatoria][i])){

                    int id = getResources().getIdentifier("txtLetra" + i, "id", getPackageName());/*RESGATANDO O ID DO XML*/

                    txtLetra[i] = findViewById(id);

                    txtLetra[i].setText(letraBtn);

                    v.setEnabled(false);
                }
            }


            /*MUDA A COR*/
            /*if(){

            }*/

        }
    };





    public int aleatorio(){

        Random gerador = new Random();

        return gerador.nextInt(50);/*RETORNA O NUMERO ALEATORIO DE 0 A 50*/
    }



}
