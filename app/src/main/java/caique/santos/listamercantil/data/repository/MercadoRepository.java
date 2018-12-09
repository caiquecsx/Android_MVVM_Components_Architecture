package caique.santos.listamercantil.data.repository;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;
import caique.santos.listamercantil.data.AppDatabase;
import caique.santos.listamercantil.data.MercadoDao;
import caique.santos.listamercantil.entity.Mercado;

public class MercadoRepository {

    private MercadoDao mercadoDao;
    private LiveData<List<Mercado>> AllMercados;

    public MercadoRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        mercadoDao = database.mercadoDao();
        AllMercados = mercadoDao.getAllMercado();
    }

    public LiveData<List<Mercado>> getAllMercados() {
        return AllMercados;
    }

    public void insert(Mercado mercado){
        new insertAsyncTask(mercadoDao).execute(mercado);
    }

    private static class insertAsyncTask extends AsyncTask<Mercado, Void, Void>{
        private MercadoDao smercadoDao;

        insertAsyncTask(MercadoDao dao){
            smercadoDao = dao;
        }

        @Override
        protected Void doInBackground(Mercado... mercados) {
            smercadoDao.add(mercados[0]);
            return null;
        }
    }
}
