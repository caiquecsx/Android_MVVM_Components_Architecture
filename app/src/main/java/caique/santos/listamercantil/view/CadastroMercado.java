package caique.santos.listamercantil.view;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import caique.santos.listamercantil.R;
import caique.santos.listamercantil.entity.Mercado;
import caique.santos.listamercantil.viewmodel.CadastroMercadoViewModel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class CadastroMercado extends AppCompatActivity {

    public static void Push(Context context){
        Intent intent = new Intent(context, CadastroMercado.class);
        ((Activity)context).startActivityForResult(intent, 1);
    }

    private ActionBar actionBar;
    private CadastroMercadoViewModel cadastroMercadoViewModel;

    @BindView(R.id.activity_cadastro_mercado_edt_nome)
    EditText edt_nome;

    @BindView(R.id.activity_cadastro_mercado_edt_endereco)
    EditText edt_endereco;

    @BindView(R.id.activity_cadastro_mercado_edt_telefone)
    EditText edt_telefone;

    @BindView(R.id.activity_cadastro_mercado_bt_salvar)
    Button bt_salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_mercado);
        actionBar = getSupportActionBar();
        actionBar.setTitle("Novo Mercantil");
        actionBar.setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);

        cadastroMercadoViewModel = ViewModelProviders
                .of(this)
                .get(CadastroMercadoViewModel.class);
    }

    @OnClick(R.id.activity_cadastro_mercado_bt_salvar)
    public void salvar() {
        if( TextUtils.isEmpty( edt_nome.getText() ) ) {
            edt_nome.setError("Campo vazio!");
        } else if ( TextUtils.isEmpty(edt_telefone.getText()) ) {
            edt_telefone.setError("Campo vazio!");
        } else if ( TextUtils.isEmpty( edt_endereco.getText() ) ) {
            edt_endereco.setError("Campo vazio!");
        }else{
            esconderTeclado();
            cadastroMercadoViewModel.insert(
                    new Mercado(
                            0,
                            edt_nome.getText().toString(),
                            edt_telefone.getText().toString(),
                            edt_endereco.getText().toString()
                    )
            );
            Toast.makeText(this, "Mercado inserido!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void esconderTeclado() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        if(imm.isAcceptingText()) { // verify if the soft keyboard is open
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }
}
