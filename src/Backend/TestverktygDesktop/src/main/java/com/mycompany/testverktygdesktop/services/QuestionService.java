/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygdesktop.services;

import org.apache.commons.lang.ObjectUtils;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

/**
 *
 * @author Allan
 */
public class QuestionService implements UserType
{

    @Override
    public int[] sqlTypes()
    {
        return new int[]
        {
            Types.VARCHAR
        };
    }

    @Override
    public Class returnedClass()
    {
        return List.class;
    }

    @Override
    public boolean equals(Object o, Object o1) throws HibernateException
    {
        return ObjectUtils.equals(o, o1);
    }

    @Override
    public int hashCode(Object o) throws HibernateException
    {
        if (o != null)
        {
            return o.hashCode();
        } else
        {
            return 0;
        }
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SessionImplementor sessionImplementor, Object o)
    {
        List<String> list = null;
        String nameVal = null;
        try
        {
            nameVal = resultSet.getString(strings[0]);
        } catch (SQLException ex)
        {
            System.out.println("nullSaveGet " + ex.getMessage());
        }
        if (nameVal != null)
        {
            nameVal = nameVal.substring(1, nameVal.length() - 1);
            list = new ArrayList<>();
            StringTokenizer tokenizer = new StringTokenizer(nameVal, ",");
            while (tokenizer.hasMoreElements())
            {
                String val = (String) tokenizer.nextElement();
                list.add(val);
            }
        }
        return list;
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i, SessionImplementor sessionImplementor)
    {
        try
        {
            if (o == null)
            {

                preparedStatement.setNull(i, Types.VARCHAR);

            } else
            {
                preparedStatement.setString(i, serialize((List<String>) o));
            }
        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Object deepCopy(Object o)
    {
        return o;
    }

    @Override
    public boolean isMutable()
    {
        return false;
    }

    @Override
    public Serializable disassemble(Object o)
    {
        return (Serializable) o;
    }

    @Override
    public Object assemble(Serializable serializable, Object o)
    {
        return serializable;
    }

    @Override
    public Object replace(Object o, Object o1, Object o2)
    {
        return o;
    }

    private String serialize(List<String> list)
    {
        StringBuilder strbul = new StringBuilder();
        Iterator<String> iter = list.iterator();
        strbul.append("{");
        while (iter.hasNext())
        {
            strbul.append(iter.next());
            if (iter.hasNext())
            {
                strbul.append(",");
            }
        }
        strbul.append("}");
        return strbul.toString();
    }

}
