//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.30 at 02:21:54 PM CEST 
//


package com.example.consumingwebservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for reportOIK complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="reportOIK"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="requestXML" type="{http://localhost:8085/api/OcenjivanjeIKomentari/}requestOIK" minOccurs="0"/&gt;
 *         &lt;element name="reviewXML" type="{http://localhost:8085/api/OcenjivanjeIKomentari/}reviewOIK" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reportOIK", namespace = "http://localhost:8085/api/OcenjivanjeIKomentari/", propOrder = {
    "id",
    "requestXML",
    "reviewXML"
})
public class ReportOIK {

    protected Long id;
    protected RequestOIK requestXML;
    protected ReviewOIK reviewXML;

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
     * Gets the value of the requestXML property.
     * 
     * @return
     *     possible object is
     *     {@link RequestOIK }
     *     
     */
    public RequestOIK getRequestXML() {
        return requestXML;
    }

    /**
     * Sets the value of the requestXML property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestOIK }
     *     
     */
    public void setRequestXML(RequestOIK value) {
        this.requestXML = value;
    }

    /**
     * Gets the value of the reviewXML property.
     * 
     * @return
     *     possible object is
     *     {@link ReviewOIK }
     *     
     */
    public ReviewOIK getReviewXML() {
        return reviewXML;
    }

    /**
     * Sets the value of the reviewXML property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReviewOIK }
     *     
     */
    public void setReviewXML(ReviewOIK value) {
        this.reviewXML = value;
    }

}
