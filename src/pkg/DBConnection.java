package pkg;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class DBConnection {
    private  final String URL = "jdbc:sqlserver://103.196.155.124:1433;databaseName=pos;encrypt=true;trustServerCertificate=true";
    private final String USER = "kel4";
    private final String PASS = "Qwerty1029";
    private Connection conn;
    
    public DBConnection() {
        connect();
    }

    private void connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Eksekusi SQL DML (INSERT/UPDATE/DELETE) - support prepared statement.
     * @param sql SQL statement
     * @param params parameter opsional untuk prepared statement
     * @return jumlah baris yang terpengaruh
     * @throws SQLException jika terjadi error
     */
    public int executeUpdate(String sql, Object... params) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }

            return stmt.executeUpdate();
        }
    }

    /**
     * Eksekusi SELECT dan kembalikan hasil sebagai list of map.
     * @param sql SQL SELECT statement
     * @param params parameter opsional untuk prepared statement
     * @return list hasil query
     * @throws SQLException jika terjadi error
     */
    public List<Map<String, Object>> executeQuery(String sql, Object... params) throws SQLException {
        List<Map<String, Object>> resultList = new ArrayList<>();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }

            try (ResultSet rs = stmt.executeQuery()) {
                ResultSetMetaData meta = rs.getMetaData();
                int columnCount = meta.getColumnCount();

                while (rs.next()) {
                    Map<String, Object> row = new LinkedHashMap<>();
                    for (int i = 1; i <= columnCount; i++) {
                        row.put(meta.getColumnLabel(i), rs.getObject(i));
                    }
                    resultList.add(row);
                }
            }
        }

        return resultList;
    }
}
