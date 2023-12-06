package fr.adrienfdupont.demo.controllers;

import fr.adrienfdupont.demo.pojo.Distribution;
import fr.adrienfdupont.demo.services.DistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/distributions")
public class DistributionController {

    @Autowired
    DistributionService distributionService;

    @PostMapping
    public void create(@RequestBody Distribution distribution) {
        distributionService.create(distribution);
    }

    @GetMapping
    public List<Distribution> findAll() {
        return distributionService.findAll();
    }

    @GetMapping("/{id}")
    public Distribution findOne(@PathVariable Long id) {
        return distributionService.findOne(id);
    }

    @PutMapping
    public void update (@RequestBody Distribution distribution) {
        distributionService.update(distribution);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        distributionService.delete(id);
    }

}
