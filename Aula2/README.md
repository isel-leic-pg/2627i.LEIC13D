# Aula 2 — Tipos e valores

Exemplos para acompanhar a Aula 2: inteiros, bases, literais, aritmética e reais.

| Ficheiro | Demonstra |
|---|---|
| `inteiros.kt` | `val`, aritmética, divisão inteira (`/`, `%`) e prioridades |
| `bases.kt` | Literais `0x`/`0b`, separador `_`, `toString(base)` |
| `reais.kt` | `Double`, divisão real vs inteira, precisão IEEE 754, conversões |

## Como correr
Compilar com `kotlinc` e depois executar com `kotlin`. O nome da classe é o do
ficheiro com a **1.ª letra em maiúscula** e `Kt` no fim (sensível a maiúsculas):

```
kotlinc inteiros.kt
kotlin InteirosKt

kotlinc bases.kt
kotlin BasesKt

kotlinc reais.kt
kotlin ReaisKt
```