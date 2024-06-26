package alura.conversor.dados;

public enum MoedasNome {
    USD("Dolar"),
    BRL("Real"),
    EUR("Euro"),
    ARS("Peso");


    private String categoriaPortugues;

    MoedasNome(String categoriaPortugues){
        this.categoriaPortugues = categoriaPortugues;

    }


    public static MoedasNome fromPortugues(String text) {
        for (MoedasNome moedasnome : MoedasNome.values()) {
            if (moedasnome.categoriaPortugues.equalsIgnoreCase(text)) {
                return moedasnome;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }

}

