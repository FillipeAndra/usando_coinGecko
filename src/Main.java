import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitor = new Scanner(System.in);
        System.out.printf("Digite o nome da criptomoeda para ver o valor em reais: ");
        var moeda = leitor.nextLine();
        var pesquisa = "https://api.coingecko.com/api/v3/simple/price?ids="
                +moeda+"&vs_currencies=brl&x_cg_demo_api_key=CG-RYGDsiq1dVT281QTgAX6mqJj";

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(pesquisa)).build();
        HttpResponse<String> resposta = cliente.send(requisicao,
        HttpResponse.BodyHandlers.ofString());
        System.out.println(resposta.body());
    }
}