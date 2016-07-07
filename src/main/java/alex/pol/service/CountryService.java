package alex.pol.service;

import alex.pol.domain.Country;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Abashkin Aleksandr on 26.06.2016.
 */

public interface CountryService extends Service<Country> {
    @Override
    List<Country> getAll() throws SQLException;

    @Override
    Country getById(Integer id) throws SQLException;
}
