package com.study.demo;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/guestbook/{id}")
    public FindResult findGuestBook(@PathVariable int id, @RequestParam(required = false) String password){
        if(guestBookList.size() - 1 < id | id < 0){
            throw new GuestBookNotFoundException("해당 방명록을 찾을 수 없습니다.");
        }
        GuestbookEntry entry;
        entry = guestBookList.get(id);

        return new FindResult(entry.getName(), entry.readMessage(password));
    }


}
