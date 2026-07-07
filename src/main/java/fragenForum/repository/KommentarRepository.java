package fragenForum.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import fragenForum.model.Frage;
import fragenForum.model.Kommentar;

public interface KommentarRepository extends JpaRepository<Kommentar, UUID> {

  List<Kommentar> findByFrage(Frage frage);
}
