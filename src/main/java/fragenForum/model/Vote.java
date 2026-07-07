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
@Table(name="Vote")
public class Vote {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "voteid")
  private UUID voteId;

  @Column(name ="voting")
  private boolean voting;

  @ManyToOne
  @JoinColumn(name="antwortid")
  private Antwort antwort;

  @ManyToOne
  @JoinColumn(name="frageid")
  private Frage frage;

  @ManyToOne
  @JoinColumn(name="kommentarid")
  private Kommentar kommentar;


  public UUID getVoteId() {
    return voteId;
  }

  public void setVoteId(final UUID voteId) {
    this.voteId = voteId;
  }



  public boolean isVoting() {
    return voting;
  }

  public void setVoting(final boolean voting) {
    this.voting = voting;
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

  public Kommentar getKommentar() {
    return kommentar;
  }

  public void setKommentar(final Kommentar kommentar) {
    this.kommentar = kommentar;
  }
}
