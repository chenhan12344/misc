import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by 44399 on 2019/8/17
 *
 * @author 44399
 */
public class ConnectionPool {

    public static void main(String[] args) throws SQLException {
        ConnectionPool connectionPool = new ConnectionPool("jdbc:mysql://121.199.23.184/test", "root", "luluteam");
        Connection conn = connectionPool.getConnection();
        PreparedStatement statement = conn.prepareStatement("INSERT INTO `tb_conn_pool_test` VALUES (1)");
        statement.execute();
        conn.commit();
        connectionPool.releaseConnection(conn);
        connectionPool.shutdown();
    }

    private void shutdown() {
        for (Connection connection : cachedConnections) {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private LinkedList<Connection> cachedConnections = new LinkedList<>();

    public ConnectionPool(String url, String username, String password) {
        try {
            for (int i = 0; i < 10; i++) {
                Connection conn = DriverManager.getConnection(url, username, password);
                if (conn == null) {
                    throw new SQLException("error during initializing connection pool");
                }
                cachedConnections.add(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            for (Connection connection : cachedConnections) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public Connection getConnection() {
        if (cachedConnections == null || cachedConnections.size() == 0)
            throw new NullPointerException("no connections available");
        return cachedConnections.removeFirst();
    }

    public void releaseConnection(Connection connection) {
        if (connection == null)
            throw new RuntimeException();
        this.cachedConnections.addLast(connection);
    }

}
