package dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.NoResultatException;
import models.BaseModel;

public class GeneralDao 
{
    public Integer getId(String sequence) 
    {
        Integer id=0;
        Connection connect=null;
        try
        {
            connect=UtilDb.getCon();
            connect.setAutoCommit(false);
            Statement statement=connect.createStatement();
            String sql="SELECT nextval('"+sequence+"')";
            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            id = Integer.parseInt(rs.getString(1));
            connect.commit();
            connect.close();
        }
        catch(SQLException e)
        {
            if(connect!=null)
            {
                try
                {
                    connect.rollback();
                    connect.close();
                }
                catch(SQLException ex){}
            }
        }
        return id;
    }

    public Integer save(BaseModel basemodel) throws Exception
    {
        Connection connection=null;
        try
        {
            connection=UtilDb.getCon();
            connection.setAutoCommit(false);
            Integer id = save(connection,basemodel);
            connection.commit();
            return id;
        }
        catch(SQLException e)
        {
            if(connection!=null)
                connection.rollback();
            throw e;
        }
        finally
        {
            if(connection!=null){
                connection.close();
            }
        }
    }

    public Integer save(Connection connection,BaseModel basemodel) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException 
    {
        PreparedStatement state =null;
        try 
        {
            String table = basemodel.getClass().getName().substring(7).toLowerCase();
            String[] keys=FonctionDao.recupererAttribut(basemodel);
            String fields=FonctionDao.recupererStringAttribut(basemodel);
            String sequence=table.toLowerCase()+"sequence";
            Integer id = getId(sequence);
            basemodel.setId(id);
            String query = "insert into " + table + "("+ fields+") values (";
            for(String k : keys)
            {
                query+="?,";
            }
            query=query.substring(0, query.length()-1);
            query+=")";
            int i=1;
            state = connection.prepareStatement(query);
            Method[] values=FonctionDao.getMethodes(basemodel);
            for(String k : keys)
            {
                if(values[i-1].invoke(basemodel).getClass().equals(java.util.Date.class))
                {
                    java.sql.Date date = new java.sql.Date(((java.util.Date)values[i-1].invoke(basemodel)).getTime());
                    state.setObject(i, date);
                }
                else
                    state.setObject(i, values[i-1].invoke(basemodel));
                i++;
            }
            state.execute();
            return id;
        }
        catch(SQLException e)
        {
            throw e;
        }
        finally
        {
            if(state!=null)
                state.close();
        }
    }
    public void update(BaseModel basemodel) throws Exception 
    {
        Connection connection=null;
        try
        {
            connection=UtilDb.getCon();
            connection.setAutoCommit(false);
            update(connection,basemodel);
            connection.commit();
        }
        catch(SQLException e)
        {
            if(connection!=null)   
                connection.rollback();
            throw e;
        }
        finally
        {
            if(connection!=null){
                connection.close();
            }
        }
    }
    public void update(Connection connection,BaseModel basemodel) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException
    {
        PreparedStatement state =null;
        try 
        {
            String[] keys=FonctionDao.recupererAttribut(basemodel);
            Method [] values=FonctionDao.getMethodes(basemodel);
            String table = basemodel.getClass().getName().substring(7).toLowerCase();
            int i=1;

            String query = "update " + table + " set ";

            for(String k : keys)
            {
                query+=k+"=?,";
            }
            query=query.substring(0,query.length()-1);
            query+=" where id="+basemodel.getId();
            state = connection.prepareStatement(query);

            for(String k : keys)
            {
                if(values[i-1].invoke(basemodel).getClass().equals(java.util.Date.class))
                {
                    java.sql.Date date = new java.sql.Date(((java.util.Date)values[i-1].invoke(basemodel)).getTime());
                    state.setObject(i, date);
                }
                else
                    state.setObject(i, values[i-1].invoke(basemodel));
                i++;
            }
            state.execute();
        } 

        catch(SQLException e)
        {
            throw e;
        }
        finally
        {
            if(state!=null)
                state.close();
        }
    }
    public void delete(BaseModel basemodel) throws Exception
    {
        Connection connection=null;
        try
        {
            connection=UtilDb.getCon();
            connection.setAutoCommit(false);
            delete(connection,basemodel);
            connection.commit();
        }
        catch(SQLException e)
        {
            if(connection!=null)   
                connection.rollback();
            throw e;
        }
        finally
        {
            if(connection!=null){
                connection.close();
            }
        }
    }
    public void delete(Connection connection,BaseModel basemodel) throws Exception
    {
        PreparedStatement state =null;
        try 
        {
            String table = basemodel.getClass().getName().substring(7).toLowerCase();

            String query="";
            if(basemodel.getId()!=0)
                query = "delete from " + table + " where id="+basemodel.getId();
            else
                query = "delete from " + table +" where 1<2";

            state = connection.prepareStatement(query);
            state.execute();
        } 

        catch(SQLException e)
        {
            throw e;
        }
        finally
        {
            if(state!=null)
                state.close();
        }
    }
    
    public void deleteAll(BaseModel basemodel) throws Exception 
    {
        Connection connection=null;
        try
        {
            connection=UtilDb.getCon();
            connection.setAutoCommit(false);
            deleteAll(connection,basemodel);
            connection.commit();
        }
        catch(SQLException e)
        {
            if(connection!=null)   
                connection.rollback();
            throw e;
        }
        finally
        {
            if(connection!=null){
                connection.close();
            }
        }
    }
    public void deleteAll(Connection connection,BaseModel base) throws Exception
    {
        delete(connection,base);
    }
    public List<BaseModel> find(Connection connection, BaseModel basemodel,String condition,Integer limit, Integer offset) throws Exception 
    {
        List<BaseModel> liste = new ArrayList<BaseModel>();
        try
        {
            connection=UtilDb.getCon();
            connection.setAutoCommit(false);
            liste = find(basemodel, condition, limit, offset);
            connection.commit();
        }
        catch(SQLException e)
        {
            if(connection!=null)   
                connection.rollback();
            throw e;
        }
        finally
        {
            if(connection!=null){
                connection.close();
            }
        }
        return liste;
    }
    public List<BaseModel> find1(Connection connection, BaseModel basemodel,String condition,Integer limit, Integer offset) throws Exception 
    {
        return find(basemodel, condition, limit, offset);
    }
    public List<BaseModel> find(BaseModel conditionmodel,String condition,Integer limit, Integer offset) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoResultatException, SQLException
    {
        List<BaseModel> result = new ArrayList<BaseModel>();
        Connection connection=null;
        PreparedStatement state =null;
        ResultSet rs = null;
        int u=0;
        try 
        {
            connection=UtilDb.getCon();
            connection.setAutoCommit(false);
            String fields=FonctionDao.recupererStringAttribut(conditionmodel);
            String table = conditionmodel.getClass().getName().substring(7).toLowerCase();

            Method [] setvalues=FonctionDao.setMethodes(conditionmodel);
            String  [] keys=FonctionDao.recupererAttribut(conditionmodel);

            String query = "SELECT " + fields + " FROM "+ table;
            if(condition!=null)
                query+=" where "+condition;
            if(limit!=null)
                query+=" limit "+limit;
            if(offset!=null)
                query+=" offset "+offset;
            System.out.println(query);
            state = connection.prepareStatement(query);
            rs = state.executeQuery();
            while(rs.next())
            {
                Class classe=conditionmodel.getClass(); 
                BaseModel objet=(BaseModel)classe.newInstance(); 
                for(String key:keys)
                {
                    if(rs.getObject(key).getClass().equals(java.sql.Date.class))
                    {
                        java.util.Date date = new java.util.Date(((java.sql.Date)rs.getObject(key)).getTime());
                        setvalues[u].invoke(objet, date);
                    }
                    else
                        setvalues[u].invoke(objet, rs.getObject(key));
                    u++;
                }
                u=0;
                result.add(objet);
            }
            connection.commit();
        }
        catch(SQLException e)
        {
            if(connection!=null)   
                connection.rollback();
            throw e;
        }
        finally
        {
            if(rs!=null)
                rs.close();
            if(state!=null)
                state.close();
            if(connection!=null){
                connection.close();
            }
        }
        return result;
    }

    public List<BaseModel> findAll(BaseModel base) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoResultatException, SQLException 
    {
        return find(base,null,null,null);
    }

    public Integer count(BaseModel base) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoResultatException, SQLException
    {
        return findAll(base).size();
    }

    public Integer count(BaseModel base, String condition) throws SQLException
    {
        String req = "SELECT count(*) FROM "+base.getClass().getSimpleName();
        if(condition!=null)
            req += " WHERE "+condition;
        Connection  connection = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        int result;
        try
        {
            connection = UtilDb.getCon();
            connection.setAutoCommit(false);
            state = connection.prepareStatement(req);
            rs = state.executeQuery();
            rs.next();
            result = new Integer(rs.getObject(1).toString());
            connection.commit();
        }
        catch(SQLException e)
        {
            if(connection!=null)   
                connection.rollback();
            throw e;
        }
        finally
        {
            if(rs!=null)
                rs.close();
            if(state!=null)
                state.close();
            if(connection!=null){
                connection.close();
            }
        }
        return result;
    }
	
    public void executeRequest(Connection connection, String query) throws Exception
    {
        PreparedStatement state =null;
        try 
        {
            state = connection.prepareStatement(query);
            state.execute();
        } 

        catch(SQLException e)
        {
            throw e;
        }
        finally
        {
            if(state!=null)
                state.close();
        }
    }
    
    public void executeRequest(String query) throws Exception
    {
        PreparedStatement state =null;
        Connection  connection = null;
        try 
        {
        	connection = UtilDb.getCon();
            connection.setAutoCommit(false);
            state = connection.prepareStatement(query);
            state.execute();
            connection.commit();
        } 
        catch(SQLException e)
        {
            if(connection!=null)   
                connection.rollback();
            throw e;
        }
        finally
        {
            if(state!=null)
                state.close();
            if(connection!=null){
                connection.close();
            }
        }
    }
}
