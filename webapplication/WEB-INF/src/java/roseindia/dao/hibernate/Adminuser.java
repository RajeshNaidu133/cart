package roseindia.dao.hibernate;

import java.io.Serializable;


public class Adminuser implements Serializable {

    /** identifier field */
    private Integer id;

    /** persistent field */
    private String userid;

    /** persistent field */
    private String password;

    /** full constructor */
    public Adminuser(Integer id, String userid, String password) {
        this.id = id;
        this.userid = userid;
        this.password = password;
    }

    /** default constructor */
    public Adminuser() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return this.userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

}
