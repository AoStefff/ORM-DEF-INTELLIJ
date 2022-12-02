package hybernates.ORM_DEF;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name="viatge")
public class Viatge {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    int id_viatge;

    @ManyToOne
    @JoinColumn(columnDefinition = "id_localitat",foreignKey  = @ForeignKey(name = "fk_origen"))
    Localitat id_origen;

    @ManyToOne
    @JoinColumn(columnDefinition = "id_localitat",foreignKey  = @ForeignKey(name = "fk_desti"))
    Localitat id_desti;

	@Column
    LocalDateTime data;

    @ManyToOne
    @JoinColumn(columnDefinition = "id_transport",foreignKey  = @ForeignKey(name = "fk_transport"))
    Transport id_transport;

	@Column
    boolean habilitat;

    public Viatge() {
    }

    public Viatge(Localitat id_origen, Localitat id_desti, LocalDateTime dataHora, Transport id_transport, boolean habilitat) {
        this.id_origen = id_origen;
        this.id_desti = id_desti;
        this.data = dataHora;
        this.id_transport = id_transport;
        this.habilitat = habilitat;
    }

    public int getId_viatge() {
        return id_viatge;
    }

    public void setId_viatge(int id_viatge) {
        this.id_viatge = id_viatge;
    }

    public Localitat getId_origen() {
        return id_origen;
    }

    public void setId_origen(Localitat id_origen) {
        this.id_origen = id_origen;
    }

    public Localitat getId_desti() {
        return id_desti;
    }

    public void setId_desti(Localitat id_desti) {
        this.id_desti = id_desti;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Transport getId_transport() {
        return id_transport;
    }

    public void setId_transport(Transport id_transport) {
        this.id_transport = id_transport;
    }

    public boolean isHabilitat() {
        return habilitat;
    }

    public void setHabilitat(boolean habilitat) {
        this.habilitat = habilitat;
    }
}
