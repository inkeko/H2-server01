package org.example.controller;

import org.example.service.SqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sql")
public class SqlController {

    @Autowired
    private SqlService sqlService;

    @PostMapping("/query")
    public List<Map<String, Object>> executeSqlQuery(@RequestBody Map<String, String> request) {
        String sql = request.get("query");
        return sqlService.executeQuery(sql);
    }
}
