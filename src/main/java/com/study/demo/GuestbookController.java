package com.study.demo;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class GuestbookController {
    private final List<GuestbookEntry> guestBookList = new ArrayList<>();


    @PostMapping("/guestbook")
    public ApiResponse<List<GuestbookEntry>> addGuestBook(@RequestBody GuestbookStruct guestBook) {
        GuestbookEntry newGuestBook;

        if (guestBook.secret()){
            newGuestBook = new SecretGuestBook(guestBook.name(), guestBook.message(), guestBook.password());
        }
        else{
            newGuestBook = new PublicGuestBook(guestBook.name(), guestBook.message());
        }
        guestBookList.add(newGuestBook);
        return ApiResponse.okay(guestBookList);
    }

    @GetMapping("/guestbook")
    public ApiResponse<List<GuestbookEntry>> showGuestBook(@RequestParam(required = false) String author){
        if(author == null){
            return ApiResponse.okay(guestBookList);
        }

        Stream<GuestbookEntry> stream = guestBookList.stream().filter( oneBook -> author.equals(oneBook.getName())); //todo: 없는 사람을 검색했을때 예외처리
         List<GuestbookEntry> filteredList = stream.toList();
        return ApiResponse.okay(filteredList);
    }

    @GetMapping("/guestbook/{id}")
    public ApiResponse<FindResult> findGuestBook(@PathVariable int id, @RequestParam(required = false) String password){
        if(guestBookList.size() - 1 < id | id < 0){
            throw new GuestBookNotFoundException("해당 방명록을 찾을 수 없습니다.");
        }
        GuestbookEntry entry;
        entry = guestBookList.get(id);
        FindResult result = new FindResult(entry.getName(), entry.readMessage(password));
        return ApiResponse.okay(result);
    }
    @GetMapping("/guestbook/authors")
    public ApiResponse<List<String>> showAuthors(){
        List<String> result = guestBookList.stream().map(GuestbookEntry::getName).distinct().sorted().toList();
        return ApiResponse.okay(result);
    }

    @GetMapping("/guestbook/stats")
    public ApiResponse<Map<String, Long>> showAuthorStats(){
        Map<String, Long> authorStat = guestBookList.stream().collect(Collectors.groupingBy(GuestbookEntry::getName, Collectors.counting()));
        return ApiResponse.okay(authorStat);
    }

}
