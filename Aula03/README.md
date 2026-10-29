# Aula 3 — Texto, lógica e I/O

Exemplos para acompanhar a Aula 3: texto, valores lógicos, intervalos e leitura/escrita.

| Ficheiro | Demonstra |
|---|---|
| `texto.kt` | `String`, templates `$`, operações de texto, `Char`, raw strings |
| `logica.kt` | `Boolean`, `&&` `\|\|` `!`, comparações e `in` |
| `io.kt` | `readln()` + `toInt()`/`toDouble()` com templates |

## Como correr
Compilar com `kotlinc` e depois executar com `kotlin`. O nome da classe é o do
ficheiro com a **1.ª letra em maiúscula** e `Kt` no fim (sensível a maiúsculas):

```
kotlinc texto.kt
kotlin TextoKt

kotlinc logica.kt
kotlin LogicaKt

kotlinc io.kt
kotlin IoKt
```

O `io.kt` pede dados na consola: escrever cada resposta e carregar em Enter.