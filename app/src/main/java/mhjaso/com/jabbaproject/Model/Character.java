package mhjaso.com.jabbaproject.Model;


import java.io.Serializable;

public class Character implements Serializable
{
    //region Attributes
    public static String StringKey = "Character";
    private String name;
    private String alias;
    //endregion


    public Character(String name, String alias)
    {
        this.name = name;
        this.alias = alias;
    }



    //region Accessors

    public void setName(String name) {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public String getAlias()
    {
        return this.alias;
    }

    public String getFullName() {
        String fullName = "Unknown character";
        StringBuilder fullNameBuilder = new StringBuilder();
        if (this.name != null) {
            fullNameBuilder.append(name);
        }
        if (this.name != null && this.alias != null) {
            fullNameBuilder.append(" (").append(this.alias).append(")");
        }
        else if (this.name == null && this.alias != null) {
            fullNameBuilder.append(this.alias);
        }

        if (fullNameBuilder.toString().contentEquals("") == false) {
            fullName = fullNameBuilder.toString();
        }
        return fullName.toString();
    }

    @Override
    public String toString(){
        return getFullName();
    }

    //endregion



}
