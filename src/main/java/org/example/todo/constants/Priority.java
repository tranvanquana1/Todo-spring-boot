package org.example.todo.constants;

import jakarta.persistence.AttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum Priority {
    LOW(1, "low"),
    MEDIUM(2, "medium"),
    HIGH(3, "high");

    private final Integer value;
    private final String label;

    public static Priority of(Integer value) {
        return Stream.of(Priority.values())
                .filter(priority -> priority.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy giá trị Priority tuơng ứng với " + value));
    }

    public static class EnumConverter implements AttributeConverter<Priority, Integer> {
        @Override
        public Integer convertToDatabaseColumn(Priority priority) {
            return priority.getValue();
        }

        @Override
        public Priority convertToEntityAttribute(Integer priority) {
            return Priority.of(priority);
        }
    }
}
