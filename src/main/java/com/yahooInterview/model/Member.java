package com.yahooInterview.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@Builder
@NonNull
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member")
public class Member {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEM_ID")
	private String memId;              // 會員ID
	
	@Column(name = "MEM_NAME")
	private String memName;            // 姓名
	
	@Column(name = "MEM_ACCOUNT")
	private String memAccount;         // 帳號
	
	@Column(name = "MEM_PASSWORD")
	private String memPassword;        // 密碼
	
	@Column(name = "MEM_GENDER")
	private String memGender;          // 性別(f:女 m:男)
	
	@Column(name = "MEM_PHONE")
	private String memPhone;           // 電話
	
	@Column(name = "MEM_EMAIL")
	private String memEmail;           // 信箱
	
	@Column(name = "MEM_ADDRESS")
	private String memAddress;         // 地址
	
	@Column(name = "MEM_BIRTHDAY")
	private String memBirthday;        // 生日

	@Column(name = "MEM_STATUS")
	private String memStatus;          // 會員狀態(1:正常 0:停權)
	
}