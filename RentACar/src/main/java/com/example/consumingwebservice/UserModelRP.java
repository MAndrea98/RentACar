//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.03 at 08:37:52 PM CEST 
//


package com.example.consumingwebservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for userModelRP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userModelRP"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="inbox" type="{http://localhost:8089/api/RazmenaPoruka/}messageRP" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="outbox" type="{http://localhost:8089/api/RazmenaPoruka/}messageRP" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="permissions" type="{http://localhost:8089/api/RazmenaPoruka/}permissionsRP" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="uloga" type="{http://localhost:8089/api/RazmenaPoruka/}userTypeRP" minOccurs="0"/&gt;
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userModelRP", namespace = "http://localhost:8089/api/RazmenaPoruka/", propOrder = {
    "inbox",
    "outbox",
    "password",
    "permissions",
    "uloga",
    "username"
})
public class UserModelRP {

    @XmlElement(nillable = true)
    protected List<MessageRP> inbox;
    @XmlElement(nillable = true)
    protected List<MessageRP> outbox;
    protected String password;
    @XmlElement(nillable = true)
    protected List<String> permissions;
    @XmlSchemaType(name = "string")
    protected UserTypeRP uloga;
    protected String username;

    /**
     * Gets the value of the inbox property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inbox property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInbox().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MessageRP }
     * 
     * 
     */
    public List<MessageRP> getInbox() {
        if (inbox == null) {
            inbox = new ArrayList<MessageRP>();
        }
        return this.inbox;
    }

    /**
     * Gets the value of the outbox property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outbox property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutbox().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MessageRP }
     * 
     * 
     */
    public List<MessageRP> getOutbox() {
        if (outbox == null) {
            outbox = new ArrayList<MessageRP>();
        }
        return this.outbox;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the permissions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the permissions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPermissions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPermissions() {
        if (permissions == null) {
            permissions = new ArrayList<String>();
        }
        return this.permissions;
    }

    /**
     * Gets the value of the uloga property.
     * 
     * @return
     *     possible object is
     *     {@link UserTypeRP }
     *     
     */
    public UserTypeRP getUloga() {
        return uloga;
    }

    /**
     * Sets the value of the uloga property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserTypeRP }
     *     
     */
    public void setUloga(UserTypeRP value) {
        this.uloga = value;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

}