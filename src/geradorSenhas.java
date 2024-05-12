import java.util.Scanner;

public class geradorSenhas {
    public static void main(String[] args) {
        int tamanhoSenha;
        Scanner src = new Scanner(System.in);
        while (true) {
            System.out.println("Qual tamanho da senha que gostaria de gerar: ");
            tamanhoSenha = src.nextInt();
            src.nextLine();

            if (args.length > 0) {
                tamanhoSenha = Integer.parseInt(args[0]);
            }

            else if (tamanhoSenha <= 0) {
                System.out.println("Digite um tamanho válido!");
                System.out.println("Qual tamanho da senha que gostaria de gerar: ");
                tamanhoSenha = src.nextInt();
            }

            gerarSenha(tamanhoSenha);

            System.out.println("Deseja gerar outra senha? (S/N)");
            String resposta = src.next();

            if (resposta.equalsIgnoreCase("N")) {
                break;
            }
        }

        src.close();
    }

    private static void gerarSenha(int tamanhoSenha) {

        String[] letras = {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
                "V", "W", "X", "Y", "Z",
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
                "v", "w", "x", "y", "z"
        };
        String[] caracteresEspeciais = {
                "!", "@", "#", "$", "%", "^", "&", "*", "_", "=", "+", "?"
        };
        String[] numeros = {
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
        };

        int qtdLetras = letras.length;
        int qtdCaracteresEspeciais = caracteresEspeciais.length;
        int qtdNumeros = numeros.length;

        StringBuilder senha = new StringBuilder();

        for (int i = 0; i < tamanhoSenha; i++) {
            int randLetras = (int) (Math.random() * qtdLetras);
            int randCaracteresEspeciais = (int) (Math.random() * qtdCaracteresEspeciais);
            int randNumeros = (int) (Math.random() * qtdNumeros);

            senha.append(letras[randLetras]);
            senha.append(caracteresEspeciais[randCaracteresEspeciais]);
            senha.append(numeros[randNumeros]);
        }

        senha.setLength(tamanhoSenha);

        System.out.println("Senha Gerada: " + senha);
    }
}