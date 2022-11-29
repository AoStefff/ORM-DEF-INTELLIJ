package hybernates.ORM_DEF;

import javax.persistence.*;

@Entity
@Table(name="billet")
public class Bitllet {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id_bitllet;
    @Column
    double preu;
    @Column
    int tipus_s;
    @Column
    int id_viatge;

    public Bitllet() {
    }

    public Bitllet(int id, double preu, int tipusSeient, int idViatge) {
        this.id_bitllet = id;
        this.preu = preu;
        this.tipus_s = tipusSeient;
        this.id_viatge = idViatge;
    }
    public Bitllet(double preu, int tipusSeient, int idViatge) {
        this.preu = preu;
        this.tipus_s = tipusSeient;
        this.id_viatge = idViatge;
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

    public int getTipusSeient() {
        return tipus_s;
    }

    public void setTipusSeient(int tipusSeient) {
        this.tipus_s = tipusSeient;
    }

    public int getId_viatge() {
        return id_viatge;
    }

    public void setId_viatge(int id_viatge) {
        this.id_viatge = id_viatge;
    }
}
