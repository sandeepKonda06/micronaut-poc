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
@JsonPropertyOrder({"Description", "Name", "StandardItemIdentification", "OriginCountry", "CommodityClassification", "ClassifiedTaxCategory"})
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@Builder
public class ItemDTO {
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("StandardItemIdentification")
    private StandardItemIdentificationDTO standardItemIdentification = StandardItemIdentificationDTO.builder().build();
    @JsonProperty("OriginCountry")
    private OriginCountryDTO originCountry = OriginCountryDTO.builder().build();
    @JsonProperty("CommodityClassification")
    private CommodityClassificationDTO commodityClassification = CommodityClassificationDTO.builder().build();
    @JsonProperty("ClassifiedTaxCategory")
    private ClassifiedTaxCategoryDTO classifiedTaxCategory = ClassifiedTaxCategoryDTO.builder().build();
}
