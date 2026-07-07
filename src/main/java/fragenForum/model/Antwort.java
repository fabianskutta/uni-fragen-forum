package fragenForum.model;


import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Antwort")
public class Antwort {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "antwortid")
  private UUID antwortId;

  @Column(name = "antworttext")
  private String antwortText;

  @ManyToOne
  @JoinColumn(name = "frageid")
  private Frage frage;

  @OneToMany(mappedBy ="antwort" ) // Hier ist die Spalte nicht vorhanden. Ich verweise nur auf eine Relation
  private List<Kommentar> kommentareListe;

  public UUID getAntwortId() {
    return antwortId;
  }

  public void setAntwortId(final UUID antwortId) {
    this.antwortId = antwortId;
  }

  public String getAntwortText() {
    return antwortText;
  }

  public void setAntwortText(final String antwortText) {
    this.antwortText = antwortText;
  }

  public Frage getFrage() {
    return frage;
  }

  public void setFrage(final Frage frage) {
    this.frage = frage;
  }

  public List<Kommentar> getKommentareListe() {
    return kommentareListe;
  }

  public void setKommentareListe(final List<Kommentar> kommentareListe) {
    this.kommentareListe = kommentareListe;
  }
}
