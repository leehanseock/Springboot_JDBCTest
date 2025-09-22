package kr.ac.kopo.leehanseock.springboot_jdbctest.controller;

import kr.ac.kopo.leehanseock.springboot_jdbctest.domain.Player;
import kr.ac.kopo.leehanseock.springboot_jdbctest.domain.Team;
import kr.ac.kopo.leehanseock.springboot_jdbctest.repository.PlayerRepository;
import kr.ac.kopo.leehanseock.springboot_jdbctest.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/exam07")
public class Example07Controller {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping
    public String example07(Model model) {
        Team team = new Team();
        team.setName("team01");
        teamRepository.save(team);

        Player player = new Player();
        player.setName("player01");
        player.setTeam(team);
        playerRepository.save(player);

        List<Player> players = playerRepository.findAll();
        List<Team> teams = teamRepository.findAll();

        model.addAttribute("playerList", players);
        model.addAttribute("teamList", teams);

        return "viewPage07";
    }

}
