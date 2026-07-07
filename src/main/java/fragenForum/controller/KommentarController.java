package fragenForum.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fragenForum.model.Kommentar;
import fragenForum.service.KommentarService;

@Controller
@RequestMapping("/kommentar")
public class KommentarController {

  private final KommentarService kommentarService;

  public KommentarController(KommentarService kommentarService) {
    this.kommentarService = kommentarService;
  }

  @PostMapping("/{frageId}/antworten/{antwortId}/kommentare")
  public String addKommentarZuAntwort(@PathVariable UUID frageId,
      @PathVariable UUID antwortId,
      @ModelAttribute Kommentar neuerKommentar) {
    kommentarService.saveZuAntwort(neuerKommentar, antwortId);
    return "redirect:/fragen/" + frageId;
  }
}
