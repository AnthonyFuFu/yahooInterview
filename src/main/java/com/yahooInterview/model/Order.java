package com.yahooInterview.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "`order`")
public class Order {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORD_ID")
	private String ordId;              // 訂單ID
    
    @Column(name = "MEM_ID")
	private String memId;              // 會員ID
    
    @Column(name = "ORD_SUBTOTAL")
	private String ordSubtotal;        // 小計(未扣cupon折扣)
    
    @Column(name = "ORD_TOTAL")
	private String ordTotal;           // 總計(扣除cupon折扣)
    
    @Column(name = "ORD_STATUS")
	private String ordStatus;          // 訂單狀態(0:未完成 1:已完成 2:配送中 3:取消)(預設 0)
    
    @Column(name = "ORD_CREATE")
	private String ordCreate;          // 訂單成立時間
    
    @Column(name = "ORD_RECIPIENT")
	private String ordRecipient;       // 收件人
    
    @Column(name = "ORD_RECIPIENT_PHONE")
	private String ordRecipientPhone;  // 收件人連絡電話
    
    @Column(name = "ORD_PAYMENT")
	private String ordPayment;         // 付款方式(0:貨到付款 1:信用卡)
    
    @Column(name = "ORD_DELIVERY")
	private String ordDelivery;        // 送貨方式(0:超商取貨 1:宅配)
    
    @Column(name = "ORD_ADDRESS")
	private String ordAddress;         // 收件地址
    
    @ManyToOne
    @JoinColumn(name = "MEM_ID", insertable = false, updatable = false)
    private Member member;			   // 會員
    
}
