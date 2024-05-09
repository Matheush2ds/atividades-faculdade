# Gerenciador de Contatos

Este é um aplicativo simples de gerenciamento de contatos, desenvolvido como parte de um trabalho da disciplina de Estrutura de Dados 2 do Curos de Ciências da Computação. O projeto utiliza uma Árvore AVL para organizar os contatos de forma eficiente e oferece métodos de ordenação para aprimorar a flexibilidade na manipulação dos dados.

## Abra a Pasta SRC

O código esta disponível na pasta src

## Uso da Árvore AVL

A Árvore AVL, uma estrutura de dados de árvore binária balanceada, desempenha um papel crucial na organização dos contatos. Ela garante que os elementos sejam mantidos em ordem alfabética, facilitando a busca e exibição de informações.

### Principais Métodos da Árvore AVL

- **insert(Node node, Contato contact):** Insere um novo contato na árvore, mantendo o balanceamento.
- **inOrderTraversal(Node node, StringBuilder result):** Percorre a árvore em ordem, construindo uma representação dos contatos ordenados.
- **searchContactInTree(Node no, String nome):** Realiza uma busca por um contato na árvore com base no nome.
- **loadFromFile(String fileName):** Carrega uma instância da Árvore AVL a partir de um arquivo.
- **saveToFile(String fileName):** Salva a Árvore AVL atual em um arquivo.

## Métodos de Ordenação

Além da Árvore AVL, a aplicação oferece métodos de ordenação que operam sobre uma lista de contatos antes de reconstruir a Árvore AVL. Atualmente, dois métodos de ordenação estão disponíveis:

1. **Merge Sort (`mergeSortContacts`):** Utiliza o algoritmo Merge Sort para ordenar a lista de contatos.
2. **Quick Sort (`quickSortContacts`):** Utiliza o algoritmo Quick Sort para ordenar a lista de contatos.

Esses métodos proporcionam flexibilidade na escolha do algoritmo de ordenação, permitindo adaptações conforme necessário.
