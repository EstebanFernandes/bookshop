package fr.univtours.polytech.bookshop.model.exchangerate;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import jakarta.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"result",
"documentation",
"terms_of_use",
"time_last_update_unix",
"time_last_update_utc",
"time_next_update_unix",
"time_next_update_utc",
"base_code",
"target_code",
"conversion_rate",
"conversion_result"
})
@Generated("jsonschema2pojo")
public class WsExchangeResult {

@JsonProperty("result")
private String result;
@JsonProperty("documentation")
private String documentation;
@JsonProperty("terms_of_use")
private String terms_of_use;
@JsonProperty("time_last_update_unix")
private Integer time_last_update_unix;
@JsonProperty("time_last_update_utc")
private String time_last_update_utc;
@JsonProperty("time_next_update_unix")
private Integer time_next_update_unix;
@JsonProperty("time_next_update_utc")
private String time_next_update_utc;
@JsonProperty("base_code")
private String base_code;
@JsonProperty("target_code")
private String target_code;
@JsonProperty("conversion_rate")
private Double conversion_rate;
@JsonProperty("conversion_result")
private Double conversion_result;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

@JsonProperty("result")
public String getResult() {
return result;
}

@JsonProperty("result")
public void setResult(String result) {
this.result = result;
}

@JsonProperty("documentation")
public String getDocumentation() {
return documentation;
}

@JsonProperty("documentation")
public void setDocumentation(String documentation) {
this.documentation = documentation;
}

@JsonProperty("terms_of_use")
public String getTerms_of_use() {
return terms_of_use;
}

@JsonProperty("terms_of_use")
public void setTerms_of_use(String terms_of_use) {
this.terms_of_use = terms_of_use;
}

@JsonProperty("time_last_update_unix")
public Integer getTime_last_update_unix() {
return time_last_update_unix;
}

@JsonProperty("time_last_update_unix")
public void setTime_last_update_unix(Integer time_last_update_unix) {
this.time_last_update_unix = time_last_update_unix;
}

@JsonProperty("time_last_update_utc")
public String getTime_last_update_utc() {
return time_last_update_utc;
}

@JsonProperty("time_last_update_utc")
public void setTime_last_update_utc(String time_last_update_utc) {
this.time_last_update_utc = time_last_update_utc;
}

@JsonProperty("time_next_update_unix")
public Integer getTime_next_update_unix() {
return time_next_update_unix;
}

@JsonProperty("time_next_update_unix")
public void setTime_next_update_unix(Integer time_next_update_unix) {
this.time_next_update_unix = time_next_update_unix;
}

@JsonProperty("time_next_update_utc")
public String getTime_next_update_utc() {
return time_next_update_utc;
}

@JsonProperty("time_next_update_utc")
public void setTime_next_update_utc(String time_next_update_utc) {
this.time_next_update_utc = time_next_update_utc;
}

@JsonProperty("base_code")
public String getBase_code() {
return base_code;
}

@JsonProperty("base_code")
public void setBase_code(String base_code) {
this.base_code = base_code;
}

@JsonProperty("target_code")
public String getTarget_code() {
return target_code;
}

@JsonProperty("target_code")
public void setTarget_code(String target_code) {
this.target_code = target_code;
}

@JsonProperty("conversion_rate")
public Double getConversion_rate() {
return conversion_rate;
}

@JsonProperty("conversion_rate")
public void setConversion_rate(Double conversion_rate) {
this.conversion_rate = conversion_rate;
}

@JsonProperty("conversion_result")
public Double getConversion_result() {
return conversion_result;
}

@JsonProperty("conversion_result")
public void setConversion_result(Double conversion_result) {
this.conversion_result = conversion_result;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}