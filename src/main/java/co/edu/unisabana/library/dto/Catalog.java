package co.edu.unisabana.library.dto;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;


@Data
public class Catalog {
    private List<BookDTO> catalog = new ArrayList<>();
    public Catalog(){
        catalog.add(new BookDTO("cuentos completos I", "Isaac Asimov", "zeta", "9788498722581"));
        catalog.add(new BookDTO("Fundamentos de programación \npiensa en c", "Osvaldo Cairó", "pearson", "9702608104"));
        catalog.add(new BookDTO("Memorias de Adriano\ntraduccion de Julio Cortazar", "Margurite Youcenar", "planeta", "9586140385"));
    }

    public boolean POST(String title, String author, String editorial, String isbn){
        return this.catalog.add(new BookDTO(title, author, editorial, isbn));        
    }


    public boolean DELETE(String isbn){
        return this.catalog.removeIf(Book -> (Book.getIsbn().equals(isbn)));
    }


    public List<BookDTO> serchByAuthor(String serch){
        List<BookDTO> results = new ArrayList<>();
        for (BookDTO book : this.catalog) {
            if(book.author.toLowerCase().contains(serch)) results.add(book);
        }
        return results;
    }


    public List<BookDTO> serchByTitle(String title){
        List<BookDTO> results = new ArrayList<>();
        for (BookDTO book : this.catalog) {
            if(book.title.toLowerCase().contains(title)) results.add(book);
        }
        return results;
    }


    public List<BookDTO> serchByISBN(String isbn){
        List<BookDTO> results = new ArrayList<>();
        for (BookDTO book : this.catalog) {
            if(book.isbn.contains(isbn)) results.add(book);
        }
        return results;
    }
    
    public BookDTO updateBookDTO(String isbn, String property, String value){
        for (BookDTO book : this.catalog) {
            if(book.getIsbn().equals(isbn)){
                if(property.equals("title")){
                    book.setTitle(value);
                    return book;
                }
                if(property.equals("author")){
                    book.setAuthor(value);
                    return book;
                }
                if(property.equals("isbn")){
                    book.setIsbn(value);
                    return book;
                }
                if(property.equals("editorial")){
                    book.setEditorial(value);
                    return book;
                }
            }
        }
        return new BookDTO("error", "404", "there is no book with ISBN:", isbn);
    }
}
