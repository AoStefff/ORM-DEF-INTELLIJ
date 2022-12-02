package hybernates.ORM_DEF;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="factura_equipatge")
public class FacEquip implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(columnDefinition = "id_viatge",foreignKey = @ForeignKey(name = "fk_viatge"))
    Viatge id_viatge;

    @ManyToOne
    @JoinColumn(columnDefinition = "id_client",foreignKey = @ForeignKey(name = "fk_client"))
    Client id_client;

    @ManyToOne
    @JoinColumn(columnDefinition = "id_equipatge",foreignKey = @ForeignKey(name = "fk_equipatge"))
    Equipatge id_equipatge;

    public FacEquip() {

    }

    public FacEquip( Viatge id_viatge, Client id_client, Equipatge id_equipatge) {
        this.id_viatge = id_viatge;
        this.id_client = id_client;
        this.id_equipatge = id_equipatge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Equipatge getId_equipatge() {
        return id_equipatge;
    }

    public void setId_equipatge(Equipatge id_equipatge) {
        this.id_equipatge = id_equipatge;
    }
}
