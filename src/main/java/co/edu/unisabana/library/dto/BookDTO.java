package co.edu.unisabana.library.dto;

import lombok.*;

//Explicar lombok
@Data
@AllArgsConstructor
public class BookDTO {
    String title;
    String author;
    String editorial;
    String isbn;//es un numero muy grande que desborda el int y el editor no quizo leer el long. no se van a hacer operaciones matematicas con el por eso quedo como Sring  
}