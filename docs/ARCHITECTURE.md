# 아키텍처

## 인프라 구성

```
[외부]
   │
   ▼
┌─────────────────────────────────────┐
│  Mac Mini (Application Server)      │
│  - Spring Boot API                  │
│  - Nginx (리버스 프록시)              │
│  - MCP Server                       │
│  - Coolify (배포)                    │
└─────────────┬───────────────────────┘
              │ 사설IP (로컬 네트워크)
              ▼
┌─────────────────────────────────────┐
│  LG Gram (DB & Storage Server)      │
│  - PostgreSQL 16 + pgvector         │
│  - Nginx (이미지 정적 서빙)           │
│  - 마크다운/이미지 저장소              │
└─────────────────────────────────────┘
```

## 네트워크

- Mac Mini: 외부 접근 가능 (퍼블릭)
- LG Gram: 로컬 네트워크 전용 (외부 접근 불가)
- 두 서버는 사설IP로 직접 연결

## 핵심 워크플로우

### 1. Article Writing (쓰기)
```
Obsidian → JSON(텍스트+이미지) → 백엔드
         → 이미지 저장 (Gram)
         → 마크다운 URL 치환 및 저장
         → 텍스트 임베딩 → pgvector 저장
```

### 2. Image Upload & Serving
```
Obsidian → 이미지 → 백엔드 → Gram 저장 → Nginx URL 서빙
```

### 3. Search / RAG (검색)
```
질문 → Embedding → pgvector 시맨틱 검색 → LLM 응답 생성
```

### 4. MCP Link
```
IDE (Cursor/Claude Code) → MCP → Mac Mini → 로컬 툴 실행
```

## 패키지 구조

```
com.dotcode.individualobsidian/
├── IndividualObsidianApplication.kt
├── controller/        # REST API
├── service/           # 비즈니스 로직
├── repository/        # JPA Repository
├── domain/            # Entity
├── dto/               # Request/Response DTO
├── common/config/     # 설정
└── infra/ai/          # Embedding, LLM 클라이언트
```
