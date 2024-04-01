package fr.emse.test;

import java.util.Vector;

class Money implements IMoney {
	private int fAmount;
	private String fCurrency;
	
	public Money(int amount, String currency) { 
		fAmount = amount;
		fCurrency = currency;
	}
	
	public int amount() {
		return fAmount;
	}
	
	public String currency() {
		return fCurrency;
	}
	
	

	@Override
	public IMoney add(IMoney aMoney) {
		// TODO Auto-generated method stub
		if (aMoney instanceof Money)
			return aMoney.addMoney(this);
		return aMoney.addMoneyBag((MoneyBag) aMoney);
	}

	@Override
	public IMoney addMoney(Money money) {
		// TODO Auto-generated method stub
		if (money.currency().equals(currency())) {
			return new Money(amount() + money.amount(), currency());
		} else {
			return new MoneyBag(this, money);
		}
		
	}

	@Override
	public IMoney addMoneyBag(MoneyBag moneyBag) {
		// TODO Auto-generated method stub
		Vector<Money> MergedMoney = new Vector<Money>(); 
		
		MergedMoney.add(this);
		
		MergedMoney.addAll(moneyBag.getMoneyBagVal());
		return new MoneyBag(MergedMoney);
		
	}

	@Override
	public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	       
	        if (obj == null) {
	            return false;
	        }
	        
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        
	        Money money = (Money) obj;
	        
	        return fAmount==money.fAmount && fCurrency.equals(money.fCurrency);
	    
	}
}