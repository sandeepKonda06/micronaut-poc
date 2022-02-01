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
@JsonPropertyOrder({"ID", "InvoicedQuantity", "LineExtensionAmount", "AccountingCost", "OrderLineReference", "Item", "Price"})
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@Builder
public class InvoiceLineDTO {
    @JsonProperty("ID")
    private String id;
    @JsonProperty("InvoicedQuantity")
    private InvoicedQuantityDTO invoicedQuantity = InvoicedQuantityDTO.builder().build();
    @JsonProperty("LineExtensionAmount")
    private LineExtensionAmountDTO lineExtensionAmount = LineExtensionAmountDTO.builder().build();
    @JsonProperty("AccountingCost")
    private String accountingCost;
    @JsonProperty("OrderLineReference")
    private OrderLineReferenceDTO orderLineReference = OrderLineReferenceDTO.builder().build();
    @JsonProperty("Item")
    private ItemDTO item = ItemDTO.builder().build();
    @JsonProperty("Price")
    private PriceDTO price = PriceDTO.builder().build();
}
