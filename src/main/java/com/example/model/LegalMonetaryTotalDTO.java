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
@JsonPropertyOrder({"LineExtensionAmount", "TaxExclusiveAmount", "TaxInclusiveAmount", "ChargeTotalAmount", "PayableAmount"})
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@Builder
public class LegalMonetaryTotalDTO {
    @JsonProperty("LineExtensionAmount")
    private LineExtensionAmountDTO lineExtensionAmount = LineExtensionAmountDTO.builder().build();
    @JsonProperty("TaxExclusiveAmount")
    private TaxExclusiveAmountDTO taxExclusiveAmount = TaxExclusiveAmountDTO.builder().build();
    @JsonProperty("TaxInclusiveAmount")
    private TaxInclusiveAmountDTO taxInclusiveAmount = TaxInclusiveAmountDTO.builder().build();
    @JsonProperty("ChargeTotalAmount")
    private ChargeTotalAmountDTO chargeTotalAmount = ChargeTotalAmountDTO.builder().build();
    @JsonProperty("PayableAmount")
    private PayableAmountDTO payableAmount = PayableAmountDTO.builder().build();
}
