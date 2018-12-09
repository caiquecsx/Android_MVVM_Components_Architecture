package caique.santos.listamercantil.data;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import caique.santos.listamercantil.entity.Mercado;

@Dao
public interface MercadoDao {
    @Insert
    long add(Mercado mercado);

    @Update
    void update(Mercado mercado);

    @Delete
    void delete(Mercado mercado);

    @Query("DELETE FROM mercado_table")
    void deleteAll();

    @Query("SELECT * FROM mercado_table")
    LiveData<List<Mercado>> getAllMercado();
}
