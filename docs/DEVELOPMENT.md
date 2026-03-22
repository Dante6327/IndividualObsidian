# 개발 가이드

## 로컬 개발 환경

```bash
# DB 실행
docker-compose up -d

# 앱 실행
./gradlew bootRun
```

## 개발 순서

### Phase 1: 기본 CRUD
1. [ ] Article Entity + Repository
2. [ ] ArticleController + ArticleService (CRUD API)
3. [ ] DTO 정의 (Request/Response)

### Phase 2: 이미지 처리
4. [ ] 이미지 업로드 API
5. [ ] 마크다운 URL 치환 로직

### Phase 3: AI 연동
6. [ ] Embedding 클라이언트 (infra/ai)
7. [ ] ArticleVector Entity + pgvector 저장
8. [ ] 시맨틱 검색 API

### Phase 4: RAG
9. [ ] LLM 클라이언트 (Claude API)
10. [ ] RAG 응답 생성 API

## 기술 스택 상세

| 영역 | 기술 |
|------|------|
| Backend | Kotlin + Spring Boot 3.3.0, JDK 21 |
| DB | PostgreSQL 16 + pgvector |
| AI | OpenAI/Anthropic Embedding, Claude API, Ollama |
| Infra | Nginx, Coolify, MCP Server |

## AI 연동 방식

- Embedding: OpenAI 또는 Anthropic API (WebClient 직접 호출)
- LLM 추론: Claude API (외부) 또는 Ollama (로컬)
- Spring AI: 현재 미사용 (추후 마이그레이션 고려)
- 벡터 저장: pgvector 직접 연동
