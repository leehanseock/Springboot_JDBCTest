package kr.ac.kopo.leehanseock.springboot_jdbctest.controller;

import kr.ac.kopo.leehanseock.springboot_jdbctest.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/exam01")
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping
    public String requestMethod(Model model) {
        String sql = "select * from person";
        List<Person> personList= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Person.class));
        System.out.println("personList : " + personList);
        model.addAttribute("personList",personList);
        return "viewPage01";
    }

    @GetMapping("/new")
        public String newMethod(Model model) {
            String sql = "select * from person";
            Person person = new Person();
            model.addAttribute("person", person);
            return "viewPage01_new";
    }

    @PostMapping("/insert")
        public String insertMethod(@ModelAttribute Person person) {
            String sql = "insert into person (name, age, email) values (?, ?, ?)";
            //jdbcTemplate.update(sql, person.getName(), person.getAge(), person.getEmail());
            Object[] params = {person.getName(), person.getAge(), person.getEmail()};
            int resultCount = jdbcTemplate.update(sql, params);
        return "redirect:/exam01";
    }
}
