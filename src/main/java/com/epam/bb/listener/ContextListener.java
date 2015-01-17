package com.epam.bb.listener;

import com.epam.bb.database.dao.DaoFactory;
import com.epam.bb.database.pool.ConnectionPool;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;

//todo: add Hikari pool

public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ConnectionPool pool = null;
        try {
            pool = new ConnectionPool();
        } catch (SQLException e) {
            try {
                Socket socket = new Socket("localhost", 8005);
                if (socket.isConnected()) {
                    PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                    pw.println("SHUTDOWN");//send shut down command
                    pw.close();
                    socket.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        DaoFactory.configure(pool, DaoFactory.DaoType.H2);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            DaoFactory.shutdown();
        } catch (SQLException e) {
            e.printStackTrace();
        }
            /*TODO log timeout session or logout from application!bek*/

    }
}
