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
@JsonPropertyOrder({"TaxableAmount", "TaxAmount", "TaxCategory"})
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@Builder
public class TaxSubtotalDTO {
    @JsonProperty("TaxableAmount")
    private TaxableAmountDTO taxableAmount = TaxableAmountDTO.builder().build();
    @JsonProperty("TaxAmount")
    private TaxAmountDTO taxAmount = TaxAmountDTO.builder().build();
    @JsonProperty("TaxCategory")
    private TaxCategoryDTO taxCategory = TaxCategoryDTO.builder().build();
}
