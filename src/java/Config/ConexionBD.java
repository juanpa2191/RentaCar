
package Config;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author Diego Iván Cruz O
 */
public class ConexionBD {
    public DriverManagerDataSource Conectar() {
        DriverManagerDataSource xcon = new DriverManagerDataSource();
        xcon.setDriverClassName("com.mysql.jdbc.Driver");
        xcon.setUrl("jdbc:mysql://localhost:3306/rentacar");
        xcon.setUsername("root");
        xcon.setPassword("");
        return xcon;
    }
}
