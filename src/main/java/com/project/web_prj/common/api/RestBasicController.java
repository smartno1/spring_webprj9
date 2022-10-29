package com.project.web_prj.common.api;

import com.project.web_prj.board.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

// jsp 뷰포워딩을 하지않고 클라이언트에게 JSON데이터를 전송함 (CSR)
@RestController // @ResponseBody 와 @Controller 기능 하나로.
@Log4j2         // @@ResponseBody : json 으로 하겠다. 클래스에걸면 전체, 메서드에 걸면 그 메서드만.
public class RestBasicController {

    @Setter @Getter @AllArgsConstructor
    static class BoardResDto {
        private Long boardNo;
        private String title;
        private String writer;
        private String content;
    }

    @GetMapping("/api/hello")
    public String hello() {
        return "hello!!!";
    }

    @GetMapping("/api/board")
//    @ResponseBody
    public BoardResDto board() {    // Board 에서 원하는 데이터만 보내려면 DTO 를 별도로 만들어서 사용.
        BoardResDto board
                = new BoardResDto(10L, "gg", "zz", "xx");

        return board;
    }

//    @GetMapping("/api/board")
//    public Board board() {    // Board 객체 이용.
//        Board board = new Board();
//        board.setBoardNo(10L);
//        board.setContent("할룽~");
//        board.setTitle("메룽~~");
//        board.setWriter("박영희");
//
//        return board;
//    }

    @GetMapping("/api/arr")
    public String[] arr() {
        String[] foods = {"짜장면", "레몬에이드", "볶음밥"};
        return foods;
    }

    @GetMapping("/api/list")
    public List<BoardResDto> list() {

        List<BoardResDto> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new BoardResDto((long)i, "t"+i, "w"+i, "c"+i));
        }

        return list;
    }

    // post 요청처리
    @PostMapping("/api/join")
    public String join(@RequestBody List<String> info) {
        log.info("/api/join POST!! - {}", info);
        return "POST-OK";
    }
    // put 요청처리
    @PutMapping("/api/join")
    public String joinPut(@RequestBody Board board) {
        log.info("/api/join PUT!! - {}", board);
        return "PUT-OK";
    }
    // delete 요청처리
    @DeleteMapping("/api/join")
    public String joinDelete() {
        log.info("/api/join DELETE!!");
        return "DEL-OK";
    }


    // RestController에서 뷰포워딩하기 (SSR)
    @GetMapping("/hoho")
    public ModelAndView hoho() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

}
