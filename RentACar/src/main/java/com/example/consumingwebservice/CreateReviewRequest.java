//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.08 at 12:00:55 PM CEST 
//


package com.example.consumingwebservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="review" type="{http://localhost:8085/api/OcenjivanjeIKomentari/}reviewDTOOIK"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "review"
})
@XmlRootElement(name = "createReviewRequest", namespace = "http://localhost:8085/api/OcenjivanjeIKomentari/")
public class CreateReviewRequest {

    @XmlElement(namespace = "http://localhost:8085/api/OcenjivanjeIKomentari/", required = true)
    protected ReviewDTOOIK review;

    /**
     * Gets the value of the review property.
     * 
     * @return
     *     possible object is
     *     {@link ReviewDTOOIK }
     *     
     */
    public ReviewDTOOIK getReview() {
        return review;
    }

    /**
     * Sets the value of the review property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReviewDTOOIK }
     *     
     */
    public void setReview(ReviewDTOOIK value) {
        this.review = value;
    }

}
