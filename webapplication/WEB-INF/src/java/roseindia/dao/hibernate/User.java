package roseindia.dao.hibernate;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class User implements Serializable {

    /** identifier field */
    private Integer id;

    /** persistent field */
    private String userid;

    /** persistent field */
    private String password;

    /** nullable persistent field */
    private String firstname;

    /** nullable persistent field */
    private String lastname;

    /** nullable persistent field */
    private String email;

    /** nullable persistent field */
    private String country;

    /** nullable persistent field */
    private String zip;

    /** nullable persistent field */
    private String state;

    /** nullable persistent field */
    private String city;

    /** nullable persistent field */
    private String address;

    /** nullable persistent field */
    private String phone;

    /** nullable persistent field */
    private Integer fax;

    /** full constructor */
    public User(Integer id, String userid, String password, String firstname, String lastname, String email, String country, String zip, String state, String city, String address, String phone, Integer fax) {
        this.id = id;
        this.userid = userid;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.country = country;
        this.zip = zip;
        this.state = state;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.fax = fax;
    }

    /** default constructor */
    public User() {
    }

    /** minimal constructor */
    public User(Integer id, String userid, String password) {
        this.id = id;
        this.userid = userid;
        this.password = password;
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

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getFax() {
        return this.fax;
    }

    public void setFax(Integer fax) {
        this.fax = fax;
    }

}
