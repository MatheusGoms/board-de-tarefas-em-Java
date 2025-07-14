package repository;

import model.Tarefa;
import java.util.ArrayList;
import java.util.List;

public class TarefaRepository {
    private List<Tarefa> tarefas = new ArrayList<>();
    private int contadorId = 1;

    public Tarefa adicionarTarefa(String descricao) {
        Tarefa tarefa = new Tarefa(contadorId++, descricao);
        tarefas.add(tarefa);
        return tarefa;
    }

    public List<Tarefa> listarTarefas() {
        return tarefas;
    }

    public Tarefa buscarPorId(int id) {
        return tarefas.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    public boolean removerTarefa(int id) {
        return tarefas.removeIf(t -> t.getId() == id);
    }
}
