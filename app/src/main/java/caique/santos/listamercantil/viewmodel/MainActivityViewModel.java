package caique.santos.listamercantil.viewmodel;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import caique.santos.listamercantil.data.repository.MercadoRepository;
import caique.santos.listamercantil.entity.Mercado;

public class MainActivityViewModel extends AndroidViewModel {

    private MercadoRepository mercadoRepository;
    private LiveData<List<Mercado>> AllMercados;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        mercadoRepository = new MercadoRepository(application);
        AllMercados = mercadoRepository.getAllMercados();
    }

    public LiveData<List<Mercado>> getAllMercados(){
        return AllMercados;
    }

    public void insert(Mercado mercado){
        mercadoRepository.insert(mercado);
    }
}
