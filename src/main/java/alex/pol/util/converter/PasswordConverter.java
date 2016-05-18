package alex.pol.util.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class PasswordConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String pass) {
        StringBuilder sb = new StringBuilder();
        sb.append(pass.hashCode());
        return sb.toString();
    }

    @Override
    public String convertToEntityAttribute(String db) {
             return db;
    }
}
