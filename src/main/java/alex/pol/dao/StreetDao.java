package alex.pol.dao;

import alex.pol.domain.Street;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Abashkin Aleksandr on 26.06.2016.
 */
public interface StreetDao extends JpaRepository<Street, Integer> {
}
