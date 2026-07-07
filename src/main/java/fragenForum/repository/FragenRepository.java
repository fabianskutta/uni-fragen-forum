package fragenForum.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fragenForum.model.Frage;

@Repository
public interface FragenRepository extends JpaRepository<Frage, UUID> {
}