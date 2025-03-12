package org.example.service;

import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

@Service
public class SqlService {

    private final DataSource dataSource;

    public SqlService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Map<String, Object>> executeQuery(String sql) {
        if (!sql.trim().toLowerCase().startsWith("select")) {
            throw new IllegalArgumentException("Csak SELECT utasítások engedélyezettek!");
        }

        List<Map<String, Object>> results = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new LinkedHashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(metaData.getColumnName(i), rs.getObject(i));
                }
                results.add(row);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Hiba történt az SQL végrehajtása közben", e);
        }

        return results;
    }
}