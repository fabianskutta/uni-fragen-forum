package fragenForum.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import fragenForum.model.Frage;
import fragenForum.repository.FragenRepository;

@Service
public class FragenService {

  private final FragenRepository repo;

  public FragenService(FragenRepository repo) {
    this.repo = repo;
  }

  public List<Frage> listAllFragen() {
    return repo.findAll();
  }

  public void save(Frage frage) {
    repo.save(frage);
  }

  public Frage findById(UUID id) {
    return repo.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("Frage nicht gefunden: " + id));
  }
}
