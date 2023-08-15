# songspy-core-api

**지금 무슨 노래 듣고 있으세요?** 를 모티브로 
현재 사람들이 듣고 있는 곡을 확인할 수 있는 서비스입니다.

```spoitfy``` oauth를 이용해서 현재 사람들이 듣고 있는 곡 정보를 조회합니다.

## 배치
```songspy-batch``` 모듈을 통해 배치성 작업을 스케줄러로 구현했습니다.

### AccessTokenRefreshScheduler

spotify를 연동한 고객들의 access-token을 지속적으로 refresh할 수 있는 Scheduler입니다.

```30분``` 간격으로 작업을 수행합니다.

***Sequence Diagram***

```mermaid
sequenceDiagram
  participant batch
  participant spotify

  autonumber

  batch ->> batch: get expired access-token
  batch -->> spotify: refresh access-token (/api/token)
  activate spotify
  spotify -->> batch: refresh response
  deactivate spotify
  batch ->> batch: update token
```

### CurrentPlayingTrackScheduler

spotify를 연동한 고객들의 access-token을 이용하여 현재 듣고 있는 곡 정보를 조회한 후, 저장하는 Scheduler입니다.

```3분``` 간격으로 작업을 수행합니다.

***Sequence Diagram***

```mermaid
sequenceDiagram
  participant batch
  participant spotify

  autonumber

  batch ->> batch: get existed access-token
  batch -->> spotify: get current-playing-track (/v1/me/player/currently-playing)
  activate spotify
  spotify -->> batch: track response
  deactivate spotify
  batch ->> batch: track update not exist in user tracks
```

## 회원가입 및 스포티파이 연동
회원가입은 google oauth를 이용합니다.

```mermaid
sequenceDiagram
  participant songspy-fe
  participant songspy-be
  participant google
  participant spoitfy
	
  autonumber

  alt google-oauth 이용한 회원가입
  
  songspy-fe ->> google: auth code 발급 요청
  activate google
  google ->> songspy-fe: auth code 응답 및 리다이렉트
  deactivate google
  songspy-fe ->> google: access-token 발급 요청
  activate google
  google ->> songspy-fe: access-token 응답
  deactivate google
  
  songspy-fe ->> songspy-be: google 회원가입 (/v1/songspy/google-auth)
  songspy-be ->> google: 발급 받은 access-token을 통해 유저 정보 조회 (/oauth2/v1/userinfo)
  activate google  
  google ->> songspy-be: 유저 정보 응답
  deactivate google
  songspy-be ->> songspy-be: 유저 정보를 통해 회원가입
  songspy-be ->> songspy-fe: jwt 토큰 발급
  
  end

  alt spotify-oauth를 이용한 연동
  
  songspy-fe ->> spotify: auth code 발급 요청
  activate spotify
  spotify ->> songspy-fe: auth code 응답 및 리다이렉트
  deactivate spotify

  songspy-fe ->> songspy-be: spotify access-token 발급 요청
  songspy-be ->> spotify: access-token 발급 요청
  activate spotify
  spotify ->> songspy-be: access-token 응답
  deactivate spotify
  songspy-be ->> songspy-be: access-token 유저 정보와 함께 저장
  songspy-be ->> songspy-fe: 200 Success
  
  end
```