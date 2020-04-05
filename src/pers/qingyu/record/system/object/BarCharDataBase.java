package pers.qingyu.record.system.object;

public class BarCharDataBase {
	private int amount;
	private String title;
	private String categoryAxisLabel;

	public BarCharDataBase(int amount, String title, String categoryAxisLabel) {
		this.amount = amount;
		this.title = title;
		this.categoryAxisLabel = categoryAxisLabel;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategoryAxisLabel() {
		return categoryAxisLabel;
	}

	public void setCategoryAxisLabel(String categoryAxisLabel) {
		this.categoryAxisLabel = categoryAxisLabel;
	}
}
