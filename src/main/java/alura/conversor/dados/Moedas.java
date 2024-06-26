package alura.conversor.dados;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record Moedas (double conversion_rate){
}
