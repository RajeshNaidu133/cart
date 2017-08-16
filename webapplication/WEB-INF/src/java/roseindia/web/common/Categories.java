package roseindia.web.common;

import java.io.Serializable;
/*
 * Bean to set and get category class products in tree menu.
 */
public class Categories implements Serializable{
	protected String title;
	protected Products product;
	protected String body;
	protected String id;
	protected String date;	

	//constructor
    public Categories()
    {
    }

    //setter getter methods for all properties
    public String getTitle()
    {
        return title;
    }

   

    public String getBody()
    {
        return body;
    }

    public void setTitle(String in_title)
    {
        title = in_title;
    }

    

    public void setBody(String in_body)
    {
        body = in_body;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}
    
   
}
