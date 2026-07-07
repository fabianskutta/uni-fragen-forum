package fragenForum.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fragenForum.model.Frage;
import fragenForum.service.FragenService;
import fragenForum.service.VoteService;

@Controller
public class FragenController {

  private final FragenService fragenService;
  private final VoteService voteService;

  public FragenController(FragenService fragenService, VoteService voteService) {
    this.fragenService = fragenService;
    this.voteService = voteService;
  }

  @GetMapping({"/", "/fragen"})
  public String showFragen(Model model) {
    List<Frage> fragenListe = fragenService.listAllFragen();

    Map<UUID, Integer> scores = new LinkedHashMap<>();
    for (Frage f : fragenListe) {
      int score = voteService.getUpvotesFrage(f.getFrageId())
                - voteService.getDownvotesFrage(f.getFrageId());
      scores.put(f.getFrageId(), score);
    }

    fragenListe.sort((a, b) ->
        Integer.compare(scores.get(b.getFrageId()), scores.get(a.getFrageId())));

    model.addAttribute("fragenListe", fragenListe);
    model.addAttribute("scores", scores);
    model.addAttribute("neueFrage", new Frage());
    return "fragen";
  }

  @PostMapping("/fragen")
  public String addFrage(Frage neueFrage) {
    fragenService.save(neueFrage);
    return "redirect:/";
  }

}
