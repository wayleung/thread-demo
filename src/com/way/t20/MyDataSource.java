package com.way.t20;/**
 * @Auther: Way Liang
 * @Date: 10/27/2018 23:54
 * @Description:
 */

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Way Liang
 * @Date: 10/27/2018 23:54
 * @Description:
 */
public class MyDataSource {

    //容器选择链表LinkedList是因为 增删多 查询少
    private LinkedList<Connection> pool = new LinkedList<>();

    private static final int INIT_CONNECTIONS = 10;

    private static final String DRIVER_CLASS = "";

    private static final String USER="";

    private static final String URL ="";

    private static final String PASSWORD="";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public MyDataSource() {

        for (int i=0;i<INIT_CONNECTIONS;i++) {
            try {
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                pool.addLast(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public Connection getConnection(){
        Connection connection = null;
        //不能直接在方法上synchronized 锁的是当前实例 而我们要锁的是池
        synchronized (pool){
            while (pool.size()<=0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (!pool.isEmpty()){
                connection  = pool.removeFirst();
            }
        }

       return connection;
    }

    public void release(Connection connection){
        //释放 就是把连接放回去池里 并不是真的销毁
        if (connection!=null) {
            //这里要保证线程安全
            synchronized (pool){
                pool.addLast(connection);
                notifyAll();
            }
        }

    }
}
