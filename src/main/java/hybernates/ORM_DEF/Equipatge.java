package hybernates.ORM_DEF;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="equipatge")
public class Equipatge {
    @Id
    int id;
    @Column
    String nom;
    @Column
    double pes;
    @Column
    double preu;

    public Equipatge(int id, String nom, double pes, double preu) {
        this.id = id;
        this.nom = nom;
        this.pes = pes;
        this.preu=preu;
    }
    public Equipatge(String nom, double pes, double preu) {
        this.nom = nom;
        this.pes = pes;
        this.preu=preu;
    }

    public Equipatge() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPes() {
        return pes;
    }

    public void setPes(double pes) {
        this.pes = pes;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }
}
