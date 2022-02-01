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
@JsonPropertyOrder({"ID", "Percent", "TaxScheme"})
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@Builder
public class ClassifiedTaxCategoryDTO {
    @JsonProperty("ID")
    private String id;
    @JsonProperty("Percent")
    private String percent;
    @JsonProperty("TaxScheme")
    private TaxSchemeDTO taxScheme = TaxSchemeDTO.builder().build();
}
