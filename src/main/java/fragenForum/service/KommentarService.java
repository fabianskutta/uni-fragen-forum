package fragenForum.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import fragenForum.model.Antwort;
import fragenForum.model.Frage;
import fragenForum.model.Kommentar;
import fragenForum.repository.AntwortRepository;
import fragenForum.repository.FragenRepository;
import fragenForum.repository.KommentarRepository;

@Service
public class KommentarService {

  private final AntwortRepository antwortRepository;
  private final FragenRepository fragenRepository;
  private final KommentarRepository kommentarRepository;

  public KommentarService(AntwortRepository antwortRepository,
      FragenRepository fragenRepository,
      KommentarRepository kommentarRepository) {
    this.antwortRepository = antwortRepository;
    this.fragenRepository = fragenRepository;
    this.kommentarRepository = kommentarRepository;
  }

  public List<Kommentar> findByFrageId(UUID frageId) {
    Frage frage = fragenRepository.findById(frageId)
                                  .orElseThrow(() -> new IllegalArgumentException("Frage nicht gefunden"));

    return kommentarRepository.findByFrage(frage);
  }

  public void saveZuFrage(Kommentar kommentar, UUID frageId) {
    Frage frage = fragenRepository.findById(frageId)
                                  .orElseThrow(() -> new IllegalArgumentException("Frage nicht gefunden"));

    kommentar.setFrage(frage);
    kommentar.setAntwort(null);
    kommentarRepository.save(kommentar);
  }

  public void saveZuAntwort(Kommentar kommentar, UUID antwortId) {
    Antwort antwort = antwortRepository.findById(antwortId)
                                       .orElseThrow(() -> new IllegalArgumentException("Antwort nicht gefunden"));

    kommentar.setAntwort(antwort);
    kommentar.setFrage(null);
    kommentarRepository.save(kommentar);
  }
}
