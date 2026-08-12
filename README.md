# 🤖 Android AI Developer Assistant

An AI-powered Android Developer Assistant built with **Kotlin, Jetpack Compose, MVVM, Clean Architecture, Gemini, Retrieval-Augmented Generation (RAG), and Model Context Protocol (MCP)**.

The project is designed as a practical demonstration of how a modern Android application can integrate **LLMs, semantic retrieval, embeddings, and external AI tools** while maintaining a scalable and testable architecture.

---

## 🚀 Project Overview

**Android AI Developer Assistant** is a personal AI project focused on exploring modern AI application architecture on Android.

Instead of implementing only a traditional chatbot, the project progressively introduces:

* Modern Android UI with Jetpack Compose
* MVVM architecture
* Clean Architecture
* Kotlin Coroutines
* StateFlow
* Gemini API integration
* Retrieval-Augmented Generation (RAG)
* Text embeddings
* Semantic similarity search
* Context-grounded responses
* Model Context Protocol (MCP)
* MCP client/server communication
* AI tool integration
* AI agent workflows

The ultimate goal is to build an Android-based AI assistant that can answer questions using a private knowledge base and dynamically interact with external tools through MCP.

---

# 🎯 Project Goals

The main objectives of this project are:

1. Build a production-style Android AI application.
2. Demonstrate modern Android architecture.
3. Integrate an LLM into an Android application.
4. Implement a RAG pipeline for contextual responses.
5. Understand embeddings and semantic retrieval.
6. Implement MCP-based external tool communication.
7. Build an AI-agent-style workflow.
8. Keep AI, networking, retrieval, and UI layers modular.
9. Create a practical project suitable for demonstrating AI engineering skills in an Android Developer portfolio.

---

# 🏗️ Architecture

The application follows **Clean Architecture + MVVM**.

```text
                         ┌─────────────────────┐
                         │    Jetpack Compose  │
                         │         UI          │
                         └──────────┬──────────┘
                                    │
                                    ▼
                         ┌─────────────────────┐
                         │      ViewModel      │
                         │     StateFlow       │
                         └──────────┬──────────┘
                                    │
                                    ▼
                         ┌─────────────────────┐
                         │       UseCase       │
                         │   Business Logic    │
                         └──────────┬──────────┘
                                    │
                    ┌───────────────┼───────────────┐
                    │               │               │
                    ▼               ▼               ▼
              ┌──────────┐   ┌──────────┐    ┌──────────┐
              │   RAG    │   │  Gemini  │    │   MCP    │
              │ Pipeline │   │   API    │    │  Client  │
              └────┬─────┘   └────┬─────┘    └────┬─────┘
                   │              │               │
                   ▼              │               ▼
            ┌────────────┐        │        ┌─────────────┐
            │ Embeddings │        │        │ MCP Server  │
            │ + Semantic │        │        │             │
            │  Search    │        │        │   Tools     │
            └─────┬──────┘        │        │ Resources   │
                  │               │        └─────────────┘
                  └───────────────┴───────────────┐
                                                  ▼
                                           AI Generated
                                              Answer
```

---

# 🧠 AI Architecture

The project evolves through multiple stages.

## Phase 1 — Chat UI

```text
User
 ↓
Compose UI
 ↓
ViewModel
 ↓
UseCase
 ↓
Repository
```

The first phase establishes the Android architecture and chat experience.

---

## Phase 2 — Gemini Integration

Gemini is integrated as the LLM.

```text
User Question
      ↓
ChatViewModel
      ↓
AskQuestionUseCase
      ↓
ChatRepository
      ↓
Gemini API
      ↓
AI Response
```

This phase demonstrates API integration, coroutine-based asynchronous processing, UI state handling, loading states, and error handling.

---

# 🔎 Phase 3 — Retrieval-Augmented Generation

The project introduces a custom RAG pipeline.

```text
                KNOWLEDGE INGESTION

Documents
    ↓
Chunking
    ↓
Embeddings
    ↓
Vector Storage


                  QUERY PIPELINE

User Question
      ↓
Query Embedding
      ↓
Semantic Search
      ↓
Top-K Relevant Chunks
      ↓
Context Construction
      ↓
Gemini
      ↓
Grounded Response
```

## RAG Components

### Document

Represents a knowledge source.

```kotlin
data class KnowledgeDocument(
    val id: String,
    val title: String,
    val content: String
)
```

### Document Chunk

Large documents are divided into smaller pieces.

```kotlin
data class DocumentChunk(
    val id: String,
    val documentId: String,
    val title: String,
    val content: String
)
```

### Embedding

Each chunk can be represented as a numerical vector.

```kotlin
data class Embedding(
    val chunkId: String,
    val vector: List<Float>
)
```

### Semantic Similarity

The initial implementation uses cosine similarity to compare query and document vectors.

```text
Query Embedding
       ↓
Similarity Calculation
       ↓
Rank Chunks
       ↓
Top-K Results
```

The retrieved chunks are then added to the LLM prompt as contextual information.

---

# 🔌 Phase 4 — Model Context Protocol (MCP)

The next stage introduces MCP to provide standardized communication between the AI application and external capabilities.

```text
                     Android Application
                              │
                              ▼
                         MCP Client
                              │
                       MCP Transport
                              │
                              ▼
                         MCP Server
                         ┌────┴────┐
                         │         │
                       Tools    Resources
                         │         │
                         ▼         ▼
                    External   External
                    Actions     Data
```

The Kotlin MCP SDK provides separate client and server modules and supports tool, resource, and prompt operations.

---

## MCP Tool Example

The project will expose tools such as:

```text
get_android_project_info
get_kotlin_version
search_android_documentation
get_android_development_tip
```

Example workflow:

```text
User
 ↓
AI Agent
 ↓
Determine whether external information is required
 ↓
MCP Client
 ↓
MCP Server
 ↓
Tool Execution
 ↓
Tool Result
 ↓
Gemini
 ↓
Final Response
```

---

# 🤖 RAG + MCP + LLM

The final AI architecture combines both RAG and MCP.

```text
                           User
                            │
                            ▼
                      Chat Interface
                            │
                            ▼
                        ViewModel
                            │
                            ▼
                         UseCase
                            │
                            ▼
                     ┌─────────────┐
                     │ AI Agent    │
                     └──────┬──────┘
                            │
                 ┌──────────┴──────────┐
                 │                     │
                 ▼                     ▼
                RAG                   MCP
                 │                     │
                 ▼                     ▼
          Knowledge Base          MCP Server
                 │                     │
                 ▼                     ▼
          Relevant Context          Tools
                 │                     │
                 └──────────┬──────────┘
                            ▼
                          Gemini
                            │
                            ▼
                      Final Response
```

### RAG answers:

> **"What information should the AI know?"**

### MCP answers:

> **"What external tools or resources can the AI use?"**

### Gemini answers:

> **"How should the final response be generated?"**

---

# 🛠️ Tech Stack

## Android

* Kotlin
* Jetpack Compose
* Material 3
* Android SDK
* Kotlin Coroutines
* StateFlow
* ViewModel

## Architecture

* MVVM
* Clean Architecture
* Repository Pattern
* Use Case Pattern
* Dependency Injection

## AI

* Google Gemini API
* LLM-based response generation
* Embeddings
* Retrieval-Augmented Generation
* Semantic Search
* AI Agent workflow

## MCP

* Model Context Protocol
* Kotlin MCP SDK
* MCP Client
* MCP Server
* MCP Tools
* MCP Resources
* Streamable/HTTP-based communication

The current Kotlin MCP SDK provides dedicated `kotlin-sdk-client` and `kotlin-sdk-server` artifacts; the SDK documentation currently lists version `0.15.0`.

---

# 📁 Project Structure

```text
android-ai-developer-assistant/
│
├── app/
│
│   └── src/main/java/
│
│       └── com/pankaj/aideveloperassistant/
│
│           │
│           ├── presentation/
│           │   ├── chat/
│           │   │   ├── ChatScreen.kt
│           │   │   ├── ChatViewModel.kt
│           │   │   └── ChatUiState.kt
│           │   │
│           │   └── components/
│           │
│           ├── domain/
│           │   ├── model/
│           │   ├── repository/
│           │   └── usecase/
│           │
│           ├── data/
│           │   ├── datasource/
│           │   │
│           │   ├── remote/
│           │   │   ├── GeminiService.kt
│           │   │   └── GeminiEmbeddingService.kt
│           │   │
│           │   ├── repository/
│           │   │
│           │   └── rag/
│           │       ├── KnowledgeDocument.kt
│           │       ├── DocumentChunk.kt
│           │       ├── Embedding.kt
│           │       ├── CosineSimilarity.kt
│           │       ├── RagRetriever.kt
│           │       └── RagPromptBuilder.kt
│           │
│           └── di/
│
├── mcp-server/
│   │
│   └── src/main/kotlin/
│       └── com/pankaj/mcp/
│           ├── Application.kt
│           ├── server/
│           ├── tools/
│           └── resources/
│
└── README.md
```

---

# 🔄 RAG Retrieval Example

Suppose the knowledge base contains:

```text
StateFlow
MVVM
Repository
Clean Architecture
Hilt
```

User asks:

```text
"What is StateFlow?"
```

The system performs:

```text
"What is StateFlow?"
        ↓
Query Embedding
        ↓
Semantic Similarity
        ↓
-------------------------------
StateFlow           0.92
MVVM                0.71
Repository          0.43
Clean Architecture  0.37
Hilt                0.15
-------------------------------
        ↓
Top-K = 2
        ↓
StateFlow + MVVM
        ↓
Context
        ↓
Gemini
        ↓
Final Answer
```

---

# 🔧 MCP Example

User asks:

```text
"What technologies are used in this project?"
```

The AI Agent can determine that project-specific information should be obtained through an MCP tool.

```text
AI Agent
   ↓
MCP Tool Discovery
   ↓
get_android_project_info
   ↓
MCP Server
   ↓
Tool Result
   ↓
Gemini
   ↓
Final Answer
```

---

# 🔐 Security

API keys and secrets should **never be committed to GitHub**.

Use:

```text
local.properties
```

or environment variables/secrets.

Example:

```properties
GEMINI_API_KEY=YOUR_API_KEY
```

Add sensitive files to:

```text
.gitignore
```

Never hardcode:

```kotlin
const val API_KEY = "actual-secret-key"
```

---

# 🧪 Testing Strategy

The project is intended to include testing at multiple levels.

## Unit Tests

* UseCase tests
* ViewModel tests
* RAG retrieval tests
* Cosine similarity tests
* Repository tests

## RAG Tests

Test:

```text
Query
 ↓
Embedding
 ↓
Similarity
 ↓
Top-K
```

Example:

```text
StateFlow query
      ↓
StateFlow chunk should rank highest
```

## MCP Tests

Test:

```text
MCP Client
    ↓
Tool Discovery
    ↓
Tool Invocation
    ↓
Tool Result
```

The official Kotlin MCP ecosystem also provides a testing module for in-memory client/server interaction testing without external processes or network connections.

---

# 📈 Future Improvements

Planned improvements include:

* [ ] Persistent vector storage
* [ ] Room/AppSearch-based local knowledge storage
* [ ] Improved document chunking
* [ ] Embedding cache
* [ ] Similarity threshold
* [ ] Source citations in chat responses
* [ ] Streaming Gemini responses
* [ ] MCP authentication
* [ ] Multiple MCP servers
* [ ] MCP resource support
* [ ] MCP prompt support
* [ ] Tool execution history
* [ ] Agent planning
* [ ] Tool-call confirmation UI
* [ ] Offline/local knowledge retrieval
* [ ] Conversation memory
* [ ] AI response evaluation
* [ ] RAG retrieval evaluation
* [ ] Production-ready error handling and observability

---

# 🗺️ Development Roadmap

```text
Phase 1
───────
Compose Chat UI
      ↓
MVVM
      ↓
Clean Architecture

        ↓

Phase 2
───────
Gemini API
      ↓
LLM Response
      ↓
Loading/Error States

        ↓

Phase 3
───────
RAG
 ↓
Document Chunking
 ↓
Embeddings
 ↓
Semantic Search
 ↓
Top-K Retrieval
 ↓
Context Grounding

        ↓

Phase 4
───────
MCP
 ↓
MCP Client
 ↓
MCP Server
 ↓
Tool Discovery
 ↓
Tool Invocation

        ↓

Phase 5
───────
AI Agent
 ↓
Intent Detection
 ↓
RAG / MCP Decision
 ↓
Tool Execution
 ↓
Context Integration
 ↓
Gemini
 ↓
Final Response
```

---

# 🎓 What This Project Demonstrates

This project demonstrates practical knowledge of:

### Android

* Modern Android development
* Jetpack Compose
* MVVM
* Clean Architecture
* Coroutines
* StateFlow
* Repository pattern
* Dependency injection

### Generative AI

* LLM integration
* Prompt engineering
* Embeddings
* Semantic search
* Retrieval-Augmented Generation
* Context grounding
* Tool/function calling
* AI agent architecture

### MCP

* Model Context Protocol
* MCP client/server architecture
* Tool discovery
* Tool invocation
* Resource access
* External capability integration

---

# 💼 Resume Value

This project is designed to demonstrate the combination of **senior Android engineering and modern AI application development**.

Suggested resume bullet:

> **Built an AI-powered Android Developer Assistant using Jetpack Compose, MVVM, Clean Architecture, Kotlin Coroutines, Gemini, RAG, embeddings, semantic retrieval, and MCP-based tool integration.**

Additional bullet:

> **Implemented a RAG pipeline with document chunking, embeddings, cosine-similarity retrieval, Top-K context selection, and context-grounded LLM responses.**

Additional MCP bullet:

> **Designed MCP client/server communication to expose external tools and resources to an AI-agent workflow, enabling dynamic tool discovery and invocation.**

---

# 📚 Learning Resources

* [Gemini API Documentation](https://ai.google.dev/)
* [Gemini Embeddings Documentation](https://ai.google.dev/gemini-api/docs/embeddings)
* [Model Context Protocol](https://modelcontextprotocol.io/)
* [Kotlin MCP SDK](https://kotlin.sdk.modelcontextprotocol.io/)

---

# 👨‍💻 Author

**Pankaj V. Prajapati**

Senior Android Developer | Kotlin | Jetpack Compose | Android | Generative AI

This project is developed as a personal learning and portfolio project to explore the integration of modern Android architecture with Generative AI, RAG, and Model Context Protocol.

---

# ⭐ Project Status

🚧 **Work in Progress**

The project is being developed incrementally from a traditional Android chat application into an AI-powered developer assistant with RAG and MCP capabilities.

Contributions, suggestions, and discussions are welcome.

---

## License

This project is intended for personal learning, experimentation, and portfolio demonstration.
