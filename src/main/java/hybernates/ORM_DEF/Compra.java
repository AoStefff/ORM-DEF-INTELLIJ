package hybernates.ORM_DEF;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="compra")
public class Compra {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int idCompra;

    @ManyToOne
    @JoinColumn(columnDefinition = "id_bitllet",foreignKey = @ForeignKey(name = "fk_bitllet"))
    Bitllet id_bitllet;

    @ManyToOne
    @JoinColumn(columnDefinition = "id_viatge",foreignKey = @ForeignKey(name = "fk_viatge"))
    Viatge id_viatge;

    @ManyToOne
    @JoinColumn(columnDefinition = "id_client",foreignKey = @ForeignKey(name = "fk_client"))
    Client id_client;
    @Column
    LocalDate dataCompra;
    @Column
    double preu;
    @Column
    String nomPassatger;
    @Column
    String dniPassatger;

    public Compra() {
    }

    public Compra(Bitllet id_bitllet, Viatge id_viatge, Client id_client, LocalDate dataCompra, double preu, String nomPassatger, String dniPassatger) {
        this.id_bitllet = id_bitllet;
        this.id_viatge = id_viatge;
        this.id_client = id_client;
        this.dataCompra = dataCompra;
        this.preu = preu;
        this.nomPassatger = nomPassatger;
        this.dniPassatger = dniPassatger;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Bitllet getId_bitllet() {
        return id_bitllet;
    }

    public void setId_bitllet(Bitllet id_bitllet) {
        this.id_bitllet = id_bitllet;
    }

    public Viatge getId_viatge() {
        return id_viatge;
    }

    public void setId_viatge(Viatge id_viatge) {
        this.id_viatge = id_viatge;
    }

    public Client getId_client() {
        return id_client;
    }

    public void setId_client(Client id_client) {
        this.id_client = id_client;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public String getNomPassatger() {
        return nomPassatger;
    }

    public void setNomPassatger(String nomPassatger) {
        this.nomPassatger = nomPassatger;
    }

    public String getDniPassatger() {
        return dniPassatger;
    }

    public void setDniPassatger(String dniPassatger) {
        this.dniPassatger = dniPassatger;
    }
}
