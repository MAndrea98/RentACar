//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.10 at 06:35:29 PM CEST 
//


package com.example.consumingwebservice;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for userTypeRP.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="userTypeRP"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ENDUSER"/&gt;
 *     &lt;enumeration value="RENTER"/&gt;
 *     &lt;enumeration value="ADMIN"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "userTypeRP", namespace = "http://localhost:8089/api/RazmenaPoruka/")
@XmlEnum
public enum UserTypeRP {

    ENDUSER,
    RENTER,
    ADMIN;

    public String value() {
        return name();
    }

    public static UserTypeRP fromValue(String v) {
        return valueOf(v);
    }

}
