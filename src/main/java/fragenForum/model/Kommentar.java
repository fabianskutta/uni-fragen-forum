package fragenForum.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Kommentar")
public class Kommentar {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "kommentarid")
  private UUID kommentarId;

  @Column(name="kommentartext")
  private String kommentarText;

  @ManyToOne // Hier ist Spalte antwortId wirklich vorhanden -> ich benötige kein mappedBy
  @JoinColumn(name ="antwortid")
  private Antwort antwort;

  @ManyToOne
  @JoinColumn(name ="frageid")
  private Frage frage;




  public UUID getKommentarId() {
    return kommentarId;
  }

  public void setKommentarId(final UUID kommentarId) {
    this.kommentarId = kommentarId;
  }

  public String getKommentarText() {
    return kommentarText;
  }

  public void setKommentarText(final String kommentar) {
    this.kommentarText = kommentar;
  }

  public Antwort getAntwort() {
    return antwort;
  }

  public void setAntwort(final Antwort antwort) {
    this.antwort = antwort;
  }

  public Frage getFrage() {
    return frage;
  }

  public void setFrage(final Frage frage) {
    this.frage = frage;
  }
}
