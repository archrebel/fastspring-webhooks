package com.archetypesoftware.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.function.Function;

class Millis2DateDeserializer<T> extends StdDeserializer<T> {
    private final Function<Long, T> dateSupplier;

    @SuppressWarnings("unused")
    public Millis2DateDeserializer(Class<T> clazz, Function<Long, T> dateSupplier) {
        super(clazz);
        this.dateSupplier = dateSupplier;
    }

    @Override
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String timestamp = jsonParser.getText();

        if (StringUtils.isBlank(timestamp)) {
            return null;
        }

        return dateSupplier.apply(Long.valueOf(timestamp));
    }
}

public class DateDeserializers {
    public static class Millis2LocalDateTimeDeserializer extends Millis2DateDeserializer<LocalDateTime> {

        public Millis2LocalDateTimeDeserializer() {
            super(LocalDateTime.class, DateDeserializers::dateTimeOf);
        }
    }

    public static class Millis2LocalDateDeserializer extends Millis2DateDeserializer<LocalDate> {
        public Millis2LocalDateDeserializer() {
            super(LocalDate.class, DateDeserializers::dateOf);
        }
    }

    public static LocalDateTime dateTimeOf(long millis) {
        return Instant.ofEpochMilli(millis)
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public static LocalDate dateOf(long millis) {
        return Instant.ofEpochMilli(millis)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
