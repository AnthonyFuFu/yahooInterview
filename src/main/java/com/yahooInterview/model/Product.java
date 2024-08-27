package com.yahooInterview.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Builder
@NonNull
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PD_ID")
	private String pdId;               // 商品ID
    
    @Column(name = "PD_NAME")
	private String pdName;             // 商品名稱
    
    @Column(name = "PD_PRICE")
	private String pdPrice;            // 商品原價
    
    @Column(name = "PD_DESCRIPTION")
	private String pdDescription;	   // 商品資訊
    
    @Column(name = "PD_STATUS")
	private String pdStatus;           // 商品狀態(0:下架 1:上架 Default:0)
    
    @Column(name = "PD_IS_DEL")
	private String pdIsDel;            // 商品刪除(0:未刪除 1:刪除 Default:0)
    
    @Column(name = "PD_CREATE_BY")
	private String pdCreateBy;         // 商品創建人
    
    @Column(name = "PDCREATETIME")
	private String pdCreateTime;       // 商品創建時間
    
    @Column(name = "PD_UPDATE_BY")
	private String pdUpdateBy;         // 商品最後修改人
    
    @Column(name = "PD_UPDATE_TIME")
	private String pdUpdateTime;       // 商品最後修改時間
    
}