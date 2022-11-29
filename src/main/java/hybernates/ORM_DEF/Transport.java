package hybernates.ORM_DEF;

import javax.persistence.*;

@Entity
@Table(name="transport")
public class Transport {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    @Column
    int sNormal;
    @Column
    int sPreferent;
    @Column
    String nom;
    @Column
    int maxPes;

    public Transport() {
    }

    public Transport(int idTransport, int sNormal, int sPreferent, String nom, int max_pes) {
        this.id = idTransport;
        this.sNormal = sNormal;
        this.sPreferent = sPreferent;
        this.nom = nom;
        this.maxPes =max_pes;
    }
    public Transport(int sNormal, int sPreferent, String nom, int max_pes) {
        this.sNormal = sNormal;
        this.sPreferent = sPreferent;
        this.nom = nom;
        this.maxPes =max_pes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getsNormal() {
        return sNormal;
    }

    public void setsNormal(int sNormal) {
        this.sNormal = sNormal;
    }

    public int getsPreferent() {
        return sPreferent;
    }

    public void setsPreferent(int sPreferent) {
        this.sPreferent = sPreferent;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getMaxPes() {
        return maxPes;
    }

    public void setMaxPes(int maxPes) {
        this.maxPes = maxPes;
    }
}


