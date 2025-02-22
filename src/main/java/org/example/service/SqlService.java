package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SqlService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> executeQuery(String sql) {
        // Csak SELECT lekérdezések engedélyezése
        if (!sql.trim().toUpperCase().startsWith("SELECT")) {
            throw new IllegalArgumentException("Csak SELECT lekérdezések engedélyezettek.");
        }

        // Lekérdezés végrehajtása
        return jdbcTemplate.queryForList(sql);
    }
}