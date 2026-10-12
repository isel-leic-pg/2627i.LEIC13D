# Aula 6 — Mutabilidade e ciclos

Exemplos para acompanhar a Aula 6: `val` vs `var`, operadores de afetação,
`while`, `do-while`, `for`, `break` e `return`.

| Ficheiro | Demonstra |
|---|---|
| `var_operadores.kt` | `val` vs `var`; `=`, `+=`, `-=`, `*=`, `/=`, `%=`, `++`, `--` |
| `ciclos_while.kt` | `while` e `do-while` (contar, somar até 0, validar uma leitura) |
| `ciclos_for.kt` | `for` sobre intervalos e texto, `downTo`, `step`, `break`, `return` |
| `palavras.kt` | Integrador: função + `do-while` + `for` (ler uma palavra e comparar letras) |
| `intervalo_que_muda.kt` | `var` que guarda um intervalo (`IntRange`) reafetado num `while`; descobrir um número em 0..15 |

## Como correr
Compilar com `kotlinc` e depois executar com `kotlin`. O nome da classe é o do
ficheiro com a **1.ª letra em maiúscula** e `Kt` no fim (sensível a maiúsculas):

```
kotlinc var_operadores.kt
kotlin Var_operadoresKt

kotlinc ciclos_while.kt
kotlin Ciclos_whileKt

kotlinc ciclos_for.kt
kotlin Ciclos_forKt

kotlinc palavras.kt
kotlin PalavrasKt

kotlinc intervalo_que_muda.kt
kotlin Intervalo_que_mudaKt
```

`ciclos_while.kt`, `palavras.kt` e `intervalo_que_muda.kt` pedem dados na consola: escrever cada resposta e carregar em Enter.
