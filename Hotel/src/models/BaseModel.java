package models;

public class BaseModel {
    private Integer id;

    public Integer getId()
    {
        return this.id;
    }
    public void setId(Integer id)
    {
        this.id=id;
    }
    public BaseModel(Integer id)
    {
        setId(id);
    }

    public BaseModel()
    {

    }
}
