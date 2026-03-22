# IndividualObsidian

Obsidian 기반 개인용 AI 지식 베이스 시스템.
로컬 네트워크에서 동작하는 Private AI Knowledge Base.

## 기술 스택

- Kotlin + Spring Boot 3.3.0
- PostgreSQL 16 + pgvector
- OpenAI/Anthropic Embedding, Claude API

## 실행 방법

```bash
# DB 실행
docker-compose up -d

# 앱 실행
./gradlew bootRun
```

## 문서

- [아키텍처](docs/ARCHITECTURE.md)
- [개발 가이드](docs/DEVELOPMENT.md)
