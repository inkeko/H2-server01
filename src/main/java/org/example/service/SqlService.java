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
    /**
     * 🔍 Táblák és oszlopok lekérdezése
     */
    public Map<String, List<String>> getDatabaseMetadata() {
        Map<String, List<String>> metadata = new LinkedHashMap<>();

        // 🔐 Csak ezek a táblák jelenhetnek meg
        Set<String> allowedTables = Set.of("country", "city", "countrylanguage");

        try (Connection conn = dataSource.getConnection()) {
            DatabaseMetaData dbMeta = conn.getMetaData();
            String schema = conn.getSchema();

            try (ResultSet tables = dbMeta.getTables(null, schema, "%", new String[]{"TABLE"})) {
                while (tables.next()) {
                    String tableName = tables.getString("TABLE_NAME");

                    if (!allowedTables.contains(tableName.toLowerCase())) {
                        continue; // kihagyjuk azokat, amik nincsenek a fehérlistában
                    }

                    List<String> columns = new ArrayList<>();
                    try (ResultSet cols = dbMeta.getColumns(null, schema, tableName, null)) {
                        while (cols.next()) {
                            String colName = cols.getString("COLUMN_NAME");
                            columns.add(colName);
                        }
                    }

                    metadata.put(tableName, columns);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Nem sikerült lekérdezni az adatbázis metaadatait", e);
        }

        return metadata;
    }


}