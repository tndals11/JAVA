package org.example.chapter15.c_board_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.chapter15.c_board_app.entity.Board;

@AllArgsConstructor
@Getter
public class BoardRequestDto {
    private String title;
    private String content;
    private String author;

    public Board toEntity() {
        // 요청값으로 Board 객체 생성
        return new Board(title, content, author);
    }

}
