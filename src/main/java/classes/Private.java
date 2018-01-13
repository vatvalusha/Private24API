package classes;

/**
 * Created by Valera on 11.01.2018.
 */


import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "currency",
        "base_ccy",
        "buy",
        "sale"
})
public class Private {

    @JsonProperty("ccy")
    private String currency;
    @JsonProperty("base_ccy")
    private String baseCurrency;
    @JsonProperty("buy")
    private String buy;
    @JsonProperty("sale")
    private String sale;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("currency")
    public String getCcy() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCcy(String currency) {
        this.currency = currency;
    }

    @JsonProperty("base_ccy")
    public String getBaseCcy() {
        return baseCurrency;
    }

    @JsonProperty("base_ccy")
    public void setBaseCcy(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    @JsonProperty("buy")
    public String getBuy() {
        return buy;
    }

    @JsonProperty("buy")
    public void setBuy(String buy) {
        this.buy = buy;
    }

    @JsonProperty("sale")
    public String getSale() {
        return sale;
    }

    @JsonProperty("sale")
    public void setSale(String sale) {
        this.sale = sale;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Private: {" +  "\n" +
                "   currency: '" + currency + '\'' +  "\n" +
                "   baseCurrency: '" + baseCurrency + '\'' +  "\n" +
                "   buy: " + buy + '\'' +  "\n" +
                "   sale: '" + sale + '\'' +  "\n" +
                "   additionalProperties: " + additionalProperties +  "\n" +
                '}';
    }
}