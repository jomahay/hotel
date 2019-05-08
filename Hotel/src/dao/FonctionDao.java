package dao;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import models.BaseModel;
public class FonctionDao {
    
    public static String firstUpper(String str) {
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }
	
    public static Field[] recupererField(BaseModel base)
    {
        Object object = (Object)base;
        Class classe=object.getClass();
        Field[] fields=classe.getDeclaredFields();
        return fields;		
    }

    public static String[] recupererAttribut(BaseModel base)
    {
        Object lo = (Object)base;
        Class classefille=lo.getClass();
        Class classemere=classefille.getSuperclass();
        Field[] attributFille=classefille.getDeclaredFields();
        Field[] attributMere=classemere.getDeclaredFields();
        String[] listeattribut=new String[attributFille.length+attributMere.length];
        Field[] attributs=new Field[attributFille.length+attributMere.length];
        for(int i=0;i<(attributMere.length+attributFille.length);i++){
            for(int j=0;j<attributMere.length;j++){
                attributs[i]=attributMere[j];
                listeattribut[i]=attributs[i].getName();
                i++;
            }
            for(int a=0;a<attributFille.length;a++){
                attributs[i]=attributFille[a];
                listeattribut[i]=attributs[i].getName();
                i++;
            }
        }
        return listeattribut;
    }

    public static String recupererStringAttribut(BaseModel base)
    {
        String[] fields=recupererAttribut(base);
        String field="";
        for(String s:fields)
        {
            field+=s+",";
        }
        field=field.substring(0, field.length()-1);
        return field;
    }

    public static Method[] getMethodes(BaseModel base) throws NoSuchMethodException, SecurityException
    {
        String[] field=recupererAttribut(base);
        Method[] m=new Method[field.length];
        Class classe=base.getClass();
        for(int i=0;i<field.length;i++)
        {
            m[i]=classe.getMethod("get"+firstUpper(field[i]));
        }
        return m;
    }

    public static Method[] setMethodes(BaseModel base) throws NoSuchMethodException, SecurityException
    {
        String[] field=recupererAttribut(base);
        Method[] m=new Method[field.length];
        Class classe=base.getClass();
        for(int i=0;i<field.length;i++)
        {
            Method getmethod=getMethodes(base)[i];
            m[i]=classe.getMethod("set"+firstUpper(field[i]),getmethod.getReturnType());
        }
        return m;
    }
}
