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
@RequestMapping("/api/distributions")
public class DistributionController {

    @Autowired
    DistributionService distributionService;

    @Autowired
    CategoryService categoryService;

    @PostMapping
    public void create(@RequestBody CreateDistributionDto createDistributionDto) {
        Distribution distribution = new Distribution();
        Category category = categoryService.findOne(createDistributionDto.getCategory_id());
        distribution.setName(createDistributionDto.getName());
        distribution.setDescription(createDistributionDto.getDescription());
        distribution.setCategory(category);
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
    public void update (@RequestBody UpdateDistributionDto updateDistributionDto) {
        Distribution distribution = distributionService.findOne(updateDistributionDto.getId());
        Category category = categoryService.findOne(updateDistributionDto.getCategory_id());
        distribution.setName(updateDistributionDto.getName());
        distribution.setDescription(updateDistributionDto.getDescription());
        distribution.setCategory(category);
        distributionService.update(distribution);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        distributionService.delete(id);
    }

}
