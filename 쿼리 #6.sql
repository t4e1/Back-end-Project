DROP TABLE IF EXISTS reply CASCADE;
DROP TABLE IF EXISTS liked_post CASCADE;
DROP TABLE IF EXISTS picture CASCADE;
DROP TABLE IF EXISTS fair CASCADE;
DROP TABLE IF EXISTS news CASCADE;
DROP TABLE IF EXISTS member_policy CASCADE;
DROP TABLE IF EXISTS policy CASCADE;
DROP TABLE IF EXISTS login_history CASCADE;
DROP TABLE IF EXISTS member_authority CASCADE;
DROP TABLE IF EXISTS authority CASCADE;
DROP TABLE IF EXISTS post CASCADE;
DROP TABLE IF EXISTS post_category CASCADE;
DROP TABLE IF EXISTS memberinfo CASCADE;
DROP TABLE IF EXISTS member_category CASCADE;
DROP TABLE IF EXISTS report CASCADE;
DROP TABLE IF EXISTS report_category CASCADE;

CREATE TABLE report_category (
    report_category_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '신고 분류 ID',
    report_category_name VARCHAR(255) NOT NULL UNIQUE COMMENT '신고 분류 명'
);

CREATE TABLE report (
    report_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '신고번호',
    report_reason VARCHAR(255) NOT NULL COMMENT '신고 사유',
    report_date DATE NOT NULL COMMENT '신고 날짜',
    report_processed_acceptance TINYINT(1) NOT NULL DEFAULT 0 COMMENT '처리 여부',
    report_processing_date DATETIME COMMENT '처리 날짜',
    reported_text_number INT NOT NULL UNIQUE COMMENT '신고당한 글번호',
    report_category_id INT NOT NULL COMMENT '신고 분류 ID',
    FOREIGN KEY (report_category_id) REFERENCES report_category(report_category_id)
);

CREATE TABLE member_category (
    member_category_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '회원 카테고리 ID',
    category_name VARCHAR(255) NOT NULL UNIQUE COMMENT '카테고리 명'
);

CREATE TABLE memberinfo (
    member_code INT PRIMARY KEY AUTO_INCREMENT COMMENT '회원 코드',
    member_id VARCHAR(15) NOT NULL UNIQUE COMMENT '회원 아이디',
    member_name VARCHAR(255) NOT NULL COMMENT '회원이름',
    member_pwd VARCHAR(255) NOT NULL UNIQUE COMMENT '비밀번호',
    member_email VARCHAR(255) NOT NULL UNIQUE COMMENT '이메일',
    member_addr VARCHAR(255) NOT NULL COMMENT '주소',
    member_phone VARCHAR(255) NOT NULL COMMENT '전화번호',
    blacklist_status TINYINT(1) NOT NULL DEFAULT 0 COMMENT '블랙회원여부',
    restrict_start_date DATETIME COMMENT '제재적용일',
    restrict_end_date DATETIME COMMENT '제재종료일',
    login_fail_count INT COMMENT '로그인 실패횟수',
    access_acceptance TINYINT(1) NOT NULL DEFAULT 0 COMMENT '접근제한여부',
    withdrawal_acceptance TINYINT(1) NOT NULL DEFAULT 0 COMMENT '회원탈퇴여부',
    member_category_id INT NOT NULL COMMENT '회원 카테고리 ID',
    FOREIGN KEY (member_category_id) REFERENCES member_category(member_category_id)
);

CREATE TABLE fair (
    fair_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '주류페어 번호',
    fair_title VARCHAR(255) NOT NULL COMMENT '주류페어 제목',
    fair_content TEXT NOT NULL COMMENT '주류페어 내용',
    fair_writedate DATETIME NOT NULL COMMENT '작성날짜',
    use_acceptance TINYINT(1) NOT NULL DEFAULT 1 COMMENT '사용여부',
    member_code INT NOT NULL  DEFAULT 1 COMMENT '주류페어 작성자',
    FOREIGN KEY (member_code) REFERENCES memberinfo(member_code)
);

CREATE TABLE news (
    news_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '뉴스번호',
    news_title VARCHAR(255) NOT NULL COMMENT '뉴스제목',
    news_content TEXT NOT NULL COMMENT '뉴스내용',
    news_writedate DATETIME NOT NULL COMMENT '작성날짜',
    use_acceptance TINYINT(1) NOT NULL DEFAULT 1 COMMENT '사용여부',
    member_code INT NOT NULL DEFAULT 1 COMMENT '뉴스 작성자',
    FOREIGN KEY (member_code) REFERENCES memberinfo(member_code)
);

CREATE TABLE post_category (
    category_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '카테고리ID',
    category_name VARCHAR(255) NOT NULL UNIQUE COMMENT '카테고리 내용'
);

CREATE TABLE post (
    post_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '게시글번호',
    post_title VARCHAR(255) NOT NULL COMMENT '게시글제목',
    post_content TEXT NOT NULL COMMENT '게시글내용',
    post_date DATETIME NOT NULL COMMENT '게시글 작성일',
    category_id INT NOT NULL COMMENT '게시글 유형',
    use_acceptance TINYINT(1) NOT NULL DEFAULT 1 COMMENT '사용여부',
    like_amount INT NOT NULL COMMENT '좋아요 수',
    reported_acceptance TINYINT(1) NOT NULL DEFAULT 0 COMMENT '신고여부',
    member_code INT NOT NULL COMMENT '게시글 작성자',
    post_modify_date DATETIME NOT NULL COMMENT '게시글 수정일',
    FOREIGN KEY (category_id) REFERENCES post_category(category_id),
    FOREIGN KEY (member_code) REFERENCES memberinfo(member_code)
);

CREATE TABLE reply (
    reply_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '댓글번호',
    post_id INT NOT NULL COMMENT '게시글번호',
    reply_content TEXT NOT NULL COMMENT '댓글내용',
    reply_date DATETIME NOT NULL COMMENT '댓글작성일',
    report_acceptance TINYINT(1) NOT NULL DEFAULT 0 COMMENT '신고여부',
    use_acceptance TINYINT(1) DEFAULT 1 NOT NULL COMMENT '사용여부',
    member_code INT NOT NULL COMMENT '댓글 작성자',
    FOREIGN KEY (post_id) REFERENCES post(post_id),
    FOREIGN KEY (member_code) REFERENCES memberinfo(member_code)
);

CREATE TABLE picture (
    picture_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '사진코드',
    picture_basicname VARCHAR(255) NOT NULL COMMENT '기존사진명',
    picture_location VARCHAR(255) NOT NULL COMMENT '사진경로',
    picture_rename VARCHAR(255) NOT NULL COMMENT '변경된 사진이름',
    news_id INT COMMENT '뉴스번호',
    post_id INT COMMENT '게시글번호',
    fair_id INT COMMENT '주류페어 번호',
    FOREIGN KEY (news_id) REFERENCES news(news_id),
    FOREIGN KEY (post_id) REFERENCES post(post_id),
    FOREIGN KEY (fair_id) REFERENCES fair(fair_id)
);

CREATE TABLE liked_post (
    like_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '좋아요ID',
    like_date DATETIME NOT NULL COMMENT '생성날짜',
    like_cancel_date DATETIME COMMENT '취소날짜',
    like_state TINYINT(1) NOT NULL DEFAULT 1 COMMENT '활성상태',
    member_code INT NOT NULL COMMENT '좋아요 한 회원',
    post_id INT NOT NULL COMMENT '게시글번호',
    FOREIGN KEY (member_code) REFERENCES memberinfo(member_code),
    FOREIGN KEY (post_id) REFERENCES post(post_id)
);

CREATE TABLE policy (
    policy_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '정책ID',
    policy_description VARCHAR(255) NOT NULL COMMENT '정책내용'
);

CREATE TABLE member_policy (
    member_code INT NOT NULL COMMENT '회원아이디',
    policy_id INT NOT NULL COMMENT '정책ID',
    PRIMARY KEY (member_code, policy_id),
    FOREIGN KEY (member_code) REFERENCES memberinfo(member_code),
    FOREIGN KEY (policy_id) REFERENCES policy(policy_id)
);

CREATE TABLE authority (
    authority_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '권한ID',
    authority_name VARCHAR(255) NOT NULL COMMENT '권한이름',
    authority_description VARCHAR(255) NOT NULL COMMENT '권한설명'
);

CREATE TABLE member_authority (
    member_code INT NOT NULL COMMENT '회원아이디',
    authority_id INT NOT NULL COMMENT '권한ID',
    PRIMARY KEY (member_code, authority_id),
    FOREIGN KEY (member_code) REFERENCES memberinfo(member_code),
    FOREIGN KEY (authority_id) REFERENCES authority(authority_id)
);

CREATE TABLE login_history (
    login_history_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '로그인내역ID',
    success_check TINYINT(1) NOT NULL COMMENT '성공여부',
    attempt_date DATE NOT NULL COMMENT '시도날짜',
    attempt_time TIME NOT NULL COMMENT '시도시간',
    attempt_location VARCHAR(255) NOT NULL COMMENT '시도위치',
    member_code INT NOT NULL COMMENT '회원아이디',
    FOREIGN KEY (member_code) REFERENCES memberinfo(member_code)
);
