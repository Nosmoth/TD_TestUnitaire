package fr.emse.test;

import java.util.Vector;

public class MoneyBag implements IMoney {
	private Vector<Money> fMonies = new Vector<Money>();
	

	public MoneyBag(Money m) {
		appendMoney(m);
	}
	
	public MoneyBag(Vector<Money> f) {
		this.fMonies = new Vector<>(f);
	}

	public MoneyBag(Money m1, Money m2) {
		appendMoney(m2);
		appendMoney(m1);

	}
	
	public MoneyBag(IMoney m1, IMoney m2) {
		appendMoney(m2);
		appendMoney(m1);

	}
	
	public MoneyBag(MoneyBag moneyBag) {
		for (Money money : moneyBag.fMonies) {
			appendMoney(money);
		}
	}

	public MoneyBag(Money bag[]) {
		for (Money obj : bag) {
			appendMoney(obj);
		}
	}

	public Vector<Money> getMoneyBagVal() {
		return fMonies;
	}
	
	public IMoney add(IMoney m) {
		return m.addMoneyBag(this);
	}
	
	private void appendMoney(Money m) {
		if (fMonies.isEmpty()) {
			fMonies.add(m);
		} else {
			int i = 0;
			while ((i < fMonies.size()) && (!(fMonies.get(i).currency().equals(m.currency()))))
				i++;
			if (i >= fMonies.size()) { 
				fMonies.add(m);
			} else {
				fMonies.set(i, new Money(fMonies.get(i).amount() + m.amount(),m.currency()));
			}
		}
	}

	private void appendMoney(IMoney m) {
		if (m instanceof Money) {
			appendMoney(m);
		}
		else {
			MoneyBag moneyBag = (MoneyBag) m;
			for (Money money : moneyBag.fMonies) {
				appendMoney(money);
			}
		}
	}
	
	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null || getClass() != obj.getClass()) {
	            return false;
	        }
	        MoneyBag other = (MoneyBag) obj;
	        return fMonies.equals(other.fMonies);
	    }
	 
	 
	@Override
	public IMoney addMoney(Money money) {
		// TODO Auto-generated method stub
		MoneyBag moneyBag = new MoneyBag(this);
		return moneyBag.add(money);

	}

	@Override
	public IMoney addMoneyBag(MoneyBag moneyBag) {
		// TODO Auto-generated method stub
		return null;
	}

}
