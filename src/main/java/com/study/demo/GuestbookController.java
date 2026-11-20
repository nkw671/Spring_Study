package com.study.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GuestbookController {
    private final List<GuestbookEntry> guestBookList = new ArrayList<>();
    @PostMapping("/guestbook")
    public List<GuestbookEntry> addGuestBook(@RequestBody GuestbookEntry guestBook) {
        guestBookList.add(guestBook);
        return guestBookList;
    }
    @GetMapping("/guestbook")
    public List<GuestbookEntry> showGuestBook(){
        return guestBookList;
    }
}
