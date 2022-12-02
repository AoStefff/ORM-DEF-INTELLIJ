package hybernates.ORM_DEF;

import javax.persistence.*;

@Entity
@Table(name="localitat")
public class Localitat {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id_localitat;
    @Column
    String nom;
    @Column
    String pais;
    @Column
    String abreviacio;

    public Localitat() {
    }

    public Localitat(int id, String nom, String pais, String abreviacio) {
        this.id_localitat = id;
        this.nom = nom;
        this.pais = pais;
        this.abreviacio = abreviacio;
    }
    public Localitat(String nom, String pais, String abreviacio) {
        this.id_localitat = id_localitat;
        this.nom = nom;
        this.pais = pais;
        this.abreviacio = abreviacio;
    }

    public int getId_localitat() {
        return id_localitat;
    }

    public void setId_localitat(int id_localitat) {
        this.id_localitat = id_localitat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getAbreviacio() {
        return abreviacio;
    }

    public void setAbreviacio(String abreviacio) {
        this.abreviacio = abreviacio;
    }
}
