import java.util.Scanner; // Importa a classe Scanner para capturar dados do usuário.

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o objeto Scanner para ler entradas do teclado.
        char[][] sala = new char[5][5]; // Matriz 5x5 que representa os assentos da sala ('L' = livre, 'R' = reservado).

        inicializarSala(sala); // Preenche a matriz com 'L' (livre).

        int opcao;
        do {
            // Menu de opções para o usuário.
            System.out.println("\n--- Menu ---");
            System.out.println("1. Exibir mapa da sala");
            System.out.println("2. Reservar assento");
            System.out.println("3. Cancelar reserva");
            System.out.println("4. Mostrar assentos disponíveis");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt(); // Lê a opção escolhida pelo usuário.

            switch (opcao) {
                case 1:
                    exibirSala(sala); // Exibe o mapa da sala.
                    break;
                case 2:
                    reservarAssento(sala, scanner); // Permite reservar um assento.
                    break;
                case 3:
                    cancelarReserva(sala, scanner); // Permite cancelar uma reserva.
                    break;
                case 4:
                    mostrarAssentosDisponiveis(sala); // Exibe o número de assentos disponíveis.
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close(); // Fecha o objeto Scanner.
    }

    // Função para inicializar a matriz com 'L' (livre).
    public static void inicializarSala(char[][] sala) {
        for (int i = 0; i < sala.length; i++) { // Percorre as fileiras.
            for (int j = 0; j < sala[i].length; j++) { // Percorre os assentos em cada fileira.
                sala[i][j] = 'L'; // Marca todos os assentos como livres.
            }
        }
    }

    // Função para exibir o mapa atual da sala.
    public static void exibirSala(char[][] sala) {
        System.out.println("\nMapa da Sala:");
        System.out.println("  0 1 2 3 4"); // Mostra os números das colunas.
        for (int i = 0; i < sala.length; i++) {
            System.out.print(i + " "); // Mostra o número da fileira.
            for (int j = 0; j < sala[i].length; j++) {
                System.out.print(sala[i][j] + " "); // Exibe o estado de cada assento.
            }
            System.out.println(); // Pula para a próxima linha (próxima fileira).
        }
    }

    // Função para reservar um assento.
    public static void reservarAssento(char[][] sala, Scanner scanner) {
        System.out.print("Digite o número da fileira (0-4): ");
        int fileira = scanner.nextInt(); // Lê o número da fileira.
        System.out.print("Digite o número do assento (0-4): ");
        int assento = scanner.nextInt(); // Lê o número do assento.

        // Verifica se o assento está disponível.
        if (sala[fileira][assento] == 'L') {
            sala[fileira][assento] = 'R'; // Reserva o assento (marca como 'R').
            System.out.println("Assento reservado com sucesso!");
        } else {
            System.out.println("Assento já está reservado!");
        }
    }

    // Função para cancelar uma reserva.
    public static void cancelarReserva(char[][] sala, Scanner scanner) {
        System.out.print("Digite o número da fileira (0-4): ");
        int fileira = scanner.nextInt(); // Lê o número da fileira.
        System.out.print("Digite o número do assento (0-4): ");
        int assento = scanner.nextInt(); // Lê o número do assento.

        // Verifica se o assento está reservado.
        if (sala[fileira][assento] == 'R') {
            sala[fileira][assento] = 'L'; // Cancela a reserva (marca como 'L').
            System.out.println("Reserva cancelada com sucesso!");
        } else {
            System.out.println("Assento já está livre!");
        }
    }

    // Função para mostrar o número total de assentos disponíveis.
    public static void mostrarAssentosDisponiveis(char[][] sala) {
        int disponiveis = 0; // Contador de assentos livres.
        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < sala[i].length; j++) {
                if (sala[i][j] == 'L') { // Se o assento está livre, incrementa o contador.
                    disponiveis++;
                }
            }
        }
        System.out.println("Total de assentos disponíveis: " + disponiveis);
    }
}
