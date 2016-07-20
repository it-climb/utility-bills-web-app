package alex.pol.service;

import alex.pol.domain.City;
import alex.pol.domain.Country;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Abashkin Aleksandr on 26.06.2016.
 */

public interface CityService extends Service<City> {
    @Override
    List<City> getAll() throws SQLException;

    @Override
    City getById(Integer id) throws SQLException;
}
