package br.edu.fatec.pedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ProximaActivity extends AppCompatActivity {

    private EditText disciplina, aluno, faltas;
    private String notaP1, notaP2, notaP3, notaMedia, situacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxima);

        // Vinculação da parte gráfica com a codificação

        disciplina = (EditText) findViewById(R.id.disciplina);
        aluno = (EditText) findViewById(R.id.aluno);
        faltas = (EditText) findViewById(R.id.faltas);

        // Recuperação das informações passadas da primeira activity

        notaP1 = getIntent().getStringExtra("notaP1");
        notaP2 = getIntent().getStringExtra("notaP2");
        notaP3 = getIntent().getStringExtra("notaP3");
        notaMedia = getIntent().getStringExtra("notaMedia");
        situacao = getIntent().getStringExtra("situacao");
    }

    // Criação do método "compartilhar" pelo botão Compartilhar

    public void compartilhar(View view) {

        // Mensagem a ser compartilhada

        String mensagem = "O(a) aluno(a) " + aluno.getText().toString() + " foi " + situacao +
                " com média " + notaMedia + " em " + disciplina.getText().toString() +
                " com as notas P1 = " + notaP1 + ", P2 = " + notaP2 + ", P3 = " + notaP3 +
                " e " + faltas.getText().toString() + " falta(s)!";

        // Compartilhamento

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Situação acadêmica");
        intent.putExtra(Intent.EXTRA_TEXT, mensagem);
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent, "Compartilhando com..."));
    }
}