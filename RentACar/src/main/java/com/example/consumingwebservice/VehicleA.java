//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.11 at 09:41:14 PM CEST 
//


package com.example.consumingwebservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for vehicleA complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="vehicleA"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cdw" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="childSeatsNo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="gasType" type="{http://localhost:8087/api/Administrator/}gasTypeA" minOccurs="0"/&gt;
 *         &lt;element name="gearBox" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="image" type="{http://www.w3.org/2001/XMLSchema}byte" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="mileage" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="model" type="{http://localhost:8087/api/Administrator/}modelA" minOccurs="0"/&gt;
 *         &lt;element name="owner" type="{http://localhost:8087/api/Administrator/}renterA" minOccurs="0"/&gt;
 *         &lt;element name="price" type="{http://localhost:8087/api/Administrator/}priceListA" minOccurs="0"/&gt;
 *         &lt;element name="proposedMileage" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="vehicleClass" type="{http://localhost:8087/api/Administrator/}vehicleClassA" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vehicleA", propOrder = {
    "cdw",
    "childSeatsNo",
    "gasType",
    "gearBox",
    "id",
    "image",
    "mileage",
    "model",
    "owner",
    "price",
    "proposedMileage",
    "vehicleClass"
})
public class VehicleA {

    protected Boolean cdw;
    protected int childSeatsNo;
    protected GasTypeA gasType;
    protected String gearBox;
    protected Long id;
    @XmlElement(nillable = true)
    protected List<Byte> image;
    protected int mileage;
    protected ModelA model;
    protected RenterA owner;
    protected PriceListA price;
    protected int proposedMileage;
    protected VehicleClassA vehicleClass;

    /**
     * Gets the value of the cdw property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCdw() {
        return cdw;
    }

    /**
     * Sets the value of the cdw property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCdw(Boolean value) {
        this.cdw = value;
    }

    /**
     * Gets the value of the childSeatsNo property.
     * 
     */
    public int getChildSeatsNo() {
        return childSeatsNo;
    }

    /**
     * Sets the value of the childSeatsNo property.
     * 
     */
    public void setChildSeatsNo(int value) {
        this.childSeatsNo = value;
    }

    /**
     * Gets the value of the gasType property.
     * 
     * @return
     *     possible object is
     *     {@link GasTypeA }
     *     
     */
    public GasTypeA getGasType() {
        return gasType;
    }

    /**
     * Sets the value of the gasType property.
     * 
     * @param value
     *     allowed object is
     *     {@link GasTypeA }
     *     
     */
    public void setGasType(GasTypeA value) {
        this.gasType = value;
    }

    /**
     * Gets the value of the gearBox property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGearBox() {
        return gearBox;
    }

    /**
     * Sets the value of the gearBox property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGearBox(String value) {
        this.gearBox = value;
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
     * Gets the value of the image property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the image property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Byte }
     * 
     * 
     */
    public List<Byte> getImage() {
        if (image == null) {
            image = new ArrayList<Byte>();
        }
        return this.image;
    }

    /**
     * Gets the value of the mileage property.
     * 
     */
    public int getMileage() {
        return mileage;
    }

    /**
     * Sets the value of the mileage property.
     * 
     */
    public void setMileage(int value) {
        this.mileage = value;
    }

    /**
     * Gets the value of the model property.
     * 
     * @return
     *     possible object is
     *     {@link ModelA }
     *     
     */
    public ModelA getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelA }
     *     
     */
    public void setModel(ModelA value) {
        this.model = value;
    }

    /**
     * Gets the value of the owner property.
     * 
     * @return
     *     possible object is
     *     {@link RenterA }
     *     
     */
    public RenterA getOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     * 
     * @param value
     *     allowed object is
     *     {@link RenterA }
     *     
     */
    public void setOwner(RenterA value) {
        this.owner = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link PriceListA }
     *     
     */
    public PriceListA getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceListA }
     *     
     */
    public void setPrice(PriceListA value) {
        this.price = value;
    }

    /**
     * Gets the value of the proposedMileage property.
     * 
     */
    public int getProposedMileage() {
        return proposedMileage;
    }

    /**
     * Sets the value of the proposedMileage property.
     * 
     */
    public void setProposedMileage(int value) {
        this.proposedMileage = value;
    }

    /**
     * Gets the value of the vehicleClass property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleClassA }
     *     
     */
    public VehicleClassA getVehicleClass() {
        return vehicleClass;
    }

    /**
     * Sets the value of the vehicleClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleClassA }
     *     
     */
    public void setVehicleClass(VehicleClassA value) {
        this.vehicleClass = value;
    }

}
