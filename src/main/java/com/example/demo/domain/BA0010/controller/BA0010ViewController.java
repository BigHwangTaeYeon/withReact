package com.example.demo.domain.BA0010.controller;

import com.example.demo.domain.BA0010.service.BA0010Service;
import com.example.demo.domain.BA0010.dto.BA0010Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BA0010ViewController {

    @Autowired
    private BA0010Service BA0010Service;

//    @Autowired
//    private TodoService todoService;

    /*
     *     목록 조회
     */
    @GetMapping(value="/api/getJson", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTodos1() throws Exception {
//        List<Todo> todos = todoService.getTodos(Sort.by(Direction.ASC, "id"));
        List<BA0010Dto> BA0010Api = BA0010Service.getApi();
        return ResponseEntity.ok(BA0010Api);
    }
    @GetMapping(value="/apigo")
    public ResponseEntity<?> getTodos2() throws Exception {
//        List<Todo> todos = todoService.getTodos(Sort.by(Direction.ASC, "id"));
        List<BA0010Dto> BA0010Api = BA0010Service.getApi();
        return ResponseEntity.ok(BA0010Api);
    }
    @GetMapping(value="/apigo2")
    public String getTodos3() throws Exception {
//        List<Todo> todos = todoService.getTodos(Sort.by(Direction.ASC, "id"));
        List<BA0010Dto> BA0010Api = BA0010Service.getApi();
        return BA0010Api.toString();
    }

    /*
     *     등록
     */
//    @PostMapping
//    public ResponseEntity<String> postTodo(@RequestBody Todo todo) throws Exception {
////        todo.setCreatedDateTime(LocalDateTime.now());
////        todo.setIsComplete(false);
////        todoService.postTodo(todo);
//        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
//    }

    /*
     *     수정
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> putTodo(@PathVariable("id") Long id) throws Exception {
//        Todo todo = todoService.findTodoById(id);
//
//        Boolean isComplete = todo.getIsComplete() ? false : true;
//        todo.setIsComplete(isComplete);
//        todoService.postTodo(todo);

        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    }

    /*
     *     삭제
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long id) throws Exception {
//        todoService.deleteTodo(id);

        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    }

}
