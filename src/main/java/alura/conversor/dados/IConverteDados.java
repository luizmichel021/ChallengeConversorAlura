package alura.conversor.dados;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}