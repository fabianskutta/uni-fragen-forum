package fragenForum.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fragenForum.service.VoteService;

@Controller
@RequestMapping("/vote")
public class VoteController {

  private final VoteService voteService;

  public VoteController(VoteService voteService) {
    this.voteService = voteService;
  }

  @PostMapping("/frage/{frageId}")
  public String voteFrage(@PathVariable UUID frageId, @RequestParam boolean up) {
    voteService.voteFrage(frageId, up);
    return "redirect:/fragen/" + frageId;
  }

  @PostMapping("/antwort/{antwortId}")
  public String voteAntwort(@PathVariable UUID antwortId, @RequestParam UUID frageId,
      @RequestParam boolean up) {
    voteService.voteAntwort(antwortId, up);
    return "redirect:/fragen/" + frageId;
  }

  @PostMapping("/kommentar/{kommentarId}")
  public String voteKommentar(@PathVariable UUID kommentarId, @RequestParam UUID frageId,
      @RequestParam boolean up) {
    voteService.voteKommentar(kommentarId, up);
    return "redirect:/fragen/" + frageId;
  }
}
