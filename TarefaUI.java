package ui;

import model.Tarefa;
import service.TarefaService;
import java.util.Scanner;

public class TarefaUI {
    private TarefaService service;
    private Scanner scanner;

    public TarefaUI() {
        this.service = new TarefaService();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("\n==== Board de Tarefas ====");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Concluir Tarefa");
            System.out.println("4. Remover Tarefa");
            System.out.println("5. Editar Tarefa");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    adicionarTarefa();
                    break;
                case 2:
                    listarTarefas();
                    break;
                case 3:
                    concluirTarefa();
                    break;
                case 4:
                    removerTarefa();
                    break;
                case 5:
                    editarTarefa();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private void adicionarTarefa() {
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();
        Tarefa tarefa = service.adicionarTarefa(descricao);
        System.out.println("Tarefa adicionada: " + tarefa);
    }

    private void listarTarefas() {
        System.out.println("\n==== Lista de Tarefas ====");
        for (Tarefa tarefa : service.listarTarefas()) {
            System.out.println(tarefa);
        }
    }

    private void concluirTarefa() {
        System.out.print("Digite o ID da tarefa a concluir: ");
        int id = scanner.nextInt();
        if (service.concluirTarefa(id)) {
            System.out.println("Tarefa concluída com sucesso!");
        } else {
            System.out.println("Tarefa não encontrada!");
        }
    }

    private void removerTarefa() {
        System.out.print("Digite o ID da tarefa a remover: ");
        int id = scanner.nextInt();
        if (service.removerTarefa(id)) {
            System.out.println("Tarefa removida com sucesso!");
        } else {
            System.out.println("Tarefa não encontrada!");
        }
    }

    private void editarTarefa() {
        System.out.print("Digite o ID da tarefa a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha
        System.out.print("Digite a nova descrição: ");
        String novaDescricao = scanner.nextLine();
        if (service.editarTarefa(id, novaDescricao)) {
            System.out.println("Tarefa editada com sucesso!");
        } else {
            System.out.println("Tarefa não encontrada!");
        }
    }
}
