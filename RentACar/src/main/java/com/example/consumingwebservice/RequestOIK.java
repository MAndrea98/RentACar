//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.11 at 09:41:14 PM CEST 
//


package com.example.consumingwebservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for requestOIK complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="requestOIK"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="endUserXML" type="{http://localhost:8085/api/OcenjivanjeIKomentari/}endUserOIK" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="renterXML" type="{http://localhost:8085/api/OcenjivanjeIKomentari/}renterOIK" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestOIK", namespace = "http://localhost:8085/api/OcenjivanjeIKomentari/", propOrder = {
    "endUserXML",
    "id",
    "renterXML",
    "status"
})
public class RequestOIK {

    protected EndUserOIK endUserXML;
    protected Long id;
    protected RenterOIK renterXML;
    protected String status;

    /**
     * Gets the value of the endUserXML property.
     * 
     * @return
     *     possible object is
     *     {@link EndUserOIK }
     *     
     */
    public EndUserOIK getEndUserXML() {
        return endUserXML;
    }

    /**
     * Sets the value of the endUserXML property.
     * 
     * @param value
     *     allowed object is
     *     {@link EndUserOIK }
     *     
     */
    public void setEndUserXML(EndUserOIK value) {
        this.endUserXML = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the renterXML property.
     * 
     * @return
     *     possible object is
     *     {@link RenterOIK }
     *     
     */
    public RenterOIK getRenterXML() {
        return renterXML;
    }

    /**
     * Sets the value of the renterXML property.
     * 
     * @param value
     *     allowed object is
     *     {@link RenterOIK }
     *     
     */
    public void setRenterXML(RenterOIK value) {
        this.renterXML = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

}
