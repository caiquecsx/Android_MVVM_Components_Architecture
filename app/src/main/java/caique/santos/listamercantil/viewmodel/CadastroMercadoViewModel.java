package caique.santos.listamercantil.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import caique.santos.listamercantil.data.repository.MercadoRepository;
import caique.santos.listamercantil.entity.Mercado;

public class CadastroMercadoViewModel extends AndroidViewModel {

    private MercadoRepository mercadoRepository;

    public CadastroMercadoViewModel(@NonNull Application application) {
        super(application);
        mercadoRepository = new MercadoRepository(application);
    }

    public void insert(Mercado mercado) {
        mercadoRepository.insert(mercado);
    }
}
