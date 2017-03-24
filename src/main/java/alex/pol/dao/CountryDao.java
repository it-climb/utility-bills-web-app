package alex.pol.dao;

import alex.pol.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Abashkin Aleksandr on 26.06.2016.
 */
public interface CountryDao extends JpaRepository<Country, Integer> {
}
