package hybernates.ORM_DEF;

import javax.persistence.*;

@Entity
@Table(name="bitllet")
public class Bitllet {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id_bitllet;
    @Column
    double preu;
    @Column
    int tipus_s;

    @ManyToOne
    @JoinColumn(columnDefinition = "id_viatge",foreignKey  = @ForeignKey(name = "fk_viatge"))
    Viatge id_viatge;

    public Bitllet() {

    }

    public Bitllet(int id, double preu, int tipusSeient, Viatge id_viatge) {
        this.id_bitllet = id;
        this.preu = preu;
        this.tipus_s = tipusSeient;
        this.id_viatge = id_viatge;
    }
    public Bitllet(double preu, int tipusSeient,  Viatge id_viatge) {
        this.preu = preu;
        this.tipus_s = tipusSeient;
        this.id_viatge = id_viatge;
    }

    public int getId_bitllet() {
        return id_bitllet;
    }

    public void setId_bitllet(int id_bitllet) {
        this.id_bitllet = id_bitllet;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public int getTipus_s() {
        return tipus_s;
    }

    public void setTipus_s(int tipus_s) {
        this.tipus_s = tipus_s;
    }

    public Viatge getId_viatge() {
        return id_viatge;
    }

    public void setId_viatge(Viatge id_viatge) {
        this.id_viatge = id_viatge;
    }
}
