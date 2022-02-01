package com.example.util;

import com.example.model.AccountingCustomerPartyDTO;
import com.example.model.AccountingSupplierPartyDTO;
import com.example.model.CompanyID;
import com.example.model.ContactDTO;
import com.example.model.CountryDTO;
import com.example.model.CustomerPartyDTO;
import com.example.model.CustomerPartyIdentificationDTO;
import com.example.model.CustomerPartyLegalEntityDTO;
import com.example.model.EndpointIDDTO;
import com.example.model.IdDTO;
import com.example.model.InvoiceDTO;
import com.example.model.PartyNameDTO;
import com.example.model.PartyTaxSchemeDTO;
import com.example.model.PostalAddressDTO;
import com.example.model.SupplierPartyDTO;
import com.example.model.SupplierPartyIdentificationDTO;
import com.example.model.TaxSchemeDTO;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;

import java.util.Optional;

@UtilityClass
@Slf4j
public class TransformerUtil {
    public static Document mapTo(final InvoiceDTO invoiceDTO) {
        Document document = new Document();
        return document
                .append("ID", invoiceDTO.getId())
                .append("CustomizationID", invoiceDTO.getCustomizationID())
                .append("ProfileID", invoiceDTO.getProfileID())
                .append("IssueDate", invoiceDTO.getIssueDate())
                .append("DueDate", invoiceDTO.getDueDate())
                .append("InvoiceTypeCode", invoiceDTO.getInvoiceTypeCode())
                .append("DocumentCurrencyCode", invoiceDTO.getInvoiceTypeCode())
                .append("AccountingCost", invoiceDTO.getAccountingCost())
                .append("BuyerReference", invoiceDTO.getBuyerReference())
                .append("AccountingSupplierParty", new Document()
                        .append("Party", new Document()
                                .append("EndpointID", new Document()
                                        .append("@schemeID", invoiceDTO.getAccountingSupplierParty().getParty().getEndpointID().getSchemeID())
                                        .append("#text", invoiceDTO.getAccountingSupplierParty().getParty().getEndpointID().getText()))
                                .append("PartyIdentification", new Document()
                                        .append("ID", invoiceDTO.getAccountingSupplierParty().getParty().getPartyIdentification().getId()))
                                .append("PartyName", new Document()
                                        .append("Name", invoiceDTO.getAccountingSupplierParty().getParty().getPartyName().getName()))
                                .append("PostalAddress", new Document()
                                        .append("StreetName", invoiceDTO.getAccountingSupplierParty().getParty().getPostalAddress().getStreetName())
                                        .append("AdditionalStreetName", invoiceDTO.getAccountingSupplierParty().getParty().getPostalAddress().getAdditionalStreetName())
                                        .append("CityName", invoiceDTO.getAccountingSupplierParty().getParty().getPostalAddress().getCityName())
                                        .append("PostalZone", invoiceDTO.getAccountingSupplierParty().getParty().getPostalAddress().getPostalZone())
                                        .append("Country", new Document()
                                                .append("IdentificationCode", invoiceDTO.getAccountingSupplierParty().getParty().getPostalAddress().getCountry().getIdentificationCode())))))
                .append("AccountingCustomerParty", new Document()
                        .append("Party", new Document()
                                .append("EndpointID", new Document()
                                        .append("@schemeID", invoiceDTO.getAccountingCustomerParty().getParty().getEndpointID().getSchemeID())
                                        .append("#text", invoiceDTO.getAccountingCustomerParty().getParty().getEndpointID().getText()))
                                .append("PartyIdentification", new Document()
                                        .append("ID", new Document()
                                                .append("@schemeID", invoiceDTO.getAccountingCustomerParty().getParty().getPartyIdentification().getId().getSchemeID())
                                                .append("#text", invoiceDTO.getAccountingCustomerParty().getParty().getPartyIdentification().getId().getText())))
                                .append("PartyName", new Document()
                                        .append("Name", invoiceDTO.getAccountingCustomerParty().getParty().getPartyName().getName()))
                                .append("PostalAddress", new Document()
                                        .append("StreetName", invoiceDTO.getAccountingCustomerParty().getParty().getPostalAddress().getStreetName())
                                        .append("AdditionalStreetName", invoiceDTO.getAccountingCustomerParty().getParty().getPostalAddress().getAdditionalStreetName())
                                        .append("CityName", invoiceDTO.getAccountingCustomerParty().getParty().getPostalAddress().getCityName())
                                        .append("PostalZone", invoiceDTO.getAccountingCustomerParty().getParty().getPostalAddress().getPostalZone())
                                        .append("Country", new Document()
                                                .append("IdentificationCode", invoiceDTO.getAccountingCustomerParty().getParty().getPostalAddress().getCountry().getIdentificationCode())))
                                .append("PartyTaxScheme", new Document()
                                        .append("CompanyID", invoiceDTO.getAccountingCustomerParty().getParty().getPartyTaxScheme().getCompanyID())
                                        .append("TaxScheme", new Document()
                                                .append("ID", invoiceDTO.getAccountingCustomerParty().getParty().getPartyTaxScheme().getTaxScheme().getId())))
                                .append("PartyLegalEntity", new Document()
                                        .append("RegistrationName", invoiceDTO.getAccountingCustomerParty().getParty().getPartyLegalEntity().getRegistrationName())
                                        .append("CompanyID", new Document()
                                                .append("@schemeID", invoiceDTO.getAccountingCustomerParty().getParty().getPartyLegalEntity().getCompanyID().getSchemeID())
                                                .append("#text", invoiceDTO.getAccountingCustomerParty().getParty().getPartyLegalEntity().getCompanyID().getText())))
                                .append("Contact", new Document()
                                        .append("Name", invoiceDTO.getAccountingCustomerParty().getParty().getContact().getName())
                                        .append("Telephone", invoiceDTO.getAccountingCustomerParty().getParty().getContact().getTelephone())
                                        .append("ElectronicMail", invoiceDTO.getAccountingCustomerParty().getParty().getContact().getElectronicMail())
                                )
                        ));
    }

    public static InvoiceDTO mapTo(final String id, final Document document) {
        InvoiceDTO.InvoiceDTOBuilder builder = InvoiceDTO.builder();
        if (!AppUtil.isEmpty(id)) {
            builder.id(id);
        }
        builder
                .customizationID(document.get("CustomizationID", String.class))
                .profileID(document.get("ProfileID", String.class))
                .issueDate(document.get("IssueDate", String.class))
                .dueDate(document.get("DueDate", String.class))
                .invoiceTypeCode(document.get("InvoiceTypeCode", String.class))
                .documentCurrencyCode(document.get("DocumentCurrencyCode", String.class))
                .accountingCost(document.get("AccountingCost", String.class))
                .buyerReference(document.get("BuyerReference", String.class));

        Document accountingSupplierParty = Optional.ofNullable(document.get("AccountingSupplierParty", Document.class))
                .orElse(new Document());
        Document party = Optional.ofNullable(accountingSupplierParty.get("Party", Document.class))
                .orElse(new Document());
        Document endpointID = Optional.ofNullable(party.get("EndpointID", Document.class))
                .orElse(new Document());
        Document partyIdentification = Optional.ofNullable(party.get("PartyIdentification", Document.class))
                .orElse(new Document());
        Document partyName = Optional.ofNullable(party.get("PartyName", Document.class))
                .orElse(new Document());
        Document postalAddress = Optional.ofNullable(party.get("PostalAddress", Document.class))
                .orElse(new Document());

        builder.accountingSupplierParty(AccountingSupplierPartyDTO.builder()
                .party(SupplierPartyDTO.builder()
                        .endpointID(EndpointIDDTO.builder()
                                .schemeID(endpointID.get("@schemeID", String.class))
                                .text(endpointID.get("#text", String.class))
                                .build())
                        .partyIdentification(SupplierPartyIdentificationDTO.builder()
                                .id(partyIdentification.get("ID", String.class))
                                .build())
                        .partyName(PartyNameDTO.builder()
                                .name(partyName.get("Name", String.class))
                                .build())
                        .postalAddress(PostalAddressDTO.builder()
                                .streetName(postalAddress.get("StreetName", String.class))
                                .additionalStreetName(postalAddress.get("AdditionalStreetName", String.class))
                                .cityName(postalAddress.get("CityName", String.class))
                                .postalZone(postalAddress.get("PostalZone", String.class))
                                .country(CountryDTO.builder()
                                        .identificationCode(postalAddress.get("Country", Document.class)
                                                .get("IdentificationCode", String.class))
                                        .build())
                                .build())
                        .build())
                .build());

        Document accountingCustomerParty = Optional.ofNullable(document.get("AccountingCustomerParty", Document.class))
                .orElse(new Document());
        Document acParty = Optional.ofNullable(accountingCustomerParty.get("Party", Document.class))
                .orElse(new Document());
        Document acEndpointID = Optional.ofNullable(acParty.get("EndpointID", Document.class))
                .orElse(new Document());
        Document acPartyIdentification = Optional.ofNullable(Optional.ofNullable(acParty.get("PartyIdentification", Document.class))
                        .orElse(new Document()).get("ID", Document.class))
                .orElse(new Document());
        Document acPartyName = Optional.ofNullable(acParty.get("PartyName", Document.class))
                .orElse(new Document());
        Document acPostalAddress = Optional.ofNullable(acParty.get("PostalAddress", Document.class))
                .orElse(new Document());
        Document partyTaxScheme = Optional.ofNullable(acParty.get("PartyTaxScheme", Document.class))
                .orElse(new Document());
        Document partyTaxSchemeTaxScheme = Optional.ofNullable(partyTaxScheme.get("TaxScheme", Document.class))
                .orElse(new Document());
        Document partyLegalEntity = Optional.ofNullable(acParty.get("PartyLegalEntity", Document.class))
                .orElse(new Document());
        Document partyLegalEntityCompanyID = Optional.ofNullable(partyLegalEntity.get("CompanyID", Document.class))
                .orElse(new Document());
        Document contact = Optional.ofNullable(acParty.get("Contact", Document.class))
                .orElse(new Document());

        builder.accountingCustomerParty(AccountingCustomerPartyDTO.builder()
                .party(CustomerPartyDTO.builder()
                        .endpointID(EndpointIDDTO.builder()
                                .schemeID(acEndpointID.get("@schemeID", String.class))
                                .text(acEndpointID.get("#text", String.class))
                                .build())
                        .partyIdentification(CustomerPartyIdentificationDTO.builder()
                                .id(IdDTO.builder()
                                        .schemeID(acPartyIdentification.get("@schemeID", String.class))
                                        .text(acPartyIdentification.get("#text", String.class))
                                        .build())
                                .build())
                        .partyName(PartyNameDTO.builder()
                                .name(acPartyName.get("Name", String.class))
                                .build())
                        .postalAddress(PostalAddressDTO.builder()
                                .streetName(acPostalAddress.get("StreetName", String.class))
                                .additionalStreetName(acPostalAddress.get("AdditionalStreetName", String.class))
                                .cityName(acPostalAddress.get("CityName", String.class))
                                .postalZone(acPostalAddress.get("PostalZone", String.class))
                                .country(CountryDTO.builder()
                                        .identificationCode(acPostalAddress.get("Country", Document.class)
                                                .get("IdentificationCode", String.class))
                                        .build())
                                .build())
                        .partyTaxScheme(PartyTaxSchemeDTO.builder()
                                .companyID(partyTaxScheme.get("CompanyID", String.class))
                                .taxScheme(TaxSchemeDTO.builder()
                                        .id(partyTaxSchemeTaxScheme.get("ID", String.class))
                                        .build())
                                .build())
                        .partyLegalEntity(CustomerPartyLegalEntityDTO.builder()
                                .registrationName(partyLegalEntity.get("RegistrationName", String.class))
                                .companyID(CompanyID.builder()
                                        .schemeID(partyLegalEntityCompanyID.get("@schemeID", String.class))
                                        .text(partyLegalEntityCompanyID.get("#text", String.class))
                                        .build())
                                .build())
                        .contact(ContactDTO.builder()
                                .name(contact.get("Name", String.class))
                                .telephone(contact.get("Telephone", String.class))
                                .electronicMail(contact.get("ElectronicMail", String.class))
                                .build())
                        .build())
                .build());
        return builder.build();
    }

    public static Document mapToFields(final InvoiceDTO invoiceDTO) {
        Document document = new Document();

        if (!AppUtil.isEmpty(invoiceDTO.getCustomizationID())) {
            document.append("CustomizationID", invoiceDTO.getCustomizationID());
        }
        if (!AppUtil.isEmpty(invoiceDTO.getProfileID())) {
            document.append("ProfileID", invoiceDTO.getProfileID());
        }
        if (!AppUtil.isEmpty(invoiceDTO.getIssueDate())) {
            document.append("IssueDate", invoiceDTO.getIssueDate());
        }
        if (!AppUtil.isEmpty(invoiceDTO.getDueDate())) {
            document.append("DueDate", invoiceDTO.getDueDate());
        }
        if (!AppUtil.isEmpty(invoiceDTO.getInvoiceTypeCode())) {
            document.append("InvoiceTypeCode", invoiceDTO.getInvoiceTypeCode());
        }
        if (!AppUtil.isEmpty(invoiceDTO.getDocumentCurrencyCode())) {
            document.append("DocumentCurrencyCode", invoiceDTO.getDocumentCurrencyCode());
        }
        if (!AppUtil.isEmpty(invoiceDTO.getDocumentCurrencyCode())) {
            document.append("AccountingCost", invoiceDTO.getAccountingCost());
        }
        if (!AppUtil.isEmpty(invoiceDTO.getDocumentCurrencyCode())) {
            document.append("BuyerReference", invoiceDTO.getBuyerReference());
        }
        return document;
    }

}
