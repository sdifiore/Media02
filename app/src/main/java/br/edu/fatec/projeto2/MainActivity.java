package br.edu.fatec.pedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText notaP1, notaP2, notaP3;
    private TextView notaMedia, situacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // vinculação da parte gráfica com a codificação

        notaP1 = (EditText) findViewById(R.id.notaP1);
        notaP2 = (EditText) findViewById(R.id.notaP1);
        notaP3 = (EditText) findViewById(R.id.notaP3);
        notaMedia = (TextView) findViewById(R.id.notaMedia);
        situacao = (TextView) findViewById(R.id.situacao);

        // Chamada do método "calcular" pelo botão Calcular

        Button btCalcular = (Button) findViewById(R.id.btCalcular);
        btCalcular.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular(view);
            }
        });
    }

    // Criação do método para calcular a média das notas e definir a situação do aluno

    public void calcular(View view) {

        float p1 = Float.parseFloat(notaP1.getText().toString());
        float p2 = Float.parseFloat(notaP2.getText().toString());

        // média = (P1*2 + P2*3)/5, e a P3 substituirá a menor nota entre a P1 e a P2, caso seja necessário

        if ((p1*2 + p2*3)/5 < 6.0f) {
            if (p1 < p2) {
                p1 = Float.parseFloat(notaP3.getText().toString());
            } else {
                p2 = Float.parseFloat(notaP3.getText().toString());
            }
        }

        float media = (p1*2 + p2*3)/5;
        notaMedia.setText(Float.toString(media));
        situacao.setText((media >= 6.0f) ? "Aprovado(a)" : "Reprovado(a)");

    }

    // Chamada do método "enviar" pelo botão Enviar

    public void enviar(View view) {
        Intent intent = new Intent(getApplicationContext(), ProximaActivity.class);
        intent.putExtra("notaP1",((EditText)findViewById(R.id.notaP1)).getText().toString());
        intent.putExtra("notaP2",((EditText)findViewById(R.id.notaP1)).getText().toString());
        intent.putExtra("notaP3",((EditText)findViewById(R.id.notaP3)).getText().toString());
        intent.putExtra("notaMedia",((TextView)findViewById(R.id.notaMedia)).getText().toString());
        intent.putExtra("situacao", ((TextView)findViewById(R.id.situacao)).getText().toString());
        startActivity(intent);
    }
}