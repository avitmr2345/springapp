package com.myfirst_springapp.springapp.rest;

import java.util.List;
import java.util.ArrayList;
import com.myfirst_springapp.springapp.entity.Candidate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class CandidateRestController {

    private List<Candidate> theEmployees;

    @PostConstruct
    public void loadData() {
        theEmployees = new ArrayList<>();

        theEmployees.add(new Candidate("Avish", "Tomar"));
        theEmployees.add(new Candidate("Avi", "Tomar"));
        theEmployees.add(new Candidate("A", "Tomar"));
    }

    @GetMapping("/candidate")
    public List<Candidate> getEmployees() {
        return theEmployees;
    }

    // @PathVariable will link the method parameter to the path variable
    @GetMapping("/candidate/{candidateId}")
    public Candidate getEmployee(@PathVariable int candidateId) {

        if ((candidateId >= theEmployees.size()) || (candidateId < 0)) {
            throw new CandidateNotFoundException("Employee id " + candidateId + " not found");
        }

        return theEmployees.get(candidateId);
    }
}
