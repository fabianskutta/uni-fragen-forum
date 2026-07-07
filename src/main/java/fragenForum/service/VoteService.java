package fragenForum.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import fragenForum.model.Antwort;
import fragenForum.model.Frage;
import fragenForum.model.Kommentar;
import fragenForum.model.Vote;
import fragenForum.repository.AntwortRepository;
import fragenForum.repository.FragenRepository;
import fragenForum.repository.KommentarRepository;
import fragenForum.repository.VoteRepository;

@Service
public class VoteService {

  private final VoteRepository voteRepository;
  private final FragenRepository fragenRepository;
  private final AntwortRepository antwortRepository;
  private final KommentarRepository kommentarRepository;

  public VoteService(VoteRepository voteRepository, FragenRepository fragenRepository,
      AntwortRepository antwortRepository, KommentarRepository kommentarRepository) {
    this.voteRepository = voteRepository;
    this.fragenRepository = fragenRepository;
    this.antwortRepository = antwortRepository;
    this.kommentarRepository = kommentarRepository;
  }

  public void voteFrage(UUID frageId, boolean voteWert) {
    Frage frage = fragenRepository.findById(frageId)
        .orElseThrow(() -> new IllegalArgumentException("Frage nicht gefunden"));

    Vote vote = new Vote();
    vote.setVoting(voteWert);
    vote.setFrage(frage);
    voteRepository.save(vote);
  }

  public void voteAntwort(UUID antwortId, boolean voteWert) {
    Antwort antwort = antwortRepository.findById(antwortId)
        .orElseThrow(() -> new IllegalArgumentException("Antwort nicht gefunden"));

    Vote vote = new Vote();
    vote.setVoting(voteWert);
    vote.setAntwort(antwort);
    voteRepository.save(vote);
  }

  public void voteKommentar(UUID kommentarId, boolean voteWert) {
    Kommentar kommentar = kommentarRepository.findById(kommentarId)
        .orElseThrow(() -> new IllegalArgumentException("Kommentar nicht gefunden"));

    Vote vote = new Vote();
    vote.setVoting(voteWert);
    vote.setKommentar(kommentar);
    voteRepository.save(vote);
  }

  public int getUpvotesFrage(UUID frageId) {
    Frage frage = fragenRepository.findById(frageId)
        .orElseThrow(() -> new IllegalArgumentException("Frage nicht gefunden"));
    return voteRepository.countByFrageAndVoting(frage, true);
  }

  public int getDownvotesFrage(UUID frageId) {
    Frage frage = fragenRepository.findById(frageId)
        .orElseThrow(() -> new IllegalArgumentException("Frage nicht gefunden"));
    return voteRepository.countByFrageAndVoting(frage, false);
  }

  public int getUpvotesAntwort(Antwort antwort) {
    return voteRepository.countByAntwortAndVoting(antwort, true);
  }

  public int getDownvotesAntwort(Antwort antwort) {
    return voteRepository.countByAntwortAndVoting(antwort, false);
  }

  public int getUpvotesKommentar(Kommentar kommentar) {
    return voteRepository.countByKommentarAndVoting(kommentar, true);
  }

  public int getDownvotesKommentar(Kommentar kommentar) {
    return voteRepository.countByKommentarAndVoting(kommentar, false);
  }
}
