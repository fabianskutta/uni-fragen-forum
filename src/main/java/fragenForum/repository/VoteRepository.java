package fragenForum.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import fragenForum.model.Antwort;
import fragenForum.model.Frage;
import fragenForum.model.Kommentar;
import fragenForum.model.Vote;

public interface VoteRepository extends JpaRepository<Vote, UUID> {

  int countByFrageAndVoting(Frage frage, boolean voting);
  int countByAntwortAndVoting(Antwort antwort, boolean voting);
  int countByKommentarAndVoting(Kommentar kommentar, boolean voting);
}
