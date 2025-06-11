package br.com.john.brothersbank.config;

import jakarta.persistence.AttributeConverter;

public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        if (attribute == null){
            return null;
        }
        return attribute ? "ativa" : "inativa";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.equalsIgnoreCase("inativa")) {
            return false;
        }
        if (dbData.equalsIgnoreCase("ativa")){
            return true;
        }

        throw new IllegalArgumentException("Valor de status do banco inválido: " + dbData);
    }
}
