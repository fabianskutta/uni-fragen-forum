package fragenForum.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Frage")
public class Frage {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name="frageid")
  private UUID frageId;

  @Column(name ="fragetext")
  private String frageText;

  @Column(name = "ersteller_name")
  private String erstellerName;

  @Column(name = "beschreibung", length = 2000)
  private String beschreibung;


  @OneToMany(mappedBy = "frage")
  private List<Antwort> antwortenListe = new ArrayList<>();

  @OneToMany(mappedBy = "frage")
  private List<Kommentar> kommentareListe = new ArrayList<>();


  public UUID getFrageId() {
    return frageId;
  }

  public void setFrageId(final UUID frageId) {
    this.frageId = frageId;
  }

  public String getFrageText() {
    return frageText;
  }

  public void setFrageText(final String frageText) {
    this.frageText = frageText;
  }

  public List<Antwort> getAntwortenListe() {
    return antwortenListe;
  }

  public void setAntwortenListe(final List<Antwort> antwortenListe) {
    this.antwortenListe = antwortenListe;
  }

  public List<Kommentar> getKommentareListe() {
    return kommentareListe;
  }

  public void setKommentareListe(final List<Kommentar> kommentareListe) {
    this.kommentareListe = kommentareListe;
  }

  public String getErstellerName() {
    return erstellerName;
  }

  public void setErstellerName(final String erstellerName) {
    this.erstellerName = erstellerName;
  }

  public String getBeschreibung() {
    return beschreibung;
  }

  public void setBeschreibung(final String beschreibung) {
    this.beschreibung = beschreibung;
  }
}
