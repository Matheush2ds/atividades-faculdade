# Cohen-Sutherland

Este é um projeto Java que implementa o algoritmo de recorte Cohen-Sutherland. O algoritmo é utilizado para recortar linhas em uma janela de visualização definida por coordenadas retangulares.

## Estrutura do Projeto

O projeto é dividido em classes que representam pontos, linhas e a implementação do algoritmo Cohen-Sutherland. Além disso, há uma classe para a interface gráfica usando Swing.

- `Ponto`: Representa um ponto no plano cartesiano.
- `Linha`: Representa uma linha definida por dois pontos.
- `CohenSutherland`: Implementa o algoritmo de recorte.
- `InterfaceGrafica`: Interface gráfica para interação com o usuário.

## Como Executar

Para executar o projeto, você pode usar a classe `InterfaceGrafica` que oferece uma interface gráfica simples para inserção de dados e visualização do resultado.

Certifique-se de ter o ambiente de execução Java configurado.

```bash
# Compile o projeto
javac CohenSutherland.java InterfaceGrafica.java

# Execute a interface gráfica
java InterfaceGrafica
