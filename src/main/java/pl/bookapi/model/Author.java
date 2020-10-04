package pl.bookapi.model;

import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    private String name;
    private String surname;
    private LocalDate birthday;
}
