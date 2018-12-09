package caique.santos.listamercantil.data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import caique.santos.listamercantil.entity.Mercado;
import caique.santos.listamercantil.entity.Produto;

@Database(entities = {Produto.class, Mercado.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public static synchronized AppDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room
                    .databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "prjdbase")
                    .addCallback(sAppDatabaseCallback)
                    .build();
        }
        return INSTANCE;
    }

    public abstract MercadoDao mercadoDao();
    public abstract ProdutoDao produtoDao();

    private static AppDatabase.Callback sAppDatabaseCallback =
            new AppDatabase.Callback() {
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void>{
        private final MercadoDao mercadoDao;

        PopulateDbAsync(AppDatabase appDatabase){
            mercadoDao = appDatabase.mercadoDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mercadoDao.deleteAll();
            Mercado mercado =
                    new Mercado(0, "Canadá",
                            "32572544", "Rua Duas Nações N 4444");
            mercadoDao.add(mercado);

            return null;
        }
    }
}
