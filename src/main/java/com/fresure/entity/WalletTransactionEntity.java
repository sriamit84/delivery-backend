package com.fresure.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WALLET_TRANSACTION_DETAILS")
public class WalletTransactionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "wallet_transaction_id", updatable = false, nullable = false)
	private Long walletTransactionId;

	private Double amount;

	public Long getWalletTransactionId() {
		return walletTransactionId;
	}

	public void setWalletTransactionId(Long walletTransactionId) {
		this.walletTransactionId = walletTransactionId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
