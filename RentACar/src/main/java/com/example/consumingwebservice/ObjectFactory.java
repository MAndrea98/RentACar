//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.08 at 12:00:55 PM CEST 
//


package com.example.consumingwebservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.consumingwebservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllMessageRequest_QNAME = new QName("http://localhost:8089/api/RazmenaPoruka/", "getAllMessageRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.consumingwebservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PriceListOIK }
     * 
     */
    public PriceListOIK createPriceListOIK() {
        return new PriceListOIK();
    }

    /**
     * Create an instance of {@link PriceListOIK.Discount }
     * 
     */
    public PriceListOIK.Discount createPriceListOIKDiscount() {
        return new PriceListOIK.Discount();
    }

    /**
     * Create an instance of {@link PriceListOIK.DatesPrice }
     * 
     */
    public PriceListOIK.DatesPrice createPriceListOIKDatesPrice() {
        return new PriceListOIK.DatesPrice();
    }

    /**
     * Create an instance of {@link Ad }
     * 
     */
    public Ad createAd() {
        return new Ad();
    }

    /**
     * Create an instance of {@link Ad.Free }
     * 
     */
    public Ad.Free createAdFree() {
        return new Ad.Free();
    }

    /**
     * Create an instance of {@link AcceptCommentRequest }
     * 
     */
    public AcceptCommentRequest createAcceptCommentRequest() {
        return new AcceptCommentRequest();
    }

    /**
     * Create an instance of {@link ReviewDTOA }
     * 
     */
    public ReviewDTOA createReviewDTOA() {
        return new ReviewDTOA();
    }

    /**
     * Create an instance of {@link AcceptCommentResponse }
     * 
     */
    public AcceptCommentResponse createAcceptCommentResponse() {
        return new AcceptCommentResponse();
    }

    /**
     * Create an instance of {@link DeclineCommentRequest }
     * 
     */
    public DeclineCommentRequest createDeclineCommentRequest() {
        return new DeclineCommentRequest();
    }

    /**
     * Create an instance of {@link DeclineCommentResponse }
     * 
     */
    public DeclineCommentResponse createDeclineCommentResponse() {
        return new DeclineCommentResponse();
    }

    /**
     * Create an instance of {@link EndUserA }
     * 
     */
    public EndUserA createEndUserA() {
        return new EndUserA();
    }

    /**
     * Create an instance of {@link ReviewA }
     * 
     */
    public ReviewA createReviewA() {
        return new ReviewA();
    }

    /**
     * Create an instance of {@link RenterA }
     * 
     */
    public RenterA createRenterA() {
        return new RenterA();
    }

    /**
     * Create an instance of {@link PriceListA }
     * 
     */
    public PriceListA createPriceListA() {
        return new PriceListA();
    }

    /**
     * Create an instance of {@link VehicleA }
     * 
     */
    public VehicleA createVehicleA() {
        return new VehicleA();
    }

    /**
     * Create an instance of {@link GasTypeA }
     * 
     */
    public GasTypeA createGasTypeA() {
        return new GasTypeA();
    }

    /**
     * Create an instance of {@link ModelA }
     * 
     */
    public ModelA createModelA() {
        return new ModelA();
    }

    /**
     * Create an instance of {@link ManufacturerA }
     * 
     */
    public ManufacturerA createManufacturerA() {
        return new ManufacturerA();
    }

    /**
     * Create an instance of {@link VehicleClassA }
     * 
     */
    public VehicleClassA createVehicleClassA() {
        return new VehicleClassA();
    }

    /**
     * Create an instance of {@link AgentA }
     * 
     */
    public AgentA createAgentA() {
        return new AgentA();
    }

    /**
     * Create an instance of {@link CompanyA }
     * 
     */
    public CompanyA createCompanyA() {
        return new CompanyA();
    }

    /**
     * Create an instance of {@link ReportA }
     * 
     */
    public ReportA createReportA() {
        return new ReportA();
    }

    /**
     * Create an instance of {@link UserModelA }
     * 
     */
    public UserModelA createUserModelA() {
        return new UserModelA();
    }

    /**
     * Create an instance of {@link AdminA }
     * 
     */
    public AdminA createAdminA() {
        return new AdminA();
    }

    /**
     * Create an instance of {@link CreateReviewRequest }
     * 
     */
    public CreateReviewRequest createCreateReviewRequest() {
        return new CreateReviewRequest();
    }

    /**
     * Create an instance of {@link ReviewDTOOIK }
     * 
     */
    public ReviewDTOOIK createReviewDTOOIK() {
        return new ReviewDTOOIK();
    }

    /**
     * Create an instance of {@link CreateReviewResponse }
     * 
     */
    public CreateReviewResponse createCreateReviewResponse() {
        return new CreateReviewResponse();
    }

    /**
     * Create an instance of {@link EditReviewRequest }
     * 
     */
    public EditReviewRequest createEditReviewRequest() {
        return new EditReviewRequest();
    }

    /**
     * Create an instance of {@link EditReviewResponse }
     * 
     */
    public EditReviewResponse createEditReviewResponse() {
        return new EditReviewResponse();
    }

    /**
     * Create an instance of {@link DeleteReviewRequest }
     * 
     */
    public DeleteReviewRequest createDeleteReviewRequest() {
        return new DeleteReviewRequest();
    }

    /**
     * Create an instance of {@link DeleteReviewResponse }
     * 
     */
    public DeleteReviewResponse createDeleteReviewResponse() {
        return new DeleteReviewResponse();
    }

    /**
     * Create an instance of {@link RequestOIK }
     * 
     */
    public RequestOIK createRequestOIK() {
        return new RequestOIK();
    }

    /**
     * Create an instance of {@link EndUserOIK }
     * 
     */
    public EndUserOIK createEndUserOIK() {
        return new EndUserOIK();
    }

    /**
     * Create an instance of {@link ReviewOIK }
     * 
     */
    public ReviewOIK createReviewOIK() {
        return new ReviewOIK();
    }

    /**
     * Create an instance of {@link RenterOIK }
     * 
     */
    public RenterOIK createRenterOIK() {
        return new RenterOIK();
    }

    /**
     * Create an instance of {@link UserModelOIK }
     * 
     */
    public UserModelOIK createUserModelOIK() {
        return new UserModelOIK();
    }

    /**
     * Create an instance of {@link ReportOIK }
     * 
     */
    public ReportOIK createReportOIK() {
        return new ReportOIK();
    }

    /**
     * Create an instance of {@link AdminXML }
     * 
     */
    public AdminXML createAdminXML() {
        return new AdminXML();
    }

    /**
     * Create an instance of {@link SendMessageRequest }
     * 
     */
    public SendMessageRequest createSendMessageRequest() {
        return new SendMessageRequest();
    }

    /**
     * Create an instance of {@link MessageRP }
     * 
     */
    public MessageRP createMessageRP() {
        return new MessageRP();
    }

    /**
     * Create an instance of {@link SendMessageResponse }
     * 
     */
    public SendMessageResponse createSendMessageResponse() {
        return new SendMessageResponse();
    }

    /**
     * Create an instance of {@link GetAllMessageResponse }
     * 
     */
    public GetAllMessageResponse createGetAllMessageResponse() {
        return new GetAllMessageResponse();
    }

    /**
     * Create an instance of {@link EditMessageRequest }
     * 
     */
    public EditMessageRequest createEditMessageRequest() {
        return new EditMessageRequest();
    }

    /**
     * Create an instance of {@link EditMessageResponse }
     * 
     */
    public EditMessageResponse createEditMessageResponse() {
        return new EditMessageResponse();
    }

    /**
     * Create an instance of {@link DeleteMessageRequest }
     * 
     */
    public DeleteMessageRequest createDeleteMessageRequest() {
        return new DeleteMessageRequest();
    }

    /**
     * Create an instance of {@link DeleteMessageResponse }
     * 
     */
    public DeleteMessageResponse createDeleteMessageResponse() {
        return new DeleteMessageResponse();
    }

    /**
     * Create an instance of {@link UserModelRP }
     * 
     */
    public UserModelRP createUserModelRP() {
        return new UserModelRP();
    }

    /**
     * Create an instance of {@link LogedUserRP }
     * 
     */
    public LogedUserRP createLogedUserRP() {
        return new LogedUserRP();
    }

    /**
     * Create an instance of {@link PriceListOIK.Discount.Entry }
     * 
     */
    public PriceListOIK.Discount.Entry createPriceListOIKDiscountEntry() {
        return new PriceListOIK.Discount.Entry();
    }

    /**
     * Create an instance of {@link PriceListOIK.DatesPrice.Entry }
     * 
     */
    public PriceListOIK.DatesPrice.Entry createPriceListOIKDatesPriceEntry() {
        return new PriceListOIK.DatesPrice.Entry();
    }

    /**
     * Create an instance of {@link Ad.Free.Entry }
     * 
     */
    public Ad.Free.Entry createAdFreeEntry() {
        return new Ad.Free.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://localhost:8089/api/RazmenaPoruka/", name = "getAllMessageRequest")
    public JAXBElement<Object> createGetAllMessageRequest(Object value) {
        return new JAXBElement<Object>(_GetAllMessageRequest_QNAME, Object.class, null, value);
    }

}
