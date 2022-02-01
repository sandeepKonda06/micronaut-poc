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
@JsonPropertyOrder({"PaymentMeansCode", "PaymentID", "PayeeFinancialAccount"})
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@Builder
public class PaymentMeansDTO {
    @JsonProperty("PaymentMeansCode")
    private PaymentMeansCodeDTO paymentMeansCode = PaymentMeansCodeDTO.builder().build();
    @JsonProperty("PaymentID")
    private String paymentID;
    @JsonProperty("PayeeFinancialAccount")
    private PayeeFinancialAccountDTO payeeFinancialAccount = PayeeFinancialAccountDTO.builder().build();
}
