package fragenForum.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import fragenForum.model.Antwort;
import fragenForum.model.Frage;

public interface AntwortRepository extends JpaRepository<Antwort, UUID> {

  List<Antwort> findByFrage(Frage frage);
}
