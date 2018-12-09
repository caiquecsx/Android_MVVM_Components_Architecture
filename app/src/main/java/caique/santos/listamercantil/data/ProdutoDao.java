package caique.santos.listamercantil.data;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import caique.santos.listamercantil.entity.Produto;

@Dao
public interface ProdutoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long add(Produto produto);

    @Update
    void update(Produto produto);

    @Delete
    void delete(Produto produto);

    @Query("SELECT * FROM produto_table")
    LiveData<List<Produto>> getAllProduto();
}
