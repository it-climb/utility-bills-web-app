package alex.pol.service;

import alex.pol.domain.Street;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Abashkin Aleksandr on 26.06.2016.
 */

public interface StreetService extends Service<Street> {
    @Override
    List<Street> getAll() throws SQLException;

    @Override
    Street getById(Integer id) throws SQLException;
}
