# ❗  학습목표
  - Spring 기반 MVC 주요 구성 / 처리 흐름 이해
  
  - CRUD 프로그래밍 학습
  
  - limit을 통안 페이징 처리 숙지


# 🔌 개발환경 
 
 - opdn JDK 11

 - Oracle

 - Mybatis

 - JDBC
   
 - Tomcat9

# 📂 파일구성

controller
 - BoardController
 - HomeController

dto
 - BoardDTO
 - PageDTO

repository
 - BoardRepository

service
 - BoardService

mapper
 - boardMapper.xml

model
 - mybatis-config.xml

📜 view단
- detail.jsp
- home.jsp
- indexv
- list.jsp
- paging.jsp
- save.jsp
- update.jsp




# 📋 Spring 게시판 만들기 - sql 문

    create table board(
        num number primary key,
        title varchar2(50) not null,
        writer varchar2(50) not null,
        content varchar2(100),
        regdate date,
        cnt number default 0
    );

    create sequence board_seq
        start with 1
        increment by 1
        maxvalue 99999
        nocache
        nocycle
        noorder;


    SELECT * FROM board_table;
    
    -- 현페이지 3개식 출력
    select * from board_table order by id desc limit 0, 3; -- 12, 11, 10
    select * from board_table order by id desc limit 1, 3; -- 11, 10, 9
    select * from board_table order by id desc limit 2, 3; -- 10, 9, 8
    select * from board_table order by id desc limit 3, 3; -- 9, 8, 7
    
    select * from board_table order by id desc limit 0, 5; -- 12, 11, 10, 9, 8
    
    -- 1page: 12,11,10,  2page: 9, 8, 7,  3page: 6, 5, 4 
    select * from board_table order by id desc limit 0, 3; -- 12, 11, 10
    select * from board_table order by id desc limit 3, 3; -- 9, 8, 7
    select * from board_table order by id desc limit 6, 3; -- 6, 5, 4
