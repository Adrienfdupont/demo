package fr.adrienfdupont.demo.controllers;

import fr.adrienfdupont.demo.dto.CreateDistributionDto;
import fr.adrienfdupont.demo.dto.UpdateDistributionDto;
import fr.adrienfdupont.demo.pojo.Category;
import fr.adrienfdupont.demo.pojo.Distribution;
import fr.adrienfdupont.demo.services.CategoryService;
import fr.adrienfdupont.demo.services.DistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api/distributions")
public class DistributionController {

    @Autowired
    DistributionService distributionService;

    @Autowired
    CategoryService categoryService;

    @PostMapping
    public Distribution create(@RequestBody CreateDistributionDto createDistributionDto) {
        Distribution distribution = new Distribution();
        distribution.setName(createDistributionDto.getName());
        distribution.setDescription(createDistributionDto.getDescription());

        Category category = categoryService.findOne(createDistributionDto.getCategoryId());
        if (category != null) {
            category.getDistributions().add(distribution);
            categoryService.create(category);
        }
        return distribution;
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
    public void update (@RequestBody UpdateDistributionDto updateDistributionDto) {
        Distribution distribution = distributionService.findOne(updateDistributionDto.getId());
        distribution.setName(updateDistributionDto.getName());
        distribution.setDescription(updateDistributionDto.getDescription());
        distributionService.update(distribution);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        distributionService.delete(id);
    }

}
