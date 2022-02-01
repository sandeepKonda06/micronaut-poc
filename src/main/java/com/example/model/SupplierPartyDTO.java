package com.example.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "EndpointID",
        "PartyIdentification",
        "PartyName",
        "PostalAddress",
        "PartyTaxScheme",
        "PartyLegalEntity",
        "Contact"
})
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@Builder
public class SupplierPartyDTO {
    @JsonProperty("EndpointID")
    private EndpointIDDTO endpointID = EndpointIDDTO.builder().build();
    @JsonProperty("PartyIdentification")
    private SupplierPartyIdentificationDTO partyIdentification = SupplierPartyIdentificationDTO.builder().build();
    @JsonProperty("PartyName")
    private PartyNameDTO partyName = PartyNameDTO.builder().build();
    @JsonProperty("PostalAddress")
    private PostalAddressDTO postalAddress = PostalAddressDTO.builder().build();
    @JsonProperty("PartyTaxScheme")
    private PartyTaxSchemeDTO partyTaxScheme = PartyTaxSchemeDTO.builder().build();
    @JsonProperty("PartyLegalEntity")
    private SupplierPartyLegalEntityDTO partyLegalEntity = SupplierPartyLegalEntityDTO.builder().build();
    @JsonProperty("Contact")
    private ContactDTO contact = ContactDTO.builder().build();
}
