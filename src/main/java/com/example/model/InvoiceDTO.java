package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Introspected;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"CustomizationID", "ProfileID", "ID", "IssueDate", "DueDate", "InvoiceTypeCode", "DocumentCurrencyCode", "AccountingCost", "BuyerReference", "AccountingSupplierParty", "AccountingCustomerParty", "Delivery", "PaymentMeans", "PaymentTerms", "AllowanceCharge", "TaxTotal", "LegalMonetaryTotal", "InvoiceLine"})
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Introspected
public class InvoiceDTO {
    @JsonProperty("CustomizationID")
    private String customizationID;
    @JsonProperty("ProfileID")
    private String profileID;
    @JsonProperty("ID")
    private @NonNull String id;
    @JsonProperty("IssueDate")
    private String issueDate;
    @JsonProperty("DueDate")
    private String dueDate;
    @JsonProperty("InvoiceTypeCode")
    private String invoiceTypeCode;
    @JsonProperty("DocumentCurrencyCode")
    private String documentCurrencyCode;
    @JsonProperty("AccountingCost")
    private String accountingCost;
    @JsonProperty("BuyerReference")
    private String buyerReference;
    @JsonProperty("AccountingSupplierParty")
    private AccountingSupplierPartyDTO accountingSupplierParty = AccountingSupplierPartyDTO.builder().build();
    @JsonProperty("AccountingCustomerParty")
    private AccountingCustomerPartyDTO accountingCustomerParty = AccountingCustomerPartyDTO.builder().build();
    @JsonProperty("Delivery")
    private DeliveryDTO delivery = DeliveryDTO.builder().build();
    @JsonProperty("PaymentMeans")
    private PaymentMeansDTO paymentMeans = PaymentMeansDTO.builder().build();
    @JsonProperty("PaymentTerms")
    private PaymentTermsDTO paymentTerms = PaymentTermsDTO.builder().build();
    @JsonProperty("AllowanceCharge")
    private AllowanceChargeDTO allowanceCharge = AllowanceChargeDTO.builder().build();
    @JsonProperty("TaxTotal")
    private TaxTotalDTO taxTotal = TaxTotalDTO.builder().build();
    @JsonProperty("LegalMonetaryTotal")
    private LegalMonetaryTotalDTO legalMonetaryTotal = LegalMonetaryTotalDTO.builder().build();
    @JsonProperty("InvoiceLine")
    private List<InvoiceLineDTO> invoiceLine = new ArrayList<>();
}
