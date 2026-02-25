# WS-Soap - Sistema de Consulta de Cliente (SOAP + Legacy JSP)

Projeto de estudo que simula um **sistema corporativo legado**, expondo um **Web Service SOAP (JAX-WS)** e ao mesmo tempo disponibilizando um **front-end JSP tradicional**, ambos compartilhando a mesma regra de negócio.

O objetivo é reproduzir um cenário muito comum em empresas: sistemas antigos convivendo com integrações SOAP externas.

---

## 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot 3
- JAX-WS (SOAP)
- JAXB
- JSP (Java Server Pages)
- Tomcat Embedded
- Maven
- Lombok

---

## 🧠 Arquitetura

O projeto foi estruturado para separar completamente:

- Regra de negócio
- Camada Web Legacy (JSP)
- Camada de Integração SOAP

```
                +------------------+
                |  ClienteService  |
                +------------------+
                         |
                 ClienteResultado
                  /            \
        JSP Controller       SOAP Endpoint
            (MVC)              (JAX-WS)
```

A mesma regra de negócio atende múltiplos canais de acesso.

---

## 📁 Estrutura de Packages

```
com.guibedan.ws.soap
│
├── config          # Configuração do SOAP endpoint
├── domain          # Objetos de domínio
├── entity          # Entidades simulando persistência
├── repository      # Repositórios
├── service         # Regras de negócio
├── exception       # Exceções do projeto
│
├── web
│   └── controller  # Controllers JSP (legacy MVC)
│
└── ws
    ├── contract    # Interface SOAP (SEI)
    ├── dto         # Request/Response SOAP
    └── endpoint    # Implementação do WebService
```

---

## 🌐 Funcionalidades

### ✅ Consulta de cliente por CPF

A consulta pode ser realizada através de:

- Interface Web JSP (sistema legado)
- Web Service SOAP

---

## 🖥️ Front Legacy (JSP)

Acesse no navegador:

```
http://localhost:8080/cliente
```

Fluxo:

1. Informar CPF
2. Buscar cliente
3. Exibir resultado ou página de erro

Este fluxo simula aplicações corporativas antigas baseadas em JSP.

---

## 🔗 Web Service SOAP

### Endpoint WSDL

```
http://localhost:8080/ws/cliente?wsdl
```

### Operação disponível

```
buscarCliente(cpf)
```

---

### Exemplo de Request SOAP

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ws="http://soap.seuprojeto.com/ws">
   <soapenv:Header/>
   <soapenv:Body>
      <ws:buscarClienteRequest>
         <cpf>12345678900</cpf>
      </ws:buscarClienteRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

---

## ⚠️ Tratamento de Erros

O projeto utiliza o padrão **Service Result Pattern**, evitando exceptions compartilhadas entre canais.

O serviço retorna:

```
ClienteResultado
```

Cada camada decide como tratar o erro:

| Camada | Comportamento |
|------|-------------|
| JSP | Redireciona para página de erro |
| SOAP | Retorna SOAP Fault |
| Service | Retorna resultado estruturado |

### Exemplo SOAP Fault

```xml
<S:Fault>
   <faultcode>S:Client</faultcode>
   <faultstring>Cliente não encontrado</faultstring>
</S:Fault>
```

---

## ▶️ Como executar

### 1️⃣ Clonar repositório

```bash
git clone https://github.com/seu-usuario/ws-soap.git
```

### 2️⃣ Executar aplicação

```bash
mvn spring-boot:run
```

ou executar pela IDE:

```
WsSoapApplication.java
```

---

## 🧪 Testando o SOAP

Ferramentas recomendadas:

- SoapUI
- Postman (modo SOAP)
- IntelliJ HTTP Client

WSDL:

```
http://localhost:8080/ws/cliente?wsdl
```

---

## 🎯 Objetivo do Projeto

Este projeto foi desenvolvido para estudo dos seguintes conceitos:

- Integração SOAP com Spring Boot
- Convivência com sistemas Legacy
- Separação de responsabilidades
- Reutilização de regras de negócio
- Tratamento de erro por protocolo
- Arquitetura backend corporativa

---

## 📚 Conceitos Aplicados

- Service Layer Pattern
- Result Pattern
- Separation of Concerns
- Legacy Integration
- Contract First SOAP Design

---

## 👨‍💻 Autor

Projeto desenvolvido para estudos de arquitetura backend Java e integrações corporativas.
