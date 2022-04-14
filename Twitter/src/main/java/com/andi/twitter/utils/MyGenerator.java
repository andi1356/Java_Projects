package com.andi.twitter.utils;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj)
            throws HibernateException {

        String prefix = "user_";

        Connection connection = session.connection();

        try {
            Statement statement=connection.createStatement();
//org.h2.jdbc.JdbcSQLSyntaxErrorException: Table "USER" not found; SQL statement:
//select count(id) from User [42102-200]  ...    getJdbcSQLException(DbException.java:453)
//            TODO
            String query = String.format("select count(%s) from %s",
                    session.getEntityPersister(obj.getClass().getName(), obj)
                            .getIdentifierPropertyName(),
                    obj.getClass().getSimpleName());

            ResultSet rs=statement.executeQuery(query);

            if(rs.next())
            {
                int id=rs.getInt(1)+101;
                return prefix + id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}