package entity;

public class Words {
	private int wid;
	private String word;
	private String pronounce;
	private String description;
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getPronounce() {
		return pronounce;
	}
	public void setPronounce(String pronounce) {
		this.pronounce = pronounce;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "words [wid=" + wid + ", word=" + word + ", pronounce=" + pronounce + ", description=" + description
				+ "]";
	}
	
}
