//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.01 at 03:10:38 PM CEST 
//


package com.example.consumingwebservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for reviewOIK complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="reviewOIK"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accepted" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="ad" type="{http://localhost:8085/api/OcenjivanjeIKomentari/}ad" minOccurs="0"/&gt;
 *         &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="deleted" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="endUserXML" type="{http://localhost:8085/api/OcenjivanjeIKomentari/}endUserOIK" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="renterXML" type="{http://localhost:8085/api/OcenjivanjeIKomentari/}renterOIK" minOccurs="0"/&gt;
 *         &lt;element name="stars" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reviewOIK", namespace = "http://localhost:8085/api/OcenjivanjeIKomentari/", propOrder = {
    "accepted",
    "ad",
    "content",
    "deleted",
    "endUserXML",
    "id",
    "renterXML",
    "stars"
})
public class ReviewOIK {

    protected Boolean accepted;
    protected Ad ad;
    protected String content;
    protected Boolean deleted;
    protected EndUserOIK endUserXML;
    protected Long id;
    protected RenterOIK renterXML;
    protected int stars;

    /**
     * Gets the value of the accepted property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAccepted() {
        return accepted;
    }

    /**
     * Sets the value of the accepted property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAccepted(Boolean value) {
        this.accepted = value;
    }

    /**
     * Gets the value of the ad property.
     * 
     * @return
     *     possible object is
     *     {@link Ad }
     *     
     */
    public Ad getAd() {
        return ad;
    }

    /**
     * Sets the value of the ad property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ad }
     *     
     */
    public void setAd(Ad value) {
        this.ad = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the deleted property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDeleted() {
        return deleted;
    }

    /**
     * Sets the value of the deleted property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeleted(Boolean value) {
        this.deleted = value;
    }

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
     * Gets the value of the stars property.
     * 
     */
    public int getStars() {
        return stars;
    }

    /**
     * Sets the value of the stars property.
     * 
     */
    public void setStars(int value) {
        this.stars = value;
    }

}
