package roseindia.dao.hibernate;

import java.io.Serializable;



public class Category implements Serializable {

    /** identifier field */
    private Integer categoryid;

    /** nullable persistent field */
    private String categoryname;

    /** persistent field */
    private int parentid;

    /** full constructor */
    public Category(Integer categoryid, String categoryname, int parentid) {
        this.categoryid = categoryid;
        this.categoryname = categoryname;
        this.parentid = parentid;
    }

    /** default constructor */
    public Category() {
    }

    /** minimal constructor */
    public Category(Integer categoryid, int parentid) {
        this.categoryid = categoryid;
        this.parentid = parentid;
    }

    public Integer getCategoryid() {
        return this.categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return this.categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public int getParentid() {
        return this.parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

   

}
