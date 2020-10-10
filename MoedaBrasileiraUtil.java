package com.example.delivers;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import br.com.alura.aluraviagens.model.Pacote;

    // Recebe um valor BigDecimal e formata para a moeda brasileira;
public class MoedaUtil {
    public static String formataParaBrasileiro(BigDecimal valor) {

        NumberFormat formatoBrasileito = DecimalFormat.getCurrencyInstance(
                new Locale("pt", "br"));
        return formatoBrasileito.format(valor).replace("R$", "R$ ");
    }
}