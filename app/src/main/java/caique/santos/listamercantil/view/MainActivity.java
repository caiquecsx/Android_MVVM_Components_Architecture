package caique.santos.listamercantil.view;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import caique.santos.listamercantil.R;
import caique.santos.listamercantil.entity.Mercado;
import caique.santos.listamercantil.viewmodel.MainActivityViewModel;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mainActivityViewModel;

    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.activity_main_recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        final MercadoListAdapter mercadoListAdapter =
                new MercadoListAdapter(this);
        recyclerView.setAdapter(mercadoListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mainActivityViewModel = ViewModelProviders
                .of(this)
                .get(MainActivityViewModel.class);

        mainActivityViewModel.getAllMercados().observe(this, new Observer<List<Mercado>>() {
            @Override
            public void onChanged(List<Mercado> mercados) {
                mercadoListAdapter.setMercados(mercados);
            }
        });
    }

    @OnClick(R.id.fab)
    public void fabClick(View view) {
        CadastroMercado.Push(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
