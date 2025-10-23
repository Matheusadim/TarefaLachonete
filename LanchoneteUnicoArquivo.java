import java.util.LinkedList; // Import necessário para a Parte 2

/**
 * CLASSE PÚBLICA PRINCIPAL
 * Contém o método main() para executar os testes de ambas as implementações.
 * O nome do arquivo DEVE ser LanchoneteUnicoArquivo.java
 */
public class LanchoneteUnicoArquivo {

    public static void main(String[] args) {
        
        // --- Teste Parte 1: Implementação "do Zero" (Manual) ---
        
        System.out.println("==================================================");
        System.out.println(" INICIANDO TESTE - PARTE 1: IMPLEMENTAÇÃO MANUAL");
        System.out.println("==================================================");
        
        // Instancia a lista manual
        ListaPedidos filaManual = new ListaPedidos();

        System.out.println("\nAdicionando pedidos NORMAIS (Fila FIFO)...");
        // id, nome, item, qtd, valorBase, tipo
        filaManual.adicionarPedido(101, "Ana", "X-Burger", 1, 20.0, TipoPedido.NORMAL);
        filaManual.adicionarPedido(102, "Bruno", "Suco", 2, 7.0, TipoPedido.NORMAL);
        filaManual.imprimirLista();

        System.out.println("\nChegou um pedido URGENTE (Pilha LIFO)...");
        filaManual.adicionarPedido(103, "Carla", "Açaí", 1, 18.0, TipoPedido.URGENTE);
        filaManual.imprimirLista(); // Carla (103) deve ser a primeira

        System.out.println("\nChegou outro URGENTE!");
        filaManual.adicionarPedido(104, "Daniel", "Refrigerante", 1, 5.0, TipoPedido.URGENTE);
        filaManual.imprimirLista(); // Daniel (104) deve ser o primeiro

        System.out.println("\nChegou um pedido PRIORITÁRIO (Inserir Meio)...");
        // Lista atual: 104, 103, 101, 102 (Tamanho 4)
        // Posição mediana (m = 4 / 2 = 2). Deve entrar no índice 2.
        filaManual.adicionarPedido(105, "Elisa", "Batata Frita", 1, 12.0, TipoPedido.PRIORITARIO);
        filaManual.imprimirLista(); // Ordem esperada: 104, 103, 105, 101, 102
        
        System.out.println("\n--- Testando Remoções (Manual) ---");
        System.out.println("\nAtendendo pedido (removerInicio)...");
        Pedido atendidoManual = filaManual.removerInicio();
        System.out.println("Atendido: " + atendidoManual.getNome_cliente());
        filaManual.imprimirLista();

        System.out.println("\nCancelando último pedido (removerFim)...");
        Pedido canceladoFimManual = filaManual.removerFim();
        System.out.println("Cancelado: " + canceladoFimManual.getNome_cliente());
        filaManual.imprimirLista();
        
        System.out.println("\nCancelamento específico (removerPosicaoK k=1)...");
        Pedido canceladoKManual = filaManual.removerPosicaoK(1); // Remove o pedido de Elisa (105)
        System.out.println("Cancelado: " + canceladoKManual.getNome_cliente());
        filaManual.imprimirLista();


        // --- Teste Parte 2: Implementação com Funções Específicas do JAVA ---
        
        System.out.println("\n\n==================================================");
        System.out.println(" INICIANDO TESTE - PARTE 2: IMPLEMENTAÇÃO JAVA (LinkedList)");
        System.out.println("==================================================");
        
        // Instancia a lista do Java
        GerenciadorPedidosJavaUtil filaJava = new GerenciadorPedidosJavaUtil();

        System.out.println("\nAdicionando pedidos NORMAIS (Fila FIFO)...");
        // id, nome, item, qtd, valorBase, tipo
        filaJava.adicionarPedido(101, "Ana", "X-Burger", 1, 20.0, TipoPedido.NORMAL);
        filaJava.adicionarPedido(102, "Bruno", "Suco", 2, 7.0, TipoPedido.NORMAL);
        filaJava.imprimirLista();

        System.out.println("\nChegou um pedido URGENTE (Pilha LIFO)...");
        filaJava.adicionarPedido(103, "Carla", "Açaí", 1, 18.0, TipoPedido.URGENTE);
        filaJava.imprimirLista(); 

        System.out.println("\nChegou outro URGENTE!");
        filaJava.adicionarPedido(104, "Daniel", "Refrigerante", 1, 5.0, TipoPedido.URGENTE);
        filaJava.imprimirLista(); 

        System.out.println("\nChegou um pedido PRIORITÁRIO (Inserir Meio)...");
        filaJava.adicionarPedido(105, "Elisa", "Batata Frita", 1, 12.0, TipoPedido.PRIORITARIO);
        filaJava.imprimirLista(); // Ordem esperada: 104, 103, 105, 101, 102

        System.out.println("\n--- Testando Remoções (Java Util) ---");
        System.out.println("\nAtendendo pedido (removerInicio)...");
        Pedido atendidoJava = filaJava.removerInicio();
        System.out.println("Atendido: " + atendidoJava.getNome_cliente());
        filaJava.imprimirLista();

        System.out.println("\nCancelando último pedido (removerFim)...");
        Pedido canceladoFimJava = filaJava.removerFim();
        System.out.println("Cancelado: " + canceladoFimJava.getNome_cliente());
        filaJava.imprimirLista();
        
        System.out.println("\nCancelamento específico (removerPosicaoK k=1)...");
        Pedido canceladoKJava = filaJava.removerPosicaoK(1);
        System.out.println("Cancelado (k=1): " + canceladoKJava.getNome_cliente());
        filaJava.imprimirLista();
    }
}

// =====================================================================
// DEMAIS CLASSES E ENUMS (sem a palavra 'public')
// =====================================================================

/**
 * Enum para os tipos de pedido.
 * (Removido 'public' para poder ficar no mesmo arquivo)
 */
enum TipoPedido {
    NORMAL,
    PRIORITARIO,
    URGENTE
}

/**
 * Classe que armazena os dados (o "Objeto" ou "DATA").
 * (Removido 'public' para poder ficar no mesmo arquivo)
 */
class Pedido {
    private int id_pedido;
    private String nome_cliente;
    private String item;
    private int quantidade;
    private double valor;
    private TipoPedido tipo;

    // Construtor que aplica as regras de negócio do exercício
    public Pedido(int id_pedido, String nome_cliente, String item, int quantidade, double valorBase, TipoPedido tipo) {
        this.id_pedido = id_pedido;
        this.nome_cliente = nome_cliente;
        this.item = item;
        this.quantidade = quantidade;
        this.tipo = tipo;

        // Aplica o acréscimo de valor conforme o tipo
        switch (tipo) {
            case URGENTE:
                this.valor = valorBase * 1.20; // Regra: +20%
                break;
            case PRIORITARIO:
                this.valor = valorBase * 1.10; // Regra: +10%
                break;
            case NORMAL:
            default:
                this.valor = valorBase;
                break;
        }
    }

    // Getters
    public int getId_pedido() {
        return id_pedido;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    @Override
    public String toString() {
        return "Pedido #" + id_pedido +
                " (" + tipo + ")" +
                " | Cliente: " + nome_cliente +
                " | Item: " + item + " (x" + quantidade + ")" +
                " | Valor: R$" + String.format("%.2f", valor);
    }
}

/**
 * Nó (Célula) da Lista Encadeada para a Parte 1.
 * (Removido 'public' para poder ficar no mesmo arquivo)
 */
class No {
    Pedido pedido; // O dado
    No proximo;    // A referência (ponteiro)

    public No(Pedido pedido) {
        this.pedido = pedido;
        this.proximo = null; 
    }
}

/**
 * PARTE 1: Implementação "do Zero" (Manual)
 * (Removido 'public' para poder ficar no mesmo arquivo)
 */
class ListaPedidos {
    
    private No cabeca; // Primeiro elemento
    private No cauda;  // Último elemento
    private int tamanho;

    // Construtor
    public ListaPedidos() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
    }

    // --- 5. Funções Utilitárias ---

    public int tamanho() {
        return this.tamanho;
    }

    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    public Pedido obterCabeca() {
        if (estaVazia()) return null;
        return cabeca.pedido;
    }

    public Pedido obterCauda() {
        if (estaVazia()) return null;
        return cauda.pedido;
    }

    // --- 3. Função de Busca ---
    
    public Pedido buscarPorId(int id) {
        No atual = cabeca;
        while (atual != null) {
            if (atual.pedido.getId_pedido() == id) {
                return atual.pedido; // Encontrou
            }
            atual = atual.proximo;
        }
        return null; // Não encontrou
    }

    public Pedido buscarPorPosicao(int k) {
        if (k < 0 || k >= tamanho) {
            System.out.println("Erro: Posição inválida.");
            return null;
        }
        
        No atual = cabeca;
        for (int i = 0; i < k; i++) {
            atual = atual.proximo;
        }
        return atual.pedido;
    }

    // --- 1. Funções de Inserção (Tarefa 1) ---

    public void adicionarPedido(int id, String nome, String item, int qtd, double valorBase, TipoPedido tipo) {
        if (buscarPorId(id) != null) {
            System.out.println("Erro: Pedido com ID " + id + " já existe. Pedido rejeitado.");
            return;
        }

        Pedido novoPedido = new Pedido(id, nome, item, qtd, valorBase, tipo);

        switch (tipo) {
            case URGENTE:
                inserirInicio(novoPedido); 
                break;
            case PRIORITARIO:
                inserirMeio(novoPedido); 
                break;
            case NORMAL:
            default:
                inserirFim(novoPedido); 
                break;
        }
    }

    // (Urgente)
    private void inserirInicio(Pedido pedido) {
        No novoNo = new No(pedido);
        if (estaVazia()) {
            cabeca = novoNo;
            cauda = novoNo;
        } else {
            novoNo.proximo = this.cabeca;
            this.cabeca = novoNo;
        }
        this.tamanho++;
    }

    // (Normal)
    private void inserirFim(Pedido pedido) {
        No novoNo = new No(pedido);
        if (estaVazia()) {
            cabeca = novoNo;
            cauda = novoNo;
        } else {
            this.cauda.proximo = novoNo;
            this.cauda = novoNo;
        }
        this.tamanho++;
    }

    // (Prioritário)
    private void inserirMeio(Pedido pedido) {
        int m = this.tamanho / 2;

        if (m == 0) {
            inserirInicio(pedido);
            return;
        }

        No novoNo = new No(pedido);
        No atual = this.cabeca;
        for (int i = 0; i < m - 1; i++) {
            atual = atual.proximo;
        }

        novoNo.proximo = atual.proximo;
        atual.proximo = novoNo;
        this.tamanho++;
    }

    // --- 2. Funções de Remoção (Tarefa 2) ---

    // (Pedido Atendido)
    public Pedido removerInicio() {
        if (estaVazia()) {
            System.out.println("Erro: A lista de pedidos está vazia.");
            return null;
        }

        Pedido pedidoRemovido = this.cabeca.pedido;
        this.cabeca = this.cabeca.proximo;
        this.tamanho--;

        if (estaVazia()) {
            this.cauda = null;
        }
        return pedidoRemovido;
    }

    // (Cancelamento)
    public Pedido removerFim() {
        if (estaVazia()) {
            System.out.println("Erro: A lista de pedidos está vazia.");
            return null;
        }
        
        if (this.tamanho == 1) {
            return removerInicio();
        }

        No atual = this.cabeca;
        while (atual.proximo != this.cauda) {
            atual = atual.proximo;
        }

        Pedido pedidoRemovido = this.cauda.pedido;
        this.cauda = atual;
        this.cauda.proximo = null;
        this.tamanho--;
        
        return pedidoRemovido;
    }

    // (Cancelamento Específico)
    public Pedido removerPosicaoK(int k) {
        if (k < 0 || k >= this.tamanho) {
            System.out.println("Erro: Posição inválida.");
            return null;
        }

        if (k == 0) {
            return removerInicio();
        }
        
        if (k == this.tamanho - 1) {
            return removerFim();
        }

        No anterior = this.cabeca;
        for (int i = 0; i < k - 1; i++) {
            anterior = anterior.proximo;
        }
        
        No noParaRemover = anterior.proximo;
        Pedido pedidoRemovido = noParaRemover.pedido;
        
        anterior.proximo = noParaRemover.proximo; // Pula o nó
        this.tamanho--;

        return pedidoRemovido;
    }

    // --- 4. Função de Impressão (Tarefa 4) ---

    public void imprimirLista() {
        if (estaVazia()) {
            System.out.println("--- Lista de Pedidos Vazia ---");
            return;
        }
        
        System.out.println("--- Fila de Pedidos (Tamanho: " + this.tamanho + ") ---");
        No atual = this.cabeca;
        int i = 0;
        while (atual != null) {
            System.out.println(i + ": " + atual.pedido);
            atual = atual.proximo;
            i++;
        }
        System.out.println("-------------------------------------");
    }
}


/**
 * PARTE 2: Implementação com Funções Específicas do JAVA
 * (Removido 'public' para poder ficar no mesmo arquivo)
 */
class GerenciadorPedidosJavaUtil {

    private LinkedList<Pedido> listaDePedidos;

    public GerenciadorPedidosJavaUtil() {
        this.listaDePedidos = new LinkedList<>();
    }

    // --- 5. Funções Utilitárias ---
    public boolean estaVazia() {
        return listaDePedidos.isEmpty();
    }

    public int tamanho() {
        return listaDePedidos.size();
    }

    public Pedido obterCabeca() {
        if (estaVazia()) return null;
        return listaDePedidos.getFirst();
    }

    public Pedido obterCauda() {
        if (estaVazia()) return null;
        return listaDePedidos.getLast();
    }

    // --- 3. Funções de Busca ---
    public Pedido buscarPorId(int id) {
        for (Pedido p : listaDePedidos) {
            if (p.getId_pedido() == id) {
                return p;
            }
        }
        return null;
    }
    
    public Pedido buscarPorPosicao(int k) {
        if (k < 0 || k >= tamanho()) {
             System.out.println("Erro: Posição inválida.");
            return null;
        }
        return listaDePedidos.get(k);
    }

    // --- 1. Funções de Inserção (Tarefa 1) ---
    public void adicionarPedido(int id, String nome, String item, int qtd, double valorBase, TipoPedido tipo) {
        if (buscarPorId(id) != null) {
            System.out.println("Erro: Pedido com ID " + id + " já existe. Pedido rejeitado.");
            return;
        }

        Pedido novoPedido = new Pedido(id, nome, item, qtd, valorBase, tipo);

        switch (tipo) {
            case URGENTE:
                listaDePedidos.addFirst(novoPedido); // Insere no início
                break;
            case PRIORITARIO:
                int m = listaDePedidos.size() / 2;
                listaDePedidos.add(m, novoPedido); // Insere na posição 'm'
                break;
            case NORMAL:
            default:
                listaDePedidos.addLast(novoPedido); // Insere no fim
                break;
        }
    }

    // --- 2. Funções de Remoção (Tarefa 2) ---
    
    // (Pedido Atendido)
    public Pedido removerInicio() {
        if (estaVazia()) {
            System.out.println("Erro: A lista de pedidos está vazia.");
            return null;
        }
        return listaDePedidos.removeFirst();
    }

    // (Cancelamento)
    public Pedido removerFim() {
        if (estaVazia()) {
            System.out.println("Erro: A lista de pedidos está vazia.");
            return null;
        }
        return listaDePedidos.removeLast();
    }

    // (Cancelamento Específico)
    public Pedido removerPosicaoK(int k) {
         if (k < 0 || k >= tamanho()) {
             System.out.println("Erro: Posição inválida.");
            return null;
        }
        return listaDePedidos.remove(k);
    }

    // --- 4. Função de Impressão (Tarefa 4) ---
    public void imprimirLista() {
        if (estaVazia()) {
            System.out.println("--- Lista de Pedidos Vazia ---");
            return;
        }
        
        System.out.println("--- Fila de Pedidos (Tamanho: " + tamanho() + ") ---");
        int i = 0;
        for (Pedido p : listaDePedidos) {
            System.out.println(i + ": " + p);
            i++;
        }
        System.out.println("-------------------------------------");
    }
}