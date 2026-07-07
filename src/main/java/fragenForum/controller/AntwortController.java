package fragenForum.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fragenForum.model.Antwort;
import fragenForum.model.Frage;
import fragenForum.model.Kommentar;
import fragenForum.service.AntwortService;
import fragenForum.service.FragenService;
import fragenForum.service.KommentarService;
import fragenForum.service.VoteService;

@Controller
@RequestMapping("/fragen")
public class AntwortController {

  private final FragenService fragenService;
  private final AntwortService antwortService;
  private final KommentarService kommentarService;
  private final VoteService voteService;

  public AntwortController(FragenService fragenService, AntwortService antwortService,
      KommentarService kommentarService, VoteService voteService) {
    this.fragenService = fragenService;
    this.antwortService = antwortService;
    this.kommentarService = kommentarService;
    this.voteService = voteService;
  }

  @GetMapping("/{id}")
  public String showFrageDetails(@PathVariable UUID id, Model model) {

    Frage frage = fragenService.findById(id);

    model.addAttribute("frage", frage);
    model.addAttribute("antwortenListe", antwortService.findByFrageId(id));
    model.addAttribute("neueAntwort", new Antwort());
    model.addAttribute("kommentareListe", kommentarService.findByFrageId(id));
    model.addAttribute("neuerKommentar", new Kommentar());
    model.addAttribute("frageUpvotes", voteService.getUpvotesFrage(id));
    model.addAttribute("frageDownvotes", voteService.getDownvotesFrage(id));

    return "details";
  }

  @PostMapping("/{id}/antworten")
  public String addAntwort(@PathVariable UUID id,
      @ModelAttribute("neueAntwort") Antwort neueAntwort) {
    antwortService.save(neueAntwort, id);
    return "redirect:/fragen/" + id;
  }

  @PostMapping("/{id}/kommentare")
  public String addKommentar(@PathVariable UUID id,
      @ModelAttribute("neuerKommentar") Kommentar neuerKommentar) {
    kommentarService.saveZuFrage(neuerKommentar, id);
    return "redirect:/fragen/" + id;
  }

}
