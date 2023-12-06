package fr.adrienfdupont.demo.repositories;

import fr.adrienfdupont.demo.pojo.Distribution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistributionRepository extends JpaRepository<Distribution, Long> {

}
