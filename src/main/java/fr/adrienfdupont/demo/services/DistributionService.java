package fr.adrienfdupont.demo.services;

import fr.adrienfdupont.demo.pojo.Distribution;
import fr.adrienfdupont.demo.repositories.DistributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DistributionService {

    @Autowired
    private DistributionRepository distributionRepository;

    public void create(Distribution distribution) {
        distributionRepository.save(distribution);
    }

    public List<Distribution> findAll() {
        return distributionRepository.findAll();
    }

    public Distribution findOne(Long id) {
        return distributionRepository.findById(id).orElse(null);
    }

    public void update(Distribution newDistribution) {
        Distribution distribution = this.findOne(newDistribution.getId());

        if (distribution != null) {
            distribution.setName(newDistribution.getName());
            distribution.setDescription(newDistribution.getDescription());
            distributionRepository.save(distribution);
        }
    }

    public void delete(Long id) {
        Distribution distribution = this.findOne(id);
        distributionRepository.delete(distribution);
    }

}
