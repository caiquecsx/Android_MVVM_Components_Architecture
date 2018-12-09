package caique.santos.listamercantil.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "produto_table",
        indices = {@Index({"mercadoId"})},
        foreignKeys =
@ForeignKey(entity = Mercado.class,
        parentColumns = "id",
        childColumns = "mercadoId",
        onDelete = ForeignKey.CASCADE
            ))
public class Produto {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "nome")
    private String nome;
    @ColumnInfo(name = "marca")
    private String marca;
    @ColumnInfo(name = "preco")
    private int preço;
    @ColumnInfo(name = "syncPending")
    private boolean syncPending;
    @ColumnInfo(name = "mercadoId")
    private int mercadoId;

    public Produto(int id, String nome, String marca,
                   int preço, boolean syncPending, int mercadoId) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.preço = preço;
        this.syncPending = syncPending;
        this.mercadoId = mercadoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPreço() {
        return preço;
    }

    public void setPreço(int preço) {
        this.preço = preço;
    }

    public boolean isSyncPending() {
        return syncPending;
    }

    public void setSyncPending(boolean syncPending) {
        this.syncPending = syncPending;
    }

    public int getMercadoId() {
        return mercadoId;
    }

    public void setMercadoId(int mercadoId) {
        this.mercadoId = mercadoId;
    }
}
