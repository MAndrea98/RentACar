//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.09 at 11:11:12 AM CEST 
//


package com.example.consumingwebservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for priceListA complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="priceListA"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cdwPrice" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="pricePerMile" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "priceListA", propOrder = {
    "cdwPrice",
    "pricePerMile"
})
public class PriceListA {

    protected double cdwPrice;
    protected double pricePerMile;

    /**
     * Gets the value of the cdwPrice property.
     * 
     */
    public double getCdwPrice() {
        return cdwPrice;
    }

    /**
     * Sets the value of the cdwPrice property.
     * 
     */
    public void setCdwPrice(double value) {
        this.cdwPrice = value;
    }

    /**
     * Gets the value of the pricePerMile property.
     * 
     */
    public double getPricePerMile() {
        return pricePerMile;
    }

    /**
     * Sets the value of the pricePerMile property.
     * 
     */
    public void setPricePerMile(double value) {
        this.pricePerMile = value;
    }

}
