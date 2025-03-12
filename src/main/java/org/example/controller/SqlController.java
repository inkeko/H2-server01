package org.example.controller;

import org.example.service.SqlService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sql")
public class SqlController {

    private final SqlService sqlService;

    public SqlController(SqlService sqlService) {
        this.sqlService = sqlService;
    }

    @PostMapping("/query")
    public List<Map<String, Object>> executeSqlQuery(@RequestBody Map<String, String> request) {
        String sql = request.get("query");
        return sqlService.executeQuery(sql);
    }
}