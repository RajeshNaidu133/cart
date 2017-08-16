// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NewsForm.java

package roseindia.web.struts.form;

import fr.improve.struts.taglib.layout.util.DefaultForm;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

/**
 * Form bean for add to categories in tree menu Entry Screen.
 *
 */

public class CategoriesForm extends DefaultForm
{

    public CategoriesForm()
    {
    }

    public String getTitle()
    {
        return title;
    }

    public String getSubject()
    {
        return subject;
    }

    public String getBody()
    {
        return body;
    }

    public void setTitle(String in_title)
    {
        title = in_title;
    }

    public void setSubject(String in_subject)
    {
        subject = in_subject;
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

    public boolean getSendNewsToMailingList()
    {
        return sendNewsToMailingList;
    }

    public void setSendNewsToMailingList(boolean in_sendNewsToMailinList)
    {
        this.sendNewsToMailingList = in_sendNewsToMailinList;
    }

    private void isEmpty(ActionErrors in_actionErrors, String in_parameter, String in_nameParameter)
    {
        if(in_parameter == null || in_parameter.equals(""))
        {
            ActionMessage l_actionError = new ActionMessage("error.required");
            in_actionErrors.add(in_nameParameter, l_actionError);
        }
    }

    /**
	 * Validate the properties posted in this request. If validation errors are
	 * found, return an <code>ActionErrors</code> object containing the errors.
	 * If no validation errors occur, return <code>null</code> or an empty
	 * <code>ActionErrors</code> object.
	 *
	 * @param mapping The current mapping (from struts-config.xml)
	 * @param request The servlet request object
	 */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
    {
        ActionErrors l_actionErrors = new ActionErrors();       
        isEmpty(l_actionErrors, title, "title");
        isEmpty(l_actionErrors, subject, "subject");
        isEmpty(l_actionErrors, body, "body");
        return l_actionErrors;
    }

    protected String title;
    protected String subject;
    protected String body;
    protected String id;
    protected String date;
    protected boolean sendNewsToMailingList;
    
	/**
	 * Returns the date.
	 * @return String
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 * @param date The date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

}
