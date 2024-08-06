# Sistema de Gestão de Pacientes e Consultas

## Enunciado

- **Disponibilidade**: Simplificar e centralizar a definição de consultas frequentes, evitando erros e melhorando a produtividade;
- **Confidencialidade**: Restringir acesso somente a projeções e/ou seleções de tabelas reais;
- **Integridade**: Evitar alterações indevidas no BD.

Crie um Banco de Dados com 2 tabelas (paciente e consulta). Crie 2 visões, explorando os conceitos vistos na aula de hoje, ou seja, uma visão virtual e uma materializada.

Para isso, insira vários dados nas tabelas.

## Estrutura do Banco de Dados

### Tabelas

#### Paciente

Tabela que armazena informações dos pacientes.

| Campo             | Tipo          | Descrição                        |
|-------------------|---------------|----------------------------------|
| `id`              | INT           | Chave primária, auto incremento  |
| `nome`            | VARCHAR(100)  | Nome do paciente                 |
| `data_nascimento` | DATE          | Data de nascimento do paciente   |
| `endereco`        | VARCHAR(255)  | Endereço do paciente             |
| `telefone`        | VARCHAR(15)   | Telefone do paciente             |

#### Consulta

Tabela que armazena informações das consultas realizadas.

| Campo           | Tipo          | Descrição                                |
|-----------------|---------------|------------------------------------------|
| `id`            | INT           | Chave primária, auto incremento          |
| `paciente_id`   | INT           | Chave estrangeira referenciando `paciente(id)` |
| `data_consulta` | DATE          | Data da consulta                         |
| `descricao`     | TEXT          | Descrição da consulta                    |

### Inserção de Dados

Foram inseridos alguns dados de exemplo nas tabelas `paciente` e `consulta` para demonstrar o funcionamento do sistema.
