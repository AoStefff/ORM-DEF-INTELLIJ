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
    @JoinColumn(columnDefinition = "id",foreignKey  = @ForeignKey(name = "fk_desti"))
    Localitat id_origenn;
    int id_origen;
	@Column
    int id_desti;
	@Column
    LocalDateTime data;
	@Column
    int id_transport;
	@Column
    boolean habilitat;

    public Viatge() {
    }

    public Viatge(int idOrigen, int idDesti, LocalDateTime dataHora, int idTransport, boolean habilitat) {
        this.id_origen = idOrigen;
        this.id_desti = idDesti;
        this.data = dataHora;
        this.id_transport = idTransport;
        this.habilitat = habilitat;
    }
    public Viatge(int idViatge,int idOrigen, int idDesti, LocalDateTime dataHora, int idTransport, boolean habilitat) {
        this.id_viatge=idViatge;
        this.id_origen = idOrigen;
        this.id_desti = idDesti;
        this.data = dataHora;
        this.id_transport = idTransport;
        this.habilitat = habilitat;
    }



    public int getIdViatge() {
        return id_viatge;
    }

    public void setIdViatge(int idViatge) {
        this.id_viatge = idViatge;
    }

    public int getIdOrigen() {
        return id_origen;
    }

    public void setIdOrigen(int idOrigen) {
        this.id_origen = idOrigen;
    }

    public int getIdDesti() {
        return id_desti;
    }

    public void setIdDesti(int idDesti) {
        this.id_desti = idDesti;
    }

    public LocalDateTime getDataHora() {
        return data;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.data = dataHora;
    }

    public int getIdTransport() {
        return id_transport;
    }

    public void setIdTransport(int idTransport) {
        this.id_transport = idTransport;
    }

    public boolean isHabilitat() {
        return habilitat;
    }

    public void setHabilitat(boolean habilitat) {
        this.habilitat = habilitat;
    }
}
