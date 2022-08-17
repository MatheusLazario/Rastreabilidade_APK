package com.example.consulta.conexao;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
    public static Connection conectar() throws ClassNotFoundException, SQLException {

        Connection conn = null;
        StrictMode.ThreadPolicy politica;
        politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(politica);
        /*
        9999999999004634966501232L00341001737424665
         */

        Class.forName("net.sourceforge.jtds.jdbc.Driver");

        String ip = "192.168.1.8:1433";
        String db = "base_teste";
        String user = "sa";
        String senha = "teste1234!";

        String connString = "jdbc:jtds:sqlserver://" + ip + ";databaseName=" + db + ";user=" + user + ";password=" + senha + ";";
        conn = DriverManager.getConnection(connString);

        return conn;
    }

}
