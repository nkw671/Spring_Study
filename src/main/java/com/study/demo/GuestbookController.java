package com.study.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class GuestbookController {
    private final List<GuestbookEntry> guestBookList = new ArrayList<>();


    @PostMapping("/guestbook")
    public List<GuestbookEntry> addGuestBook(@RequestBody GuestbookStruct guestBook) {
        GuestbookEntry newGuestBook;

        if (guestBook.secret()){
            newGuestBook = new SecretGuestBook(guestBook.name(), guestBook.message(), guestBook.password());
        }
        else{
            newGuestBook = new PublicGuestBook(guestBook.name(), guestBook.message());
        }
        guestBookList.add(newGuestBook);
        return guestBookList;
    }

    @GetMapping("/guestbook")
    public List<GuestbookEntry> showGuestBook(){
        return guestBookList;
    }
}
