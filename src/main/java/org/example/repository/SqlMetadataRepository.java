package org.example.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SqlMetadataRepository {

    // 🔹 Tábla nevek lekérdezése az INFORMATION_SCHEMA használatával
    @Query(value = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'PUBLIC'", nativeQuery = true)
    List<String> findAllTableNames();

    // 🔹 Oszlopnevek lekérdezése adott táblához
    @Query(value = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = 'PUBLIC' AND TABLE_NAME = :tableName", nativeQuery = true)
    List<String> findColumnNamesByTableName(String tableName);
}

