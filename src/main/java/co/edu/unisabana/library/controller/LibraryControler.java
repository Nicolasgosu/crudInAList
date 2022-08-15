package co.edu.unisabana.library.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unisabana.library.dto.*;
import java.util.List;

@RestController
public class LibraryControler {
    Catalog catalog = new Catalog();


    @GetMapping("/userHelp")
    public String homePage() {
        return "write: \n\t/catalog to see all books \n\t/sercht?q=(change this for a title) to serch books by title \n\t/sercha?q=(change this for an author) to serch books by author \n\t/serchisbn?q=(change this for an ISBN) to serch a book by ISBN";
    }

    @GetMapping("/adminHelp")
    public String adminPage(){
        return "write: \n\t/delete/(change this for an ISBN) to delete a book \n\t/ceate/(change this for a title)/(change this for an author)/(change this for an editorial)/(change this for an ISBN) \n\t/home to get more info \n\t/change/(isbn of the book you want to modify)/(property to modify (author,isbn,editorial or title)/(new value) to update somthing)";
    }

    @GetMapping(value = "/create/{title}/{author}/{editorial}/{isbn}")
    public String createBook(@PathVariable String title,
                                           @PathVariable String author,
                                           @PathVariable String editorial,
                                           @PathVariable String isbn) {
        if (this.catalog.POST(title, author, editorial, isbn)){
            return "book added successfully";
        }else{
            return "error";
        }
    }

    @GetMapping(value = "/delete/{isbn}")
    public String deleteBook(@PathVariable String isbn){
        if (this.catalog.DELETE(isbn)){
            return "book deleted successfully";
        }
        return "error";    
    }

    @GetMapping(value = "/change/{isbn}/{property}/{value}")
    public BookDTO updateBook(@PathVariable String isbn,@PathVariable String property,@PathVariable String value){
     return this.catalog.updateBookDTO(isbn, property, value);   
    }

    @GetMapping("/catalog")
    public List<BookDTO> fullCatalog(){
        return this.catalog.getCatalog(); 
    }

    @GetMapping(value = "/searcha")
    public List<BookDTO> serchAuthor (@RequestParam String q) {  
        return this.catalog.serchByAuthor(q.toLowerCase());
    }

    @GetMapping(value = "/searchisbn")
    public List<BookDTO> serchIsbn (@RequestParam String q) {  
        return this.catalog.serchByISBN(q.toLowerCase());
    }

    @GetMapping(value = "/searcht")
    public List<BookDTO> serchTitle (@RequestParam String q) {  
        return this.catalog.serchByTitle(q.toLowerCase());
    }

}
