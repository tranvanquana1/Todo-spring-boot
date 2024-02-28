CREATE DATABASE erp_demo;

USE erp_demo;

CREATE TABLE users
(
    id          INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    full_name   VARCHAR(150) COLLATE utf8mb4_unicode_ci COMMENT 'Họ và tên',
    gender      TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT 'Giới tính, 0: Nữ, 1: Nam',
    username    VARCHAR(100) COLLATE ascii_general_ci COMMENT 'Username',
    status      TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT 'Trạng thái của tài khoản, 0: vô hiệu hoá, 1: đang hoạt động',
    role_id     INT UNSIGNED     NOT NULL DEFAULT 0 COMMENT 'Chức vụ, id của bảng roles',
    daily_wage  DECIMAL(20, 0)   NOT NULL DEFAULT 0 COMMENT 'Mức lương theo ngày',
    created_by  INT UNSIGNED     NOT NULL DEFAULT 0 COMMENT 'ID của người tạo, 0: Hệ thống',
    created_at  DATETIME         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Thời gian tạo',
    modified_by INT UNSIGNED     NULL COMMENT 'ID của người cập nhật, 0: Hệ thống',
    modified_at DATETIME         NULL ON UPDATE CURRENT_TIMESTAMP
) COMMENT 'Dữ liệu Nhân viên' ENGINE = InnoDB
                              DEFAULT CHARSET = ascii
                              COLLATE = ascii_general_ci
                              AUTO_INCREMENT = 1;

CREATE TABLE roles
(
    id          INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    code        VARCHAR(50) COLLATE ascii_general_ci COMMENT 'Mã chức vụ',
    name        VARCHAR(50) COLLATE utf8mb4_unicode_ci COMMENT 'Tên chức vụ',
    created_by  INT UNSIGNED NOT NULL DEFAULT 0 COMMENT 'ID của người tạo, 0: Hệ thống',
    created_at  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Thời gian tạo',
    modified_by INT UNSIGNED NULL COMMENT 'ID của người cập nhật, 0: Hệ thống',
    modified_at DATETIME     NULL ON UPDATE CURRENT_TIMESTAMP
) COMMENT 'Dữ liệu Chức vụ' ENGINE = InnoDB
                            DEFAULT CHARSET = ascii
                            COLLATE = ascii_general_ci
                            AUTO_INCREMENT = 1;

CREATE TABLE attendances
(
    id             INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    user_id        INT UNSIGNED COMMENT 'ID của bảng User',
    status         TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT 'Trạng thái duyệt công: 0 - Pending, 1 - Đã duyệt, 2 - Từ chối',
    note           VARCHAR(255) COLLATE utf8mb4_unicode_ci COMMENT 'Ghi chú',
    check_in_time  datetime COMMENT 'Thời gian Check-in',
    check_out_time datetime COMMENT 'Thời gian Check-out',
    created_by     INT UNSIGNED     NOT NULL DEFAULT 0 COMMENT 'ID của người tạo, 0: Hệ thống',
    created_at     DATETIME         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Thời gian tạo',
    modified_by    INT UNSIGNED     NULL COMMENT 'ID của người cập nhật, 0: Hệ thống',
    modified_at    DATETIME         NULL ON UPDATE CURRENT_TIMESTAMP
) COMMENT 'Dữ liệu Chức vụ' ENGINE = InnoDB
                            DEFAULT CHARSET = ascii
                            COLLATE = ascii_general_ci
                            AUTO_INCREMENT = 1;

CREATE TABLE payslips
(
    id           INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    user_id      INT UNSIGNED COMMENT 'ID của bảng User',
    `period`     INT UNSIGNED COMMENT 'Kỳ lương',
    gross_amount DECIMAL(20, 0) NOT NULL DEFAULT 0 COMMENT 'Lương GROSS',
    net_amount   DECIMAL(20, 0) NOT NULL DEFAULT 0 COMMENT 'Lương NET',
    created_by   INT UNSIGNED   NOT NULL DEFAULT 0 COMMENT 'ID của người tạo, 0: Hệ thống',
    created_at   DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Thời gian tạo',
    modified_by  INT UNSIGNED   NULL COMMENT 'ID của người cập nhật, 0: Hệ thống',
    modified_at  DATETIME       NULL ON UPDATE CURRENT_TIMESTAMP
) COMMENT 'Dữ liệu Chức vụ' ENGINE = InnoDB
                            DEFAULT CHARSET = ascii
                            COLLATE = ascii_general_ci
                            AUTO_INCREMENT = 1;

INSERT INTO roles(code, name)
VALUES ('CEO', 'Chief Executive Officer'),
       ('CFO', 'Chief Financial Officer'),
       ('CTO', 'Chief Technology Officer'),
       ('HOD', 'Head of Department'),
       ('PM', 'Project Manager'),
       ('TL', 'Tech Leader'),
       ('WE', 'Web Engineer'),
       ('QA', 'QA Engineer'),
       ('DE', 'Data Engineer'),
       ('DA', 'Data Analyst'),
       ('DS', 'Data Scientist'),
       ('SA', 'Solution Architect'),
       ('Infra', 'Infrastructure Engineer'),
       ('SE', 'Security Engineer');