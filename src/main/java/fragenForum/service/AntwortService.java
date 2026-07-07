package fragenForum.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import fragenForum.model.Antwort;
import fragenForum.model.Frage;
import fragenForum.repository.AntwortRepository;
import fragenForum.repository.FragenRepository;

@Service
public class AntwortService {

  private final AntwortRepository antwortRepository;
  private final FragenRepository fragenRepository;

  public AntwortService(AntwortRepository antwortRepository,
      FragenRepository fragenRepository) {
    this.antwortRepository = antwortRepository;
    this.fragenRepository = fragenRepository;
  }

  public List<Antwort> findByFrageId(UUID frageId) {
    Frage frage = fragenRepository.findById(frageId)
                                  .orElseThrow(() -> new IllegalArgumentException("Frage nicht gefunden"));

    return antwortRepository.findByFrage(frage);
  }

  public void save(Antwort antwort, UUID frageId) {
    Frage frage = fragenRepository.findById(frageId)
                                  .orElseThrow(() -> new IllegalArgumentException("Frage nicht gefunden"));

    antwort.setFrage(frage);
    antwortRepository.save(antwort);
  }

}
